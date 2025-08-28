package stepdefinitions;

import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.languageLearningPage;

public class LanguageExtractionSteps{
	
	HomePage hp = new HomePage();
	languageLearningPage lp = new languageLearningPage();
	
	@Given("user is in the homepage")
	public void user_is_in_the_homepage() {
	System.out.println("user is in the home page");
	}

	@When("user search click language learning")
	public void user_search_for() {
	    hp.clickLanguageLearning();
	    lp.changeTab();
	}

	@Then("extract and print the available languages and count")
	public void extract_and_print_the_available_languages_and_count() {
		lp.printLanguage();
	}

	@Then("extract and print the available levels and count")
	public void extract_and_print_the_available_levels_and_count() {
		lp.printLevel();
	}
}
