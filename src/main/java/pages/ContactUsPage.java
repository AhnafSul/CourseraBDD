package pages;

import java.time.Duration;
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
	
	@FindBy(xpath = "//input[@id='FirstName']") WebElement firstName;
	@FindBy(xpath = "//input[@id='LastName']") WebElement lastName;
	@FindBy(xpath = "//input[@id='Email']") WebElement email;
	@FindBy(xpath = "//input[@id='Phone']") WebElement phone;
	@FindBy(xpath = "//input[@id='Company']") WebElement Company;
	@FindBy(xpath = "//select[@id='Institution_Type__c']") WebElement selectInstitutionType;
	@FindBy(xpath = "//select[@id='Title']") WebElement selectJobRole;
	@FindBy(xpath = "//select[@id='Department']") WebElement selectDepartment;
	@FindBy(xpath = "//select[@id='What_the_lead_asked_for_on_the_website__c']") WebElement selectNeeds;
	@FindBy(xpath = "//select[@id='Self_reported_employees_to_buy_for__c']") WebElement selectNumberOfLearners;
	@FindBy(xpath = "//select[@id='Country']") WebElement selectCountry;
	@FindBy(xpath = "//button[text()='Submit']") WebElement submit;
	
	
	
	public void enterFirstName(String value) {
	    firstName.sendKeys(value);
	}

	public void enterLastName(String value) {
	    lastName.sendKeys(value);
	}

	public void enterEmail(String value) {
	    email.sendKeys(value);
	}

	public void enterPhone(String value) {
	    phone.sendKeys(value);
	}

	public void enterCompany(String value) {
	    Company.sendKeys(value);
	}

	
	public void selectInstitutionType(String value) {
	    Select institutionType = new Select(selectInstitutionType);
	    institutionType.selectByVisibleText(value);
	}

	public void selectJobRole(String value) {
	    Select jobRole = new Select(selectJobRole);
	    jobRole.selectByVisibleText(value);
	}

	public void selectDepartment(String value) {
	    Select department = new Select(selectDepartment);
	    department.selectByVisibleText(value);
	}

	public void selectNeeds(String value) {
	    Select needs = new Select(selectNeeds);
	    needs.selectByVisibleText(value);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            return selectNumberOfLearners.isEnabled();
	        }
	    });

	}

	public void selectNumberOfLearners(String value) {
	    Select numberOfLearners = new Select(selectNumberOfLearners);
	    numberOfLearners.selectByVisibleText(value);
	}

	public void selectCountry(String value) {
	    Select country = new Select(selectCountry);
	    country.selectByVisibleText(value);
	}

	public void clickSubmit() {
	    submit.click();
	}

	

	
public void fillContactForm(String first, String last, String emailVal, String phoneVal, String company,
            String institutionType, String jobRole, String department, String needs,
            String learners, String country) {

enterFirstName(first);
enterLastName(last);
enterEmail(emailVal);
enterPhone(phoneVal);
enterCompany(company);
selectInstitutionType(institutionType);
selectJobRole(jobRole);
selectDepartment(department);
selectNeeds(needs); // handles dynamic dropdown activation

if (selectNumberOfLearners.isEnabled()) {
selectNumberOfLearners(learners);
}

selectCountry(country);
}

	
	
	
	
	



}
