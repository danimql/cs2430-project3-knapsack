package project3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * This class contains all the methods that will be used to calculate the experiments we want to select based on different approaches
 * and will also have the main method testing out all the methods.
 * @author Guillermo Nasif
 */
public class ExperimentApp {

	public static void main(String[] args) {
		
		Experiments[] exp = {
				new Experiments("Cloud Patterns", 36 , 5),
				new Experiments("Solar Flares", 264 , 9),
				new Experiments("Solar Power", 188 , 6),
				new Experiments("Binary Stars", 203 , 8),
				new Experiments("Relativity", 104 , 8),
				new Experiments("Seed Viability", 7 , 4),
				new Experiments("Sun Spots", 90 , 2),
				new Experiments("Mice Tumors", 65 , 8),
				new Experiments("Microgravity Plant Growth", 75 , 5),
				new Experiments("Micrometeorites", 170 , 9),
				new Experiments("Cosmic Rays", 80 , 7),
				new Experiments("Yeast Fermentation", 27 , 4)
		};
		
		//sort array based on weight in ascending order
		Arrays.sort(exp, Comparator.comparingInt(Experiments::getWeight) );
		System.out.println("Possible experiments to be considered based on their weight:");
		System.out.println("------------------------------------------------------------");
		Experiments[] weightResult = weightBased(exp);
		for(Experiments e : weightResult) {
			if (e != null ) System.out.println(e);
		}
		System.out.println();
		System.out.println("Total rating of experiments selected based on their weight : " + ratingCalculator(weightResult));
		System.out.println();
		
		//sort array based on rating in descending order
		Arrays.sort(exp, Comparator.comparingInt(Experiments::getRating).reversed());
		System.out.println("Possible experiments to be considered based on their rating:");
		System.out.println("------------------------------------------------------------");
		Experiments[] ratingResult = ratingBased(exp);
		for(Experiments ex : ratingResult) {
			if (ex != null ) System.out.println(ex);
		}
		System.out.println();
		System.out.println("Total rating of experiments selected based on their rating : " + ratingCalculator(ratingResult));
		System.out.println();
		
		//sorting array by ratio of rating/weight in descending order
		Arrays.sort(exp, Comparator.comparingDouble( e -> (double) ((Experiments) e).getRating()/((Experiments) e).getWeight()).reversed());
		System.out.println("Possible experiments to be considered based on the ratio of rating/weight:");
		System.out.println("--------------------------------------------------------------------------");
		Experiments[] ratioResult = ratioBased(exp);
		for(Experiments ex : ratioResult) {
			if (ex != null ) System.out.println(ex);
		}
		System.out.println("Total rating of experiments selected based on their rating : " + ratingCalculator(ratioResult));
		System.out.println();
		
		//Generating new numbers for rating and showing them
//		ratingGenerator(exp);
//		for(Experiments ex : exp) {
//			if (ex != null ) System.out.println(ex);
//		}
	}
	
	/**
	 * Looks for the experiments with the lightest to the most massive that won't go over the weight limit(700 kg)
	 * @param exp array of type Experiments containing all the experiments already sorted
	 * @return an array of type Experiments containing the experiments that will fit in the spaceshift and from the lightest to the heaviest
	 */
	public static Experiments[] weightBased(Experiments[] exp) {
		Experiments[] weightExp = new Experiments[exp.length];
		int initialWeight = 0;
		int index = 0;
		for (int i = 0; i < exp.length ; i++) {
			if (initialWeight + exp[i].getWeight() <=700) {
				//adding experiment to the new array
				weightExp[index] = exp[i];
				index++;
				initialWeight = initialWeight + exp[i].getWeight();
			}
		}
		return weightExp;
	}
	
	/**
	 * Creates an array containing the experiments with the highest rating and below the weight limit
	 * @param exp array of type Experiments containing all the experiments already sorted
	 * @return an array of type Experiments containing the experiments with the highest rating that will fit in the spaceshift
	 */
	public static Experiments[] ratingBased(Experiments[] exp) {
		Experiments[] ratingExp = new Experiments[exp.length];
		int initialWeight = 0;
		int index = 0;
		for (int i = 0 ; i < exp.length ; i++) {
			if (initialWeight + exp[i].getWeight() <=700) { //still checking that we won't go over the weight limjt
				//adding experiment to the new array
				ratingExp[index] = exp[i];
				index++;
				initialWeight = initialWeight + exp[i].getWeight();
			}
		}
		return ratingExp;
	}
	
	/**
	 * Creates an array containing the experiments with the highest ratio of mass/rate below the weight limit
	 * @param exp array of type Experiments containing all the experiments already sorted in mass/rate ratio
	 * @return array of type Experiments containing the experiments with the highest rating that will fit in the spaceshift
	 */
	public static Experiments[] ratioBased(Experiments[] exp) {
		Experiments[] ratioExp = new Experiments[exp.length];
		int initialWeight = 0;
		int index = 0;
		for (int i = 0 ; i < exp.length ; i++) {
			if (initialWeight + exp[i].getWeight() <=700) { //still checking that we won't go over the weight limit
				//adding experiment to the new array
				ratioExp[index] = exp[i];
				index++;
				initialWeight = initialWeight + exp[i].getWeight();
			}
		}
		return ratioExp;
	}
	
	
	/**
	 * Helper Method to calculate the rating of the specified array
	 * @param exp  array of type Experiments
	 * @return the total Rating of the specified array
	 */
	public static int ratingCalculator(Experiments[] exp) {
		int totalRating = 0;
		for(Experiments e : exp) {
			if (e != null) totalRating = totalRating + e.getRating();
		}
		return totalRating;
	}
	
	/**
	 * Arbitrary function for generating rating numbers based on their weight
	 */
//	public static void ratingGenerator(Experiments[] exp) {
//		int max = 0;
//		for(int i = 0 ; i < exp.length ; i++) {
//			if (exp[i].getWeight()> max) max = exp[i].getWeight(); // finding the heaviest element
//		}
//		for (int i = 0 ; i < exp.length ; i++) {
			//setting the rating based on the weight of the element, possible if we have a setter in the Element class
//			if (exp[i].getWeight() == max) exp[i].setRating(9);
//			else if (exp[i].getWeight() < max && exp[i].getWeight() >= max-50) exp[i].setRating(8);
//			else if (exp[i].getWeight() < max-70 && exp[i].getWeight() >= max-120) exp[i].setRating(7);
//			else if (exp[i].getWeight() < max-120 && exp[i].getWeight() >= max-140) exp[i].setRating(6);
//			else if (exp[i].getWeight() < max-140 && exp[i].getWeight() >= max-160) exp[i].setRating(5);
//			else if (exp[i].getWeight() < max-160 && exp[i].getWeight() >= max-180) exp[i].setRating(4);
//			else if (exp[i].getWeight() < max-180 && exp[i].getWeight() >= max-200) exp[i].setRating(3);
//			else if (exp[i].getWeight() < max-200 && exp[i].getWeight() >= max-220) exp[i].setRating(2);
//			else if (exp[i].getWeight() < max-220) exp[i].setRating(1);  
//			
//		}
//		
//	}
}
