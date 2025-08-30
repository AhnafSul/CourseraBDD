package pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.DriverFactory;

public class HomePage {
	private WebDriver driver;
	private static Logger logger = LogManager.getLogger(HomePage.class); 
	
	
	public HomePage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[placeholder=\"What do you want to learn?\"]") WebElement search_txt; 
	@FindBy(xpath = "//a[text()='For Enterprise']") WebElement enterprise_link;
	@FindBy(xpath = "//a[text()='For Campus']") WebElement campus_link;
	@FindBy(css = "a[href=\"/browse/language-learning\"]") WebElement langaugeLearning; 
	
	public void clickLanguageLearning() {
		logger.info("***** Clicking language learning *****");
		langaugeLearning.click();
	}	
	
	public void searchBar(String courseName) {
		logger.info("***** Search Web Development *****");
		search_txt.sendKeys(courseName);
		search_txt.sendKeys(Keys.ENTER);
	}	
}
