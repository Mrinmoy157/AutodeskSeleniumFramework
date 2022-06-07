package com.crm.Autodesk.purchaseOrder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.ObjectRepository.AddProdPage;
import com.crm.autodesk.ObjectRepository.AddVendorPage;
import com.crm.autodesk.ObjectRepository.CreatingNewProductsPage;
import com.crm.autodesk.ObjectRepository.CreatingNewPurchaseOrderPage;
import com.crm.autodesk.ObjectRepository.CreatingNewVendorsPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.ProductsPage;
import com.crm.autodesk.ObjectRepository.PurchaseOrderPage;
import com.crm.autodesk.ObjectRepository.VendorsPage;
import com.crm.autodesk.genericUtility.ExcelUtility;
import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.JavaUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * this is create purchase order page test script
 * @author mrinm
 *
 */
public class CreatePurchaseOrder28Test {

	public static void main(String[] args) throws Throwable {
		FileUtility futility= new FileUtility();
		ExcelUtility eutility= new ExcelUtility();
		WebDriverUtility wutility= new WebDriverUtility();
		JavaUtility jutility=new JavaUtility();
		
		String url=futility.getPropertyKeyValue("url");
		String browser=futility.getPropertyKeyValue("browser");
		String username=futility.getPropertyKeyValue("username");
		String password=futility.getPropertyKeyValue("password");
		
		String subject=eutility.getDataFromExcel("sheet7", 1, 0);
		String vendor=eutility.getDataFromExcel("sheet7", 1, 1);
		String billingAddress=eutility.getDataFromExcel("sheet7", 1, 2);
		String prodName=eutility.getDataFromExcel("sheet2", 1, 0)+jutility.getRandomNumber();
		String quantity=eutility.getDataFromExcel("sheet2", 1, 1);
		
		
		
		WebDriver driver=null;
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
		
		HomePage homepage= new HomePage(driver);
		//creating vendors
		homepage.clickOnVendors(driver);
		
		VendorsPage vendorPage= new VendorsPage(driver);
		vendorPage.clickOnAddIcon();
		
		CreatingNewVendorsPage createVendorPage= new CreatingNewVendorsPage(driver);
		createVendorPage.createVendor(vendor);
		
		
		//creating products
		homepage.clickOnProducts();
		
		ProductsPage prodPage= new ProductsPage(driver);
		prodPage.clickOnAddIcon();
		
		CreatingNewProductsPage newProdPage= new CreatingNewProductsPage(driver);
		newProdPage.createProducts(prodName);
		
		
		
		
		//creating purchase order
		homepage.clickOnPurchaseOrder(driver);
		
		PurchaseOrderPage purOrder=new PurchaseOrderPage(driver);
		purOrder.clickOnAddIcon();
		
		CreatingNewPurchaseOrderPage createPurOrder= new CreatingNewPurchaseOrderPage(driver);
		createPurOrder.createPurchaseOrder(subject);
		
		AddVendorPage venPage= new AddVendorPage(driver);
		venPage.addVendorInPurchaseOrder(driver, vendor);
		
		createPurOrder.switchBackFromChildBrowser(driver,billingAddress);

		createPurOrder.addProductsInPurchaseOrder();
		
		AddProdPage addproductinpurchase= new AddProdPage(driver);
		addproductinpurchase.addProductInPurchaseOrder(driver, prodName);
		
		createPurOrder.switchingBackFromChildBrowser(driver,quantity);
		
		homepage.logout(driver);
		driver.quit();
		
		

	}

}
