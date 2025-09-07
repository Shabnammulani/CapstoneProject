package pages;

import org.openqa.selenium.By;

public class Locators {


    // Login page locators
    public static By signInBtn = By.id("signin");
    public static By usernameContainer = By.xpath("//div[contains(@class,'css-1hwfws3')][.//div[text()='Select Username']]");
    public static By passwordContainer = By.xpath("//div[contains(@class,'css-1hwfws3')][.//div[text()='Select Password']]");
    public static By loginBtn = By.cssSelector("button[type='submit']");
    public static By ordersLink = By.id("orders");
    public static By usernameInput = By.id("react-select-2-input");
    public static By passwordInput = By.id("react-select-3-input");

    // Product selection locators
    public static By appleCheckbox = By.xpath("//span[@class='checkmark' and text()='Apple']");
    public static By iPhone11ProAddBtn = By.xpath("//div[@id='6']//div[@class='shelf-item__buy-btn']");
    public static By sidebar = By.cssSelector(".float-cart.float-cart--open");
    public static By increaseQtyBtn = By.cssSelector(".float-cart.float-cart--open .shelf-item__price .change-product-button:nth-of-type(2)");
    public static By qtyText = By.xpath("//div[contains(@class,'float-cart__shelf-container')]//p[contains(text(),'Quantity: 2')]");

    // Close cart button
    public static By cartCloseBtn = By.cssSelector(".float-cart__close-btn");
    
    
    // Adding new product
    public static By iPhone12ProAddBtn = By.xpath("//div[@id='4']//div[@class='shelf-item__buy-btn']");
    public static By iPhone12ProQtyText = By.xpath("//div[contains(@class,'float-cart__shelf-container')]//p[contains(text(),'Quantity: 1')]");
    
    
    // Checkout locators
    public static By checkoutBtn = By.cssSelector("div.buy-btn");
    public static By orderSummary = By.xpath("//h3[text()='Order Summary']");

    // Address input locators
    public static By firstNameInput = By.id("firstNameInput");
    public static By lastNameInput = By.id("lastNameInput");
    public static By addressLine1Input = By.id("addressLine1Input");
    public static By provinceInput = By.id("provinceInput");
    public static By postCodeInput = By.id("postCodeInput");
    public static By submitAddressBtn = By.id("checkout-shipping-continue");
    public static By orderSuccessMsg = By.id("confirmation-message");

    // Receipt & navigation
    public static By downloadReceipt = By.id("downloadpdf");
    public static By continueShoppingBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");
    public static By ordersMenu = By.id("orders");
    
    // Favorite
    public static By logo = By.cssSelector("a.Navbar_logo__26S5Y");
    public static By iphoneXRFavouriteBtn = By.xpath("//p[@class='shelf-item__title' and text()='iPhone XR']/preceding-sibling::div[@class='shelf-stopper']/button");
    public static By favouritesLink = By.id("favourites");
    public static By favouriteProduct = By.xpath("//p[@class='shelf-item__title' and text()='iPhone XR']");




    // Logout
    public static By logoutBtn = By.xpath("//span[@id='signin' and text()='Logout']");
    public static By signInVisible = By.xpath("//span[@id='signin' and text()='Sign In']");
}
