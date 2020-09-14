package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignUpPage {

    public GlbSignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (id = "email")
    public WebElement emailGiris;
    @FindBy (name = "name")
    public WebElement nameGiris;
    @FindBy (id = "mobile")
    public WebElement phoneGiris;
    @FindBy (id = "password")
    public WebElement passwordGiris;
    @FindBy (id = "re_password")
    public WebElement repasswordGiris;
    @FindBy (name = "submit")
    public WebElement signUpButonu;
    @FindBy (xpath = "//div[@class='alert alert-success']")
    public WebElement SuccesYazisi;
}
