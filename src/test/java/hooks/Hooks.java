package hooks;

import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    static WebDriver driver;
 
    @Before	
    public void setUp() {
        DriverFactory.initializeDriver();
    }
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
