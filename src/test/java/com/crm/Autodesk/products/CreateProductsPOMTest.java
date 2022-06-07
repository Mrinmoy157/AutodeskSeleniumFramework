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

/**
 * this is create products page test
 * @author mrinm
 *
 */
public class CreateProductsPOMTest {

	public static void main(String[] args) throws Throwable {
		FileUtility futility= new FileUtility();
		ExcelUtility eutility= new ExcelUtility();
		WebDriverUtility wutility=new WebDriverUtility();
		
		
		String prodName=eutility.getDataFromExcel("sheet2", 1, 0);
		System.out.println("Product Name is "+prodName);
		
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
		
		
		wutility.maximizeWindow(driver);
		driver.get(url);
		wutility.WaitForPageToLoad(driver);
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.login(username, password);
		
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnProducts();
		
		
		ProductsPage prodPage= new ProductsPage(driver);
		prodPage.clickOnAddIcon();
		
		
		CreatingNewProductsPage propage= new CreatingNewProductsPage(driver);
		propage.createProducts(prodName);
		
		
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
		
		
		homepage.logout(driver);
		driver.close();


	}

}
