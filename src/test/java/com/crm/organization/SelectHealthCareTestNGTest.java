package com.crm.organization;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreatingNewOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizationInformationPage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodesk.genericUtility.BaseClass;

public class SelectHealthCareTestNGTest extends BaseClass{
	@Test(groups="smokeTest")
	public void selectHealthCare() throws Throwable {
		String orgName=eutility.getDataFromExcel("sheet1", 1, 0);
		orgName=orgName+jutility.getRandomNumber();
		System.out.println("Organization name is"+orgName);
		String industry=eutility.getDataFromExcel("sheet1", 1, 3);
		
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnOrganization();
		
		OrganizationPage orgpage= new OrganizationPage(driver);
		orgpage.clickOnAddIcon();
		
		
		CreatingNewOrganizationPage orgPage= new CreatingNewOrganizationPage(driver);
		orgPage.createOrganization(orgName, industry);
		
		OrganizationInformationPage orgInfoPage= new OrganizationInformationPage(driver);
		String actualOrgName = orgInfoPage.getOrganizationText();
		//Assert.fail();
		
//		if(actualOrgName.contains(orgName)){
//			System.out.println("pass");
//		}
//		else{
//			System.out.println("Fail");
//		}
		
		Assert.assertEquals(actualOrgName.contains(orgName),true);
	}

}
