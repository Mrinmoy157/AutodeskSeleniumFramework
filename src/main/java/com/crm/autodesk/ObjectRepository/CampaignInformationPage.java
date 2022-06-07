package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is campaign information page repository
 * @author mrinm
 *
 */
public class CampaignInformationPage {
	//declaration
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement campaignInformation;
		
		//initialization
		public CampaignInformationPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}

		public WebElement getCampaignInformation() {
			return campaignInformation;
		}
		
		//business logic
		/**
		 * this method is used to get product text
		 * @return
		 */
		public String getCampaignText() {
			return campaignInformation.getText();
		}

}
