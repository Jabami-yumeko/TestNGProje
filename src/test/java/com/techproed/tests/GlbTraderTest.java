package com.techproed.tests;

import com.techproed.pages.GlbTraderPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbTraderTest extends TestBaseFinal {


    @Test
    public void glbTraderArama(){

        extentTest = extentReports.createTest("Glb Trader Arama ve karsilastirma", "Glb Trader sayfasinda camera aradik ve karsilastirdik");

        extentTest.info("Glb Trader sitesine gidiyoruz");
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_search"));

        extentTest.info("Nesne olusturuyoruz");
        GlbTraderPage glbTraderPage=new GlbTraderPage();

        extentTest.info("Select nesnesi uretelim");
        Select select=new Select(glbTraderPage.kategorilerDropDown);
        select.selectByIndex(6);

        extentTest.info("Kelimeyi giriyoruz");
        glbTraderPage.aramaKutusu.sendKeys(ConfigurationReader.getProperty("glb_kelime")+ Keys.ENTER);

        extentTest.info("2. siradaki urunun ismini aldik");
        String urunIsmi = glbTraderPage.sonuclarList.get(1).getText();

        extentTest.info("2. siradaki urune tikladik");
        glbTraderPage.sonuclarList.get(1).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String sayfaBasligi = Driver.getDriver().getTitle();

        extentTest.info("Assert işlemi yapalım.");
        Assert.assertEquals(urunIsmi , sayfaBasligi);
        extentTest.pass("Testimiz PASSED !");

    }

}
