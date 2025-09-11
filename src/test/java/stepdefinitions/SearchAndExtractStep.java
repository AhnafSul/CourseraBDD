package stepdefinitions;
 
import base.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;
 
public class SearchAndExtractStep {
		
    private final HomePage hp = new HomePage();
    private final SearchPage sp = new SearchPage();
    
    	
    @Given("the user is in home page")
    public void the_user_is_in_home_page() {
    	Log.info("***** user is in the home page *****");
    }
 
    @When("the user searches for {string}")
    public void the_user_searches_for(String string) {
    	Log.info("***** Searching for "+string +" *****");
    	hp.searchBar(string);
    }
 
    @When("filters by Beginner level and English language")
    public void filters_by_beginner_level_and_english_language() {
    	Log.info("***** Filter the course based on language and levels *****");
    	sp.languageSorting();
        sp.levelSorting();
    }
 
    @Then("the system should extract the course name,total hours,rating for the first two courses")
    public void the_system_should_extract_the_course_name_total_hours_rating_for_the_first_two_courses() {
    	Log.info("***** Extracting course deatils *****");
    	sp.getCourseDetails();
        
    }
	
}
 
 