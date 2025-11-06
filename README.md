# cs2430-project3-knapsack
Programming Project 3 – Knapsack Problem (Experiments Payload Selection) in Java


Work divided general layout:




Data & Class Design (Setup and Structure)

Build the Experiment class (name, weight, rating) and a container class that holds them, with constructors, setters/getters, and print methods
Input the 12 experiments from the table provided in the assignment
Provide helper functions to compute total weight and rating.
This teammate’s code becomes the base data structure everyone else uses.



Greedy Algorithms (Three Heuristics)

Implement and test the three heuristic selection methods specified:
Highest rating first
Lightest weight first
Best rating-to-weight ratio (duplicates lose 2 points each)
Record, for each: subset chosen + total rating ≤ 700 kg.
Write the short explanations and tables answering:
“If you select only by weight… only by rating…



Brute-Force Search (Exact Optimum)

Enumerate all 2¹² = 4096 subsets of experiments and find the one with the highest rating under 700 kg
Report the winning subset and rating.
Optionally test a second creative approach (e.g., random search or greedy + swap) as suggested in the prompt



Dynamic Programming & Debug Analysis

Describe and implement a dynamic-programming algorithm for the knapsack problem
Run it, verify it matches the brute-force optimum, and include a walk-through (table/trace/graph) in the report showing how the DP table fills
Discuss performance with large objects and propose debugging methods for viewing intermediate data.

