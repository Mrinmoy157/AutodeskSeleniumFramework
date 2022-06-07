package com.crm.Autodesk.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.ObjectRepository.CreatingNewProductsPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.ProductsInformationPage;
import com.crm.autodesk.ObjectRepository.ProductsPage;
import com.crm.autodesk.genericUtility.ExcelUtility;
import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductsTest {

	public static void main(String[] args) throws Throwable {
		
		
		FileUtility futility= new FileUtility();
		ExcelUtility eutility= new ExcelUtility();
		WebDriverUtility wutility=new WebDriverUtility();
		
		
		
//		FileInputStream fil= new FileInputStream("./src\\test\\resources\\TestData.xlsx");
//		Workbook wb=WorkbookFactory.create(fil);
//		Sheet sheet = wb.getSheet("Sheet2");
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
		
		String prodName=eutility.getDataFromExcel("sheet2", 1, 0);
		System.out.println("Product Name is "+prodName);
		
		
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
		//driver.findElement(By.name("user_name")).sendKeys(username);                                      //using login page to use username password
		//driver.findElement(By.name("user_password")).sendKeys(password);
		//driver.findElement(By.id("submitButton")).click();
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.login(username, password);

		//driver.findElement(By.linkText("Products")).click();                                                  //using home page
		HomePage homepage=new HomePage(driver);
		homepage.clickOnProducts();
		
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();               //using products page
		ProductsPage prodPage= new ProductsPage(driver);
		prodPage.clickOnAddIcon();
		
//		driver.findElement(By.name("productname")).sendKeys(prodName);                                           //using creating new products page for product name
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CreatingNewProductsPage propage= new CreatingNewProductsPage(driver);
		propage.createProducts(prodName);
		
		
		//String value = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();                  //using products information page for getting text
		ProductsInformationPage proInfoPage= new ProductsInformationPage(driver);
		String actualProdName=proInfoPage.getProductsText();
		
		if(actualProdName.contains(prodName))
		{
			System.out.println(prodName+" is verified to be true");
		}
		else
		{
			System.out.println(prodName+" is verified to be false");
		}
		
		
//		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));                   //using home page for logout
//		wutility.mouseOverOnElement(driver, ele);
//		driver.findElement(By.linkText("Sign Out")).click();
		homepage.logout(driver);
		driver.close();

	}

}
