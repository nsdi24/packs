import csv

def analyze_drops():
    dropsFIFO = {}
    dropsAIFO = {}
    dropsSPPIFO = {}
    dropsPACKS = {}
    dropsPIFO = {}
    dropsFixed_queue_bounds = {}

    for i in range(0,101):
        dropsFIFO[i] = 0
        dropsAIFO[i] = 0
        dropsSPPIFO[i] = 0
        dropsPACKS[i] = 0
        dropsPIFO[i] = 0
        dropsFixed_queue_bounds[i] = 0

    with open("temp/packs/tcp/drops_analysis/uniform_rank_distribution/uniform_8_queues/FIFO/drops_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                dropsFIFO[rank] = dropsFIFO[rank] + 1

    with open("temp/packs/tcp/drops_analysis/uniform_rank_distribution/uniform_8_queues/AIFO/drops_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                dropsAIFO[rank] = dropsAIFO[rank] + 1

    with open("temp/packs/tcp/drops_analysis/uniform_rank_distribution/uniform_8_queues/SPPIFO/drops_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                dropsSPPIFO[rank] = dropsSPPIFO[rank] + 1

    with open("temp/packs/tcp/drops_analysis/uniform_rank_distribution/uniform_8_queues/PACKS/drops_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                dropsPACKS[rank] = dropsPACKS[rank] + 1

    with open("temp/packs/tcp/drops_analysis/uniform_rank_distribution/uniform_8_queues/PIFO/drops_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                dropsPIFO[rank] = dropsPIFO[rank] + 1

    with open("temp/packs/tcp/drops_analysis/uniform_rank_distribution/uniform_8_queues/Fixed_queue_bounds/drops_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                dropsFixed_queue_bounds[rank] = dropsFixed_queue_bounds[rank] + 1

    # Write results in file
    w = open("projects/packs/plots/tcp/drops_analysis/uniform_rank_distribution/uniform_8_queues/uniform.dat", 'w')
    axis = range(0,100)
    w.write("#  FIFO    AIFO    SPPIFO    PACKS    PIFO    Fixed_queue_bounds\n")
    for line in range(0,len(axis)):
        w.write("%s   %s   %s   %s   %s   %s   %s\n" % (axis[line], dropsFIFO[line], dropsAIFO[line], dropsSPPIFO[line], dropsPACKS[line], dropsPIFO[line], dropsFixed_queue_bounds[line]))


# Call analysis functions
analyze_drops()
