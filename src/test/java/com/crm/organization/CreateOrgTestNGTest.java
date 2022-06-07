package com.crm.organization;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreatingNewOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizationInformationPage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodesk.genericUtility.BaseClass;

@Listeners(com.crm.autodesk.genericUtility.ListenerImplementationClass.class)
public class CreateOrgTestNGTest extends BaseClass{

	@Test(groups="smokeTest")
	public void createOrg() throws Throwable {
		String orgName=eutility.getDataFromExcel("sheet1", 1, 0);
		orgName=orgName+jutility.getRandomNumber();
		System.out.println("Organization name is"+orgName);
		
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnOrganization();
		
		OrganizationPage orgpage= new OrganizationPage(driver);
		orgpage.clickOnAddIcon();
		
		CreatingNewOrganizationPage createOrg= new CreatingNewOrganizationPage(driver);
		createOrg.createOrganizationOnly(orgName);
		//Assert.fail();
		
		OrganizationInformationPage orgInfoPage= new OrganizationInformationPage(driver);
		String actualOrgName=orgInfoPage.getOrganizationText();
		
		
//		if(actualOrgName.contains(orgName)) {
//			System.out.println("name is verified");
//		}
//		else {
//			System.out.println("name is not verified");
//		}
		
		Assert.assertEquals(actualOrgName.contains(orgName),true);
	}

}
