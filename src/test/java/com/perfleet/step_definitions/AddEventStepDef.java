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
import org.openqa.selenium.support.ui.Select;

import java.util.*;

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
        BrowserUtils.waitForClickablility(generalInformationPage.addEventButton, 4);
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
        new DashboardPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(addEventPage.saveButton, 5);
        Assert.assertTrue(addEventPage.saveButton.isDisplayed());
    }


    @When("Compulsory fields are shown as below:")
    public void compulsory_fields_are_shown_as_below(List<String> dataTable) {
        BrowserUtils.waitFor(3);
        Assert.assertEquals(dataTable, addEventPage.AllrequiredFields());
    }

    @When("fill the compulsory fields with valid values but leave title empty")
    public void fillTheCompulsoryFieldsWithValidValuesButLeaveTitleEmpty() {
        BrowserUtils.waitFor(3);
        addEventPage.organizerName.sendKeys("mnvr");

        //BrowserUtils.waitForClickablility(addEventPage.organizerEmail, 4);
        //addEventPage.organizerEmail.sendKeys("mnvr@gmail.com");

        //BrowserUtils.waitForClickablility(addEventPage.Start, 30);
        //addEventPage.Start.click();
       // addEventPage.today.click();

        //addEventPage.FirstTitle.sendKeys("");
       // BrowserUtils.waitFor(3);

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
        new DashboardPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(addEventPage.saveButton, 4);
        addEventPage.saveButton.click();
    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String string) {
        BrowserUtils.waitForClickablility(addEventPage.blankErrorMessage, 4);
        Assert.assertEquals(addEventPage.blankErrorMessage.getText(), "This value should not be blank.");
    }


    //ozlem

    @And("the user can mark the event with any color")
    public void theUserCanMarkTheEventWithAnyColor() {
        new DashboardPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(4);
        addEventPage.getColors("#5484ED").click();

    }

    @When("the user can mark {string} button")
    public void theUserCanMarkButton(String alldayevent) {
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        Assert.assertTrue(addEventPage.allDayEvent.isDisplayed());

    }


    @Then("Repeat option should includes the options below")
    public void repeatOptionShouldIncludesTheOptionsBelow(List<String> dataTable) {





        }


    @Then("Ends option should be as below")
    public void endsOptionShouldBeAsBelow(List<String> dataTable) {





        
    }

    @And("Ends options should be clickable")
    public void endsOptionsShouldBeClickable() {

        Assert.assertTrue(addEventPage.afterEndButton.isEnabled());
        Assert.assertTrue(addEventPage.byEndButton.isEnabled());
        Assert.assertTrue(addEventPage.neverEndButton.isEnabled());
    }

    @When("All Users can see all events in the General information page")
    public void allUsersCanSeeAllEventsInTheGeneralInformationPage() {
        List<String> list=BrowserUtils.getElementsText(addEventPage.addedEventList);
        String option = list.get(0).toString();
        System.out.println(option);
        String actual = "Calendar event added by John Doe\n" + "...\n" + "competition\n" + "Yesterday";
        Assert.assertEquals(option,actual);
    }
}