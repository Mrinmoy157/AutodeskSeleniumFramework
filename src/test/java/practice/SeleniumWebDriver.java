package practice;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWebDriver {

	public static void main(String[] args) {
		
		Random r= new Random();
		int random=r.nextInt(100);
		String name="tyMantra"+random;
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(name);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String value = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(value.contains(name))
		{
			System.out.println(name+" test case is pass");
		}
		else
		{
			System.out.println(name+" test case is fail");
		}
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a= new Actions(driver);
		a.moveToElement(ele).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

	}

}
