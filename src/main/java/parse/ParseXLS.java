package parse;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ParseXLS {

	XSSFWorkbook workbook;

	public ParseXLS(String filename) {
		try {
			FileInputStream file = new FileInputStream(new File(filename));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void outputNumbers() {
		//get sheets for 2008 to 2018
		for (int i = 2008; i < 2018; i++) {
			XSSFSheet sheet = workbook.getSheet(Integer.toString(i));
			System.out.println(sheet.toString());
		}
	}

	public static void main() {
		ParseXLS hi = new ParseXLS("hi");
		hi.outputNumbers();
	}

}
