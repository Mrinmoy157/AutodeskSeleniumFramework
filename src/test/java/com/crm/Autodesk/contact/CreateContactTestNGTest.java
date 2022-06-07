package com.crm.Autodesk.contact;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactInformationPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreatingNewContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.genericUtility.BaseClass;

public class CreateContactTestNGTest extends BaseClass{
	@Test(groups="sanityTest")
	public void createContact() throws Throwable {
		String firstN=eutility.getDataFromExcel("sheet3", 1, 0);
		System.out.println("First name is "+firstN);
		String lastN=eutility.getDataFromExcel("sheet3", 1, 1);
		lastN=lastN+jutility.getRandomNumber();
		System.out.println("Last name is "+lastN);
		
		
		HomePage homepage= new HomePage(driver);
		homepage.clickOnContacts(driver);
		
		
		ContactsPage contpage= new ContactsPage(driver);
		contpage.clickOnAddIcon();
		
		
		CreatingNewContactPage contactPage= new CreatingNewContactPage(driver);
		contactPage.createContact(firstN, lastN);
		
		
		ContactInformationPage conInfoPage= new ContactInformationPage(driver);
		String actualcontactName=conInfoPage.getContactsText();
		
		if(actualcontactName.contains(lastN))
		{
			System.out.println("Verification successfull");
		}
		else
		{
			System.out.println("Verification unsuccessfull");
		}
		
		Assert.assertEquals(actualcontactName.contains(firstN),true);
	}

}
