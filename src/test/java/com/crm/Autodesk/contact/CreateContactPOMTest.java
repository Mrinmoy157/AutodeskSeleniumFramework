package com.crm.Autodesk.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.ObjectRepository.ContactInformationPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreatingNewContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.genericUtility.ExcelUtility;
import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.JavaUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * this is create contact test page
 * @author mrinm
 *
 */
public class CreateContactPOMTest {

	public static void main(String[] args) throws Throwable {
		JavaUtility jutility=new JavaUtility();
		FileUtility futility= new FileUtility();
		ExcelUtility eutility= new ExcelUtility();
		WebDriverUtility wutility=new WebDriverUtility();
		
		String firstN=eutility.getDataFromExcel("sheet3", 1, 0);
		System.out.println("First name is "+firstN);
		String lastN=eutility.getDataFromExcel("sheet3", 1, 1);
		lastN=lastN+jutility.getRandomNumber();
		System.out.println("Last name is "+lastN);
		
		String browser=futility.getPropertyKeyValue("browser");
		String url=futility.getPropertyKeyValue("url");
		String username=futility.getPropertyKeyValue("username");
		String password=futility.getPropertyKeyValue("password");
		
		
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Enter valid browser");
		}
		
		
		wutility.maximizeWindow(driver);
		driver.get(url);
		wutility.WaitForPageToLoad(driver);
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.login(username, password);
		
		
		HomePage homepage= new HomePage(driver);
		homepage.clickOnContacts(driver);
		
		
		ContactsPage contpage= new ContactsPage(driver);
		contpage.clickOnAddIcon();
		
		
		CreatingNewContactPage contactPage= new CreatingNewContactPage(driver);
		contactPage.createContact(firstN, lastN);
		
		
		ContactInformationPage conInfoPage= new ContactInformationPage(driver);
		String actualcontactName=conInfoPage.getContactsText();
		
		if(actualcontactName.contains(lastN))
		{
			System.out.println("Verification successfull");
		}
		else
		{
			System.out.println("Verification unsuccessfull");
		}
		
		
		homepage.logout(driver);
		driver.close();

	}

}
