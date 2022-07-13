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
import org.openqa.selenium.WebElement;

public class FaceBook extends BaseClass {

	public static void main(String[] args) throws IOException, Exception {
		
		FaceBook s = new FaceBook();
		s.browserConfigChrome();
		s.maximizeWindow();
		s.openUrl("https://www.facebook.com");
		
		WebElement User = s.locateById("email");
		s.textInput(User, s.excelWrite("C:\\Users\\N.Sabari\\eclipse-workspace\\MavenJunit\\Excel\\Facebook.xlsx", "Sheet1", 1, 0));
		
		
		WebElement Password = s.locateById("pass");
		s.textInput(Password,s.excelWrite("C:\\Users\\N.Sabari\\eclipse-workspace\\MavenJunit\\Excel\\Facebook.xlsx", "Sheet1", 1, 1) );
		
		
		WebElement Login = s.LocateByName("login");
		s.Click(Login);
		
		Thread.sleep(2000);
		WebElement ExcelWrite = s.locateByXpath("//a[text()='Forgotten password?']");
		String attribute = ExcelWrite.getText();
		System.out.println(attribute);
		
		s.excelModify("C:\\Users\\N.Sabari\\eclipse-workspace\\MavenJunit\\Excel\\Facebook.xlsx", "Sheet1", 1, 2, attribute);

		
        s.quit();
	
	}
		
		
	}
	
	
