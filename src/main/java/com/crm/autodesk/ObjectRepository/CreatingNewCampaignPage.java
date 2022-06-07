package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

/**
 * this is creating new campaign page repository
 * @author mrinm
 *
 */
public class CreatingNewCampaignPage extends WebDriverUtility{
	@FindBy(name="campaignname")
	private WebElement campaignName;
	
	@FindBy(xpath="//b[text()='Campaign Information']/preceding::input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement selectProductIcon;
	
	
	public CreatingNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	//business logic
	/**
	 * this method is used to create campaign
	 * @param campName
	 */
	public void createCampaign(String campName) {
		campaignName.sendKeys(campName);
		selectProductIcon.click();
	}
	
	/**
	 * this method is used to switch back from child browser
	 * @param driver
	 */
	public void switchingBackFromChildBrowser(WebDriver driver) {
		switchToWindow(driver,"Campaigns");
		saveButton.click();
	}

}
