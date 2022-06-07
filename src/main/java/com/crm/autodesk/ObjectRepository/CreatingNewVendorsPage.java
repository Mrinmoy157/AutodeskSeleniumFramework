package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this is creating new vendor page repository
 * @author mrinm
 *
 */
public class CreatingNewVendorsPage {
	@FindBy(name="vendorname")
	private WebElement vendorTextBox;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	//initialization
	public CreatingNewVendorsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	public WebElement getSaveButton() {
		return saveButton;
	}


	public WebElement getVendorTextBox() {
		return vendorTextBox;
	}
	
	//business logic
	/**
	 * this method is used to create vendor
	 * @param vendor
	 */
	public void createVendor(String vendor) {
		vendorTextBox.sendKeys(vendor);
		saveButton.click();
	}

}
