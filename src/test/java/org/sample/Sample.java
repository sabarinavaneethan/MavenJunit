package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sample {
	
	public static void main(String[] args) throws Exception {
		File f = new File("C:\\Users\\N.Sabari\\eclipse-workspace\\MavenJunit\\Excel\\HotelBooking.xlsx");
		
		String value = null;
		
		
		FileInputStream fin = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fin);
		
		Sheet sheet = w.getSheet("Sheet1");
		
		Row row = sheet.getRow(4);
		
		Cell cell = row.getCell(1);
		
		System.out.println(cell);
		
		int cellType = cell.getCellType();
		System.out.println(cellType);
	}

}
