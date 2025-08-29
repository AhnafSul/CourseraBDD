package hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import stepdefinitions.LanguageExtractionSteps;

public class Hooks {
    static WebDriver driver;
    private static Logger logger = LogManager.getLogger(LanguageExtractionSteps.class);
 
    @Before	
    public void setUp() {
    	logger.info("***** Starting scenario *****");
        DriverFactory.initializeDriver();
    }
    @After
    public void tearDown() {
    	logger.info("***** Scenario finished *****");
        DriverFactory.quitDriver();
    }
}
