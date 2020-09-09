package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ornek_HotelOlusturma extends TestBase {

    // http://www.fhctrip-qa.com/admin/HotelAdmin/Create
    //a. Username : manager2
    //b. Password : Man1ager2!

    @BeforeMethod
    public void girisTest(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);

    }
    @Test
    public void hotelCreate(){ //IDGroup
        driver.findElement(By.id("Code")).sendKeys("#2000");
        driver.findElement(By.id("Name")).sendKeys("Alper");
        driver.findElement(By.id("Address")).sendKeys("Belgium");
        driver.findElement(By.id("Phone")).sendKeys("123456");
        driver.findElement(By.id("Email")).sendKeys("alpereneskar@gmail.com");


        WebElement IDGroup = driver.findElement(By.id("IDGroup"));
        Select select = new Select(IDGroup);
        select.selectByIndex(1);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement selectButonu =driver.findElement(By.id("btnSubmit"));
        selectButonu.click();

       // WebElement basariliYazisi = driver.findElement(By.className("bootbox-body"));

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement basariliYazisi = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className("bootbox-body")));

        Assert.assertTrue(basariliYazisi.isDisplayed());




    }



}
