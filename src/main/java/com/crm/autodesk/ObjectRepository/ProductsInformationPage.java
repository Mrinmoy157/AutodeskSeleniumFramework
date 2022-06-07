package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this is product information page repository
 * @author mrinm
 *
 */
public class ProductsInformationPage {
	//declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement productsInformation;
	
	//initialization
	public ProductsInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getProductsInformation() {
		return productsInformation;
	}
	
	//business logic
	/**
	 * this method is used to get product text
	 * @return
	 */
	public String getProductsText() {
		return productsInformation.getText();
	}

}
