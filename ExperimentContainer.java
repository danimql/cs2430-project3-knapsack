package project3;

import java.util.ArrayList;
import java.util.List;

public class ExperimentContainer {

    private List<Experiment> experiments;

    public ExperimentContainer() {
        this.experiments = new ArrayList<>();
    }

    public void addExperiment(Experiment e) {
        experiments.add(e);
    }

    public List<Experiment> getExperiments() {
        return experiments;
    }

    //brute-force solution
    public void findBestSubset(int capacity) {
        int n = experiments.size();

        int bestRating = -1;
        int bestWeight = 0;
        int bestMask = 0;

        int totalSubsets = 1 << n;  // 2^n

        for (int mask = 0; mask < totalSubsets; mask++) {
            int totalWeight = 0;
            int totalRating = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    Experiment e = experiments.get(i);
                    totalWeight += e.getWeight();
                    totalRating += e.getRating();
                }
            }

            if (totalWeight <= capacity && totalRating > bestRating) {
                bestRating = totalRating;
                bestWeight = totalWeight;
                bestMask = mask;
            }
        }

        System.out.println("Best total rating = " + bestRating);
        System.out.println("Total weight = " + bestWeight);
        System.out.println("Chosen experiments:");

        for (int i = 0; i < n; i++) {
            if ((bestMask & (1 << i)) != 0) {
                Experiment e = experiments.get(i);
                int experimentNumber = i + 1;
                System.out.println(experimentNumber + ": " +
                        e.getName() + " (" + e.getWeight() +
                        " kg, rating " + e.getRating() + ")");
            }
        }
    }
}
