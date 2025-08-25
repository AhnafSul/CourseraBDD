package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
	private static WebDriver driver;
    public static WebDriver initializeDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver=new ChromeDriver();
            
        } else if (browser.equalsIgnoreCase("edge")) {
           // driver.set(new EdgeDriver());
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
    	if(getDriver() != null) {
    		getDriver().quit();
    	}
    }
}
