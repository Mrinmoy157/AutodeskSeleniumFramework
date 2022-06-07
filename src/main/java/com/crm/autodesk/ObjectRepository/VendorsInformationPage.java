package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this is vendor information page repository
 * @author mrinm
 *
 */
public class VendorsInformationPage {
	//declaration
		@FindBy(xpath="//span[@class='lvtHeaderText']")
		private WebElement vendorsInformation;
		
		
		
		//initialization
		public VendorsInformationPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}

		public WebElement getVendorsInformation() {
			return vendorsInformation;
		}
		
		//business logic
		/**
		 * this method will get the text from vendor
		 * @return
		 */
		public String getVendorsText() {
			return vendorsInformation.getText();
			
		}

}
