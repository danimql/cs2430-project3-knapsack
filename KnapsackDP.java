package project_3;

import java.util.*;

public class KnapsackDP {
    public static void main(String[] args) {
        final int MAX_WEIGHT = 700;

        List<Experiment> experiments = Arrays.asList(
            new Experiment("Cloud Patterns", 36, 5),
            new Experiment("Solar Flares", 264, 9),
            new Experiment("Solar Power", 188, 6),
            new Experiment("Binary Stars", 203, 8),
            new Experiment("Relativity", 104, 8),
            new Experiment("Seed Viability", 7, 4),
            new Experiment("Sun Spots", 90, 2),
            new Experiment("Mice Tumors", 65, 8),
            new Experiment("Microgravity Plant Growth", 75, 5),
            new Experiment("Micrometeorites", 170, 9),
            new Experiment("Cosmic Rays", 80, 7),
            new Experiment("Yeast Fermentation", 27, 4)
        );

        int n = experiments.size();
        int[][] dp = new int[n + 1][MAX_WEIGHT + 1];

        // Build DP table
        for (int i = 1; i <= n; i++) {
            Experiment exp = experiments.get(i - 1);
            for (int w = 0; w <= MAX_WEIGHT; w++) {
                if (exp.weight > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - exp.weight] + exp.rating);
                }
            }
        }

        // Optional: Print snapshot of DP table for debugging
        System.out.println("\n--- DP Table Snapshot (every 100 kg) ---");
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= MAX_WEIGHT; col += 100) {
                System.out.printf("%4d ", dp[row][col]);
            }
            System.out.println();
        }

        // Backtrack to find selected experiments
        List<Experiment> selected = new ArrayList<>();
        int remainingWeight = MAX_WEIGHT;
        System.out.println("\n--- Backtracking Steps ---");
        for (int index = n; index > 0; index--) {
            if (dp[index][remainingWeight] != dp[index - 1][remainingWeight]) {
                Experiment exp = experiments.get(index - 1);
                selected.add(exp);
                System.out.println("Included: " + exp.name + " (" + exp.weight + " kg, Rating: " + exp.rating + ")");
                remainingWeight -= exp.weight;
            }
        }

        // Output final results
        System.out.println("\nMaximum Rating Achieved: " + dp[n][MAX_WEIGHT]);
        System.out.println("Selected Experiments:");
        for (Experiment exp : selected) {
            System.out.println("- " + exp.name + " (" + exp.weight + " kg, Rating: " + exp.rating + ")");
        }
    }
}