package runners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefinitions","hooks"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Parameters("browser")
    @BeforeClass
    public void setBrowser(@Optional("chrome")String browser) {
    	System.setProperty("browser",browser);
    }
}

