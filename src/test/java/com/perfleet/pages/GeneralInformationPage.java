package com.perfleet.pages;

import com.perfleet.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GeneralInformationPage extends BasePage {
    @FindBy(xpath = "//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-Driver']")
    public WebElement carRow;

    @FindBy(xpath = "//*[@id=\"container\"]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/h5")
    public WebElement genInfoText;

    @FindBy(xpath = "//a[@title='Edit Car']")
    public WebElement editButton;

    @FindBy(xpath = "//a[@title='Delete Car']")
    public WebElement deleteButton;

    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement addEventButton;

    @FindBy(xpath = "//tbody//tr[3]")
    public WebElement anyVehicle;

    @FindBy(xpath = "//*[@id=\"container\"]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/h5")
    public WebElement GenInfoText;

    @FindBy(css = "a[title='Delete Car']")
    public WebElement delete;

    }
