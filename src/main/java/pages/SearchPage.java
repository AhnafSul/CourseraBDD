package pages;
 
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;
import base.Log;
import utils.ExcelWriter;
 
public class SearchPage {
	private final WebDriver driver;
	 private final WebDriverWait wait;
 
    public SearchPage() {
    	this.driver = DriverFactory.getDriver();
    	this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
    }
 
    // WebElements for the first course
    @FindBy(css = "div[data-testid^=\"language:English\"]")

    private WebElement sortLanguage;

    @FindBy(css = "div[data-testid^='productDifficultyLevel:Beginner']")

    private WebElement sortLevel;
    

    @FindBy(css = "a[data-click-key=\"search.search.click.search_card\"]")

    private List<WebElement> titleList;

    @FindBy(css = "div[aria-label=\"Rating\"]>span")

    private List<WebElement> ratingList;

    @FindBy(css = "div[class=\"cds-CommonCard-metadata\"]>p")

    private List<WebElement> durationList; 
 
    // --- Methods to get text for the course ---
 
    public void getCourseDetails() {
    	Log.info("***** Fetching the course details and convert it into a list *****");
    	
    	 if (titleList.size() < 2 || ratingList.size() < 2 || durationList.size() < 2) {
             Log.info("***** Insufficient course data available *****");
             return;
         }

        String t1 = "title : " +titleList.get(0).getText();

        String r1 = "rating : " +ratingList.get(0).getText();

        String d1 = "duration : " + (durationList.get(0).getText().split(" · "))[2];

        String t2 = "title : " +titleList.get(1).getText();

        String r2 = "rating : " +ratingList.get(1).getText();

        String d2 = "duration : " + (durationList.get(1).getText().split(" · "))[2];
        List<String> courseDetails1 = Arrays.asList(t1,r1,d1);
        List<String> courseDetails2 = Arrays.asList(t2,r2,d2);
        String browser = DriverFactory.getBrowser();
        SimpleDateFormat sdf = new SimpleDateFormat("dd_HHmmssSSS");
        String timestamp = sdf.format(new Date());
	    ExcelWriter.writeOnExcel(courseDetails1, courseDetails2, "Extracted_Data.xlsx", browser + "_CD"+timestamp,"Course 1","Course 2");
        
    }
    
    public void languageSorting() {
    	Log.info("***** Applying language filter *****");
    	sortLanguage.click();
    }
    
    public void levelSorting() {
    	Log.info("***** Applying level filter *****");
    	sortLevel.click();
    }
    
}
 
 