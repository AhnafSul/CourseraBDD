package hooks;

import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import base.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    static WebDriver driver;
 
    @Before	
    public void setUp() {
    	Log.info("***** Starting scenario *****");
        DriverFactory.initializeDriver();
    }
    @After
    public void tearDown() {
    	Log.info("***** Scenario finished *****");
        DriverFactory.quitDriver();
    }
}
