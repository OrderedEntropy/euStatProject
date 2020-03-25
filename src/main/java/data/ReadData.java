package data;

import java.io.File;


public class ReadData {
	public static void main(String args[]) {
		Downloader dl = new Downloader();
		String url = "https://ec.europa.eu/budget/library/figures/internet-tables-all.xls";
		dl.getFile(url, "data.xls");

	}
}