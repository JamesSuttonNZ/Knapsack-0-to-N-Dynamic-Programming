package part3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Dynamic Programming Algorithm to solve a 0-N Knapsack Problem
 * @author James Sutton
 *
 */
public class Knapsack_0_to_N_DP {

	private static int[] weights;
	private static int[] values;
	private static int[] refer; //for referencing object
	private static int[] groupsize;
	private static int[] choices;
	private static int weightLimit;
	private static int rows = 0;
	
	public static void main(String[] args){
		
		String[] w = args[0].split(",");
		weights = new int[w.length];
		for(int i = 0; i < w.length; i++){
			weights[i] = Integer.parseInt(w[i]);
		}
		
		String[] v = args[1].split(",");
		values = new int[v.length];
		for(int i = 0; i < v.length; i++){
			values[i] = Integer.parseInt(v[i]);
		}
		
		String[] g = args[2].split(",");
		groupsize = new int[g.length];
		for(int i = 0; i < g.length; i++){
			groupsize[i] = Integer.parseInt(g[i]);
		}
		
		for(int i = 0; i < groupsize.length; i++){
			rows += groupsize[i];
		}
		
		refer = new int[rows];
		
		int count = 0;
		for(int i = 0; i < groupsize.length; i++){
			for(int j = 0; j < groupsize[i]; j++){
				refer[count] = i;
				count++;
			}
		}
		
		weightLimit = Integer.parseInt(args[3]);
		
		if(values.length != weights.length || values.length != groupsize.length || weights.length != groupsize.length){
			throw new Error("number of values and weights needs to be the same");
		}
		
		for(int i = 0; i < groupsize.length; i++){
			if(groupsize[i] < 1){
				throw new Error("every group must be atleast of size 1");
			}
		}
		
		System.out.println("Weights: "+Arrays.toString(weights));
		System.out.println("Values: "+Arrays.toString(values));
		System.out.println("Groupsize: "+Arrays.toString(groupsize));
		System.out.println("Weight Limit: "+weightLimit+"\n");
		
		final long startTime = System.currentTimeMillis();
		knapsack();
		final long endTime = System.currentTimeMillis();

		System.out.println("\nTotal execution time: " + (endTime - startTime) + "ms");
	}

	/**
	 * creates dynamic programming table
	 */
	private static void knapsack() {
		
		int[][] V = new int[rows][weightLimit+1];
		
		for(int row = 0; row < rows; row++){
			int object = refer[row];
			for(int col = 0; col < weightLimit+1; col++){
				if(row == 0){
					if(weights[object] <= col && weights[object] <= weightLimit){
						V[row][col] = values[object];
					}
				}
				else{
					int above = V[row-1][col];
					if(col-weights[object] < 0){
						V[row][col] = above;
					}else{
						V[row][col] = Math.max(V[row-1][col], (V[row-1][col-weights[object]]+values[object]));
					}
				}
			}
		}
		//prints table commented out for execution time consistency
//		System.out.println("Table:");
//		for (int[] row : V){
//			System.out.println(Arrays.toString(row));
//		}
		
		recovery(V);
	}

	/**
	 * recovers chosen values from the table
	 * @param V
	 */
	private static void recovery(int[][] V) {
		//recovery
		choices = new int[values.length];
		int row = rows-1;
		int col = weightLimit;
		int totValue = 0;
		int totWeight = 0;
		while(row > 0){
			int score = V[row][col];
			int above = V[row-1][col];
			if(score == above){
				row--;
			}
			else{
				choices[refer[row]]++;
				col = col - weights[refer[row]];
				totValue += values[refer[row]];
				totWeight += weights[refer[row]];
				row--;	
			}
		}

		//check if we can take first row object
		if(totWeight+weights[refer[row]] <= weightLimit){
			choices[refer[row]]++;
			totValue += values[refer[row]];
			totWeight += weights[refer[row]];
		}
		
		System.out.println("\nChoices: "+Arrays.toString(choices));
		System.out.println("Total Value of chosen objects: "+totValue);
		System.out.println("Total Weight of chosen objects: "+totWeight);
	}
	
}
