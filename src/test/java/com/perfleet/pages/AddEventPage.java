package com.perfleet.pages;

import com.perfleet.utilities.BrowserUtils;
import com.perfleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddEventPage {
   public AddEventPage(){
       PageFactory.initElements(Driver.get(),this);}

    @FindBy(xpath = "//header/div[@id='main-menu']/ul[1]/li[2]/a[1]/span[1]")
    public WebElement fleetButton;

    @FindBy(xpath = "//*[text()='Vehicles']")
    public WebElement vehicleButton;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement title;

    @FindBy(xpath = "//*[.='Cars']")
    public WebElement cars;

    @FindBy(xpath = "//*[text()='John Johnson']")
    public WebElement driver;

    @FindBy(xpath = "//*[text()='General']")
    public WebElement general;

    @FindBy(xpath = "//span[@class='color empty-color']")
    public WebElement colorButton;

    @FindBy(xpath = "//label[@class='required']")
    public List<WebElement> Allrequired;

    @FindBy(xpath = "(//div[@class='controls']/input)[10]")
    public WebElement FirstTitle;

    @FindBy(xpath = "(//*[@id='s2id_oro_calendar_event_form_calendar']/a/span[1])[2]")
    public WebElement owner;

    @FindBy(xpath = "(//input[@type='text'])[7]")
    public WebElement organizerName;


    //@FindBy(xpath = "//*[@id=\"oro_calendar_event_form_organizerDisplayName-uid-6228ab8b8723a\"]")
    //public WebElement organizerName;

    @FindBy(xpath = "(//input[@type='email'])[2]")
    public WebElement organizerEmail;

    @FindBy(xpath = "(//input[@placeholder='Choose a date'])[3]")
    public WebElement Start;

    @FindBy(xpath = "(//input[@class='input-small datepicker-input end hasDatepicker'])[2]")
    public WebElement End;

    @FindBy(css = "[data-handler='today']")
    public WebElement today;


    //@FindBy(xpath = "(//span[@class='action-wrapper']/button)[4]")
    //public WebElement saveButton;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement saveButton;


    @FindBy(xpath = "//span[@class='validation-failed']/span/span")
    public WebElement blankErrorMessage;

    @FindBy(css = "[class='form form-horizontal']")
    public WebElement addEventPagee;

    @FindBy(css ="[id=ui-id-10]")
    public WebElement headerAddEvent;

    @FindBy(css = "[title='close']")
    public WebElement close;



    public List<String> AllrequiredFields(){
        List<WebElement> required = Allrequired;
        return BrowserUtils.getElementsText(required);
    }








}
