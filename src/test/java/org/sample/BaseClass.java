package org.sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	static WebDriver driver;
	   //Basic 
		public static void browserConfigChrome() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		public static void openUrl(String url) {
			driver.get(url);

		}
		
		public static void maximizeWindow() {
			driver.manage().window().maximize();
		}
		
		public String CurrentUrl() {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;

		}
		
		public String GetTitle() {
			String title = driver.getTitle();
			return title;

		}
		
		public static WebElement locateById(String id) {
			WebElement TxtUser = driver.findElement(By.id(id));
			return TxtUser;
             
		}
		
		public WebElement LocateByName(String name) {
			   WebElement element = driver.findElement(By.name(name));
			   return element;
			}
		
		public WebElement locateByXpath(String xpath) 
		{
			
			WebElement element = driver.findElement(By.xpath(xpath));
            return element;
		}
	
		
		public static void textInput(WebElement element,String value) {
			element.sendKeys(value);
		}
		
		
		public static void Click(WebElement element) {
			element.click();
		}
		
	
		public static void refresh() {
			driver.navigate().refresh();
		}
		
		public void quit() {
			driver.quit();

		}
		
		public String getText(WebElement element) {
			String text = element.getText();
			return text;

		}
		
		public String getAttribute(WebElement element) {
			String attribute = element.getAttribute("value");
			return attribute;
		}

		
		
		
		
		
		
		//ExcelRead And ExcelWrite
		public String excelWrite(String path,String Sheet,int r,int c ) throws IOException 
		{
			File f = new File(path);
			
			String value = null;
			
			
			FileInputStream fin = new FileInputStream(f);
			
			Workbook w = new XSSFWorkbook(fin);
			
			Sheet sheet = w.getSheet(Sheet);
			
			Row row = sheet.getRow(r);
			
			Cell cell = row.getCell(c);
			
			
			
			int cellType = cell.getCellType();
			
			if (cellType==1) 
			{
				value = cell.getStringCellValue();
			}
			
			else if(cellType==0)
			{
				if (DateUtil.isCellDateFormatted(cell))
				{
                  Date dateCellValue = cell.getDateCellValue();
                  SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
                  value = s.format(dateCellValue);
				}
				else
				{
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					value = String.valueOf(l);
				}
			}
			
			return value;

		}
		
		
		public void excelModify(String path,String sheet,int row,int cell,String name) throws IOException
		{
			
			File f = new File(path);
			FileInputStream fin = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fin);
			Sheet s = w.getSheet(sheet);
			Row r = s.getRow(row);
			Cell c = r.getCell(cell);
			
            c.setCellValue(name);
            FileOutputStream fout = new FileOutputStream(f);
            w.write(fout);
		}

		
		public void createCellExcel(String path,String sheet,int row,int cell,String name)throws IOException
		{
		
				
				File f = new File(path);
				FileInputStream fin = new FileInputStream(f);
				Workbook w = new XSSFWorkbook(fin);
				Sheet s = w.getSheet(sheet);
				Row r = s.createRow(row);
				Cell c = r.createCell(cell);
	            c.setCellValue(name);
	            FileOutputStream fout = new FileOutputStream(f);
	            w.write(fout);
		
		}
		
		
		
		
		
		
		//MouseOverAnd DragandDrop
		
		public void actionsMouseOver (WebElement element) {
			Actions obj = new Actions(driver);
	        obj.moveToElement(element).perform();
		}
	
		
		public void dragAndDrop(WebElement Src,WebElement Drop) {
			Actions acc = new Actions(driver);
			acc.dragAndDrop(Src, Drop).perform();

		}
		
		public void doubleClick(WebElement element) {
			Actions obj = new Actions(driver);
			obj.doubleClick(element).perform();

		}
		
		public void rightClick(WebElement element) {
			Actions obj = new Actions(driver);
			obj.contextClick(element).perform();
		}
		
		public void singleClick(WebElement element) {
			Actions obj = new Actions(driver);
			obj.click(element).perform();
		}
		
		
		
		
		
		//Robot
		
		public void usingRobotDown(int count) throws AWTException 
		{
			Robot r = new Robot();
			for (int i = 0; i < count ; i++) 
			{
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
			}
			
		}
		public void usingRobotEnter() throws AWTException {
		  Robot r = new Robot();
		  r.keyPress(KeyEvent.VK_ENTER);
		  r.keyRelease(KeyEvent.VK_ENTER);
			
		}
		
		public void robotPaste() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
			
			
		}
		
		public void robotCut() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_X);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_X);
			
			
		}
		
		
		
		
		
		
		
		
		//Alert
		public void alertAccept() {
			Alert a = driver.switchTo().alert();
			a.accept();

		}
		public void alertDismiss() {
			Alert a = driver.switchTo().alert();
			a.dismiss();

		}
	   
		public void alertWithTextInput(String text) {
			Alert a = driver.switchTo().alert();
			a.sendKeys(text);
			a.accept();
		}
		
		
		
		
		
		
		
		
		
		//Select
		
		public void selectByIndex(WebElement element,int index) {
			
			Select s = new Select(element);
			s.selectByIndex(index);

		}
		public void selectByValue(WebElement element,String value) {
			Select s = new Select(element);
			s.selectByValue(value);

		}
		public void selectByVisibleText(WebElement element,String text)
		{
			Select s = new Select(element);
			s.selectByVisibleText(text);

		}
		public int getNumberOptions(WebElement element) {
			Select s = new Select(element);
			List<WebElement> op = s.getOptions();
			int size = op.size();
			return size;

		}
		
		public List<String> getOptions(WebElement element) {
			Select s = new Select(element);
			List<WebElement> op = s.getOptions();
			List<String> li = new ArrayList<String>();
			for (WebElement webElement : op) 
			{
				String text = webElement.getText();
					li.add(text);
				
			}
			return li;

		}
		
		public List<String> getOptionsAttribute(WebElement element) {
			
			Select s = new Select(element);
			List<WebElement> op = s.getOptions();
			List<String> li= new ArrayList<String>();
			
			for (WebElement x : op)
			{
				String st = x.getAttribute("value");
				li.add(st);
			}
			return li;
			
		}
		
		
		public List<String> forGetOptions(WebElement element) {
			Select s = new Select(element);
			List<WebElement> op = s.getOptions();
			List<String> Li = new ArrayList<String>();
			
			for (int i = 0; i < op.size(); i++) {
				WebElement x = op.get(i);
				String text = x.getText();
				Li.add(text);
			}
			return Li;
		}
		
		public List<String> forGetOptionsAttribute(WebElement element) {
			Select s = new Select(element);
            List<WebElement> op = s.getOptions();
            List<String> Li = new ArrayList<String>();
            for (int i = 0; i < op.size(); i++) 
            {
				WebElement x = op.get(i);
				String attribute = x.getAttribute("value");
				Li.add(attribute);
			}
			return Li;
			
		}
		
		
		
		
		//SelectMultipleOption
		public boolean isMultiple(WebElement element) {
			
			Select s = new Select(element);
			boolean multiple = s.isMultiple();
			return multiple;

		}
		
		public void selectAllOptions(WebElement element)
		{
			Select s = new Select(element);
			List<WebElement> op = s.getOptions();
			for (int i = 0; i < op.size(); i++) 
			{
				s.selectByIndex(i);
			}
		}
		
		public void printAllOptionAttribute(WebElement element) 
		{
			Select s = new Select(element);
			List<WebElement> op = s.getOptions();
			for (WebElement x : op) 
			{
				String attribute = x.getDomAttribute("value");
				System.out.println(attribute);
			}
			

		}
		 
		public void printAllOptionText(WebElement element)
		{
			
		Select s = new Select(element);
		List<WebElement> op = s.getOptions();
		for (int i = 0; i < op.size(); i++) 
		{
		    WebElement x = op.get(i);
		    String text = x.getText();
		    System.out.println(text);	
		}	
		}
		
		public void deselectOption(WebElement element,int count) {
			Select s = new Select(element);
			List<WebElement> op = s.getOptions();
			s.deselectByIndex(count-1);	
		}
		
		public void deselectAllOption(WebElement element) {
			Select s = new Select(element);
			s.deselectAll();

		}
		
		
		public void getFirstSelectedOption(WebElement element) {
			Select s = new Select(element);
			WebElement x = s.getFirstSelectedOption();
			String text = x.getText();
			System.out.println(text);

		}
		
		public void selectRequiredOptions(WebElement element, int count) {
			Select s = new Select(element);
			
			for (int i = 0; i < count; i++) 
			{
				s.selectByIndex(i);
			}

		}
		
		
		public void selectOptionsfromdown(WebElement element, int count) 
		{
			Select s = new Select(element);
			for (int i = 0; i < count; count--)
			{
				s.selectByIndex(count);
				
			}

		}
		
		
		public void selectMidOption(WebElement element) {
			Select s = new Select(element);
			List<WebElement> op = s.getOptions();
			int sizeofoption = op.size();
			int midValue=sizeofoption/2;
			s.selectByIndex(midValue);

		}
		
		public void selectEvenOption(WebElement element) {
			Select s = new Select(element);
			List<WebElement> op = s.getOptions();
			int size = op.size();
			for (int i = 0; i < size; i++) 
			{
				if (i%2!=0) 
				{
					s.selectByIndex(i);
				}
			}

		}
		
		public void selectOddOption(WebElement element) {
			Select s = new Select(element);
			List<WebElement> op = s.getOptions();
			int size = op.size();
			for (int i = 0; i < size; i++) 
			{
				if (i%2==0) 
				{
					s.selectByIndex(i);
				}
			}

		}
		
		
		//Window Handling
		public String windowHandling() 
			{
			String parent = driver.getWindowHandle();	
			Set<String> All = driver.getWindowHandles();
		
			for (String x : All) 
			{
				if (!parent.equals(x)) 
				{
					driver.switchTo().window(x);
			
				}	
			}
			return parent;
			}
		
		
		public void parentWindow(String parent) 
			{
			driver.switchTo().window(parent);

			}
		
		
		public void windowHandle2() {
			
			Set<String> All = driver.getWindowHandles();
			
			
			List<String> li = new ArrayList<String>();
			
			li.addAll(All);
			System.out.println("Set "+All);
			System.out.println("List "+li);
			
			String Child2 = li.get(2);
			driver.switchTo().window(Child2);

		}
		
		
		
		//ScreenShot
		public void takesScreenshot(String name) throws IOException {
			TakesScreenshot tk = (TakesScreenshot) driver;
			File src = tk.getScreenshotAs(OutputType.FILE);
			File desc = new File("C:\\Users\\N.Sabari\\eclipse-workspace\\Maven\\ScreenShot\\"+name+".png");
			FileUtils.copyFile(src, desc);

		}
		
		
		
		
		//JavaScript
		public void JavascriptExecutor(String script,WebElement element) 
		{
		 JavascriptExecutor jk =  (JavascriptExecutor) driver;
		 
		 jk.executeScript(script, element);
		 //script="arguments[0].setAttribute('value','sabari11998@gmail.com')"
			
		}
		
		public String JavascriptGetAttribute(String script, WebElement element) {
			
			JavascriptExecutor jk = (JavascriptExecutor) driver;
			Object attribute = jk.executeScript(script, element);
			//script="return arguments[0].getAttribute('value')"
			String text = (String) attribute;
			return text;

		}
		
		
		
		//WebTable
		public void webTableEachElement() 
		{
			List<WebElement> ListofRows = driver.findElements(By.tagName("tr"));//Note Here I have used FindElements
			for (int i = 0; i < ListofRows.size() ; i++) 
			{
			 WebElement row = ListofRows.get(i); //This WebElement row has two "td" tagname.
			 List<WebElement> ListofData = row.findElements(By.tagName("td"));//Note here I have used FindElements
			 for (int j = 0; j < ListofData.size(); j++) 
			 {
				 WebElement Data = ListofData.get(j);
				 String text = Data.getText();
				 System.out.println(text);
				 
			}
			 
			 
				
			}

		}
		
		public List<WebElement> usingFindElementsWebTable(String tagName) 
		{
			List<WebElement> ListofWebElements = driver.findElements(By.tagName(tagName));
			return ListofWebElements;
		}
		

		public void webTableElement(int rownumber,int cellnumber) 
		{
			List<WebElement> ListofRows = driver.findElements(By.tagName("tr"));//Note Here I have used FindElements			
			 WebElement row = ListofRows.get(rownumber); //This WebElement row has two "td" tagname.
			 List<WebElement> ListofData = row.findElements(By.tagName("td"));//Note here I have used FindElements			
				 WebElement Data = ListofData.get(cellnumber);
				 String text = Data.getText();
				 System.out.println(text);
			
		}		
		
		public void RowAndCellOfTable() {
			List<WebElement> ListofRows = driver.findElements(By.tagName("tr"));//Note Here I have used FindElements
			for (int i = 0; i < ListofRows.size() ; i++) 
			{
			 WebElement row = ListofRows.get(i); //This WebElement row has two "td" tagname.
			 List<WebElement> ListofData = row.findElements(By.tagName("td"));//Note here I have used FindElements
			 for (int j = 0; j < ListofData.size(); j++) 
			 {
				 WebElement Data = ListofData.get(j);
				 String text = Data.getText();
				 if (text.equals("third cell")) 
				 {
					System.out.println(text);
					System.out.println(i+1);
					System.out.println(j+1);
				}
			}
			 
			 
				
			}
			
		}
		
		
}
