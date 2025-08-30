package stepdefinitions;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.ContactUsPage;
import pages.HomePage;
import pages.UniversityPage;
import base.DriverFactory;

public class ContactUsSteps {

     ContactUsPage contactUsPage = new ContactUsPage();
     HomePage hp=new HomePage();
    private static final Logger logger = LogManager.getLogger(ContactUsSteps.class);

    @Given("I am on the Coursera home page")
    public void i_am_on_the_coursera_home_page() {
    	//print
    }

    @When("I click on \"For University\"")
    public void i_click_on_for_university() {
    	hp.clickforUniversities();
        logger.info("Clicked on 'For University'");
    }

    @And("I click on \"Contact Us\"")
    public void i_click_on_contact_us() {
        UniversityPage up=new UniversityPage();
        up.clickContactUs();
        logger.info("Clicked on 'Contact Us'");
    }

    @And("I fill in the contact form with the following details")
    public void i_fill_in_the_contact_form_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        contactUsPage.fillContactForm(
            data.get("First Name"),
            data.get("Last Name"),
            data.get("Email"),
            data.get("Phone"),
            data.get("Company"),
            data.get("Institution Type"),
            data.get("Job Role"),
            data.get("Department"),
            data.get("Needs"),
            data.get("Number of Learners"),
            data.get("Country")
        );

        logger.info("Filled contact form with provided data");
    }

    @And("I submit the form")
    public void i_submit_the_form() {
        contactUsPage.clickSubmit();
        logger.info("Submitted the contact form");
    }

    @Then("I should see an error message for the email field")
    public void i_should_see_an_error_message_for_the_email_field() {
        Assert.assertTrue(contactUsPage.isEmailErrorDisplayed(), "Email error message not displayed");
        logger.info("Email error message is displayed");
    }

    @And("I capture and display the error message")
    public void i_capture_and_display_the_error_message() {
        String errorMsg = contactUsPage.getEmailErrorMessage();
        System.out.println("Captured Email Error: " + errorMsg);
        logger.info("Captured Email Error: " + errorMsg);
    }
}
