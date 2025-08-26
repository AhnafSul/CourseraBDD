package runners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefinitions", "hooks"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
	private static ThreadLocal<String> browserName =new ThreadLocal<>();
	
	
    @Parameters("browser")
    @BeforeClass
    public void setBrowser(String browser) {
        browserName.set(browser);
    }
    
    public static String getBrowserName() {
    	return browserName.get();
    }
}
