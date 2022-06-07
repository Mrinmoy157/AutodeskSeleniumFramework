package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this is purchase order information page repository
 * @author mrinm
 *
 */
public class PurchaseOrderInformationPage {
	//declaration
		@FindBy(xpath="//span[@class='lvtHeaderText']")
		private WebElement purchaseOrderInformation;
		
		
		
		//initialization
		public PurchaseOrderInformationPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}

		public WebElement getOrganizationInformation() {
			return purchaseOrderInformation;
		}
		
		//business logic
		/**
		 * this method will get the text from purchase order
		 * @return
		 */
		public String getPurchaseOrderText() {
			return purchaseOrderInformation.getText();
			
		}

}
