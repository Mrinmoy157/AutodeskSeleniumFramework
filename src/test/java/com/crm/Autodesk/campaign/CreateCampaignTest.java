package com.crm.Autodesk.campaign;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.crm.autodesk.genericUtility.ExcelUtility;
import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignTest {

	public static void main(String[] args) throws Throwable {
		
		
		
		FileUtility futility= new FileUtility();
		ExcelUtility eutility= new ExcelUtility();
		WebDriverUtility wutility=new WebDriverUtility();
		
		
//		FileInputStream fil= new FileInputStream("./src\\test\\resources\\TestData.xlsx");
//		Workbook wb=WorkbookFactory.create(fil);
//		Sheet sheet = wb.getSheet("Sheet4");
//		int rowCount= sheet.getLastRowNum();
//		int columnCount= sheet.getRow(0).getLastCellNum();
//		
//		System.out.println("Total number of rows"+rowCount);
//		System.out.println("Total number of columns"+columnCount);
//		
//		for(int i=0;i<=rowCount;i++)
//		{
//			for(int j=0;j<columnCount;j++)
//			{
//				Row row = sheet.getRow(i);
//				Cell cell = row.getCell(j);
//				String data=cell.getStringCellValue();
//				System.out.print(data+"  ");
//			}
//			System.out.println();
//		}
		String campaign=eutility.getDataFromExcel("sheet4", 1, 0);
		System.out.println("Campaign selected is "+campaign);
		
		
//		FileInputStream fis = new FileInputStream("./src\\main\\resources\\commondata\\credentials.properties");
//		Properties pro_obj= new Properties();
//		pro_obj.load(fis);
//		String browser = pro_obj.getProperty("browser");
//		String url = pro_obj.getProperty("url");
//		String username = pro_obj.getProperty("username");
//		String password = pro_obj.getProperty("password");
//		System.out.println(browser);
//		System.out.println(url);
//		System.out.println(username);
//		System.out.println(password);
		
		String browser=futility.getPropertyKeyValue("browser");
		String url=futility.getPropertyKeyValue("url");
		String username=futility.getPropertyKeyValue("username");
		String password=futility.getPropertyKeyValue("password");
		
		
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Enter valid browser");
		}
		
		//driver.manage().window().maximize();
		wutility.maximizeWindow(driver);
		driver.get(url);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		wutility.WaitForPageToLoad(driver);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		wutility.mouseOverOnElement(driver, ele);
//		Actions a=new Actions(driver);
//		a.moveToElement(ele).perform();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campaign);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for(String b:child)
		{
			driver.switchTo().window(b);
		}
		driver.findElement(By.linkText("Mobile")).click();
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.close();

	}

}
