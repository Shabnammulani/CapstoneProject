package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.TestUtil;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    TestUtil util;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.util = new TestUtil(driver, Duration.ofSeconds(10));
    }

    By signInBtn = By.id("signin");
    By usernameContainer = By.xpath("//div[contains(@class,'css-1hwfws3')][.//div[text()='Select Username']]");
    By passwordContainer = By.xpath("//div[contains(@class,'css-1hwfws3')][.//div[text()='Select Password']]");
    By loginBtn = By.cssSelector("button[type='submit']");
    By ordersLink = By.id("orders");

    public void clickSignIn() {
        util.safeClick(signInBtn);
    }

    public void selectUsername(String username) {
        util.selectReactDropdown(usernameContainer, username);
    }

    public void selectPassword(String password) {
        util.selectReactDropdown(passwordContainer, password);
    }

    public void clickLogin() {
        util.safeClick(loginBtn);
    }

    public boolean isOrdersVisible() {
        return util.waitForVisible(ordersLink).isDisplayed();
    }
}
