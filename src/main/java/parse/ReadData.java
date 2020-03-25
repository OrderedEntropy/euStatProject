package parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import data.Downloader;

public class ReadData {
	public static ArrayList<Double> readData() throws FileNotFoundException, IOException {
		Downloader dl = new Downloader();
		String url = "https://ec.europa.eu/budget/library/figures/internet-tables-all.xls";
		dl.getFile(url, "data.xls");

		HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(new File("src/main/resources/data.xls")));
		ArrayList<Double> totals = new ArrayList<Double>();
		
		for (int i = 2009; i < 2019; i++) {
			HSSFSheet myExcelSheet = myExcelBook.getSheet(Integer.toString(i));
			for (int j = 2; j < 10; j++) {
				HSSFRow row = myExcelSheet.getRow(j);
				for (int k = 1; k < 10; k++) {
					if (row.getCell(k).getCellType() == HSSFCell.CELL_TYPE_STRING){
						if (row.getCell(k).getStringCellValue().contains("GROWTH")) {
							totals.add(row.getCell(k+1).getNumericCellValue());
//							System.out.println(i + " : " + row.getCell(k+1).getNumericCellValue());
							break;
						}
					}
				}
			}
			
		}
		
		return totals;
		// myExcelBook.close();

	}
}