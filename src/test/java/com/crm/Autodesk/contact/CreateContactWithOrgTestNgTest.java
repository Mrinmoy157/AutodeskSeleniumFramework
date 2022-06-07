package com.crm.Autodesk.contact;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.AddOrgPage;
import com.crm.autodesk.ObjectRepository.ContactInformationPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreatingNewContactPage;
import com.crm.autodesk.ObjectRepository.CreatingNewOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizationInformationPage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodesk.genericUtility.BaseClass;

public class CreateContactWithOrgTestNgTest extends BaseClass{
	@Test(groups="sanityTest")
	public void createContactWithOrg() throws Throwable {
		String lastN=eutility.getDataFromExcel("sheet5", 1, 0)+"_"+jutility.getRandomNumber();
		String firstN=eutility.getDataFromExcel("sheet3", 1, 0);
		String orgName=eutility.getDataFromExcel("sheet5", 1, 1)+"_"+jutility.getRandomNumber();
		
		
		HomePage homepage= new HomePage(driver);
		homepage.clickOnOrganization();
		
		OrganizationPage orgpage= new OrganizationPage(driver);
		orgpage.clickOnAddIcon();
		
		CreatingNewOrganizationPage orgPage= new CreatingNewOrganizationPage(driver);
		orgPage.createOrganizationOnly(orgName);
		
		
		OrganizationInformationPage orgInfoPage= new OrganizationInformationPage(driver);
		String actualOrgName=orgInfoPage.getOrganizationText();
//		if(actualOrgName.contains(orgName)){
//			System.out.println("success");
//		}
//		else
//		{
//			System.out.println("not successful");
//		}
		
		Assert.assertEquals(actualOrgName.contains(orgName),true);
		homepage.clickOnContacts(driver);
		
		ContactsPage contpage= new ContactsPage(driver);
		contpage.clickOnAddIcon();
		
		
		CreatingNewContactPage contPage= new CreatingNewContactPage(driver);
		contPage.createContactOnly(firstN, lastN);
		
		AddOrgPage addOrg= new AddOrgPage(driver);
		addOrg.addOrgInContact(driver, orgName);
		
		contPage.switchingBackFromChildBrowser(driver);
		
		ContactInformationPage conInfoPage= new ContactInformationPage(driver);
		String actualcontactName=conInfoPage.getContactsText();
		
		Assert.assertEquals(actualcontactName.contains(lastN),true);
	}

}
