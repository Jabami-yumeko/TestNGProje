package com.techproed.tests;

import com.techproed.pages.AmazonNewPage;
import com.techproed.utilities.Driver;
import com.techproed.utilities.JSExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecuterTest {

    @Test
    public void amazonArama() throws InterruptedException {
        Driver.getDriver().get("http://amazon.com");

        String baslik = JSExecutor.getTitleByJS();
        System.out.println(baslik);

        AmazonNewPage amazonNewPage =new AmazonNewPage();
        amazonNewPage.aramaKutusu.sendKeys("Samsung");

        // JS ile bir WebElement e tikliyoruz
        JSExecutor.clickElementByJS(amazonNewPage.aramaButonu);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        JSExecutor.scrollDownByJS();

        Thread.sleep(2000);

        // JS ile sayfadaki istedigimiz webelement in oldugu yere gidiyoruz
        WebElement colors = Driver.getDriver()
                .findElement(By.xpath("//span[.='Phone Color']"));
        JSExecutor.scrollInToViewJS(colors);

        // JS ile bir webelement in arkaplanini renklendiriyoruz
        JSExecutor.flash(colors);

        WebElement condition = Driver.getDriver()
                .findElement(By.xpath("//*[.='Condition']"));

        // JS ile bir webelementin arkaplan rengini degistirebiliyoruz..

        JSExecutor.changeColor("rgb(255, 56, 56)", condition);

        // JS ile isterseniz websayfasina JSAlert uretebiliyorsunuz..

        JSExecutor.generateAlert("Test BITTI ! ");

    }
}
