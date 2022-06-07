package com.crm.Autodesk.handlingCalendar;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * this is calendar class using date
 * @author mrinm
 *
 */
public class CalendarMakeMyTripDate {
	public static void main(String[] args) {
		LocalDateTime dateAndTime= LocalDateTime.now();
		String month=dateAndTime.getMonth().toString();
		System.out.println(month);
		int date=dateAndTime.getDayOfMonth();
		System.out.println(date);
		int year=dateAndTime.getYear();
		System.out.println(year);
		String actualMonth=month.substring(0,1)+month.substring(1).toLowerCase();
		String monthAndYear=actualMonth+" "+year;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Actions a = new Actions(driver);
		a.moveByOffset(1, 1).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		driver.findElement(By.xpath("//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
	}

}
