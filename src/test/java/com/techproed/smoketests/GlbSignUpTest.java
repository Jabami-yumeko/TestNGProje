package com.techproed.smoketests;

import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class GlbSignUpTest {


    @Test
    public void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_login_url"));
        GlbSignUpPage elm = new GlbSignUpPage();

        elm.emailGiris.sendKeys(ConfigurationReader.getProperty("glb_email"));
        elm.nameGiris.sendKeys(ConfigurationReader.getProperty("glb_name"));
        elm.phoneGiris.sendKeys(ConfigurationReader.getProperty("glb_phone"));
        elm.passwordGiris.sendKeys(ConfigurationReader.getProperty("glb_sifre"));
        elm.repasswordGiris.sendKeys(ConfigurationReader.getProperty("glb_reSifre"));
        elm.signUpButonu.click();

        System.out.println(elm.SuccesYazisi.getText());

        boolean basariliMi = elm.SuccesYazisi.isDisplayed();
        Assert.assertTrue(basariliMi);
    }
    @AfterClass
    public void tearDown(){
        // Driver class'ının içerisindeki closeDriver methodunu çağırmamız yeterli.
        // Driver'ı kapattık ve hafızadan sildik.
        Driver.closeDriver();
    }
}
