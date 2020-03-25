package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadData {
	public static void main(String args[]) throws FileNotFoundException, IOException {
		Downloader dl = new Downloader();
		String url = "https://ec.europa.eu/budget/library/figures/internet-tables-all.xls";
		dl.getFile(url, "data.xls");

		HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(new File("src/main/resources/data.xls")));

		for (int i = 2009; i < 2019; i++) {
			HSSFSheet myExcelSheet = myExcelBook.getSheet(Integer.toString(i));
			for (int j = 2; j < 10; j++) {
				HSSFRow row = myExcelSheet.getRow(j);
				for (int k = 1; k < 10; k++) {
					if (row.getCell(k).getCellType() == HSSFCell.CELL_TYPE_STRING){
						if (row.getCell(k).getStringCellValue().contains("GROWTH")) {
							System.out.println(i + " : " + row.getCell(k+1).getNumericCellValue());
							break;
						}
					}
				}
			}
			
		}
		// myExcelBook.close();

	}
}