package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;
/**
 * this is add vendor page
 * @author mrinm
 *
 */
public class AddVendorPage extends WebDriverUtility{
	
	@FindBy(id="search_txt")
	private WebElement searchTextBox;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	public AddVendorPage(WebDriver driver) {
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
	 * this method is used to add vendor in purchase order
	 * @param driver
	 * @param vendor
	 */
	public void addVendorInPurchaseOrder(WebDriver driver, String vendor) {
		switchToWindow(driver,"Vendors");
		searchTextBox.sendKeys(vendor);
		searchButton.click();
		driver.findElement(By.xpath("//a[text()='"+vendor+"']")).click();
		
	}


}
