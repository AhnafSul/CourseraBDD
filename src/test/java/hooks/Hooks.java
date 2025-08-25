package hooks;

import base.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class Hooks {
    WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome"); // default to chrome
        driver = DriverFactory.initializeDriver(browser);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
