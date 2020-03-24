package datareport;

import java.util.ArrayList;


/**
 * 
 * @author JasonDiego
 * 
 * GrowthData encapsulates a number of integer values inside an ArrayList
 * It has methods that can be used to analyze its data and run assertion-like checks
 *
 */
public class GrowthData {
	
	private ArrayList<Integer> growthValues;
	private int datasets;
	
	public GrowthData(ArrayList<Integer> growthValues) {
		this.growthValues = growthValues;
		datasets = growthValues.size();
	}
	
	public boolean isGrowthIncreasing() {
		if (datasets < 2) {
			return false;
		}
		int prev = growthValues.get(0);
		for (int i = 1; i < datasets; ++i) {
			int curr = growthValues.get(i);
			if (prev >= curr) {
				return false;
			} else {
				prev = growthValues.get(i);
			}
		}
		return true;
	}
	
	public static void main(String args[]) {
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(4);
		list.add(2);
		
		for (Integer i : list) System.out.print(i + " ");
		
	}
	
}
