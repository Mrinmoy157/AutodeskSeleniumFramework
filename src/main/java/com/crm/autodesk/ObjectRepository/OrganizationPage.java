package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this is organization page repository
 * @author mrinm
 *
 */
public class OrganizationPage {
	//Declaration
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement addIcon;
	
	
	//initialization
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


	public WebElement getClickOnAddIcon() {
		return addIcon;
	}
	
	//business logic
	/**
	 * this method will click on add icon in organization page 
	 */
	public void clickOnAddIcon() {
		addIcon.click();
	}
	

}
