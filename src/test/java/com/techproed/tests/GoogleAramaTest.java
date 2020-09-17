package com.techproed.tests;

import com.techproed.pages.GoogleAramaPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleAramaTest  extends TestBaseFinal {



    @Test
    public void aramaTesti() throws InterruptedException {
        extentTest  = extentReports.createTest("Google Arama",
                "Google'da techproeducation araması yaptık.");

        extentTest.info("sayfa adresine git.");
        Driver.getDriver().get(ConfigurationReader.getProperty("google_link"));

        extentTest.info("Webelementleri kullanabilmek icin nesne olustur");
        GoogleAramaPage googleAramaPage = new GoogleAramaPage();

        extentTest.info("techproeducation aramasi yap");
        googleAramaPage.aramaKutusu.sendKeys("techproeducation" + Keys.ENTER);

        extentTest.info("3 saniye bekle");
        Thread.sleep(3000);

        extentTest.info("tum linkleri karsilastir");
        boolean linkVarMi = false;
        for (WebElement w : googleAramaPage.tumLinkler){
            if (w.getText().contains("techproeducation11111.com")){
                linkVarMi = true;
                break;
            }}
        extentTest.info("assert islemi yap");
        Assert.assertTrue(linkVarMi);
        extentTest.pass("Testimiz PASS");
    }

}
