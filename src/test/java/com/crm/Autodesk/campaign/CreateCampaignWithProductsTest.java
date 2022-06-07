package com.crm.Autodesk.campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.autodesk.ObjectRepository.CampaignsPage;
import com.crm.autodesk.ObjectRepository.CreatingNewCampaignPage;
import com.crm.autodesk.ObjectRepository.CreatingNewProductsPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.ProductsInformationPage;
import com.crm.autodesk.ObjectRepository.ProductsPage;
import com.crm.autodesk.genericUtility.ExcelUtility;
import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.JavaUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProductsTest {

	public static void main(String[] args) throws Throwable {
		
		JavaUtility jutility= new JavaUtility();
		FileUtility futility= new FileUtility();
		ExcelUtility eutility= new ExcelUtility();
		WebDriverUtility wutility=new WebDriverUtility();
		
		
		
		//Read data from property file
//		FileInputStream fis = new FileInputStream("./src\\main\\resources\\commondata\\credentials.properties");
//		Properties pro_obj= new Properties();
//		pro_obj.load(fis);
//		String browser = pro_obj.getProperty("browser");
//		String url = pro_obj.getProperty("url");
//		String username = pro_obj.getProperty("username");
//		String password = pro_obj.getProperty("password");
		
		String browser=futility.getPropertyKeyValue("browser");
		String url=futility.getPropertyKeyValue("url");
		String username=futility.getPropertyKeyValue("username");
		String password=futility.getPropertyKeyValue("password");
		
//		Random random= new Random();
//		int ranNum=random.nextInt(1000);
		
		//Read test data from  excel sheet
//		FileInputStream fil= new FileInputStream("./src\\test\\resources\\TestData.xlsx");
//		Workbook wb=WorkbookFactory.create(fil);
//		Sheet sheet = wb.getSheet("Sheet6");
//		Row r = sheet.getRow(1);
		
		
		String campaignName=eutility.getDataFromExcel("sheet6", 1, 0)+"_"+jutility.getRandomNumber();
		System.out.println(campaignName);
		String prodName=eutility.getDataFromExcel("sheet6", 1, 1)+"_"+jutility.getRandomNumber();
		System.out.println(prodName);
		
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
		
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		wutility.WaitForPageToLoad(driver);
		driver.get(url);
//		driver.manage().window().maximize();
		wutility.maximizeWindow(driver);

		//Step1: Login to app
		
		
//		driver.findElement(By.name("user_name")).sendKeys(username);                                  //using login page to login
//		driver.findElement(By.name("user_password")).sendKeys(password);
//		driver.findElement(By.id("submitButton")).click();
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
		
		//Step2: Navigate to Products
		
		//driver.findElement(By.linkText("Products")).click();                                       //using home page to click products
		HomePage homepage= new HomePage(driver);
		homepage.clickOnProducts();
		
		//Step3: Navigate to create product page
		
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();     //using products page to click on add icon
		ProductsPage productpage= new ProductsPage(driver);
		productpage.clickOnAddIcon();
		
		
		//Step4: Create new product
		
		
//		driver.findElement(By.name("productname")).sendKeys(prodName);                                  //using creating new products page to add product name
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CreatingNewProductsPage prodPage= new CreatingNewProductsPage(driver);
		prodPage.createProducts(prodName);
		
		
		
		//Step5: Verify
		
		//String value = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();        //using products information page to get the text
		ProductsInformationPage proInfoPage = new ProductsInformationPage(driver);
		String actualprodName=proInfoPage.getProductsText();
		
//		if(value.contains(prodName))
//		{
//			System.out.println(prodName+" is verified to be true");
//		}
//		else
//		{
//			System.out.println(prodName+" is verified to be false");
//		}
		
		if(actualprodName.contains(prodName)) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
			
		
		
//		WebDriverWait wait= new WebDriverWait(driver,20);
//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Contacts"))));
		//wutility.waitForElementToBeClickable(driver,driver.findElement(By.linkText("Contacts")));
		
		
		//Step6: Navigate to campaign
		
		//WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));      //using home page to click campaign
		//wutility.mouseOverOnElement(driver, ele);
		
		homepage.clickOnCampaign(driver);
//		Actions a=new Actions(driver);
//		a.moveToElement(ele).perform();
		//driver.findElement(By.linkText("Campaigns")).click();                                                      
		
		
		//Step7: Navigate to create campaign page
		
		
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();                     //using campaigns page to click on add icon
		CampaignsPage campaignpage= new CampaignsPage(driver);
		campaignpage.clickOnAddIcon();
		
		
		
		//Step8: Create new campaign
		
//		driver.findElement(By.name("campaignname")).sendKeys(campaignName);                                             //using creating new campaign page for creating campaign
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		CreatingNewCampaignPage camppage= new CreatingNewCampaignPage(driver);
		camppage.createCampaign(campaignName);
		
		//driver.findElement(By.name("closingdate")).clear();
//		 WebElement dd = driver.findElement(By.name("closingdate"));
//		 dd.clear();
//		 
//		String date=jutility.getSystemDateWithFormat();
//		dd.sendKeys(date);
		
		
//		Set<String> set = driver.getWindowHandles();
//		
//		Iterator<String> it = set.iterator();
//		while(it.hasNext())
//		{
//			String window_id=it.next();
//			driver.switchTo().window(window_id);
//			if(driver.getTitle().contains("Products"))
//			{
//				break;
//			}
//		}
		wutility.switchToWindow(driver,"Products");
		
		driver.findElement(By.name("search_text")).sendKeys(prodName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+prodName+"']")).click();
		
		
//		Set<String> set1 = driver.getWindowHandles();
//		
//		Iterator<String> it1 = set1.iterator();
//		while(it1.hasNext())
//		{
//			String window_id=it1.next();
//			driver.switchTo().window(window_id);
//			if(driver.getTitle().contains("Campaigns"))
//			{
//				break;
//			}
//		}
		
		wutility.switchToWindow(driver,"Campaigns");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Thread.sleep(5000);
		//Step9: Verify
		
		String value1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(value1.contains(campaignName))
		{
			System.out.println(campaignName+" is verified to be true");
		}
		else
		{
			System.out.println(campaignName+" is verified to be false");
		}
		
		
		//Step10: Logout
		
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutility.mouseOverOnElement(driver, ele1);
//		Actions a1=new Actions(driver);
//		a1.moveToElement(ele1).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

}
