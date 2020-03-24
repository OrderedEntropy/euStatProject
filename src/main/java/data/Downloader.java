package data;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class Downloader {
	private File f;
	
	public File getFile(String st) throws MalformedURLException, URISyntaxException {
		URL url = new URL(st);
		f = Paths.get(url.toURI().getPath()).toFile();
		return f;
	}
}
