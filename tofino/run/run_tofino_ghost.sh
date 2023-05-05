#!/bin/bash
# RUN WITH SUDO!

# Load driver
#sudo /data/bf-sde-9.12.0/install/bin/bf_kdrv_mod_unload 
sudo /data/bf-sde-9.12.0/install/bin/bf_kdrv_mod_load /data/bf-sde-9.12.0/install/

# Compile p4 program
. /data/set_sde_9.12.0.sh
#./p4_build.sh -p p4src/ghost.p4

#############
# Real switch
#############

# Create a new tmux session (in the background) where we run the code
tmux new -s tofino -d
tmux send-keys -t tofino '. /data/set_sde_9.12.0.sh' Enter
tmux send-keys -t tofino './run_switchd.sh -p ghost --arch tofino2' Enter

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
tmux split-window -h -p 50
tmux select-pane -t 2
tmux send-keys -t tofino '. /data/set_sde_9.12.0.sh' Enter
tmux send-keys -t tofino './run_pd_rpc.py pd_rpc/port_shaping_and_ghost.py'

# Attach to the session we have just created
tmux attach-session -t tofino