package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.languageLearningPage;

public class LanguageExtractionSteps {

    HomePage hp = new HomePage();
    languageLearningPage lp = new languageLearningPage();
    SoftAssert sf = new SoftAssert();

    private static Logger logger = LogManager.getLogger(LanguageExtractionSteps.class);

    @Given("user is in the homepage")
    public void user_is_in_the_homepage() {
        System.out.println("user is in the home page");
    }

    @When("user search click language learning")
    public void user_search_for() {
        logger.info("***** Click language learning *****");
        hp.clickLanguageLearning();
        lp.changeTab();
    }

    @Then("extract and print the available languages and level")
    public void extract_and_print_the_available_languages_and_count() {
        logger.info("***** Extracting languages and levels *****");
        lp.printLanguageAndLevel();
    }
}
