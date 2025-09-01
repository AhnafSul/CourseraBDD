package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ExcelWriter;
import base.DriverFactory;

public class ContactUsPage{
	private WebDriver driver;
	private static Logger logger = LogManager.getLogger(ContactUsPage.class); 
	
	public ContactUsPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='FirstName']") WebElement first_Name;
	@FindBy(xpath = "//input[@id='LastName']") WebElement last_Name;
	@FindBy(xpath = "//input[@id='Email']") WebElement emailID;
	@FindBy(xpath = "//input[@id='Phone']") WebElement phone;
	@FindBy(xpath = "//input[@id='Company']") WebElement Company;
	@FindBy(xpath = "//select[@id='Institution_Type__c']") WebElement selectInstitutionType;
	@FindBy(xpath = "//select[@id='Title']") WebElement selectJobRole;
	@FindBy(xpath = "//select[@id='Department']") WebElement selectDepartment;
	@FindBy(xpath = "//select[@id='What_the_lead_asked_for_on_the_website__c']") WebElement selectNeeds;
	@FindBy(xpath = "//select[@id='Self_reported_employees_to_buy_for__c']") WebElement selectNumberOfLearners;
	@FindBy(xpath = "//select[@id='Country']") WebElement selectCountry;
	@FindBy(xpath = "//button[text()='Submit']") WebElement submit;
	@FindBy(css = "div.mktoErrorMsg") WebElement errorMsg;
	@FindBy(css = "a[data-testid=\"ew_header_cta\"]") WebElement newContactButton;
	@FindBy(xpath = "//select[@id='State']") WebElement selectState;
	
	public String fillForm(String firstName, String lastName, String email, String phoneNumber, String institutionType, String institutionName, String jobRole, String department, String need, String learners, String country, String states) throws InterruptedException {
		first_Name.sendKeys(firstName);
		last_Name.sendKeys(lastName);
		emailID.sendKeys(email);
		phone.sendKeys(phoneNumber);
		Company.sendKeys(institutionName);
		
		Select s1 = new Select(selectInstitutionType);
	    s1.selectByVisibleText(institutionType);
	    
	    Select s2 = new Select(selectJobRole);
	    s2.selectByVisibleText(jobRole);
	    
	    Select s3 = new Select(selectDepartment);
	    s3.selectByVisibleText(department);
	    
	    Select s4 = new Select(selectNeeds);
	    s4.selectByVisibleText(need);
	    
	    Thread.sleep(3000);
	    
	    if(learners != null) {
	    	Select s5 = new Select(selectNumberOfLearners);
	    	s5.selectByVisibleText(learners);
	    }
	    
	    Select s6 = new Select(selectCountry);
	    s6.selectByVisibleText(country);
	    
	    Thread.sleep(3000);
	    
	    if(states != null) {
	    	Select s7 = new Select(selectState);
	    	s7.selectByVisibleText(states);
	    }
	    Thread.sleep(3000);
	    
	    logger.info("***** form filled *****");
	    submit.click();
	    
	    if(errorMsg != null) {
			 
	    	String err = errorMsg.getText();
	    	driver.navigate().refresh();
	    	return err;
			 
		}
		else {
			newContactButton.click();
			return null;
		}
	    
	}
}