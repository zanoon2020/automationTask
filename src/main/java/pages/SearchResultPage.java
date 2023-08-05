package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class SearchResultPage {

	private SHAFT.GUI.WebDriver driver ; 
	
	//constructor 
	public SearchResultPage(SHAFT.GUI.WebDriver driver ) {
		this.driver = driver ;
	}
	
	//locators
	private By resultsCount = By.xpath("//h1[contains(@class,'count-heading')]//span[1]");
	private By resultBanner = By.xpath("//h1[contains(@class,'count-heading')]");
	private By manualCheckBox = By.xpath("//input[@aria-label='Manual']");
	
	public void getResultsCount() {
		String ResultsCount = driver.element().getText(resultsCount);
		driver.element().captureScreenshot(resultBanner);
		SHAFT.Report.report("Results Count are "+ResultsCount);
		
	}
	
	public void filterByManual() {
		driver.element().click(manualCheckBox);
		driver.element().assertThat(manualCheckBox).isChecked().perform();
	}
	
}
