package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.DriverFactory;

public class languageLearningPage extends DriverFactory{
	private WebDriver driver;
	
	public languageLearningPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div[data-testid^='language']") List<WebElement> languageList;
	@FindBy(css = "div[data-testid^='productDifficultyLevel']") List<WebElement> levelList;
	@FindBy(xpath = "//button[@aria-label=\"Show more Language options\"]") WebElement showMore;
	
	public void changeTab() {
		Set<String> windows = driver.getWindowHandles();
		List<String> windowHandles = new ArrayList<>(windows);
		driver.switchTo().window(windowHandles.get(windowHandles.size()-1));
	}
	
	public void printLanguage() {
		showMore.click();
		
		System.out.println("There are "+ languageList.size()+" languages available.");
		System.out.println("List of Languages:");
		for(WebElement entry : languageList) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",entry);
			System.out.println(entry.getText());
		}
		
	}
	
	public void printLevel() {
		System.out.println("There are "+ levelList.size()+" levels available.");
		System.out.println("List of levels:");
		for(WebElement entry : levelList) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",entry);
			System.out.println(entry.getText());
		}
	}
}
