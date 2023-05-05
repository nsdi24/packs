#!/bin/bash
# RUN WITH SUDO!

# Load driver
#sudo /data/bf-sde-9.12.0/install/bin/bf_kdrv_mod_unload 
sudo /data/bf-sde-9.12.0/install/bin/bf_kdrv_mod_load /data/bf-sde-9.12.0/install/

# Compile p4 program
. /data/set_sde_9.12.0.sh
#./p4_build.sh -p p4src/packs.p4

#############
# Real switch
#############

# Create a new tmux session (in the background) where we run the code
tmux new -s tofino -d
tmux send-keys -t tofino '. /data/set_sde_9.12.0.sh' Enter
tmux send-keys -t tofino './run_switchd.sh -p packs --arch tofino2' Enter

# Configure the ports
tmux send-keys -t tofino 'ucli' Enter

# Arak ens787f0
tmux send-keys -t tofino 'pm port-add 2/0 10G NONE' Enter
tmux send-keys -t tofino 'pm an-set 2/0 2' Enter
tmux send-keys -t tofino 'pm port-enb 2/0' Enter

# Boilover enp130s0f0
tmux send-keys -t tofino 'pm port-add 8/0 100G NONE' Enter
tmux send-keys -t tofino 'pm an-set 8/0 2' Enter
tmux send-keys -t tofino 'pm port-enb 8/0' Enter

tmux send-keys -t tofino 'pm show' Enter

# Add a new window pane for the pd-rpc
tmux split-window -h -p 33
tmux select-pane -t 2
tmux send-keys -t tofino '. /data/set_sde_9.12.0.sh' Enter
tmux send-keys -t tofino './run_pd_rpc.py pd_rpc/port_shaping_and_ghost.py' Enter

# Add a new window pane for the bfrt
tmux split-window -h -p 50
tmux select-pane -t 3
tmux send-keys -t tofino '. /data/set_sde_9.12.0.sh' Enter
tmux send-keys -t tofino './run_bfshell.sh -b bfrt/bfrt_priorities.py'

# Attach to the session we have just created
tmux attach-session -t tofino

: '
#############
# Tofino model
#############
# Remove /data/bf-sde-9.12.0/install/lib/libpltfm_mgr.so from the path
# Unload the kernel module to use the tofino model
sudo /data/bf-sde-9.12.0/install/bin/bf_kdrv_mod_unload 

# Create a new tmux session (in the background) where we run the tofino_model
tmux new -s tofinomodel -d
tmux send-keys -t tofinomodel '. /data/set_sde_9.12.0.sh' Enter
tmux send-keys -t tofinomodel './run_tofino_model_97.sh -p aifo > output_model.log'  Enter

# Add a new window pane for the run_switchd
tmux split-window -h -p 75
tmux select-pane -t 2
tmux send-keys -t tofinomodel '. /data/set_sde_9.12.0.sh' Enter
sudo $SDE_INSTALL/bin/veth_setup.sh
tmux send-keys -t tofinomodel './run_switchd.sh -p aifo'

# Add a new window pane for the scapy (send packets)
tmux split-window -h -p 50
tmux select-pane -t 4
tmux send-keys -t tofinomodel 'sudo ipython' Enter
tmux send-keys -t tofinomodel 'from scapy.all import sendp, sniff, Ether, IP, UDP, TCP' Enter
tmux send-keys -t tofinomodel 'pkt = Ether()/IP(src="0.0.0.8", dst="0.0.0.0", ttl=0, len=1024, id=0)/TCP(sport=0,dport=0)' Enter
tmux send-keys -t tofinomodel 'sendp(pkt, iface="veth0", count=1)'

# Add a new window pane for the scapy (receive packets)
tmux split-window -v
tmux select-pane -t 5
tmux send-keys -t tofinomodel 'sudo ipython' Enter
tmux send-keys -t tofinomodel 'from scapy.all import sendp, sniff, Ether, IP, UDP, TCP' Enter
tmux send-keys -t tofinomodel 'sniff(iface="veth0", prn=lambda x: x.show())' Enter

tmux attach-session -t tofinomodel
'