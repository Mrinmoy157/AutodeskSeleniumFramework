package com.crm.Autodesk.campaign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.autodesk.ObjectRepository.AddProdPage;
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
/**
 * this class is used to create campaign by selecting products
 * @author mrinm
 *
 */
public class CreateCampaignWithProductsPOMTest {

	public static void main(String[] args) throws Throwable {
		JavaUtility jutility= new JavaUtility();
		FileUtility futility= new FileUtility();
		ExcelUtility eutility= new ExcelUtility();
		WebDriverUtility wutility=new WebDriverUtility();
		
		String browser=futility.getPropertyKeyValue("browser");
		String url=futility.getPropertyKeyValue("url");
		String username=futility.getPropertyKeyValue("username");
		String password=futility.getPropertyKeyValue("password");
		
		
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
		
		
		wutility.WaitForPageToLoad(driver);
		driver.get(url);
		
		wutility.maximizeWindow(driver);
		
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
		
		HomePage homepage= new HomePage(driver);
		homepage.clickOnProducts();
		
		ProductsPage productpage= new ProductsPage(driver);
		productpage.clickOnAddIcon();
		
		CreatingNewProductsPage prodPage= new CreatingNewProductsPage(driver);
		prodPage.createProducts(prodName);
		
		
		ProductsInformationPage proInfoPage = new ProductsInformationPage(driver);
		String actualprodName=proInfoPage.getProductsText();
		
		if(actualprodName.contains(prodName)) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		
		homepage.clickOnCampaign(driver);
		
		CampaignsPage campaignpage= new CampaignsPage(driver);
		campaignpage.clickOnAddIcon();
		
		CreatingNewCampaignPage camppage= new CreatingNewCampaignPage(driver);
		camppage.createCampaign(campaignName);
		
		
		AddProdPage addProd= new AddProdPage(driver);
		addProd.addProductInCampaign(driver, prodName);
		
		camppage.switchingBackFromChildBrowser(driver);
		
		homepage.logout(driver);
		driver.quit();

	}

}
