package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this is campaign page repository
 * @author mrinm
 *
 */
public class CampaignsPage {
	//declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addIcon;
	
	//initialization
	public CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getAddIcon() {
		return addIcon;
	}
	
	//business logic
	/**
	 * this method is used to click on add icon
	 */
	public void clickOnAddIcon() {
		addIcon.click();
	}

}
