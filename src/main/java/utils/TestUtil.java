package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {

    private WebDriver driver;
    private WebDriverWait wait;

    public TestUtil(WebDriver driver, Duration i) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, i);
    }

    // Click safely on an element
    public void safeClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    // Wait for visibility
    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Reusable method for react-select dropdowns
    public void selectReactDropdown(By containerLocator, String valueToSelect) {
        safeClick(containerLocator);
        WebElement input = waitForVisible(containerLocator)
                .findElement(By.cssSelector("input[id^='react-select']"));
        input.sendKeys(valueToSelect);
        input.sendKeys(Keys.ENTER);
    }

    // Send keys safely
    public void sendKeys(By locator, String text) {
        WebElement element = waitForVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Stable method for react-select dropdowns
    public void selectReactDropdownStable(By inputLocator, String valueToSelect) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(inputLocator));
        input.sendKeys(valueToSelect);
        input.sendKeys(Keys.ENTER);
    }

    // ✅ Pause for manual observation
    public void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
