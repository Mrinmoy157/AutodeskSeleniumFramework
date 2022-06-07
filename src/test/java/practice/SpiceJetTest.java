package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJetTest {
	@Test
	public void bookseat() throws Throwable {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[text()='round trip']/parent::div[@class='css-1dbjc4n']/preceding-sibling::div[@class='css-1dbjc4n r-zso239']/*[name()='svg']")).click();
		driver.findElement(By.xpath("//div[text()='From']")).click();
		driver.findElement(By.xpath("//div[text()='Ahmedabad']")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[text()='To']")).click();
		driver.findElement(By.xpath("//div[text()='Bagdogra International Airport']")).click();
		//driver.findElement(By.xpath("//div[text()='Return Date']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='April ']/ancestor::div[@data-testid='undefined-month-April-2022']/descendant::div[text()='8']")).click();
		driver.findElement(By.xpath("//div[text()='May ']/ancestor::div[@data-testid='undefined-month-May-2022']/descendant::div[text()='25']")).click();
		
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz r-1wtj0ep r-1lgpqti']/child::div[@class='css-1dbjc4n']")).click();
	}

}
