"""
runs moongen script to replay traffic at a given rate
"""

import os
import sys

if __name__ == "__main__":

    # Configuration
    dev = 3
    file = "experiment/sender/caida_baseline.pcap"
    rate_multiplier = 4 # Read the pcap at twice the speed
    
    if len(sys.argv) == 1:
        print("Two arguments are required")
    
    else:
            os.system("sudo /opt/MoonGen/build/MoonGen experiment/sender/moongen/bandwidth.lua {}".format(dev))
