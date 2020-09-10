package com.techproed.tests;

import com.techproed.pages.AmazonPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class AmazonTest extends TestBase {

    @Test
    public void aramaTest(){

        driver.get("https://www.amazon.com/");

        // AmazonPage in icerisindeki bulmus oldugumuz WebElement i kullanabilmek icin
        // Amazon

        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.aramaKutusu.sendKeys("Baby Stroller");

    }
}
