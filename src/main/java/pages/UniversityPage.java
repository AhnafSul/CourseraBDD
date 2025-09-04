package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.DriverFactory;
import base.Log;

public class UniversityPage{
	private WebDriver driver;
	
	public UniversityPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Contact Us']") WebElement contactUs;
	
	
	
	public void clickContactUs() {
		Log.info("***** Clicking Contact Us Button *****");

		contactUs.click();
	}
	
	
	
	
	
	
	



}