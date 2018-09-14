package com.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.properties.TestProperties;

public abstract class BasePageObject {

	public WebDriver driver;
	public TestProperties testProperties;
	private WebDriverWait driverWait;

	public BasePageObject(WebDriver driver, TestProperties testProperties) {
		this.driver = driver;
		this.testProperties = testProperties;
		
		PageFactory.initElements(driver, this);
		
		driverWait = new WebDriverWait(driver, 5);
		driverWait.ignoring(NoSuchElementException.class);		
	}
	
	public abstract void waitForPageToLoad();

	/**
	 * Closes the driver
	 */
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

	/**
	 * Grabs the URL from the webdriver
	 * 
	 * @return a String of the current URL in the webdriver
	 */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	/**
	 * Method to navigate to a particular URL. Used in BeforeMethod to reduce load
	 * times
	 * 
	 * @param pageUrl
	 */
	public void navigateToPage(String pageUrl) {
		driver.navigate().to(pageUrl);
	}
	
	/**
	 * Waits until element is available by visibility before interacting with it
	 * with a default driverWait timeout.
	 * 
	 * @param element The Element you want to wait for
	 */
	protected void waitForVisibilityOfElement(WebElement element) {
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}
}
