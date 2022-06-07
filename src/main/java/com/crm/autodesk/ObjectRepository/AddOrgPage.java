package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;
/**
 * this is adding organization in contact page
 * @author mrinm
 *
 */
public class AddOrgPage extends WebDriverUtility{
	
	@FindBy(id="search_txt")
	private WebElement searchTextBox;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	
	public AddOrgPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


	public WebElement getSearchTextBox() {
		return searchTextBox;
	}


	public WebElement getSearchButton() {
		return searchButton;
	}
	
	//business logic
	/**
	 * this method will click on add icon in create contact page for adding organization
	 * @param driver
	 * @param orgName
	 */
	public void addOrgInContact(WebDriver driver, String orgName) {
		switchToWindow(driver,"Accounts");
		searchTextBox.sendKeys(orgName);
		searchButton.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	}

}
