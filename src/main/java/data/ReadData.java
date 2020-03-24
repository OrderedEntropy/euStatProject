package data;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;


public class ReadData {
	public static void main(String args[]) throws IOException, URISyntaxException {
		Downloader dl = new Downloader();
		File f = dl.getFile("https://ec.europa.eu/budget/library/figures/internet-tables-all.xls");
		
	}
}
