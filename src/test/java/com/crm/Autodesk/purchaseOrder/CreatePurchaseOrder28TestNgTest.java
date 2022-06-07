package com.crm.Autodesk.purchaseOrder;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.AddProdPage;
import com.crm.autodesk.ObjectRepository.AddVendorPage;
import com.crm.autodesk.ObjectRepository.CreatingNewProductsPage;
import com.crm.autodesk.ObjectRepository.CreatingNewPurchaseOrderPage;
import com.crm.autodesk.ObjectRepository.CreatingNewVendorsPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.ProductsInformationPage;
import com.crm.autodesk.ObjectRepository.ProductsPage;
import com.crm.autodesk.ObjectRepository.PurchaseOrderInformationPage;
import com.crm.autodesk.ObjectRepository.PurchaseOrderPage;
import com.crm.autodesk.ObjectRepository.VendorsInformationPage;
import com.crm.autodesk.ObjectRepository.VendorsPage;
import com.crm.autodesk.genericUtility.BaseClass;

public class CreatePurchaseOrder28TestNgTest extends BaseClass{
	@Test
	public void purchaseOrder() throws Throwable {
		String subject=eutility.getDataFromExcel("sheet7", 1, 0);
		String vendor=eutility.getDataFromExcel("sheet7", 1, 1);
		String billingAddress=eutility.getDataFromExcel("sheet7", 1, 2);
		String prodName=eutility.getDataFromExcel("sheet2", 1, 0)+jutility.getRandomNumber();
		String quantity=eutility.getDataFromExcel("sheet2", 1, 1);
		
		
		HomePage homepage= new HomePage(driver);
		//creating vendors
		homepage.clickOnVendors(driver);
		
		VendorsPage vendorPage= new VendorsPage(driver);
		vendorPage.clickOnAddIcon();
		
		CreatingNewVendorsPage createVendorPage= new CreatingNewVendorsPage(driver);
		createVendorPage.createVendor(vendor);
		
		VendorsInformationPage venInfoPage= new VendorsInformationPage(driver);
		String actualVendorName=venInfoPage.getVendorsText();
		
		Assert.assertEquals(actualVendorName.contains(vendor),true);
		
		//creating products
		homepage.clickOnProducts();
		
		ProductsPage prodPage= new ProductsPage(driver);
		prodPage.clickOnAddIcon();
		
		CreatingNewProductsPage newProdPage= new CreatingNewProductsPage(driver);
		newProdPage.createProducts(prodName);
		
		ProductsInformationPage prodInfoPage= new ProductsInformationPage(driver);
		String actualProdName=prodInfoPage.getProductsText();
		
		Assert.assertEquals(actualProdName.contains(prodName),true);
		
		
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
		
		PurchaseOrderInformationPage purOrderInfoPage= new PurchaseOrderInformationPage(driver);
		String actualPurOrderName=purOrderInfoPage.getPurchaseOrderText();
		
		Assert.assertEquals(actualPurOrderName.contains(subject),true);
	}

}
