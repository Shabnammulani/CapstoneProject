package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;
import utils.TestUtil;

public class TestngLogin {

    WebDriver driver;
    public TestUtil util;

    public TestngLogin(WebDriver driver) {
        this.driver = driver;
        this.util = new TestUtil(driver, java.time.Duration.ofSeconds(10));
    }

    // Verifying the URL
    public boolean isCorrectUrl() {
        String expectedUrl = ConfigReader.get("baseUrl");  // fetch from config.properties
        String actualUrl = driver.getCurrentUrl();
        return actualUrl.equalsIgnoreCase(expectedUrl);
    }


    // Login actions
    public void clickSignIn() {
        util.safeClick(Locators.signInBtn);
    }

    public void selectUsername(String username) {
        util.selectReactDropdownStable(Locators.usernameInput, username);
    }

    public void selectPassword(String password) {
        util.selectReactDropdownStable(Locators.passwordInput, password);
    }

    public void clickLogin() {
        util.safeClick(Locators.loginBtn);
    }

    public boolean isOrdersVisible() {
        return util.waitForVisible(Locators.ordersLink).isDisplayed();
    }

    // Product actions
    public void selectApple() {
        try {
            util.safeClick(Locators.appleCheckbox);
        } catch (Exception e) {
            // fallback: use Actions or JS click
            new Actions(driver).moveToElement(util.waitForVisible(Locators.appleCheckbox)).click().perform();
        }
    }

    public void addiPhone11Pro() {
        util.safeClick(Locators.iPhone11ProAddBtn);
    }

    public void increaseQuantity() {
        // wait for sidebar to open
        util.waitForVisible(Locators.sidebar);
        util.safeClick(Locators.increaseQtyBtn);
    }

    public boolean verifyQuantityIncreased() {
        try {
            // find the quantity element in the sidebar
            WebElement qtyElement = driver.findElement(By.cssSelector(".float-cart__shelf-container .shelf-item__details p.desc"));
            // check if it contains "Quantity: 2"
            return qtyElement.getText().contains("Quantity: 3");
        } catch (Exception e) {
            return false;
        }
    }

    // Close cart
    
    public void closeCart() {
        util.safeClick(Locators.cartCloseBtn);
    }

    public boolean isOrdersVisible1() {
        return util.waitForVisible(Locators.ordersLink).isDisplayed();
    }
    
    // Adding new product
    
    public void addiPhone12Pro() {
        util.safeClick(Locators.iPhone12ProAddBtn);
    }

    public boolean verifyiPhone12ProQuantity(int expectedQty) {
        try {
            WebElement productContainer = driver.findElement(
                By.xpath("//div[contains(@class,'shelf-item')]//p[@class='title' and text()='iPhone 12 Pro']/..")
            );

            WebElement qtyElement = productContainer.findElement(By.xpath(".//p[@class='desc']"));
            return qtyElement.getText().contains("Quantity: " + expectedQty);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }




   // Checkout actions
    public void clickCheckout() {
        util.safeClick(Locators.checkoutBtn);
    }

    public boolean isOrderSummaryVisible() {
        return util.waitForVisible(Locators.orderSummary).isDisplayed();
    }

    public void enterAddress(String fname, String lname, String address, String province, String postal) {
        try {
            util.sendKeys(Locators.firstNameInput, fname);
            util.sendKeys(Locators.lastNameInput, lname);
            util.sendKeys(Locators.addressLine1Input, address);
            util.sendKeys(Locators.provinceInput, province);
            util.sendKeys(Locators.postCodeInput, postal);
            util.safeClick(Locators.submitAddressBtn);
        } catch (Exception e) {
            System.out.println("Negative test: address form not submitted.");
        }
    }

    public boolean isOrderPlaced() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
            WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("confirmation-message")));
            return confirm.isDisplayed() && confirm.getText().contains("successfully placed");
        } catch (Exception e) {
            return false;  // Order not placed
        }
    }




    // Receipt & continue shopping
    public void downloadReceipt() {
        util.safeClick(Locators.downloadReceipt);
    }

    public void continueShopping() {
        util.safeClick(Locators.continueShoppingBtn);
    }

    public boolean isOrdersMenuVisible() {
        return util.waitForVisible(Locators.ordersMenu).isDisplayed();
    }
    
    public void clickOrdersMenu() {
        util.safeClick(By.id("orders"));  // Or Locators.ordersMenu if already defined
    }

    // Check if order placed successfully
    public boolean ordercheck() {
        try {
            // Wait for the "Order placed" element to be visible
            return util.waitForVisible(By.xpath("//span[text()='Order placed']")).isDisplayed();
        } catch (Exception e) {
            return false; // Not found, order not placed
        }
    }
    

    // Adding items to your favorite
    
    public void clickLogo() {
        util.safeClick(Locators.logo);
    }

    public void clickFavouriteButton() {
        // wait for product title to ensure DOM loaded
        util.waitForVisible(By.xpath("//p[@class='shelf-item__title' and text()='iPhone XR']"));
        util.safeClick(Locators.iphoneXRFavouriteBtn);
    }

    public void clickFavouritesLink() {
        util.safeClick(Locators.favouritesLink);
    }

    public boolean isProductInFavourites(String productName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement product = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//p[@class='shelf-item__title' and text()='" + productName + "']")
                )
            );
            return product.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    
    // Logout
    
    public void logout() {
        try {
            util.safeClick(Locators.logoutBtn);
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    util.waitForVisible(Locators.logoutBtn));
        }
    }

    public boolean isSignInVisible() {
        return util.waitForVisible(Locators.signInVisible).isDisplayed();
    }
}
