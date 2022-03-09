package com.perfleet.step_definitions;

import com.perfleet.pages.LoginPage;
import com.perfleet.utilities.BrowserUtils;
import com.perfleet.utilities.ConfigurationReader;
import com.perfleet.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class LoginnStepDef {
    LoginPage loginPage = new LoginPage();



    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Then("the user enter {string} and {string}")
    public void the_user_enter_and(String Validusername, String Validpassword) {
       loginPage.login(Validusername, Validpassword);
    }

    @Then("{string} should land on the {string} page after successful login")
    public void should_land_on_the_page_after_successful_login(String driver, String expectedTitle) {
        if (driver.equals("user5")) {
            Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));
        }
    }

    @Then("{string} or {string} should land on the {string} page after successful login")
    public void or_should_land_on_the_page_after_successful_login(String salesmanager, String storemanager, String expectedTitle) {
        if (salesmanager.equals("salesmanager101") || storemanager.equals("storemanager85")) {
            Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));
        }
    }

    @Given("copy the url after log in then log out paste the same url to browser and try to skip authentication step")
    public void copy_the_url_after_log_in_then_log_out_paste_the_same_url_to_browser_and_try_to_skip_authentication_step() {
        loginPage.loginAsDriver();
        String actualUrl = Driver.get().getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);
        BrowserUtils.clickWithJS(loginPage.logOut);
        Driver.get().get(actualUrl);
        Assert.assertFalse(Driver.get().getTitle().contains("Quick Launchpad"));

    }

    @Then("the user enters invalid credentials {string} and {string} and after {string} message should be displayed for invalid credentials")
    public void theUserEntersInvalidCredentialsAndAndAfterMessageShouldBeDisplayedForInvalidCredentials(String invalidUsername, String invalidPassword, String error) {
        loginPage.login(invalidUsername,invalidUsername);
        String actual = loginPage.invalidError.getText();
        Assert.assertEquals("Invalid user name or password.",actual);

    }

    @Then("the user enters blank credentials {string} and {string} and  {string} message should be displayed for any empty field")
    public void theUserEntersBlankCredentialsAndAndMessageShouldBeDisplayedForAnyEmptyField(String blankUsername, String blankPassword, String blankMessage) {
            loginPage.login(blankUsername,blankPassword);
            blankMessage = loginPage.passwordBox.getAttribute("validationMessage");
            Assert.assertEquals("Please fill in this field.", blankMessage);

        }
    @Given("Users should see their password in bullet signs while typing")
    public void usersShouldSeeTheirPasswordInBulletSignsWhileTyping() {
        Assert.assertTrue(loginPage.passwordBox.getAttribute("type").equals("password"));
    }

    @Then("User lands on the ‘Forgot Password’ page after clicking on the {string} link")
    public void userLandsOnTheForgotPasswordPageAfterClickingOnTheLink(String arg0) {

        loginPage.forgotPassword.click();
        BrowserUtils.waitFor(3);
        Assert.assertTrue(Driver.get().getTitle().contains("Forgot Password"));
        Driver.get().navigate().back();

    }

    @Then("Users can change their password with the username after clicking on {string} link")
    public void usersCanChangeTheirPasswordWithTheUsernameAfterClickingOnLink(String arg0) {
        loginPage.forgotPassword.click();
        BrowserUtils.waitFor(3);
        loginPage.forgotPasswordInputBox.sendKeys("user5");
        BrowserUtils.waitFor(3);
        loginPage.request.click();
        BrowserUtils.waitFor(3);
        Assert.assertFalse(loginPage.unableError.isDisplayed());

    }
    @Given("User can see {string} link on the login page and it should be clickable")
    public void userCanSeeLinkOnTheLoginPageAndItShouldBeClickable(String arg0) {
        Assert.assertTrue(loginPage.rememberMe.isDisplayed());
        Assert.assertTrue(loginPage.rememberMe.isEnabled());
    }


    @Given("User can use {string} key from their keyboard on the login page after entering username and password")
    public void userCanUseKeyFromTheirKeyboardOnTheLoginPageAfterEnteringUsernameAndPassword(String arg0) {
        Actions actions= new Actions(Driver.get());

        loginPage.usernameBox.sendKeys("user5");
        actions.sendKeys(Keys.ENTER);
        BrowserUtils.waitFor(2);

        loginPage.passwordBox.sendKeys("UserUser123");
        loginPage.passwordBox.sendKeys(Keys.ENTER);

        Assert.assertTrue(loginPage.fleet.isDisplayed());
    }


    @Given("drivers can see own username in profile menu, after successful login")
    public void driversCanSeeOwnUsernameInProfileMenuAfterSuccessfulLogin() {
        loginPage.loginAsDriver();
        Assert.assertEquals(loginPage.name.getText(),"user5");
    }

    @Given("sales manager can see own username in profile menu, after successful login")
    public void salesManagerCanSeeOwnUsernameInProfileMenuAfterSuccessfulLogin() {
        loginPage.loginAsSalesManager();
        Assert.assertEquals(loginPage.name.getText(),"salesmanager101");

    }

    @Given("store manager can see own username in profile menu, after successful login")
    public void storeManagerCanSeeOwnUsernameInProfileMenuAfterSuccessfulLogin() {
        loginPage.loginStoreManager();
        Assert.assertEquals(loginPage.name.getText(),"storemanager85");
    }


}

