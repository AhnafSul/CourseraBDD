package pages;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.DriverFactory;
import utils.ExcelWriter;
 
public class SearchPage {
	private WebDriver driver;
	private static Logger logger = LogManager.getLogger(HomePage.class); 
 
    public SearchPage() {
    	this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
    }
 
    // WebElements for the first course
    @FindBy(css = "div[data-testid^=\"language:English\"]")

    WebElement sortLanguage;

    @FindBy(css = "div[data-testid^='productDifficultyLevel:Beginner']")

    WebElement sortLevel;
    

    @FindBy(css = "a[data-click-key=\"search.search.click.search_card\"]")

    List<WebElement> titleList;

    @FindBy(css = "div[aria-label=\"Rating\"]>span")

    List<WebElement> ratingList;

    @FindBy(css = "div[class=\"cds-CommonCard-metadata\"]>p")

    List<WebElement> durationList; 
 
    // --- Methods to get text for the course ---
 
    public void getCourseDetails() {
    	logger.info("***** Fetching the course details and convert it into a list *****");
  
    	logger.info("***** Fetching the course details and convert it into a list *****");

        String t1 = "title : " +titleList.get(0).getText();

        String r1 = "rating : " +ratingList.get(0).getText();

        String d1 = "duration : " + (durationList.get(0).getText().split(" · "))[2];

        String t2 = "title : " +titleList.get(1).getText();

        String r2 = "rating : " +ratingList.get(1).getText();

        String d2 = "duration : " + (durationList.get(1).getText().split(" · "))[2];
        List<String> courseDetails1 = Arrays.asList(t1,r1,d1);
        List<String> courseDetails2 = Arrays.asList(t2,r2,d2);
        String browser = DriverFactory.getBrowser();
	    ExcelWriter.writeLanguageAndLevel(courseDetails1, courseDetails2, "Extracted_Data.xlsx", browser + "_CourseDetails","Course 1","Course 2");
        
    }
    
    public void languageSorting() {
    	sortLanguage.click();
    }
    
    public void levelSorting() {
    	sortLevel.click();
    }
    
}
 
 