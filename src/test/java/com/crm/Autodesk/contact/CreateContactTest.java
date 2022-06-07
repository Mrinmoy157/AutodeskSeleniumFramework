package com.crm.Autodesk.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.ObjectRepository.ContactInformationPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreatingNewContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.genericUtility.ExcelUtility;
import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.JavaUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest {
	public static void main(String[] args) throws Throwable {
		
		JavaUtility jutility=new JavaUtility();
		FileUtility futility= new FileUtility();
		ExcelUtility eutility= new ExcelUtility();
		WebDriverUtility wutility=new WebDriverUtility();
//		FileInputStream fil= new FileInputStream("./src\\test\\resources\\TestData.xlsx");
//		Workbook wb=WorkbookFactory.create(fil);
//		Sheet sheet = wb.getSheet("Sheet3");
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
		
		
		String firstN=eutility.getDataFromExcel("sheet3", 1, 0);
		System.out.println("First name is "+firstN);
		String lastN=eutility.getDataFromExcel("sheet3", 1, 1);
		lastN=lastN+jutility.getRandomNumber();
		System.out.println("Last name is "+lastN);
		
		
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
		wutility.WaitForPageToLoad(driver);
//		driver.findElement(By.name("user_name")).sendKeys(username);                                             //using login page to login to application
//		driver.findElement(By.name("user_password")).sendKeys(password);
//		driver.findElement(By.id("submitButton")).click();
		LoginPage loginpage= new LoginPage(driver);
		loginpage.login(username, password);
		
		//driver.findElement(By.linkText("Contacts")).click();                                                         //using home page to click on contacts page
		HomePage homepage= new HomePage(driver);
		homepage.clickOnContacts(driver);
		
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();                       //using contacts page to click on add icon
		ContactsPage contpage= new ContactsPage(driver);
		contpage.clickOnAddIcon();
		
//		driver.findElement(By.name("firstname")).sendKeys(firstN);                                                     //using creating new contacts page to create contacts
//		driver.findElement(By.name("lastname")).sendKeys(lastN);
//		driver.findElement(By.name("button")).click();
		CreatingNewContactPage contactPage= new CreatingNewContactPage(driver);
		contactPage.createContact(firstN, lastN);
		
		//String text = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();                        //using contact information page for getting text
		ContactInformationPage conInfoPage= new ContactInformationPage(driver);
		String actualcontactName=conInfoPage.getContactsText();
		
		if(actualcontactName.contains(lastN))
		{
			System.out.println("Verification successfull");
		}
		else
		{
			System.out.println("Verification unsuccessfull");
		}
//		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));                      //using home page to logout
//		wutility.mouseOverOnElement(driver, ele);
//		driver.findElement(By.linkText("Sign Out")).click();
		homepage.logout(driver);
		driver.close();
	}

}
