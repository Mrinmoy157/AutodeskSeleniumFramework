package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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

public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable {
		WebDriverUtility wutility=new WebDriverUtility();
		FileUtility futility= new FileUtility();
		ExcelUtility eutility= new ExcelUtility();
		JavaUtility jutility= new JavaUtility();
		
		
		String browser=futility.getPropertyKeyValue("browser");
		String url=futility.getPropertyKeyValue("url");
		String username=futility.getPropertyKeyValue("username");
		String password=futility.getPropertyKeyValue("password");
		
		String ExpectedOrgName=eutility.getDataFromExcel("sheet1", 1, 0)+jutility.getRandomNumber();
		String industry=eutility.getDataFromExcel("sheet1", 1, 3);
		
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver= new FirefoxDriver();
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			 driver= new InternetExplorerDriver();
			
		}
		
		wutility.maximizeWindow(driver);
		wutility.WaitForPageToLoad(driver);
		
		driver.get(url);
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(username, password);
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnOrganization();
		
		OrganizationPage orgpage= new OrganizationPage(driver);
		orgpage.clickOnAddIcon();
		
		
		CreatingNewOrganizationPage orgPage= new CreatingNewOrganizationPage(driver);
		orgPage.createOrganization(ExpectedOrgName, industry);
		
		OrganizationInformationPage orgInfoPage= new OrganizationInformationPage(driver);
		String actualOrgName = orgInfoPage.getOrganizationText();
		
		
		if(actualOrgName.contains(ExpectedOrgName)){
			System.out.println("pass");
		}
		else{
			System.out.println("Fail");
		}
		homepage.logout(driver);
		driver.quit();

	}

}
