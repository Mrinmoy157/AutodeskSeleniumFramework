package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsingLoginScriptInTestNG {
	@Test(dataProvider="getData")
	public void login(String lastname, String number) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.id("homephone")).sendKeys(number);
		driver.findElement(By.xpath("//b[text()='Contact Information']/preceding::input[@title='Save [Alt+S]']")).click();
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a= new Actions(driver);
		a.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		
		
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] objArray = new Object[5][2];
		objArray[0][0]="Verma";
		objArray[0][1]="4567781230";
		
		objArray[1][0]="Kumar";
		objArray[1][1]="4567891230";
		
		objArray[2][0]="Panigrahi";
		objArray[2][1]="7894561230";
		
		objArray[3][0]="Mishra";
		objArray[3][1]="2587413690";
		
		objArray[4][0]="Dutta";
		objArray[4][1]="7630215489";
		return objArray;
	}

}
