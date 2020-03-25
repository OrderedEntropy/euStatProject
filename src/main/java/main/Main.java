package main;

import parse.ReadData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		try {
			ArrayList<Double> a = ReadData.readData();
			System.out.print(a.toString());
		} catch (Exception e) {
			System.out.print("Couldn't parse data.");
		}
	}
}
