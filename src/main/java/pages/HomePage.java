package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class HomePage {
	private SHAFT.GUI.WebDriver driver ; 
	
	//constructor 
	public HomePage(SHAFT.GUI.WebDriver driver ) {
		this.driver = driver ;
		
	}
	
	//locators
	
	private By ebayLogo = By.xpath("//header[@role='banner']//h1");
	private By searchBox = By.xpath("(//header[@role='banner']//tr)[3]//input[@type='text']");
	private By searchButton = By.xpath("(//header[@role='banner']//tr)[3]//input[@type='submit']");
	
	
	//Actions
	public void navigateToHomePage(String url) {
		driver.browser().navigateToURL(url);
	}
	
	public void validateEbayLogo() {
		driver.element().assertThat(ebayLogo).exists().perform();
	}
	
	public void searchFor(String searchKeyWord) {
		driver.element().type(searchBox,  searchKeyWord);
		driver.element().click(searchButton);
	}

}
