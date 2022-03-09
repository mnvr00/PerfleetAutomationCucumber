package com.perfleet.step_definitions;

import com.perfleet.pages.LoginPage;
import com.perfleet.pages.LogoutPage;
import com.perfleet.utilities.BrowserUtils;
import com.perfleet.utilities.Driver;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class LogOutStepDef {

    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();

    @Given("{string} can log out by using log out button inside profile info and ends up in login page.")
    public void can_log_out_by_using_log_out_button_inside_profile_info_and_ends_up_in_login_page(String string) {
        loginPage.loginAsDriver();
        BrowserUtils.clickWithJS(loginPage.logOut);
        Assert.assertEquals(Driver.get().getTitle(),"Login");
    }

    @Given("The {string} can not go to the home page again by clicking the step back button after successfully logged out.")
    public void the_can_not_go_to_the_home_page_again_by_clicking_the_step_back_button_after_successfully_logged_out(String string) {

        loginPage.loginAsSalesManager();
        BrowserUtils.clickWithJS(loginPage.logOut);

        Actions actions = new Actions(Driver.get());
        actions.sendKeys(Keys.BACK_SPACE);

        Assert.assertNotEquals(Driver.get().getTitle(),"Dashboard");
    }

    @Given("The {string} must be logged out if the user close the tab \\(if there are multiple open tabs in the app, close all of them)")
    public void the_must_be_logged_out_if_the_user_close_the_tab_if_there_are_multiple_open_tabs_in_the_app_close_all_of_them(String string) {
         loginPage.loginAsDriver();
         String Newurl = Driver.get().getCurrentUrl();
         Driver.closeDriver();
         Driver.get().get(Newurl);
         Assert.assertNotEquals(Driver.get().getTitle(),"Dashboard");
    }

    @Given("The {string} must be logged out if the user is away from keyboard for three minutes")
    public void theMustBeLoggedOutIfTheUserIsAwayFromKeyboardForThreeMinutes(String arg0) {
        loginPage.loginStoreManager();
        BrowserUtils.waitFor(180);
        Assert.assertNotEquals(Driver.get().getTitle(),"Dashboard");
    }


}
