package stepdefinitions;

import base.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LanguageLearningPage;

public class LanguageExtractionSteps {

    private final HomePage hp = new HomePage();
    private final LanguageLearningPage lp = new LanguageLearningPage();

    @Given("user is in the homepage")
    public void user_is_in_the_homepage() {
        Log.info("***** user is in the home page *****");
    }

    @When("user search click language learning")
    public void user_search_for() {
    	Log.info("***** Click language learning *****");
        hp.clickLanguageLearning();
        lp.changeTab();
    }

    @Then("extract and print the available languages and level")
    public void extract_and_print_the_available_languages_and_count() {
    	Log.info("***** Extracting languages and levels *****");
        lp.printLanguageAndLevel();
    }
}
