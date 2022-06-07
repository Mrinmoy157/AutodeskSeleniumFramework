package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this is contact information page directory
 * @author mrinm
 *
 */
public class ContactInformationPage {
	
	//declaration
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement contactsInformation;
		
		
		public ContactInformationPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}


		public WebElement getContactsInformation() {
			return contactsInformation;
		}
		
		//business logic
		/**
		 * this method is used to get text for contact
		 * @return
		 */
		public String getContactsText() {
			return contactsInformation.getText();
		}

}
