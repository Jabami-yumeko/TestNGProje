package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

    // bos bir tane driver degiskeni olusturduk
    WebDriver driver;

    public GooglePage(WebDriver driver){
        // parametre olarak gelen driver nesnesini, bu class da olusturudugumuz
        //9. satirdaki driver nesnesine esitledik. Bu sekilde yeniden bos bir driver olusturmak yerine
        // zaten halihazirda kullandigimiz driver i bu nesneye esitlemis olduk
        this.driver = driver;

        // birazdan bulacagimiz webelement leri hazir hale getirdik
        PageFactory.initElements(driver, this);
    }
    @FindBy ( name = "q" )
    public WebElement aramaKutusu;  // findElement

}
