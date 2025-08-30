package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.DriverFactory;

public class UniversityPage{
	private WebDriver driver;
	private static Logger logger = LogManager.getLogger(UniversityPage.class); 
	
	public UniversityPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Contact Us']") WebElement contactUs;
	
	
	
	public void clickContactUs() {
		logger.info("***** Clicking Contact Us Button *****");

		contactUs.click();
	}
	
	
	
	
	
	
	



}