package hooks;

import base.DriverFactory;
import io.cucumber.java.Before;
import runners.TestRunner;
import io.cucumber.java.After;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    static WebDriver driver;
 
    @Before	
    public void setUp() {
        String browser = System.getProperty("browser","chrome");
        System.out.println("Launching browser: " + browser);
        DriverFactory.initializeDriver(browser);
        
//        if (browser == null) {
//            browser = "chrome"; // Default to chrome if the parameter is not set
//        }
        
    }
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
