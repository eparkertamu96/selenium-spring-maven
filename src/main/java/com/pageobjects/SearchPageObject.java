package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.properties.TestProperties;

@Component
public class SearchPageObject extends BasePageObject {

	@FindBy(xpath = "//input[@value = 'Google Search']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//input[@title = 'Search']")
	private WebElement searchTextbox;	
	

	@Autowired
	public SearchPageObject(WebDriver driver, TestProperties testProperties) {
		super(driver, testProperties);
	}
	
	/**
	 * Enters text into the search textbox
	 */
	public void enterSearchText(String searchText) {
		searchTextbox.sendKeys(searchText);
	}
	
	/**
	 * Clicks on the search button
	 */
	public void clickSearchButton() {
		searchButton.click();
	}

	/**
	 * Waits for page to load
	 */
	@Override
	public void waitForPageToLoad() {
		super.waitForVisibilityOfElement(searchTextbox);
		
	}	
}