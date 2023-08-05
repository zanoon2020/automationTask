package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shaft.driver.SHAFT;

import pages.HomePage;
import pages.SearchResultPage;


public class EbayTests {
	
	private SHAFT.GUI.WebDriver driver ; 
	private SHAFT.TestData.JSON testData;
	private HomePage homePage ;
	private SearchResultPage searchResultPage;
	
	@BeforeClass(description = "Setup Test Data.")
	  public void beforeClass(){
	        testData = new SHAFT.TestData.JSON("testData.json");
	    }
	
	@BeforeMethod 
	public void beforeMethod() {
		driver = new SHAFT.GUI.WebDriver() ; 
		homePage = new HomePage(driver);
		searchResultPage = new SearchResultPage(driver);
	}
	
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
		
	}
	
	
	@Test(description = "user will navigate to Ebay then search for mazda mx-5 and test will validate results count")
	public void _01navigateAndSearch() {
		homePage.navigateToHomePage(testData.getTestData("url"));
		homePage.validateEbayLogo();
		homePage.searchFor(testData.getTestData("searchKeyWord"));
		searchResultPage.getResultsCount();
	
	}
	
	
	@Test(description = "user will navigate to Ebay then search for mazda mx-5 then filter results by manual transmission")
	public void _02searchAndFilter() {
		homePage.navigateToHomePage(testData.getTestData("url"));
		homePage.searchFor(testData.getTestData("searchKeyWord"));
		searchResultPage.filterByManual();
		searchResultPage.getResultsCount();
	}
	

	

}
