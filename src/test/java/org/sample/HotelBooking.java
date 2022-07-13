package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HotelBooking extends BaseClass{
	
	public static void main(String[] args) throws IOException, Exception {
		HotelBooking s = new HotelBooking();
		
		s.browserConfigChrome();
		s.maximizeWindow();
		s.openUrl("http://www.adactin.com/HotelApp/");
	
		WebElement User = s.locateById("username");
		s.textInput(User,s.excelWrite("C:\\\\Users\\\\N.Sabari\\\\eclipse-workspace\\\\MavenJunit\\\\Excel\\\\HotelBooking.xlsx", "Sheet1", 0, 1) );
	
		WebElement Password = s.locateById("password");
		s.textInput(Password,s.excelWrite("C:\\\\Users\\\\N.Sabari\\\\eclipse-workspace\\\\MavenJunit\\\\Excel\\\\HotelBooking.xlsx", "Sheet1",1, 1) );
		
		
		WebElement Login = s.locateById("login");
		s.Click(Login);
		
		s.locateById("location");
		Thread.sleep(2000);
		WebElement Location = s.locateById("location");
		s.selectByIndex(Location, 3);
		
		
		WebElement Hotels = s.locateById("hotels");
		s.selectByIndex(Hotels, 4);
		
		
		s.locateById("room_type");
		Thread.sleep(2000);
		WebElement Room_type =s.locateById("room_type");
		s.selectByIndex(Room_type, 2);
		
		
		WebElement No_of_Room =s.locateById("room_nos");
		s.selectByIndex(No_of_Room, 2);

		Thread.sleep(2000);
		
		WebElement Adult = s.locateById("adult_room");
		s.selectByIndex(Adult, 3);
		
		
		WebElement Child = s.locateById("child_room");
		s.selectByIndex(Child, 4);
		
		
		WebElement Search =s.locateById("Submit");   
		s.Click(Search);
		
		
		Thread.sleep(2000);
		WebElement RadioButton = s.locateById("radiobutton_0");
		s.Click(RadioButton);
		
		
		WebElement Submit =s.locateById("continue");
		s.Click(Submit);
		
		
		WebElement FirstName = s.locateById("first_name");
		s.textInput(FirstName, s.excelWrite("C:\\Users\\N.Sabari\\eclipse-workspace\\MavenJunit\\Excel\\HotelBooking.xlsx", "Sheet1", 2, 1));
		
		
		WebElement LastName =s.locateById("last_name");
		s.textInput(LastName, s.excelWrite("C:\\Users\\N.Sabari\\eclipse-workspace\\MavenJunit\\Excel\\HotelBooking.xlsx", "Sheet1", 3, 1));
		
		WebElement Address =s.locateById("address");
		s.textInput(Address, s.excelWrite("C:\\Users\\N.Sabari\\eclipse-workspace\\MavenJunit\\Excel\\HotelBooking.xlsx", "Sheet1", 4, 1));
		
		s.locateById("cc_num");
		WebElement CreditCard = s.locateById("cc_num");
		s.textInput(CreditCard, s.excelWrite("C:\\Users\\N.Sabari\\eclipse-workspace\\MavenJunit\\Excel\\HotelBooking.xlsx", "Sheet1", 5, 1));
		
		
		
		WebElement CreditCardType = s.locateById("cc_type");
		s.selectByIndex(CreditCardType, 2);
		
		
		WebElement ExpiryMonth = s.locateById("cc_exp_month");
		s.selectByIndex(ExpiryMonth, 2);
		
		
		WebElement ExpiryYear =s.locateById("cc_exp_year");
		s.selectByIndex(ExpiryYear, 4);
		
		
		WebElement CvvNumber = s.locateById("cc_cvv");
		s.textInput(CvvNumber, s.excelWrite("C:\\Users\\N.Sabari\\eclipse-workspace\\MavenJunit\\Excel\\HotelBooking.xlsx", "Sheet1", 6, 1));
		
		
		WebElement Book = s.locateById("book_now");
		s.Click(Book);
		
		Thread.sleep(2000);
		WebElement List = s.locateByXpath("//a[text()='Booked Itinerary']");
		s.Click(List);
		
		WebElement OrderNo = s.locateById("order_id_626545");
	    String attribute = OrderNo.getAttribute("value");
	    System.out.println(attribute);
    
    	s.excelModify("C:\\Users\\N.Sabari\\eclipse-workspace\\MavenJunit\\Excel\\HotelBooking.xlsx", "Sheet1", 7, 1, attribute);
    	
		s.quit();
		
	}
	
	

}
