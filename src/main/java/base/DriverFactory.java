package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
    public static WebDriver initializeDriver(String browser) {
  
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("edge")) {
        	System.setProperty("webdriver.edge.driver","C:\\Users\\2400875\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe");
//        	WebDriverManager.edgedriver().setup();
        	driver.set(new EdgeDriver());
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }
        
        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
    	if(getDriver() != null) {
    		getDriver().quit();
    	}
    }
}
