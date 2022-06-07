package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LenskartTest {
	@Test
	public void select() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.lenskart.com/");
		WebElement ele = driver.findElement(By.xpath("//a[text()='EYEGLASSES']"));
		Actions a= new Actions(driver);
		a.moveToElement(ele).perform();
		WebElement ele1 = driver.findElement(By.xpath("//div[@class='nav-level-2 nav-Eyeglasses']/descendant::div[@class='gender-menu-section menu-line-section']/descendant::div[@class='gender_img']/descendant::img[@title='men']"));
		a.moveToElement(ele1).perform();
		WebElement ele2 = driver.findElement(By.xpath("//div[@class='nav-level-2 nav-Eyeglasses']/descendant::div[@class='display-none gender_category gender-men']/descendant::span[text()='PREMIUM EYEGLASSES']"));
		a.moveToElement(ele2).perform();
		driver.findElement(By.xpath("//div[@class='nav-level-2 nav-Eyeglasses']/descendant::div[@class='display-none gender_category gender-men']/descendant::span[text()='PREMIUM EYEGLASSES']/ancestor::a[@class='getGaData']/following-sibling::div[@class='display-none select-submenu']/descendant::span[text()='Fossil']")).click();
	}

}
