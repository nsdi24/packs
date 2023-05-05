#!/bin/bash
# Start running tofino-model program

function print_help() {
  echo "USAGE: $(basename ""$0"") -p <p4_program_name> [OPTIONS -- TOFINO_MODEL_OPTIONS]"
  echo "Options for running tofino-model:"
  echo "  -c TARGET_CONFIG_FILE"
  echo "    TARGET_CONFIG_FILE that describes P4 artifacts of the device"
  echo "  -d NUM"
  echo "    Instantiate NUM devices in tofino-model"
  echo "  -f PORTINFO_FILE"
  echo "    Read port to veth mapping information from PORTINFO_FILE"
  echo "  -g"
  echo "    Run with gdb"
  echo "  -h"
  echo "    Print this message"
  echo "  -p"
  echo "    Program name, a shortcut for specifying the path to the conf file with -c"
  echo "  -q"
  echo "    Quiet the model"
  echo "  --conf-disable"
  echo "    Set model to not use p4 target config file"
  echo "  --int-port-loop <pipe-bitmap>"
  echo "    Put ports in internal loopback mode for specified pipes (0xf for all pipes)"
  echo "  --log-dir"
  echo "    Specify log file directory"
  echo "  --json-logs-enable"
  echo "    Enable the JSON event log stream"
  echo "  --pkt-log-len"
  echo "    Specify packet log length in bytes"
  echo "  --use-pcie-veth"
  echo "    Set model to use veth for pcie packets"
  echo "  --dod-test-mode"
  echo "    Set model to send every 10th DeflectOnDrop packet to Port0"
  echo "  --arch <tf1|tf2|tf2m>"
  echo "    Specifiy the chip architecture, defaults to Tofino"
  echo "  --no-port-monitor"
  echo "    Do not monitor interfaces to detect port up/down events"
  echo "  --time-disable"
  echo "    Do not automatically increment time"
  exit 0
}


trap 'exit' ERR

[ -z ${SDE} ] && echo "Environment variable SDE not set" && exit 1
[ -z ${SDE_INSTALL} ] && echo "Environment variable SDE_INSTALL not set" && exit 1

echo "Using SDE ${SDE}"
echo "Using SDE_INSTALL ${SDE_INSTALL}"

opts=`getopt -o c:d:f:ghp:q --long conf-disable,int-port-loop:,log-dir:,json-logs-enable,pkt-log-len:,use-pcie-veth,dod-test-mode,arch:,time-disable,no-port-monitor -- "$@"`
if [ $? != 0 ]; then
  exit 1
fi
eval set -- "$opts"

P4_NAME=""
# default num_devices to 1
NUM_DEVICES=1
# json file specifying of-port info
PORTINFO=None
# debug options
DBG=""
# internal port loop
INT_PORT_LOOP=""
LOG_DIR=""
NO_LOG=""
JSON_LOGS_ENABLE=""
PKT_LOG_LEN=""
USE_PCIE_VETH=""
DOD_TEST_MODE=""
CONF_DISABLE=""
TARGET_CONFIG_FILE=""
CUSTOM_MODEL_OPTS=""
PORTMONITOR="--port-monitor"
CHIP_ARCH="Tofino"
TIME_DISABLE=""

HELP=false
while true; do
    case "$1" in
      -c) TARGET_CONFIG_FILE=$2; shift 2;;
      -d) NUM_DEVICES=$2; shift 2;;
      -f) PORTINFO=$2; shift 2;;
      -g) DBG="gdb -ex run --args"; shift 1;;
      -h) HELP=true; shift 1;;
      -p) P4_NAME=$2; shift 2;;
      -q) NO_LOG="--logs-disable"; shift 1;;
      --conf-disable) CONF_DISABLE="$1"; shift 1;;
      --int-port-loop) INT_PORT_LOOP="--int-port-loop $2"; shift 2;;
      --log-dir) LOG_DIR="--log-dir $2"; shift 2;;
      --json-logs-enable) JSON_LOGS_ENABLE="--json-logs-enable"; shift 1;;
      --pkt-log-len) PKT_LOG_LEN="--pkt-log-len $2"; shift 2;;
      --use-pcie-veth) USE_PCIE_VETH="--use-pcie-veth $1"; shift 1;;
      --dod-test-mode) DOD_TEST_MODE="$1"; shift 1;;
      --no-port-monitor) PORTMONITOR=""; shift 1;;
      --arch) CHIP_ARCH=$2; shift 2;;
      --time-disable) TIME_DISABLE="--time-disable"; shift 1;;
      --) shift; break;;
    esac
done

if [ $HELP = true ] || [ -z $P4_NAME ]; then
  print_help
fi

