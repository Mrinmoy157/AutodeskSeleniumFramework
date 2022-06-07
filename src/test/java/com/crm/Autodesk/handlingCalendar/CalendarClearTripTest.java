package com.crm.Autodesk.handlingCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarClearTripTest {

	public static void main(String[] args) throws Throwable {
		String month="May 2022";
		String date="24";
		FileUtility futility=new FileUtility();
		WebDriverUtility wutility= new WebDriverUtility();
		
		String browser=futility.getPropertyKeyValue("browser");
		WebDriver driver=null;
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver= new InternetExplorerDriver();
		}
		
		wutility.WaitForPageToLoad(driver);
		wutility.maximizeWindow(driver);
		driver.get("https://www.cleartrip.com/flights");
		driver.findElement(By.xpath("//button[@style='min-width: 250px;']")).click();
		String path="//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::div[text()='"+date+"']";
		//driver.findElement(By.xpath(path)).click();
		for(;;) {
			try {
				driver.findElement(By.xpath(path)).click();
				break;
			}catch(Exception e)
			{
				driver.findElement(By.xpath("//div[@class='flex-1 ta-right']")).click();
			}
		}


	}

}
