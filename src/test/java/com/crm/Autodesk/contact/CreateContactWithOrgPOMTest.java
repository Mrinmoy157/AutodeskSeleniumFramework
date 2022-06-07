package com.crm.Autodesk.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.autodesk.ObjectRepository.AddOrgPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreatingNewContactPage;
import com.crm.autodesk.ObjectRepository.CreatingNewOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationInformationPage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodesk.genericUtility.ExcelUtility;
import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.JavaUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * this class is used to create contacts by entering organization name
 * @author mrinm
 *
 */
public class CreateContactWithOrgPOMTest {

	public static void main(String[] args) throws Throwable {
		JavaUtility jutility=new JavaUtility();
		FileUtility futility= new FileUtility();
		ExcelUtility eutility= new ExcelUtility();
		WebDriverUtility wutility=new WebDriverUtility();
		
		String browser=futility.getPropertyKeyValue("browser");
		String url=futility.getPropertyKeyValue("url");
		String username=futility.getPropertyKeyValue("username");
		String password=futility.getPropertyKeyValue("password");
		
		String lastN=eutility.getDataFromExcel("sheet5", 1, 0)+"_"+jutility.getRandomNumber();
		String firstN=eutility.getDataFromExcel("sheet3", 1, 0);
		String orgName=eutility.getDataFromExcel("sheet5", 1, 1)+"_"+jutility.getRandomNumber();
		
		WebDriver driver = null;
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver=new InternetExplorerDriver();
		}
		
		wutility.WaitForPageToLoad(driver);
		driver.get(url);
		
		wutility.maximizeWindow(driver);
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.login(username, password);
		
		HomePage homepage= new HomePage(driver);
		homepage.clickOnOrganization();
		
		OrganizationPage orgpage= new OrganizationPage(driver);
		orgpage.clickOnAddIcon();
		
		CreatingNewOrganizationPage orgPage= new CreatingNewOrganizationPage(driver);
		orgPage.createOrganizationOnly(orgName);
		
		
		OrganizationInformationPage orgInfoPage= new OrganizationInformationPage(driver);
		String actualProdName=orgInfoPage.getOrganizationText();
		if(actualProdName.contains(orgName)){
			System.out.println("success");
		}
		else
		{
			System.out.println("not successful");
		}
		
		homepage.clickOnContacts(driver);
		
		ContactsPage contpage= new ContactsPage(driver);
		contpage.clickOnAddIcon();
		
		
		CreatingNewContactPage contPage= new CreatingNewContactPage(driver);
		contPage.createContactOnly(firstN, lastN);
		
		AddOrgPage addOrg= new AddOrgPage(driver);
		addOrg.addOrgInContact(driver, orgName);
		
		contPage.switchingBackFromChildBrowser(driver);
		
		homepage.logout(driver);
		driver.quit();
		
		
		

	}

}