CHIP_ARCH=`echo $CHIP_ARCH | tr '[:upper:]' '[:lower:]'`
case "$CHIP_ARCH" in
  tofino2)   CHIPTYPE=5; CHIP_FAMILY="tf2";;
  tofino2m)  CHIPTYPE=5; CHIP_FAMILY="tf2";;
  tf2)       CHIPTYPE=5; CHIP_FAMILY="tf2"; CHIP_ARCH="tofino2";;
  tf2m)      CHIPTYPE=5; CHIP_FAMILY="tf2"; CHIP_ARCH="tofino2m";;
  tofino)    CHIPTYPE=2; CHIP_FAMILY="tf1";;
  tf1)       CHIPTYPE=2; CHIP_FAMILY="tf1"; CHIP_ARCH="tofino";;
  *) echo "Invalid arch option specified ${CHIP_ARCH}"; exit 1;;
esac

TEST_DIR=""
if [[ $P4_NAME == "switch" ]]; then
  TEST_DIR=`find $SDE -type d -path "*switch*/ptf/api"`
else
  TEST_DIR=`find $SDE -type d -path "*p4-examples*/ptf-tests/$P4_NAME" | head -n1`
  if [[ ! -d "$TEST_DIR" ]]; then
    TEST_DIR=`find $SDE -type d -path "*p4-examples*/p4_16_programs/$P4_NAME" | head -n1`
  fi
fi
echo "Model using test directory: $TEST_DIR"

CUSTOM_MODEL_OPT_FILE=$TEST_DIR/custom_model_options
if [[ $CHIP_FAMILY == "tf2" ]]; then
  CUSTOM_MODEL_OPT_TOF2_FILE=$TEST_DIR/custom_model_options_tof2
  if [ -f $CUSTOM_MODEL_OPT_TOF2_FILE ]; then
    CUSTOM_MODEL_OPT_FILE=$CUSTOM_MODEL_OPT_TOF2_FILE
  fi
fi
if [ -f $CUSTOM_MODEL_OPT_FILE ]; then
  CUSTOM_MODEL_OPTS=$(<$CUSTOM_MODEL_OPT_FILE)
  echo "Detected custom model options $CUSTOM_MODEL_OPTS"
fi

P4TARGETCONFIG=""
CUSTOM_CONF_FILE=$TEST_DIR/custom_conf_file
if [[ $CONF_DISABLE == "" ]]; then
    if [[ $TARGET_CONFIG_FILE == "" ]]; then
      if [[ -f $CUSTOM_CONF_FILE ]]; then
        echo "Detected custom conf file $(<$CUSTOM_CONF_FILE)"
        TARGET_CONFIG_FILE=$SDE_INSTALL/share/p4/targets/${CHIP_ARCH}/$(<$CUSTOM_CONF_FILE)
      else
        TARGET_CONFIG_FILE=$SDE_INSTALL/share/p4/targets/${CHIP_ARCH}/${P4_NAME}.conf
      fi
    fi
    [[ ! -r $TARGET_CONFIG_FILE ]] && echo "Target config file not found" && exit 1
  P4TARGETCONFIG+="--p4-target-config $TARGET_CONFIG_FILE "
fi

# If no port info file was provided check if one exists for the test/program
# being run.
if [[ ! -r $PORTINFO ]]; then
  # Might have a TEST_DIR now, look for port json files.  For Tofino2, a chip
  # specific version would take precidence over a generic port json file.
  if [[ $CHIP_FAMILY == "tf2" ]]; then
    PORTINFO_FILE=$TEST_DIR/ports_tof2.json
    if [[ -r $PORTINFO_FILE ]]; then
      PORTINFO=$PORTINFO_FILE
    fi
  fi
  if [[ ! -r $PORTINFO ]]; then
    PORTINFO_FILE=$TEST_DIR/ports.json
    if [[ -r $PORTINFO_FILE ]]; then
      PORTINFO=$PORTINFO_FILE
    fi
  fi
fi

echo "Model using port info file: $PORTINFO"

export PATH=$SDE_INSTALL/bin:$PATH
export LD_LIBRARY_PATH=/usr/local/lib:$SDE_INSTALL/lib:$LD_LIBRARY_PATH

echo "Using PATH ${PATH}"
echo "Using LD_LIBRARY_PATH ${LD_LIBRARY_PATH}"

#Start tofino-model
sudo env "PATH=$PATH" "LD_LIBRARY_PATH=$LD_LIBRARY_PATH" $DBG tofino-model \
	$PORTMONITOR  \
	-d $NUM_DEVICES \
	-f $PORTINFO \
	$P4TARGETCONFIG --install-dir $SDE_INSTALL \
	$CUSTOM_MODEL_OPTS \
	$NO_LOG \
	--chip-type $CHIPTYPE \
	$LOG_DIR \
	$TIME_DISABLE \
	$JSON_LOGS_ENABLE \
	$PKT_LOG_LEN \
	$USE_PCIE_VETH \
	$DOD_TEST_MODE \
	$INT_PORT_LOOP $@
