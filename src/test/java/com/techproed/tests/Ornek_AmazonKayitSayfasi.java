package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ornek_AmazonKayitSayfasi extends TestBase { // 6 - 09 - 2020 pazar

    @Test
    public void test1(){
        driver.get("http://amazon.com");

        WebElement element = driver.findElement(By.id("nav-link-accountList"));

        Actions actions = new Actions(driver);

        actions.moveToElement(element).perform();

        WebElement startHereLink = driver.findElement(By.partialLinkText("Start here."));
        startHereLink.click();

        String amazonTitle = driver.getTitle();
        Assert.assertEquals("Amazon Registration",amazonTitle);
    }

    @Test
    public void test2(){
        WebElement name = driver.findElement(By.id("ap_customer_name"));
        name.sendKeys("Alper");

        driver.findElement(By.id("ap_email")).sendKeys("blabla@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("ThisIsSparta");
        driver.findElement(By.id("ap_password_check")).sendKeys("ThisIsSparta");
        driver.findElement(By.id("continue")).click();
    }







}
