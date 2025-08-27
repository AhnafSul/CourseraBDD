package hooks;

import base.DriverFactory;
import io.cucumber.java.Before;
import runners.TestRunner;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class Hooks {
    WebDriver driver;
 
    @Before
    public void setUp() {
        String browser = TestRunner.getBrowserName();
        if (browser == null) {
            browser = "chrome"; // Default to chrome if the parameter is not set

        }
        System.out.println("Launching browser: " + browser);
        driver = DriverFactory.initializeDriver(browser);
    }
 
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
