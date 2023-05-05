import csv

def analyze_inversions():

    inversionsFIFO = {}
    inversionsFIFO[0] = 0
    inversionsFIFO[1] = 0
    inversionsFIFO[2] = 0
    inversionsFIFO[3] = 0
    inversionsFIFO[4] = 0

    inversionsAIFO = {}
    inversionsAIFO[0] = 0
    inversionsAIFO[1] = 0
    inversionsAIFO[2] = 0
    inversionsAIFO[3] = 0
    inversionsAIFO[4] = 0

    inversionsSPPIFO = {}
    inversionsSPPIFO[0] = 0
    inversionsSPPIFO[1] = 0
    inversionsSPPIFO[2] = 0
    inversionsSPPIFO[3] = 0
    inversionsSPPIFO[4] = 0

    inversionsPACKS = {}
    inversionsPACKS[0] = 0
    inversionsPACKS[1] = 0
    inversionsPACKS[2] = 0
    inversionsPACKS[3] = 0
    inversionsPACKS[4] = 0

    # FIFO
    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/FIFO_20/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsFIFO[0] = inversionsFIFO[0] + 1

    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/FIFO_40/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsFIFO[1] = inversionsFIFO[1] + 1

    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/FIFO_60/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsFIFO[2] = inversionsFIFO[2] + 1

    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/FIFO_80/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsFIFO[3] = inversionsFIFO[3] + 1

    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/FIFO_90/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsFIFO[4] = inversionsFIFO[4] + 1

    # AIFO
    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/AIFO_20/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsAIFO[0] = inversionsAIFO[0] + 1

    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/AIFO_40/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsAIFO[1] = inversionsAIFO[1] + 1

    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/AIFO_60/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsAIFO[2] = inversionsAIFO[2] + 1

    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/AIFO_80/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsAIFO[3] = inversionsAIFO[3] + 1

    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/AIFO_90/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsAIFO[4] = inversionsAIFO[4] + 1

    # SPPIFO
    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/SPPIFO_20/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsSPPIFO[0] = inversionsSPPIFO[0] + 1

    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/SPPIFO_40/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsSPPIFO[1] = inversionsSPPIFO[1] + 1

    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/SPPIFO_60/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsSPPIFO[2] = inversionsSPPIFO[2] + 1

    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/SPPIFO_80/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsSPPIFO[3] = inversionsSPPIFO[3] + 1

    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/SPPIFO_90/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsSPPIFO[4] = inversionsSPPIFO[4] + 1

    # PACKS
    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/PACKS_20/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsPACKS[0] = inversionsPACKS[0] + 1

    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/PACKS_40/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsPACKS[1] = inversionsPACKS[1] + 1

    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/PACKS_60/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsPACKS[2] = inversionsPACKS[2] + 1

    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/PACKS_80/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsPACKS[3] = inversionsPACKS[3] + 1

    with open("temp/packs/udp/inversions_analysis/uniform_rank_distribution/utilization/PACKS_90/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            inversionsPACKS[4] = inversionsPACKS[4] + 1


    axis = [20,40,60,80,90]

    # Write results in file
    w = open("projects/packs/plots/udp/inversions_analysis/uniform_rank_distribution/utilization/utilization.dat", 'w')
    w.write("#  FIFO    AIFO    SPPIFO    PACKS\n")
    for line in range(0,len(axis)):
        w.write("%s   %s   %s   %s   %s\n" % (axis[line], inversionsFIFO[line], inversionsAIFO[line], inversionsSPPIFO[line], inversionsPACKS[line]))

# Call analysis functions
analyze_inversions()