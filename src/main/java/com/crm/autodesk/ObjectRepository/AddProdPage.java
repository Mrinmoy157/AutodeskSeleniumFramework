package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;
/**
 * this is adding product in campaign page
 * @author mrinm
 *
 */
public class AddProdPage extends WebDriverUtility{
	
	@FindBy(id="search_txt")
	private WebElement searchTextBox;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	
	public AddProdPage(WebDriver driver) {
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
	 * this method will add products in campaign page
	 * @param driver
	 * @param prodName
	 */
	public void addProductInCampaign(WebDriver driver,String prodName) {
		switchToWindow(driver,"Products");
		searchTextBox.sendKeys(prodName);
		searchButton.click();
		driver.findElement(By.xpath("//a[text()='"+prodName+"']")).click();
	}
	
	/**
	 * this method will add product in purchase order
	 * @param driver
	 * @param prodName
	 */
	public void addProductInPurchaseOrder(WebDriver driver, String prodName) {
		switchToWindow(driver,"Products");
		searchTextBox.sendKeys(prodName);
		searchButton.click();
		driver.findElement(By.xpath("//a[text()='"+prodName+"']")).click();
	}

}
