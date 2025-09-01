package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ExcelWriter;
import base.DriverFactory;

public class languageLearningPage{
	private WebDriver driver;
	private static Logger logger = LogManager.getLogger(languageLearningPage.class); 
	
	public languageLearningPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div[data-testid^='language']") List<WebElement> languageList;
	@FindBy(css = "div[data-testid^='productDifficultyLevel']") List<WebElement> levelList;
	@FindBy(xpath = "//button[@aria-label=\"Show more Language options\"]") WebElement showMore;
	
	public void changeTab() {
		logger.info("***** Changing Tab *****");
		
		Set<String> windows = driver.getWindowHandles();
		List<String> windowHandles = new ArrayList<>(windows);
		driver.switchTo().window(windowHandles.get(windowHandles.size()-1));
	}

	public void printLanguageAndLevel() {
        logger.info("***** Extracted languages and levels *****");

	    showMore.click();

	    List<String> languages = new ArrayList<>();
	    for (WebElement entry : languageList) {
//	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entry);
	        languages.add(entry.getText());
	    }

	    List<String> levels = new ArrayList<>();
	    for (WebElement entry : levelList) {
//	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entry);
	        levels.add(entry.getText());
	    }

	    String browser = DriverFactory.getBrowser();
	    ExcelWriter.writeLanguageAndLevel(languages, levels, "Extracted_Data.xlsx", browser + "_Results","Language","Level");
	}


}
