package pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;
import base.Log;
import utils.ExcelWriter;


public class LanguageLearningPage{
	private final WebDriver driver;
	private final WebDriverWait wait;
	
	public LanguageLearningPage() {
		this.driver = DriverFactory.getDriver();
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div[data-testid^='language']") private List<WebElement> languageList;
	@FindBy(css = "div[data-testid^='productDifficultyLevel']") private List<WebElement> levelList;
	@FindBy(xpath = "//button[@aria-label=\"Show more Language options\"]") private WebElement showMore;
	
	public void changeTab() {
		Log.info("***** Switching to new tab *****");
		
		Set<String> windows = driver.getWindowHandles();
		List<String> windowHandles = new ArrayList<>(windows);
		if (windowHandles.size() > 1) {
            driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));
		}
	}

	public void printLanguageAndLevel() {
		Log.info("***** Extracting languages and levels *****");

		try {
            showMore.click();
        } catch (Exception e) {
            Log.info("***** Show more button not available or already expanded *****");
        }

	    List<String> languages = new ArrayList<>();
	    for (WebElement entry : languageList) {
	        languages.add(entry.getText());
	    }

	    List<String> levels = new ArrayList<>();
	    for (WebElement entry : levelList) {
	        levels.add(entry.getText());
	    }

	    String browser = DriverFactory.getBrowser();
        SimpleDateFormat sdf = new SimpleDateFormat("dd_HHmmssSSS");
        String timestamp = sdf.format(new Date());
	    ExcelWriter.writeOnExcel(languages, levels, "Extracted_Data.xlsx", browser + "_R"+timestamp,"Language","Level");
	}


}
