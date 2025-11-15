package project3;

public class Project3Q5 {

    public static void main(String[] args) {

        ExperimentContainer container = new ExperimentContainer();

        container.addExperiment(new Experiment("Cloud Patterns", 36, 5));              // 1
        container.addExperiment(new Experiment("Solar Flares", 264, 9));              // 2
        container.addExperiment(new Experiment("Solar Power", 188, 6));               // 3
        container.addExperiment(new Experiment("Binary Stars", 203, 8));              // 4
        container.addExperiment(new Experiment("Relativity", 104, 8));                // 5
        container.addExperiment(new Experiment("Seed Viability", 7, 4));              // 6
        container.addExperiment(new Experiment("Sun Spots", 90, 2));                  // 7
        container.addExperiment(new Experiment("Mice Tumors", 65, 8));                // 8
        container.addExperiment(new Experiment("Microgravity Plant Growth", 75, 5));  // 9
        container.addExperiment(new Experiment("Micrometeorites", 170, 9));           // 10
        container.addExperiment(new Experiment("Cosmic Rays", 80, 7));                // 11
        container.addExperiment(new Experiment("Yeast Fermentation", 27, 4));         // 12

        int capacity = 700;

        //brute-force caller
        container.findBestSubset(capacity);
    }
}
