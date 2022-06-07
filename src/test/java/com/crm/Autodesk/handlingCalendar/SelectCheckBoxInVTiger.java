package com.crm.Autodesk.handlingCalendar;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * this is organization class where we select all check boxes
 * @author mrinm
 *
 */
public class SelectCheckBoxInVTiger {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		List<WebElement> ele = driver.findElements(By.xpath("//input[@onclick='check_object(this)']"));
		for(WebElement a:ele) {
			a.click();
		}

	}

}
