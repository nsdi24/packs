import csv

def analyze_inversions():
    inversionsFIFO = {}
    inversionsAIFO = {}
    inversionsSPPIFO = {}
    inversionsPACKS = {}

    for i in range(0,101):
        inversionsFIFO[i] = 0
        inversionsAIFO[i] = 0
        inversionsSPPIFO[i] = 0
        inversionsPACKS[i] = 0

    with open("temp/packs/tcp/inversions_analysis/uniform_rank_distribution/uniform_32_queues/FIFO_32/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                inversionsFIFO[rank] = inversionsFIFO[rank] + 1

    with open("temp/packs/tcp/inversions_analysis/uniform_rank_distribution/uniform_32_queues/AIFO_32/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                inversionsAIFO[rank] = inversionsAIFO[rank] + 1

    with open("temp/packs/tcp/inversions_analysis/uniform_rank_distribution/uniform_32_queues/SPPIFO_32/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                inversionsSPPIFO[rank] = inversionsSPPIFO[rank] + 1

    with open("temp/packs/tcp/inversions_analysis/uniform_rank_distribution/uniform_32_queues/PACKS_32/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                inversionsPACKS[rank] = inversionsPACKS[rank] + 1

    # Write results in file
    w = open("projects/packs/plots/tcp/inversions_analysis/uniform_rank_distribution/uniform_32_queues/uniform32.dat", 'w')
    axis = range(0,100)
    w.write("#    FIFO    AIFO    SP-PIFO    PACKS\n")
    for line in range(0,len(axis)):
        w.write("%s   %s   %s   %s   %s\n" % (axis[line], inversionsFIFO[line], inversionsAIFO[line], inversionsSPPIFO[line], inversionsPACKS[line]))

# Call analysis functions
analyze_inversions()