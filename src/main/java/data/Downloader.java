package data;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import org.apache.commons.io.FileUtils;
public class Downloader {

	public void getFile(String url, String name) {
		try {
			FileUtils.copyURLToFile(new URL(url), new File("src/main/resources/" + name));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}