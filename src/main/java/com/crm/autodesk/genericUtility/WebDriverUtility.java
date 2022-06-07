package com.crm.autodesk.genericUtility;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * It contains webDriver specific reusable actions
 * @author mrinm
 *
 */
public class WebDriverUtility {
	
	
	
	/**
	 * it is used for maximizing the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * wait for page to load before identifying any synchronized element in DOM
	 * @param driver
	 */
	public void WaitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(IPathConstants.ITO,TimeUnit.SECONDS);
	}
	
	/**
	 * wait for page to load before identifying any synchronized[java scripts actions] element in DOM
	 * @param driver
	 */
	public void WaitForPageToLoadForJSElement(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(IPathConstants.ITO,TimeUnit.SECONDS);
	}
	
	
	/**
	 * use to wait for element to be clickable in GUI and check for specific element for every 500 miliseconds
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,IPathConstants.ITO);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * used to check the visibility of element
	 * @param driver
	 * @param element
	 */
	public void checkingVisibility(WebDriver driver, WebElement element) {
		WebDriverWait w= new WebDriverWait(driver,IPathConstants.ITO);
		w.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * used to check if title contains or not
	 * @param driver
	 * @param title
	 */
	public void titleContains(WebDriver driver, String title) {
		WebDriverWait w= new WebDriverWait(driver,IPathConstants.ITO);
		w.until(ExpectedConditions.titleContains(title));
	}
	
	/**
	 * used to wait for element to be clickable in GUI and check for specific element for every 500 mili seconds
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @throws Throwable
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element, int pollingTime) throws Throwable
	{
		FluentWait wait= new FluentWait(driver);
		wait.pollingEvery(pollingTime,TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/**
	 * used to switch to any window based on window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String wID=it.next();
			driver.switchTo().window(wID);
			String currentWindowTitle= driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * used to switch to alert window and click on ok button
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * used to switch to alert window and click on cancel button
	 * @param driver
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	
	/**
	 * used to switch to frame window based on index
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	
	/**
	 * used to switch to frame window based on id or name attribute
	 * @param driver
	 * @param int_name_attribute
	 */
	public void switchToFrame(WebDriver driver, String int_name_attribute)
	{
		driver.switchTo().frame(int_name_attribute);
	}
	
	
	
	/**
	 * used to select the value from the dropdown based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	
	/**
	 * used to select the dropdown based on value/option available in GUI
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	
	/**
	 * used to select the dropdown based on values
	 * @param text
	 * @param element
	 */
	public void select(String text, WebElement element)
	{
		Select s=new Select(element);
		s.selectByValue(text);
	}
	
	
	
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	
	/**
	 * used to right click on specified element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	
	
	/**
	 * 
	 * @param driver
	 * @param javascript
	 */
	public void executeJavaScript(WebDriver driver, String javascript)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript(javascript, null);
	}
	
	/**
	 * 
	 * @param driver
	 * @param javascript
	 */
	public void executingJavaScript(WebDriver driver, String javascript)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(javascript,null);
	}
	
	
	
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<20)
		{
			try {
				element.click();
				break;
			}catch(Throwable e)
			{
				Thread.sleep(5000);
				count++;
			}
		}
	}
	
	
	/**
	 * used to take screenshot when the script fails at a certain page
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws Throwable
	 */
	public String takeScreenshot(WebDriver driver, String screenshotName) throws Throwable
	{
		JavaUtility jutility= new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot)driver;
		String filePath="./screenshot/"+screenshotName+jutility.getSystemDateWithFormat()+".PNG";
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest= new File(filePath);
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}
	
	
	
	
	/**
	 * pass enter key appertain in to browser
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	
}
