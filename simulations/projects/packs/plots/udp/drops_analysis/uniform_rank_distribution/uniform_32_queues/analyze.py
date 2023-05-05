import csv

def analyze_drops():
    dropsFIFO = {}
    dropsAIFO = {}
    dropsSPPIFO = {}
    dropsPACKS = {}
    dropsPIFO = {}

    for i in range(0,101):
        dropsFIFO[i] = 0
        dropsAIFO[i] = 0
        dropsSPPIFO[i] = 0
        dropsPACKS[i] = 0
        dropsPIFO[i] = 0

    with open("temp/packs/udp/drops_analysis/uniform_rank_distribution/uniform_32_queues/FIFO_32/drops_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                dropsFIFO[rank] = dropsFIFO[rank] + 1

    with open("temp/packs/udp/drops_analysis/uniform_rank_distribution/uniform_32_queues/AIFO_32/drops_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                dropsAIFO[rank] = dropsAIFO[rank] + 1

    with open("temp/packs/udp/drops_analysis/uniform_rank_distribution/uniform_32_queues/SPPIFO_32/drops_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                dropsSPPIFO[rank] = dropsSPPIFO[rank] + 1

    with open("temp/packs/udp/drops_analysis/uniform_rank_distribution/uniform_32_queues/PACKS_32/drops_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                dropsPACKS[rank] = dropsPACKS[rank] + 1

    with open("temp/packs/udp/drops_analysis/uniform_rank_distribution/uniform_32_queues/PIFO_32/drops_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                dropsPIFO[rank] = dropsPIFO[rank] + 1

    # Write results in file
    w = open("projects/packs/plots/udp/drops_analysis/uniform_rank_distribution/uniform_32_queues/uniform32.dat", 'w')
    axis = range(0,100)
    w.write("#  FIFO    AIFO    SPPIFO    PACKS    PIFO\n")
    for line in range(0,len(axis)):
        w.write("%s   %s   %s   %s   %s   %s\n" % (axis[line], dropsFIFO[line], dropsAIFO[line], dropsSPPIFO[line], dropsPACKS[line], dropsPIFO[line]))

# Call analysis functions
analyze_drops()