package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

/**
 * This is Creating new organization object repository
 * @author mrinm
 *
 */
public class CreatingNewOrganizationPage extends WebDriverUtility{
	@FindBy(name="accountname")
	private WebElement orgName;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	//initialization
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


	public WebElement getOrgName() {
		return orgName;
	}


	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}
	
	
	//business logic
	/**
	 * this method is used to send organization name and industry value and clicking on save button
	 * @param organizationName
	 * @param industryName
	 */
	public void createOrganization(String organizationName,String industryName) {
		orgName.sendKeys(organizationName);
		select(industryDropdown,industryName);
		//industryDropdown.sendKeys(industryName);
		saveButton.click();
	}
	/**
	 * this method is used to create organization and clicking on save button
	 * @param organizationName
	 */
	public void createOrganizationOnly(String organizationName) {
		orgName.sendKeys(organizationName);
		saveButton.click();
		
		
	}
	
	
 
}
