package org.sample;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Naukri extends BaseClass {

	public static void main(String[] args) throws IOException {
		
		Naukri s = new Naukri();
		s.browserConfigChrome();
		s.maximizeWindow();
		s.openUrl("https://my.naukri.com/account/register/basicdetails");
		WebElement FullName = s.locateById("name");
		s.textInput(FullName, s.excelWrite("C:\\Users\\N.Sabari\\eclipse-workspace\\MavenJunit\\Excel\\Naukri.xlsx", "Sheet1", 0, 1));
		
		WebElement Email = s.locateById("email");
		s.textInput(Email,s.excelWrite("C:\\Users\\N.Sabari\\eclipse-workspace\\MavenJunit\\Excel\\Naukri.xlsx", "Sheet1", 1, 1));
		
		WebElement Password = s.locateById("password");
		s.textInput(Password, s.excelWrite("C:\\Users\\N.Sabari\\eclipse-workspace\\MavenJunit\\Excel\\Naukri.xlsx", "Sheet1", 2, 1));
		
		WebElement mobile = s.locateById("mobile");
		s.textInput(mobile, s.excelWrite("C:\\Users\\N.Sabari\\eclipse-workspace\\MavenJunit\\Excel\\Naukri.xlsx", "Sheet1", 3, 1));
		
		WebElement WorkStatus = s.locateByXpath("//h2[text()=\"I'm Experienced\"]");
		WorkStatus.click();
		
		WebElement TextTick = s.locateByXpath("//a[@class=\"checkbox-wrap on  \"]");
		TextTick.click();
		
		WebElement RegisterNow = s.locateByXpath("//button[@type=\"submit\"]");
		RegisterNow.click();
		
		
	}
	
	
}
