package main;

import parse.ReadData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import data.GrowthData;

public class Main {
	
	public static void main(String[] args) {
		try {
			ArrayList<Double> a = ReadData.readData();
			GrowthData growth = new GrowthData(a);
			ArrayList<Double> diff = growth.yearToYearDiff();
			
			//reporting here
			
			int startingYear = 2009;
			double dnum = 0;
			for(int i = 0; i < a.size(); i++) {
				if(i != 0)
					dnum = diff.get(i-1);
				System.out.printf("%-30.30s %-30.30s %-30.30s  %-30.30s%n", (startingYear + i), a.get(i), dnum, (dnum > 0));
//				System.out.print((startingYear + i) + " : " + a.get(i) + "\t");
//				if(i != 0) {
//					System.out.print(diff.get(i - 1));
//				}
//				System.out.println();
			}
			
		} catch (Exception e) {
			System.out.print("Couldn't parse data.");
		}
	}
}
