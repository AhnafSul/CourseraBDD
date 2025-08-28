package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

public class DriverFactory {
//	protected static WebDriver driver;
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	

//	public static WebDriver initializeDriver() {
//		
//		driver = new ChromeDriver();
//		driver.get("https://www.coursera.org/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
//		return driver;
//	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
//	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
    public static WebDriver initializeDriver(String browser) {
  
        if (browser.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("edge")) {
        	System.setProperty("webdriver.edge.driver","C:\\Users\\2400875\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe");
        	driver.set(new EdgeDriver());
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        return getDriver();
    }


    public static void quitDriver() {
    	if(getDriver() != null) {
    		getDriver().quit();
    	}
    }
}
