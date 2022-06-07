package com.crm.Autodesk.campaign;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.AddProdPage;
import com.crm.autodesk.ObjectRepository.CampaignInformationPage;
import com.crm.autodesk.ObjectRepository.CampaignsPage;
import com.crm.autodesk.ObjectRepository.CreatingNewCampaignPage;
import com.crm.autodesk.ObjectRepository.CreatingNewProductsPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.ProductsInformationPage;
import com.crm.autodesk.ObjectRepository.ProductsPage;
import com.crm.autodesk.genericUtility.BaseClass;

public class CreateCampaignWithProductsTestNgTest extends BaseClass{
	@Test(groups="integrationTest")
	public void createCampaignWithProducts() throws Throwable {
		String campaignName=eutility.getDataFromExcel("sheet6", 1, 0)+"_"+jutility.getRandomNumber();
		System.out.println(campaignName);
		String prodName=eutility.getDataFromExcel("sheet6", 1, 1)+"_"+jutility.getRandomNumber();
		System.out.println(prodName);
		
		
		
		HomePage homepage= new HomePage(driver);
		homepage.clickOnProducts();
		
		ProductsPage productpage= new ProductsPage(driver);
		productpage.clickOnAddIcon();
		
		CreatingNewProductsPage prodPage= new CreatingNewProductsPage(driver);
		prodPage.createProducts(prodName);
		
		
		ProductsInformationPage proInfoPage = new ProductsInformationPage(driver);
		String actualprodName=proInfoPage.getProductsText();
		
//		if(actualprodName.contains(prodName)) {
//			System.out.println("pass");
//		}
//		else {
//			System.out.println("fail");
//		}
		
		Assert.assertEquals(actualprodName.contains(prodName),true);
		
		homepage.clickOnCampaign(driver);
		
		CampaignsPage campaignpage= new CampaignsPage(driver);
		campaignpage.clickOnAddIcon();
		
		CreatingNewCampaignPage camppage= new CreatingNewCampaignPage(driver);
		camppage.createCampaign(campaignName);
		
		
		AddProdPage addProd= new AddProdPage(driver);
		addProd.addProductInCampaign(driver, prodName);
		
		camppage.switchingBackFromChildBrowser(driver);
		
		CampaignInformationPage campInfoPage= new CampaignInformationPage(driver);
		String actualcampName=campInfoPage.getCampaignText();
		
		Assert.assertEquals(actualcampName.contains(campaignName), true);
		
	}

}
