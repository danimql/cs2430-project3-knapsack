package project3;
/**
 * This class stores information about an experiment.
 * Each experiment has a name, a weight, and a rating.
 * It provides getters for all fields and a setter for the rating.
 * @author Guillermo Nasif
 */
public class Experiments {
	
	private String experiment;
	private int weight;
	private int rating;
	
	public Experiments(String experiment, int weight, int rating){
		this.experiment = experiment;
		this.weight = weight;
		this.rating = rating;
	}

	public String getExperiment() {
		return experiment;
	}

	public int getWeight() {
		return weight;
	}

	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
		public String toString() {
			
			return experiment + " " + weight + " " + rating ;
		}
	
	
	

}
