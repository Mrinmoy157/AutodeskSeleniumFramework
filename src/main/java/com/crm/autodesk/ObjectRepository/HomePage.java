package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

/**
 * This is HomePage object repository
 * @author mrinm
 *
 */
public class HomePage extends WebDriverUtility{
	//Declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutIconImage;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreLinkMouseover;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(linkText="Purchase Order")
	private WebElement purchaseOrderLink;
	
	@FindBy(linkText="Vendors")
	private WebElement vendorLink;
	
	
	
	public WebElement getVendorLink() {
		return vendorLink;
	}

	public WebElement getMoreLinkMouseover() {
		return moreLinkMouseover;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getSignOutIconImage() {
		return signOutIconImage;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}


	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}
	
	
	
	public WebElement getPurchaseOrderLink() {
		return purchaseOrderLink;
	}

		//initialization
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
	
	//business logic
		/**
		 * this method will click on organization link
		 */
	public void clickOnOrganization() {
		organizationLink.click();
	}
	/**
	 * this method will logout the application
	 * @param driver
	 */
	public void logout(WebDriver driver) {
		mouseOverOnElement(driver,signOutIconImage);
		signOutLink.click();
	}
	/**
	 * this method will click on products link
	 */
	public void clickOnProducts() {
		productsLink.click();
	}
	
	/**
	 * this method is used to click on campaign
	 * @param driver
	 */
	public void clickOnCampaign(WebDriver driver) {
		mouseOverOnElement(driver,moreLinkMouseover);
		campaignsLink.click();
	}
	
	/**
	 * this method is used to click on contacts
	 * @param driver
	 */
	public void clickOnContacts(WebDriver driver) {
		waitForElementToBeClickable(driver,contactsLink);
		contactsLink.click();
	}
	/**
	 * this method is used to click on purchase order
	 * @param driver
	 */
	public void clickOnPurchaseOrder(WebDriver driver) {
		mouseOverOnElement(driver,moreLinkMouseover);
		purchaseOrderLink.click();
	}
	
	/**
	 * this method is used to click on vendor
	 * @param driver
	 */
	public void clickOnVendors(WebDriver driver) {
		mouseOverOnElement(driver,moreLinkMouseover);
		vendorLink.click();
	}

}
