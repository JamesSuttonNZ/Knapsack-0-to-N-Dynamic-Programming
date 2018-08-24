package part3;

import java.util.Random;

/**
 * Generates knapsack values
 * @author James Sutton
 *
 */
public class TestGenerator_0_to_N_DP {

	public static void main(String[] args){
		
		String testArgs[] = new String[4];
		
		String weights = "";
		String values = "";
		String groupsizes = "";
		
		int noObjects = Integer.parseInt(args[0]);
		
		String[] wRange = args[1].split(",");
		int minWeight = Integer.parseInt(wRange[0]);
		int maxWeight = Integer.parseInt(wRange[1]);
		
		String[] vRange = args[2].split(",");
		int minValue = Integer.parseInt(vRange[0]);
		int maxValue = Integer.parseInt(vRange[1]);
		
		String[] gRange = args[3].split(",");
		int minGroupsize = Integer.parseInt(gRange[0]);
		int maxGroupsize = Integer.parseInt(gRange[1]);
		
		Random r = new Random(1);
		int w = r.nextInt((maxWeight-minWeight)+1) + minWeight;
		int v = r.nextInt((maxValue-minValue)+1) + minValue;
		int g = r.nextInt((maxGroupsize-minGroupsize)+1) + minGroupsize;
		weights += w;
		values += v;
		groupsizes += g;
		
		for(int i = 1; i < noObjects; i++){
			int w2 = r.nextInt((maxWeight-minWeight)+1) + minWeight;
			int v2 = r.nextInt((maxValue-minValue)+1) + minValue;
			int g2 = r.nextInt((maxGroupsize-minGroupsize)+1) + minGroupsize;
			weights += ","+w2;
			values += ","+v2;
			groupsizes += ","+g2;
		}
		
		testArgs[0] = weights;
		testArgs[1] = values;
		testArgs[2] = groupsizes;
		testArgs[3] = args[4]; // weight limit
		
		Knapsack_0_to_N_DP.main(testArgs);
	}
	
}
