package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

/**
 * this is creating new contact page repository
 * @author mrinm
 *
 */
public class CreatingNewContactPage extends WebDriverUtility{
	
	@FindBy(name="firstname")
	private WebElement firstName;
	
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement clickOnOrgAddIcon;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//business logic
	/**
	 * this method is used to enter first name and last name and clicking on save button
	 * @param fname
	 * @param lname
	 */
	public void createContact(String fname,String lname) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		saveButton.click();
	}
	
	/**
	 * this method is used to create contact by entering first name and last name and clicking on organization icon 
	 * @param fname
	 * @param lname
	 */
	public void createContactOnly(String fname,String lname) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		clickOnOrgAddIcon.click();
	}
	
	/**
	 * this method is used to switch back from child browser
	 * @param driver
	 */
	public void switchingBackFromChildBrowser(WebDriver driver) {
		switchToWindow(driver,"Contacts");
		saveButton.click();
	}

}
