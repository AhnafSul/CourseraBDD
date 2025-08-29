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
 
public class SearchPage {
	private WebDriver driver;
	private static Logger logger = LogManager.getLogger(HomePage.class); 
 
    public SearchPage() {
    	this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
    }
 
    // WebElements for the first course
    @FindBy(xpath = "//*[@id='cds-react-aria-:Ragqapfjasqdala:-product-card-title']/h3")
    WebElement title1;
 
    @FindBy(xpath = "//*[@id=\"cds-react-aria-:Rbiuqgqapfjasqdala:-meter\"]/span")
    WebElement rating1;
 
    @FindBy(xpath = "(//p[@class=\"css-vac8rf\" and contains(text(),'Course ')])[1]")
    WebElement hours1;
 
    // WebElements for the second course
    @FindBy(xpath = "//*[@id=\"cds-react-aria-:Rahaapfjasqdala:-product-card-title\"]/h3")
    WebElement title2;
 
    @FindBy(xpath = "//*[@id=\"cds-react-aria-:Rbiuqhaapfjasqdala:-meter\"]/span")
    WebElement rating2;
 
    @FindBy(xpath = "(//p[text()='Beginner · Course · 1 - 4 Weeks'])[1]")
    WebElement hours2;
    
    @FindBy(xpath = "//*[@id=\"cds-react-aria-:R8qlmphel6dakqdala:\"]")
    WebElement sortLanguage;
    
    @FindBy(xpath = "//*[@id=\"cds-react-aria-:R8qlmpiel6dakqdala:\"]")
    WebElement sortLevel;    
 
    // --- Methods to get text for the course ---
 
    public List<String> getCourseDetails() {
    	logger.info("***** Fetching the course details and convert it into a list *****");
  
        String t1 = "first title : " +title1.getText();
        String r1 = "first rating : " +rating1.getText();
        String h1 = "first duration : " +hours1.getText().replace("Course", "").replace(".", "").replace("Beginner", "").trim();
        
        String t2 = "first title : " +title2.getText();
        String r2 = "first rating : " +rating2.getText();
        String h2 = "first duration : " +hours2.getText().replace("Course", "").replace(".", "").replace("Beginner", "").trim();
        
        return Arrays.asList(t1,r1,h1,t2,r2,h2);
        
    }
    
    public void languageSorting() {
    	sortLanguage.click();
    }
    
    public void levelSorting() {
    	sortLevel.click();
    }
    
}
 
 