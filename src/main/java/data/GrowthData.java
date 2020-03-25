package data;

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
	
	/**
	 * Iterate through growthValues and check whether values are increasing or not
	 * 
	 * @return whether growth is increasing based on data set values
	 */
	public boolean isGrowing() {
		if (datasets < 2) {
			return false;
		}
		int prev = growthValues.get(0);
		for (int i = 1; i < datasets; ++i) {
			int curr = growthValues.get(i);
			if (prev >= curr) {
				return false;
			} else {
				prev = curr;
			}
		}
		return true;
	}
	
	/**
	 * Compute differences between data set values and assign to a list [DIFF]
	 * DIFF.length = datasets.length - 1
	 * 
	 * @return list of value differences between data set values
	 * 	ex. { (li[1] - li[0]), (li[2] - li[1]), ... , (li[li.length) - li[li.length - 1]) }
	 */
	public ArrayList<Integer> yearToYearDiff() {
		ArrayList<Integer> DIFF = new ArrayList<Integer>();
		if (datasets < 2) return DIFF;
		
		int prev = growthValues.get(0);
		for (int i = 0; i < datasets - 1; ++i) {
			int curr = growthValues.get(i + 1);
			DIFF.add(curr - prev);
			prev = curr;
		}
		
		return DIFF;
	}
	
	public static void main(String args[]) {
		
		ArrayList<Integer> li = new ArrayList<Integer>();
		li.add(157);
		li.add(432);
		li.add(2136);
		li.add(824);
		li.add(4507);
			
		for (Integer i : li) System.out.print(i + " ");
		
		GrowthData gd = new GrowthData(li);
		
		System.out.println("\n" + gd.isGrowing());
		
		System.out.println(gd.yearToYearDiff());
		
	}
	
}
