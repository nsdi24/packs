"""
runs moongen script to process incoming traffic
"""

import os
import sys

if __name__ == "__main__":
    
    if len(sys.argv) == 2:
        if sys.argv[1] == "fifo":
            os.system("sudo /opt/MoonGen/build/MoonGen experiment/receiver/receiver.lua 4 fifo")
        if sys.argv[1] == "packs":
            os.system("sudo /opt/MoonGen/build/MoonGen experiment/receiver/receiver.lua 4 packs")