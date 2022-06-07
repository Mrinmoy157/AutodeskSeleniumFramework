package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is organization information page repository
 * @author mrinm
 *
 */
public class OrganizationInformationPage {
	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organizationInformation;
	
	
	
	//initialization
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrganizationInformation() {
		return organizationInformation;
	}
	
	//business logic
	/**
	 * this method will get the text from organization
	 * @return
	 */
	public String getOrganizationText() {
		return organizationInformation.getText();
		
	}
	

}
