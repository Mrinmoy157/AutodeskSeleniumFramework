package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

/**
 * this is creating new purchase order page repository
 * @author mrinm
 *
 */
public class CreatingNewPurchaseOrderPage extends WebDriverUtility{
	@FindBy(name="subject")
	private WebElement subjectTextBox;
	
	
	@FindBy(name="bill_street")
	private WebElement billingAddressTextBox;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement vendorAddIcon;	
	
	@FindBy(xpath="//b[text()='Copy Billing address']/preceding-sibling::input[@type='radio']")
	private WebElement billingAddressRadioButton;
	
	
	@FindBy(xpath="//b[text()='Address Information']/preceding::input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	@FindBy(id="searchIcon1")
	private WebElement productsAddIcon;
	
	
	@FindBy(name="qty1")
	private WebElement quantityTextBox;
	
	@FindBy(name="ship_street")
	private WebElement shippingAddressTextBox;
	
	
	@FindBy(xpath="//b[text()='Copy Shipping address']/preceding-sibling::input[@type='radio']")
	private WebElement shippingAddressRadioButton;
	
	@FindBy(id="productName1")
	private WebElement itemTextBox;

	

	public CreatingNewPurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getQuantityTextBox() {
		return quantityTextBox;
	}
	
	public WebElement getBillingAddressRadioButton() {
		return billingAddressRadioButton;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getSubjectTextBox() {
		return subjectTextBox;
	}


	public WebElement getVendorAddIcon() {
		return vendorAddIcon;
	}

	public WebElement getBillingAddressTextBox() {
		return billingAddressTextBox;
	}
	
	
	public WebElement getProductsAddIcon() {
		return productsAddIcon;
	}
	
	
	public WebElement getItemTextBox() {
		return itemTextBox;
	}

	//business logic
	/**
	 * this method is used to create purchase order by entering only subject text field and clicking on vendor icon
	 * @param subject
	 */
	public void createPurchaseOrder(String subject) {
		subjectTextBox.sendKeys(subject);
		
		vendorAddIcon.click();
		
	}
	/**
	 * this method is used to switch back from child browser and enter billing address
	 * @param driver
	 * @param billingAddress
	 */
	public void switchBackFromChildBrowser(WebDriver driver,String billingAddress) {
		switchToWindow(driver,"PurchaseOrder");
		billingAddressTextBox.sendKeys(billingAddress);
		billingAddressRadioButton.click();	
		
		
	}
	
	/**
	 * this method is used to add products in purchase order
	 */
	public void addProductsInPurchaseOrder() {
		productsAddIcon.click();
	}
	
	/**
	 * this method is used to switch back from child browser and click on save button
	 * @param driver
	 * @param quantity
	 */
	public void switchingBackFromChildBrowser(WebDriver driver,String quantity) {
		switchToWindow(driver,"PurchaseOrder");
		quantityTextBox.sendKeys(quantity);
//		billingAddressTextBox.sendKeys(billingAddress);
//		billingAddressRadioButton.click();
		saveButton.click();	
	}
	
	/**
	 * this method is used to switch back from child browser and enter shipping address
	 * @param driver
	 * @param shippingAddress
	 */
	public void switchBackFromChild(WebDriver driver,String shippingAddress) {
		switchToWindow(driver,"PurchaseOrder");
		billingAddressTextBox.sendKeys(shippingAddress);
		billingAddressRadioButton.click();	
	}

	

}
