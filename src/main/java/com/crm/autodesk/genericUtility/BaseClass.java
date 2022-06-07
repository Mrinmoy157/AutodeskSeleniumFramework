package com.crm.autodesk.genericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * this class contains annotations which are used again and again in test scripts
 * @author mrinm
 *
 */
public class BaseClass {
	public WebDriver driver= null;
	public FileUtility futility= new FileUtility();
	public JavaUtility jutility=new JavaUtility();
	public ExcelUtility eutility=new ExcelUtility();
	public WebDriverUtility wutility=new WebDriverUtility();
	public static WebDriver sDriver;
	
	@BeforeSuite(groups= {"smokeTest","sanityTest","integrationTest"})
	public void bs() {
		System.out.println("Database connection");
	}
	@BeforeTest(groups= {"smokeTest","sanityTest","integrationTest"})
	public void bt() {
		System.out.println("Execute script in parallel mode");
	}
	//@Parameters("browser")
	@BeforeClass(groups= {"smokeTest","sanityTest","integrationTest"})
	public void bc() throws Throwable {
		String browser=futility.getPropertyKeyValue("browser");
		String url=futility.getPropertyKeyValue("url");
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else {
			throw new Exception("Browser is not compatible");
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(IPathConstants.ITO,TimeUnit.SECONDS);
		sDriver=driver;
	}
	@BeforeMethod(groups= {"smokeTest","sanityTest","integrationTest"})
	public void bm() throws Throwable {
		String username=futility.getPropertyKeyValue("username");
		String password= futility.getPropertyKeyValue("password");
		LoginPage loginPage= new LoginPage(driver);
		loginPage.login(username, password);
	}
	@AfterMethod(groups= {"smokeTest","sanityTest","integrationTest"})
	public void am() {
		HomePage homePage = new HomePage(driver);
		homePage.logout(driver);
	}
	@AfterClass(groups= {"smokeTest","sanityTest","integrationTest"})
	public void ac() {
		driver.quit();
	}
	@AfterTest(groups= {"smokeTest","sanityTest","integrationTest"})
	public void at() {
		System.out.println("Close parallel mode execution");
	}
	@AfterSuite(groups= {"smokeTest","sanityTest","integrationTest"})
	public void as() {
		System.out.println("Close database connection");
	}

}
