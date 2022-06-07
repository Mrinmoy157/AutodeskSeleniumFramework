package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this is products page repository
 * @author mrinm
 *
 */
public class ProductsPage {
	//Declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addIcon;
	
	
	//initialization
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getAddIcon() {
		return addIcon;
	}
	
	
	//business logic
	/**
	 * this method will click on add icon in products page
	 */
	public void clickOnAddIcon() {
		addIcon.click();
	}

}
