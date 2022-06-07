package com.crm.Autodesk.handlingCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarIRCTCTest {

	public static void main(String[] args) throws Throwable {
		FileUtility futility= new FileUtility();
		WebDriverUtility wutility= new WebDriverUtility();
		
		String browser=futility.getPropertyKeyValue("browser");
		WebDriver driver= null;
		if(browser.equals("chrome"))
		{
			ChromeOptions option= new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			option.addArguments("--disable-notifications");
			driver= new ChromeDriver(option);
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver= new InternetExplorerDriver();
		}
		
		
		wutility.WaitForPageToLoad(driver);
		wutility.maximizeWindow(driver);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.xpath("//span[@class='ng-tns-c59-10 ui-calendar']")).click();
		driver.findElement(By.xpath("//div[@class='ui-datepicker-title ng-tns-c59-10']")).click();
		driver.findElement(By.xpath("//span[text()='March']/ancestor::div/descendant::a[text()='24']")).click();

	}

}
