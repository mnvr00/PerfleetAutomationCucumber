package com.perfleet.step_definitions;

import com.perfleet.pages.AddEventPage;
import com.perfleet.pages.DashboardPage;
import com.perfleet.pages.GeneralInformationPage;
import com.perfleet.pages.LoginPage;
import com.perfleet.utilities.BrowserUtils;
import com.perfleet.utilities.ConfigurationReader;
import com.perfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddEventStepDef {

    AddEventPage addEventPage = new AddEventPage();
    GeneralInformationPage generalInformationPage = new GeneralInformationPage();
    LoginPage loginPage = new LoginPage();

    @Given("the user is logged in as {string}")
    public void the_user_is_logged_in_as(String user) {
        String username = null;
        String password = null;

        if (user.contains("driver")) {
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        } else if (user.contains("sales")) {
            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
        } else if (user.contains("store")) {
            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
        }

        loginPage.login(username, password);
    }

    @Given("go to from {string} to {string} module")
    public void go_to_from_to_module(String string, String string2) {
        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.waitUntilLoaderScreenDisappear();

        try {
            WebElement closeBtn = Driver.get().findElement(By.cssSelector("button[title='close']"));
            closeBtn.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

        dashboardPage.navigateToModule("Fleet", "Vehicles");

//        try {
//            WebElement closeBtn = Driver.get().findElement(By.cssSelector("button[title='close']"));
//            if (closeBtn.isDisplayed()) {
//                closeBtn.click();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

    @When("clicking on any vehicle")
    public void clicking_on_any_vehicle() {
        new DashboardPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(generalInformationPage.carRow, 4);
        generalInformationPage.carRow.click();
    }

    @Then("User can access the {string} page")
    public void user_can_access_the_page(String string) {
        Assert.assertTrue(generalInformationPage.addEventButton.isDisplayed());
    }

    @Then("{string} or {string} can see {string} button")
    public void or_can_see_button(String string, String string2, String string3) {
        Assert.assertTrue(generalInformationPage.addEventButton.isDisplayed());
    }

    @Then("{string} or {string} can click {string} button")
    public void or_can_click_button(String string, String string2, String string3) {
        Assert.assertTrue(generalInformationPage.addEventButton.isEnabled());
    }

    @Then("{string} can NOT see {string} button")
    public void can_NOT_see_button(String string, String string2) {
        Assert.assertFalse(generalInformationPage.addEventButton.isDisplayed());
    }

    @And("clicking on {string} button")
    public void clickingOnButton(String arg0) {
        new DashboardPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(generalInformationPage.addEventButton, 5);
        generalInformationPage.addEventButton.click();
    }

    @Then("{string} page should pop up.")
    public void page_should_pop_up(String string) {
        Assert.assertTrue(addEventPage.addEventPagee.isDisplayed());
    }

    @And("user logout")
    public void user_logout() {
        LoginPage loginPage = new LoginPage();
        BrowserUtils.clickWithJS(loginPage.logOut);
    }

    @When("add event page still appear there")
    public void add_event_page_still_appear_there() {
        Assert.assertFalse(addEventPage.addEventPagee.isDisplayed());
    }

    @When("Compulsory fields are shown as below:")
    public void compulsory_fields_are_shown_as_below(List<String> dataTable) {
        Assert.assertEquals(dataTable, addEventPage.AllrequiredFields());
    }

    @When("fill the compulsory fields with valid values but leave title empty")
    public void fillTheCompulsoryFieldsWithValidValuesButLeaveTitleEmpty() {
        BrowserUtils.waitFor(3);
        addEventPage.organizerName.sendKeys("mnvr");
        addEventPage.organizerEmail.sendKeys("mnvr@gmail.com");
        addEventPage.Start.click();
        addEventPage.today.click();
        addEventPage.FirstTitle.sendKeys("");
        BrowserUtils.waitFor(3);

    }

    @When("fill the compulsory fields with valid values but leave email empty")
    public void fillTheCompulsoryFieldsWithValidValuesButLeaveEmailEmpty() {

        addEventPage.FirstTitle.sendKeys("competition");
        addEventPage.organizerName.sendKeys("mnvr");
        addEventPage.organizerEmail.sendKeys("");
        addEventPage.Start.click();
        addEventPage.today.click();
        BrowserUtils.waitFor(3);
    }

    @When("click the save button")
    public void click_the_save_button() {
        BrowserUtils.waitFor(3);
        addEventPage.saveButton.click();
    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String string) {
        Assert.assertEquals(addEventPage.blankErrorMessage.getText(), "This value should not be blank.");
    }

}