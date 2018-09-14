package com.testcases;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pageobjects.SearchPageObject;

public class SearchTestCase extends BaseTestCase {

	@Autowired
	private SearchPageObject searchPageObject;
	
	@BeforeClass
	public void beforeClass() {
		searchPageObject.navigateToPage(searchPageObject.testProperties.baseUrl);
	}	
	
	@Test(description = "Test a simple Google search")
	public void testGoogleSearch() {
		searchPageObject.waitForPageToLoad();
		searchPageObject.enterSearchText("Riding Lawn Mowers");
		searchPageObject.clickSearchButton();
	}
}
