package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoibiboTest {


	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/hotels/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("CountryType")).click();
		driver.findElement(By.xpath("//input[@data-testid='home-autosuggest-input']")).sendKeys("bangalore");
		driver.findElement(By.id("downshift-1-menu")).click();
		driver.findElement(By.xpath("//div[@data-testid='openCheckinCalendar']")).click();
		driver.findElement(By.xpath("//span[text()='March 2022']/ancestor::div[@data-testid='CalendarBlockOuterWrapper']/descendant::span[@data-testid='date_31_2_2022']")).click();
		driver.findElement(By.xpath("//span[text()='April 2022']/ancestor::div[@data-testid='CalendarBlockOuterWrapper']/descendant::span[@data-testid='date_1_3_2022']")).click();
		driver.findElement(By.xpath("//span[text()='Guests & Rooms']")).click();
		driver.findElement(By.xpath("//span[text()='Children']/following::span[text()='+']")).click();
		driver.findElement(By.xpath("//span[text()='Children']/following::span[text()='+']")).click();
		driver.findElement(By.xpath("//span[text()='Children']/following::span[text()='+']")).click();
		driver.findElement(By.xpath("//p[text()='1']/preceding::h4[text()='Select']")).click();
		driver.findElement(By.xpath("//li[text()='3']")).click();
		driver.findElement(By.xpath("//p[text()='2']/preceding::h4[text()='Select']")).click();
		driver.findElement(By.xpath("//li[text()='6']")).click();
		driver.findElement(By.xpath("//p[text()='3']/preceding::h4[text()='Select']")).click();
		driver.findElement(By.xpath("//li[text()='10']")).click();
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		driver.findElement(By.xpath("//button[@data-testid='searchHotelBtn']")).click();
		List<WebElement> ele = driver.findElements(By.xpath("//h4[@itemprop='name']"));
		for(WebElement a:ele) {
			String hotels=a.getText();
			System.out.println(hotels);
		}
		
		
		
		

	}

}
