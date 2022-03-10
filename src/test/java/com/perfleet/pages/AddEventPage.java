package com.perfleet.pages;

import com.perfleet.utilities.BrowserUtils;
import com.perfleet.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddEventPage {
   public AddEventPage(){
       PageFactory.initElements(Driver.get(),this);}


    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement title;


    @FindBy(xpath = "//input[@data-ftid='oro_calendar_event_form_allDay']")
    public WebElement allDayEvent;

    @FindBy(xpath = "//input[@data-name='recurrence-repeat']")
    public WebElement repeatsButton;

    @FindBy(xpath = "//*[text()='John Johnson']")
    public WebElement driver;

    @FindBy(xpath = "//span[@class='color']")
    public List<WebElement> colorButton;



    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement neverEndButton;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement afterEndButton;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement byEndButton;

    @FindBy(xpath = "//div[@class='list-item']")
    public List<WebElement> addedEventList;

    @FindBy(xpath = "//label[@class='required']")
    public List<WebElement> Allrequired;

    @FindBy(xpath = "(//div[@class='controls']/input)[10]")
    public WebElement FirstTitle;

    @FindBy(xpath = "(//*[@id='s2id_oro_calendar_event_form_calendar']/a/span[1])[2]")
    public WebElement owner;

    @FindBy(xpath = "(//input[@type='text'])[7]")
    public WebElement organizerName;

    @FindBy(xpath = "//*[@id=\"oro_calendar_event_form_organizerEmail-uid-622934118e2f6\"]")
    public WebElement organizerEmail;

    @FindBy(xpath = "(//input[@placeholder='Choose a date'])[3]")
    public WebElement Start;

    @FindBy(xpath = "(//input[@class='input-small datepicker-input end hasDatepicker'])[2]")
    public WebElement End;

    @FindBy(css = "[data-handler='today']")
    public WebElement today;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[@class='validation-failed']/span/span")
    public WebElement blankErrorMessage;

    @FindBy(css = "[class='form form-horizontal']")
    public WebElement addEventPagee;

    @FindBy(xpath = "//*[@id=\"ui-id-2\"]")
    public WebElement headerAddEvent;

    @FindBy(css = "[title='close']")
    public WebElement close;

    @FindBy(xpath = "(//label[@data-required='1'])[3]")
    public WebElement addEventTitle;


    @FindBy(css = "div[class='controls recurrence-subview-control recurrence-subview-control__items']>div")
    public List<WebElement> repeatEnds;


 @FindBy(css = "[id^='recurrence-repeat-view']")
 public WebElement repeatCheckbox;
 @FindBy(css = "[id^='recurrence-repeats-view']")
 public WebElement repeatDropdown;

    public List<String> AllrequiredFields(){
        List<WebElement> required = Allrequired;
        return BrowserUtils.getElementsText(required);
    }

    public WebElement getColors(String colorType){
         WebElement color=null;
          for (int i = 0; i <colorButton.size() ; i++) {
            if(colorButton.get(i).getAttribute("title").equalsIgnoreCase("colorTitle")){
             color=colorButton.get(i);
            }

               }
              return  color;
             }


 public WebElement getColor(int num){
  return Driver.get().findElement(By.xpath("//span[@class='color']["+num+"]"));
 }


}
