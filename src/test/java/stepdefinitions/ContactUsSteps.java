package stepdefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactUsPage;
import pages.HomePage;
import pages.UniversityPage;
import utils.ExcelReader;

public class ContactUsSteps {

    ContactUsPage contactUsPage = new ContactUsPage();
    HomePage hp = new HomePage();
    UniversityPage up = new UniversityPage();
    private static final Logger logger = LogManager.getLogger(ContactUsSteps.class);
    ContactUsPage cp = new ContactUsPage();
    
    @Given("I am on the Coursera home page")
    public void i_am_on_the_coursera_home_page() {
        // This step should contain the navigation logic
    }

    @When("I navigate to the university contact form and click on contact us button")
    public void i_navigate_to_the_university_contact_form() {
        hp.clickforUniversities();
        logger.info("Clicked on 'For University'");
        up.clickContactUs();
        logger.info("Clicked on 'Contact Us'");
    }
    
    @When("I fill in the contact form with the Excel details")
    public void i_fill_in_the_contact_form_with_the_excel_details() throws IOException, InterruptedException {
        Object[][] testData = ExcelReader.getTestData("C:\\Users\\2400875\\git\\CourseraBDD\\src\\test\\resources\\TestData.xlsx");
 
        for(Object[] row: testData) {
        	String firstName = row[0].toString();
        	String lastName = row[1].toString();
        	String email = row[2].toString();
        	String phoneNumber = row[3].toString();
        	String institutionType = row[4].toString();
        	String institutionName = row[5].toString();
        	String jobRole = row[6].toString();
        	String department = row[7].toString();
        	String need = row[8].toString();
        	String learners;
        	
        	if(need == "Get in touch with sales") {
        		learners = row[9].toString();
        	}
        	else {
        		learners = null;
        	}
        	
        	String country = row[10].toString();
        	
        	String states;
        	
        	try {
        		states = row[11].toString();
        	}catch(Exception e) {
        		states = null;
        	}
        	
        	String errorMsg = cp.fillForm(firstName, lastName, email, phoneNumber, institutionType, institutionName, jobRole, department, need, learners, country,states);
        	
        	if(errorMsg != null) {
            	System.out.println("Error message found : " + errorMsg);
            }
            else {
            	System.out.println("No error message found");
            }
        }
    }
    
    @When("I submit the form")
    public void i_submit_the_form() {
    }
    
    @Then("I should see an error message for the email field")
    public void i_should_see_an_error_message_for_the_email_field() {
        
    }
}