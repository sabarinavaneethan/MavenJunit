package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelAdd {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\N.Sabari\\eclipse-workspace\\Maven\\Excel\\TestData.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(0);
		Cell c = r.getCell(0);
		String Cell = c.getStringCellValue();
		
		if(Cell.equals("S.No")) 
		{
			c.setCellValue("Serial.No");
		}
		FileOutputStream fout = new FileOutputStream(f);
		w.write(fout);
		System.out.println("Completed");
		
		
		
		}
}
