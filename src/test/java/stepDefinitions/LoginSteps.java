package stepDefinitions;

import org.testng.Assert;
import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    @Given("the user is on the login page")
    public void user_on_login_page() {
        loginPage = new LoginPage(Hooks.driver); // use driver from Hooks
        loginPage.clickSignIn(); // click Sign In first
    }

    @When("the user enters {string} and {string}")
    public void enter_username_password(String username, String password) {
        loginPage.selectUsername(username);
        loginPage.selectPassword(password);
    }

    @And("clicks on the Sign In link")
    public void clicks_sign_in() {
        loginPage.clickLogin();
    }

    @Then("the user should be logged in successfully")
    public void verify_login() {
        Assert.assertTrue(loginPage.isOrdersVisible(), "Login failed! 'Orders' link not found.");
    }
}
