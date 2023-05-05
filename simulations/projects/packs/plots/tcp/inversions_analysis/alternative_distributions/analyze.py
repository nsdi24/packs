import csv

def analyze_inversions(distribution):
    inversionsFIFO = {}
    inversionsAIFO = {}
    inversionsSPPIFO = {}
    inversionsPACKS = {}

    for i in range(0,101):
        inversionsFIFO[i] = 0
        inversionsAIFO[i] = 0
        inversionsSPPIFO[i] = 0
        inversionsPACKS[i] = 0

    with open("temp/packs/tcp/inversions_analysis/alternative_distributions/" + distribution + "/FIFO/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                inversionsFIFO[rank] = inversionsFIFO[rank] + 1

    with open("temp/packs/tcp/inversions_analysis/alternative_distributions/" + distribution + "/AIFO/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                inversionsAIFO[rank] = inversionsAIFO[rank] + 1

    with open("temp/packs/tcp/inversions_analysis/alternative_distributions/" + distribution + "/SPPIFO/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                inversionsSPPIFO[rank] = inversionsSPPIFO[rank] + 1

    with open("temp/packs/tcp/inversions_analysis/alternative_distributions/" + distribution + "/PACKS/inversions_tracking.csv.log") as file:
        reader = csv.reader(file)
        for row in reader:
            device_id = int(row[0])
            rank = int(row[1])
            if device_id == 0:
                inversionsPACKS[rank] = inversionsPACKS[rank] + 1

    # Write results in file
    w = open("projects/packs/plots/tcp/inversions_analysis/alternative_distributions/" + distribution + "/" + distribution + ".dat", 'w')
    axis = range(0,100)
    w.write("#    FIFO    AIFO    SPPIFO    PACKS\n")
    for line in range(0,len(axis)):
        w.write("%s   %s   %s   %s   %s\n" % (axis[line], inversionsFIFO[line], inversionsAIFO[line], inversionsSPPIFO[line], inversionsPACKS[line]))

# Call analysis functions
analyze_inversions('convex')
analyze_inversions('exponential')
analyze_inversions('poisson')
analyze_inversions('inverse_exponential')