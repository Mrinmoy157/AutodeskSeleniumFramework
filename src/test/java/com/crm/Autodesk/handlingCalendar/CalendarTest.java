package com.crm.Autodesk.handlingCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * thi is calendar class where where we hardcode the day and month
 * @author mrinm
 *
 */
public class CalendarTest {

	public static void main(String[] args) throws Throwable {
FileUtility futility= new FileUtility();
		
		WebDriverUtility wutility= new WebDriverUtility();
		
		String browser=futility.getPropertyKeyValue("browser");
		
		WebDriver driver=null;
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver=new InternetExplorerDriver();
			
		}
		
		wutility.WaitForPageToLoad(driver);
		wutility.maximizeWindow(driver);
		driver.get("https://www.makemytrip.com");
		Actions a=new Actions(driver);
		a.moveByOffset(1,1).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		driver.findElement(By.xpath("//div[text()='March 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='7']")).click();
		driver.close();

	}

}
