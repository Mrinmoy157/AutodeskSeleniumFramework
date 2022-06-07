package com.crm.Autodesk.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.crm.autodesk.genericUtility.ExcelUtility;
import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.JavaUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws Throwable {
		
		JavaUtility jutility=new JavaUtility();
		FileUtility futility= new FileUtility();
		ExcelUtility eutility= new ExcelUtility();
		WebDriverUtility wutility=new WebDriverUtility();
		
		
		
		//Read data from property file
//				FileInputStream fis = new FileInputStream("./src\\main\\resources\\commondata\\credentials.properties");
//				Properties pro_obj= new Properties();
//				pro_obj.load(fis);
//				String browser = pro_obj.getProperty("browser");
//				String url = pro_obj.getProperty("url");
//				String username = pro_obj.getProperty("username");
//				String password = pro_obj.getProperty("password");
		
				String browser=futility.getPropertyKeyValue("browser");
				String url=futility.getPropertyKeyValue("url");
				String username=futility.getPropertyKeyValue("username");
				String password=futility.getPropertyKeyValue("password");
				
//				Random random= new Random();
//				int ranNum=random.nextInt(1000);
				
				
				//Read test data from  excel sheet
//				FileInputStream fil= new FileInputStream("./src\\test\\resources\\TestData.xlsx");
//				Workbook wb=WorkbookFactory.create(fil);
//				Sheet sheet = wb.getSheet("Sheet5");
//				Row r = sheet.getRow(1);
				String lastName=eutility.getDataFromExcel("sheet5", 1, 0)+"_"+jutility.getRandomNumber();
				String orgName=eutility.getDataFromExcel("sheet5", 1, 1)+"_"+jutility.getRandomNumber();
				
				WebDriver driver = null;
				if(browser.equals("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver= new ChromeDriver();
				}
				else if(browser.equals("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
				}
				else
				{
					WebDriverManager.edgedriver().setup();
					driver=new InternetExplorerDriver();
				}
				
				//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				//driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
				wutility.WaitForPageToLoad(driver);
				driver.get(url);
				//driver.manage().window().maximize();
				wutility.maximizeWindow(driver);
				
				
				//Step1: Login to app
				
				driver.findElement(By.name("user_name")).sendKeys(username);
				driver.findElement(By.name("user_password")).sendKeys(password);
				driver.findElement(By.id("submitButton")).click();
				
				//Step2: Navigate to organization
				
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step3: Navigate to create organization page
				
				driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
				
				//Step4: Create a new Organization
				
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Step5: Verify
				
				String value = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(value.contains(orgName))
				{
					System.out.println(orgName+" is verified to be true");
				}
				else
				{
					System.out.println(orgName+" is verified to be false");
				}
				
//				WebDriverWait wait= new WebDriverWait(driver,20);
//				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Contacts"))));
				wutility.waitForElementToBeClickable(driver,driver.findElement(By.linkText("Contacts")));
				
				//Step6: Navigate to Contacts
				
				driver.findElement(By.linkText("Contacts")).click();
				
				//Step7: Navigate to create Contact page
				
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				
				//Step8: Create a new Contact
				
				driver.findElement(By.name("lastname")).sendKeys(lastName);
				driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
				
//				Set<String> set = driver.getWindowHandles();
//				
//				Iterator<String> it = set.iterator();
//				while(it.hasNext())
//				{
//					String window_id=it.next();
//					driver.switchTo().window(window_id);
//					if(driver.getTitle().contains("Accounts"))
//					{
//						break;
//					}
//				}
				wutility.switchToWindow(driver,"Accounts");
				
				driver.findElement(By.name("search_text")).sendKeys(orgName);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
				
				
//				Set<String> set1 = driver.getWindowHandles();
//				
//				Iterator<String> it1 = set1.iterator();
//				while(it1.hasNext())
//				{
//					String window_id=it1.next();
//					driver.switchTo().window(window_id);
//					if(driver.getTitle().contains("Contacts"))
//					{
//						break;
//					}
//				}
				wutility.switchToWindow(driver,"Contacts");
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				
				//Step9: Verify
				
				String value1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(value1.contains(lastName))
				{
					System.out.println(lastName+" is verified to be true");
				}
				else
				{
					System.out.println(lastName+" is verified to be false");
				}
				
				//Step10: Logout
				
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wutility.mouseOverOnElement(driver, ele);
//				Actions a=new Actions(driver);
//				a.moveToElement(ele).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				driver.quit();

	}

}
