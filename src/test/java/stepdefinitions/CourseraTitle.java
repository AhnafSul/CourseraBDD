package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CourseraTitle {

    WebDriver driver;

    @Given("the user navigates to the Coursera homepage")
    public void navigateToCoursera() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.coursera.org/");
    }

    @Then("the page title should be {string}")
    public void verifyTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.quit();
    }
}
