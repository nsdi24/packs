#!/bin/bash

echo -e "Running AIFO evaluation using run_aifo.sh"

# Compile
mvn clean compile assembly:single
java -jar -ea NetBench.jar

#/* Figure 7 */
#python3 parse.py fig 7a
#python3 parse.py fig 7b
#python3 parse.py fig 7c

#/* Figure 8 */
#python3 parse.py fig 8a
#python3 parse.py fig 8b
#python3 parse.py fig 8c

#/* Figure 9 */
#python3 parse.py fig 9a
#python3 parse.py fig 9b
#python3 parse.py fig 9c

#/* Figure 10 */
#python3 parse.py fig 10a
#python3 parse.py fig 10b

#/* Figure 11 */
#python3 parse.py fig 11a
#python3 parse.py fig 11b

#/* Figure 12 */
#python3 parse.py fig 12a
#python3 parse.py fig 12b
#python3 parse.py fig 12c
#python3 parse.py fig 12d

#/* Figure 13 */
#python3 parse.py fig 13a
#python3 parse.py fig 13b
#python3 parse.py fig 13c
#python3 parse.py fig 13d

#/* Figure 14 */
#python3 parse.py fig 14a
#python3 parse.py fig 14b
#python3 parse.py fig 14c