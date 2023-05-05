#!/bin/bash

echo -e "Running PACKS evaluation using run_packs.sh"

# Compile
mvn clean compile assembly:single
java -jar -ea NetBench.jar