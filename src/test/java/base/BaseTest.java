package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import utils.ConfigReader;
import utils.DriverFactory;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        DriverFactory.initDriver();        // ✅ registers driver
        driver = DriverFactory.getDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        String baseUrl = ConfigReader.get("baseUrl");
        driver.get(baseUrl);
    }

    @AfterClass(alwaysRun = true)
    public void tearDownSuite() {
        DriverFactory.quitDriver();        
    }
}
