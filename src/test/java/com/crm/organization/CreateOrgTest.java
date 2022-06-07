package com.crm.organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.crm.autodesk.genericUtility.ExcelUtility;
import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.JavaUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgTest {

	public static void main(String[] args) throws Throwable {
		
		JavaUtility jutility=new JavaUtility();
		ExcelUtility eutility=new ExcelUtility();
		FileUtility futility= new FileUtility();
		WebDriverUtility wutility=new WebDriverUtility();
		
//		  FileInputStream fil= new FileInputStream("./src\\test\\resources\\TestData.xlsx"); Workbook
//		  wb=WorkbookFactory.create(fil); Sheet sheet = wb.getSheet("Sheet1"); int
//		  rowCount= sheet.getLastRowNum(); int columnCount=
//		  sheet.getRow(0).getLastCellNum();
//		  
//		  System.out.println("Total number of rows"+rowCount);
//		  System.out.println("Total number of columns"+columnCount);
//		  
//		  for(int i=0;i<=rowCount;i++){
//			  for(int j=0;j<columnCount;j++) {
//				  Row row =sheet.getRow(i); Cell cell = row.getCell(j); String
//				  data=cell.getStringCellValue(); System.out.print(data+"  ");
//				  }
//		  System.out.println();
//		  }
		
		//String orgName=sheet.getRow(1).getCell(0).getStringCellValue();
		String orgName=eutility.getDataFromExcel("sheet1", 1, 0);
		orgName=orgName+jutility.getRandomNumber();
		System.out.println("Organization name is"+orgName);
		
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
		
		driver.manage().window().maximize();
		driver.get(url);
		wutility.WaitForPageToLoad(driver);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
//		Random r=new Random();
//		int randomNum=r.nextInt(100);
//		orgName=orgName+randomNum;
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String text = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(text.contains(orgName))
		{
			System.out.println("Verification successfull");
		}
		else
		{
			System.out.println("Verification unsuccessfull");
		}
		
		//Thread.sleep(5000);
		
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutility.mouseOverOnElement(driver,ele);
//		Actions a=new Actions(driver);
//		a.moveToElement(ele).perform();
		//Thread.sleep(5000);
		
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

	}

}
