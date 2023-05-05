#! /bin/bash

SDE_VERSION=9.12.0
SDE_PATH=/data/

SDE_VERSION=$1
# path where the SDE and files are
SDE_PATH=$2

# if install for tofino use --flag-hardware (add it as third version)

# python dependencies
sudo apt-get install python3-dev python3-pip
sudo ln -sf $(which python3) /usr/bin/python
sudo ln -sf $(which pip3) /usr/bin/pip

# create set_sde.sh file
cat > $SDE_PATH/set_sde_$SDE_VERSION.sh <<EOF
export SDE=/home/$USER/bf-sde-$SDE_VERSION
export SDE_INSTALL=/home/$USER/bf-sde-$SDE_VERSION/install
export PATH=/home/nsg/bin:/home/nsg/.local/bin:/home/nsg/bin:/home/nsg/.local/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin::/home/$USER/bf-sde-$SDE_VERSION/install/bin
echo "using SDE $SDE_VERSION in \$SDE"
EOF

chmod a+x $SDE_PATH/set_sde_$SDE_VERSION.sh

# sets the sde for every open bash
echo ". $SDE_PATH/set_sde_$SDE_VERSION.sh" >> ~/.bashrc

# unzip SDE files and tools
cd $SDE_PATH
tar zxvf $SDE_PATH/bf-sde-$SDE_VERSION.tgz
tar zxvf $SDE_PATH/ica-tools.tar 

if [[ $* == *--flag-hardware* ]]; then
   ln -s $SDE_PATH/bf-sde-$SDE_VERSION ~/bf-sde-$SDE_VERSION
   ln -s $SDE_PATH/tools ~/tools
fi

# install SDE
cd $SDE/p4studio
# install dependencies
sudo ./install-p4studio-dependencies.sh

# default install (good for a vm)

if [[ $* == *--flag-hardware* ]]; then
    cat > ./profiles/hardware-install.yaml <<EOF
global-options:
  asic: true
features:
  bf-diags:
    thrift-diags: true
  drivers:
    bfrt: true
    bfrt-generic-flags: true
    grpc: true
    p4rt: true
    thrift-driver: true
  p4-examples:
    - p4-14-programs
    - p4-16-programs
  bf-platforms:
    bsp-path: $SDE_PATH/bf-reference-bsp-$SDE_VERSION.tgz
  switch:
    profile: x1_tofino
    sai: true
    thrift-switch: true
architectures:
  - tofino
EOF
sudo ./p4studio profile apply ./profiles/hardware-install.yaml
else
    sudo ./p4studio profile apply ./profiles/all-tofino.yaml
fi