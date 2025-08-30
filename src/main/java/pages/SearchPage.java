package pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

public class SearchPage {

	private WebDriver driver;

	private static Logger logger = LogManager.getLogger(HomePage.class); 

    public SearchPage() {

    	this.driver = DriverFactory.getDriver();

		PageFactory.initElements(driver, this);

    }
    
    @FindBy(css = "div[data-testid^=\"language:English\"]")

    WebElement sortLanguage;

    @FindBy(css = "div[data-testid^='productDifficultyLevel:Beginner']")

    WebElement sortLevel;
    
    //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    

    @FindBy(css = "a[data-click-key=\"search.search.click.search_card\"]")

    List<WebElement> titleList;

    @FindBy(css = "div[aria-label=\"Rating\"]>span")

    List<WebElement> ratingList;

    @FindBy(css = "div[class=\"cds-CommonCard-metadata\"]>p")

    List<WebElement> durationList;
      

    // --- Methods to get text for the course ---

    public List<String> getCourseDetails() {

    	logger.info("***** Fetching the course details and convert it into a list *****");

        String t1 = "first title : " +titleList.get(0).getText();

        String r1 = "first rating : " +ratingList.get(0).getText();

        String h1 = "first duration : " + (durationList.get(0).getText().split(" · "))[2];

        String t2 = "Second title : " +titleList.get(1).getText();

        String r2 = "first rating : " +ratingList.get(1).getText();

        String h2 = "first duration : " + (durationList.get(1).getText().split(" · "))[2];

        return Arrays.asList(t1,r1,h1,t2,r2,h2);

    }

    public void languageSorting() {

    	sortLanguage.click();

    }

    public void levelSorting() {

    	sortLevel.click();

    }

}

 