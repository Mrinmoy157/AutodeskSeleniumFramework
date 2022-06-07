package com.crm.Autodesk.handlingCalendar;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * this is calendar class where we fetch all the flight names
 * @author mrinm
 *
 */
public class CalendarMakeMyTrip {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Actions a = new Actions(driver);
		a.moveByOffset(1, 1).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("//p[text()='Bangalore, India']")).click();
		driver.findElement(By.id("toCity")).click();
		driver.findElement(By.xpath("//p[text()='Chhatrapati Shivaji International Airport']")).click();
		//driver.findElement(By.xpath("//span[text()='DEPARTURE'")).click();
		driver.findElement(By.xpath("//div[text()='March 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='11']")).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		List<WebElement> ele = driver.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));
		for(WebElement b:ele) {
			String name=b.getText();
			System.out.println("flight name is "+name);
		}
		
	}

}
