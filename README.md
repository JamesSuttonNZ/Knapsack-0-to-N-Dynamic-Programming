# Dynamic Programming Algorithm to solve a 0-N Knapsack Problem

## How to run

To run use the TestGenerator_0_to_N_DP class main method (recommended).
This randomly generates weights, values and groupsizes within given ranges.
This takes 5 command line arguments:
1.	number of objects in knapsack (int) e.g. 10
2.	weight range, comma separated min and max values (int,int) e.g. 1,10
3.	value range, comma separated min and max values (int,int) e.g. 1,10
4.	groupsize range, comma separated min and max values (int,int) e.g. 1,10
5.	weight limit of knapsack (int) e.g. 100

Alternatively the main method in the Knapsack_0_to_N_DP class can be used to specify the weight and value of each object
This takes 4 command line arguments:
1.	comma separated weights (int) e.g. 3,4,5,6,7
2.	comma separared values (int) e.g. 7,6,5,4,3
3.	comma separared values (int) e.g. 2,3,1,3,3
4.	weight limit of knapsack (int) e.g. 20
(there must be an equal number of values and weights as each pair represents the weight and value of an object in the knapsack)