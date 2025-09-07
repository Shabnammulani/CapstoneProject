package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features", // path to your feature files
    glue = "stepDefinitions",                  // package containing your step definition classes
    plugin = {"pretty", "html:target/cucumber-reports.html"}, // reports
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
