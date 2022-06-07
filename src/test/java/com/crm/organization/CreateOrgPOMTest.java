package com.crm.organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
 * this is create organization page test
 * @author mrinm
 *
 */
public class CreateOrgPOMTest {

	public static void main(String[] args) throws Throwable {
		JavaUtility jutility=new JavaUtility();
		ExcelUtility eutility=new ExcelUtility();
		FileUtility futility= new FileUtility();
		WebDriverUtility wutility=new WebDriverUtility();
		
		
		String orgName=eutility.getDataFromExcel("sheet1", 1, 0);
		orgName=orgName+jutility.getRandomNumber();
		System.out.println("Organization name is"+orgName);
		
		
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
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(username, password);
		
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnOrganization();
		
		OrganizationPage orgpage= new OrganizationPage(driver);
		orgpage.clickOnAddIcon();
		
		
		CreatingNewOrganizationPage createOrg= new CreatingNewOrganizationPage(driver);
		createOrg.createOrganizationOnly(orgName);
		
		
		OrganizationInformationPage orgInfoPage= new OrganizationInformationPage(driver);
		String actualOrgName=orgInfoPage.getOrganizationText();
		
		
		if(actualOrgName.contains(orgName)) {
			System.out.println("name is verified");
		}
		else {
			System.out.println("name is not verified");
		}
		
		homepage.logout(driver);
		driver.close();

	}

}
