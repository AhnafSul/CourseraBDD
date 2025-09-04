package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static ThreadLocal<String> browsers = new ThreadLocal<>();
	public static Properties p;
	
	public static void setBrowser(String browser) {
		browsers.set(browser);
	}
	public static String getBrowser() {
		return browsers.get();
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
    public static void initializeDriver() {
			try {
				
				FileReader file = new FileReader("src/test/resources/config.properties");
				p = new Properties();
				p.load(file);	
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	
    	String browser = browsers.get();
    	System.out.println(browser);
    	
        if (browser.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("edge")) {
        	System.setProperty("webdriver.edge.driver",p.getProperty("driverPath"));
        	driver.set(new EdgeDriver());
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }
        getDriver().get(p.getProperty("appURL"));
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
    }


    public static void quitDriver() {
    	if(getDriver() != null) {
    		getDriver().quit();
    		driver.remove();
    	}
    }
}
