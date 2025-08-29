package stepdefinitions;
 
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;
 
public class SearchAndExtractStep {
		
    WebDriver driver;
    HomePage hp = new HomePage();
    SearchPage sp = new SearchPage();
    private static Logger logger = LogManager.getLogger(HomePage.class);
    SoftAssert sa = new SoftAssert();
    
    
    @Given("the user is in home page")
    public void the_user_is_in_home_page() {
    	logger.info("***** user is in the home page *****");
        System.out.println("the user is in home page");
    }
 
    @When("the user searches for {string}")
    public void the_user_searches_for(String string) {
    	logger.info("***** Search for 'Web development' *****");
    	hp.searchBar("web development course");
    }
 
    @When("filters by Beginner level and English language")
    public void filters_by_beginner_level_and_english_language() {
    	logger.info("***** Filter the course based on language and levels *****");
    	sp.languageSorting();
        sp.levelSorting();
    }
 
    @Then("the system should extract the course name,total hours,rating for the first two courses")
    public void the_system_should_extract_the_course_name_total_hours_rating_for_the_first_two_courses() {
    	logger.info("***** Extracting course deatils *****");
    	List<String> details1 = sp.getCourseDetails();
        for(String entry:details1) {
        	System.out.println(entry);
        }
        sa.assertTrue(details1.size()>0);
        
    }
 
 
 
 
	
	
}
 
 