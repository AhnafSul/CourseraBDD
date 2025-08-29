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
	
	public List<String> printLanguage() {
		logger.info("***** Extracted the languages list *****");
		
		showMore.click();
		
		List<String> languages =  new ArrayList<>();
		
		System.out.println("There are "+ languageList.size()+" languages available.");
		System.out.println("List of Languages:");
		for(WebElement entry : languageList) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",entry);
			languages.add(entry.getText());
		}
		return languages;
		
	}
	
	public List<String> printLevel() {
		logger.info("***** Extracted the levels list *****");
		
		List<String> levels =  new ArrayList<>();
		System.out.println("There are "+ levelList.size()+" levels available.");
		System.out.println("List of levels:");
		for(WebElement entry : levelList) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",entry);
			levels.add(entry.getText());
		}
		return levels;
	}
}
