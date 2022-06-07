package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this is creating new products page repository
 * @author mrinm
 *
 */
public class CreatingNewProductsPage {
	//declaration
	@FindBy(name="productname")
	private WebElement prodName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	//initialization
	public CreatingNewProductsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	
	public WebElement getProdName() {
		return prodName;
	}
	
	
	//business logic
	/**
	 * this method is used to create products and clicking on save button
	 */
	public void createProducts(String productName) {
		prodName.sendKeys(productName);
		saveButton.click();
	}

}
