package pages;


import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;
import base.Log;

public class HomePage {
	private final WebDriver driver;
	private final WebDriverWait wait;
	
	
	public HomePage() {
		this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[placeholder=\"What do you want to learn?\"]") private WebElement search_txt; 
	@FindBy(css = "a[href=\"/browse/language-learning\"]") private WebElement langaugeLearning; 
	@FindBy(xpath = "//span[text()=' Universities']") private WebElement forUniversities;

	public void clickLanguageLearning() {
		Log.info("***** Clicking language learning *****");
		langaugeLearning.click();
	}	
	
	public void searchBar(String courseName) {
		Log.info("***** Search for " + courseName + " *****");
		search_txt.clear();
		search_txt.sendKeys(courseName);
		search_txt.sendKeys(Keys.ENTER);
	}	
	public void clickforUniversities() {
		Log.info("***** Clicking For Universities *****");
		forUniversities.click();
	}
}
