package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.BaseDriver;

@CucumberOptions(
        plugin = {
                "html:target/cucumber-report",
                "com.cucumber.listener.ExtentCucumberFormatter:target/extent_report/index.html" // extent report plugin
        },
        features = {
                "src/test/java/featureFiles/_day24_01_login.feature"
        },
        glue = {"steps"} // tell cucumber where to look for step definitions
)
public class LoginTestRunner extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Starting suite!");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Ending suite!");
        BaseDriver.quitDriver();
    }
}
