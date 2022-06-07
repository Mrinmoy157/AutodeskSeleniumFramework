package com.crm.Autodesk.products;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreatingNewProductsPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.ProductsInformationPage;
import com.crm.autodesk.ObjectRepository.ProductsPage;
import com.crm.autodesk.genericUtility.BaseClass;

public class CreateProductsTestNgTest extends BaseClass{
	@Test(groups="integrationTest")
	public void createProducts() throws Throwable {
		String prodName=eutility.getDataFromExcel("sheet2", 1, 0);
		System.out.println("Product Name is "+prodName);
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnProducts();
		
		
		ProductsPage prodPage= new ProductsPage(driver);
		prodPage.clickOnAddIcon();
		
		
		CreatingNewProductsPage propage= new CreatingNewProductsPage(driver);
		propage.createProducts(prodName);
		
		
		ProductsInformationPage proInfoPage= new ProductsInformationPage(driver);
		String actualProdName=proInfoPage.getProductsText();
		
//		if(actualProdName.contains(prodName))
//		{
//			System.out.println(prodName+" is verified to be true");
//		}
//		else
//		{
//			System.out.println(prodName+" is verified to be false");
//		}
		
		Assert.assertEquals(actualProdName.contains(prodName),true);
	}

}
