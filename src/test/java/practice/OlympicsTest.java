package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicsTest {
	@Test
	public void getData() {
		String name="Suzanne";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://olympics.com/");
		driver.findElement(By.xpath("//div[@id='onetrust-button-group']/child::button[text()='Yes, I am happy']")).click();
		driver.findElement(By.xpath("//a[@href=\"/en/athletes/\"]/ancestor::ul[@class='b2p-nav__menu -header--links analytics-multiple-cta']/descendant::span[text()='Athletes']")).click();
		driver.findElement(By.xpath("//button[@class='button-no-styles icon-close-button pvp-modal__close']")).click();
		driver.findElement(By.xpath("//span[text()='"+name+"']")).click();
		WebElement ele = driver.findElement(By.xpath("//div[@class='col-right d-flex']"));
		System.out.println(ele.getText());
		driver.close();
	}

}
