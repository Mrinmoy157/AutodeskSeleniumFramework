package practice;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrganizationAndDeleteTest {

	public static void main(String[] args) throws Throwable {
		Random r= new Random();
		int rannum=r.nextInt(1000);
		String name="mrin"+rannum;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(name);
		driver.findElement(By.xpath("//b[text()='Organization Information']/preceding::input[@title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Organizations")).click();
//		WebDriverWait w= new WebDriverWait(driver,20);
//		w.until(ExpectedConditions.elementToBeClickable(check)).click();
//		List<WebElement> ele = driver.findElements(By.xpath("//a[@title='Organizations']"));
		
//		for(WebElement a:ele) {
//			Thread.sleep(5000);
//			String value = a.getText();
//			System.out.println(value);
//			//for(;;) {
//			if(value=="vtiger") {
//				//a.click();
//				System.out.println("found");
//				driver.findElement(By.xpath("//a[@title='Organizations']")).click();
//				//break;
//			}
//			else {
//				System.out.println("not found");
//			}
		
//		for(;;) {
//			try {
//				driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
//				break;
//			}
//			catch(Exception e) {
//				List<WebElement> ele = driver.findElements(By.xpath("//a[@title='Organizations']"));
//				
//			
//			driver.findElement(By.xpath("//a[text()='Create Mail Merge templates ']/following::img[@src='themes/images/next.gif']")).click();
//			}
		
//			else {
//				driver.findElement(By.xpath("//a[text()='Create Mail Merge templates ']/following::img[@src='themes/images/next.gif']")).click();
//			   Thread.sleep(5000);
//			}
//			
//		}
//		driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		//}
	
//		}
		
		
		for(;;) {
			try {
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[text()='"+name+"']")).click();
				break;
			}catch(Exception e) {
				driver.findElement(By.xpath("//a[text()='Create Mail Merge templates ']/following::img[@src='themes/images/next.gif']")).click();
			}
		}
		driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		driver.switchTo().alert().accept();
			
		

	}

}
