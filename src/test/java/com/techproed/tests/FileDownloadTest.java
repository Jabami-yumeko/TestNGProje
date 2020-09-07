package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {

    @Test
    public void dosyaVarMi(){
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));

        String kullaniciDosyaYolu= System.getProperty("user.dir");

        String pomXmlDosyaYolu = kullaniciDosyaYolu +"/pom.xml";

        boolean varMi = Files.exists(Paths.get(pomXmlDosyaYolu));
        Assert.assertTrue(varMi);

    }

    @Test
    public void dosyaUpload(){
        // C:\Users\ASUS\Pictures\Saved Pictures\jabami.jpg
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        chooseFile.sendKeys("C:\\Users\\ASUS\\Pictures\\Saved Pictures\\jabami.jpg");

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement fileUploadedYazisi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedYazisi.isDisplayed());
    }

    @Test
    public void dosyadownload(){
        driver.get("http://the-internet.herokuapp.com/download");

        WebElement amsterdam = driver.findElement(By.partialLinkText("Amsterdam.jpg"));
        amsterdam.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean varMi = Files.exists(Paths.get("C:\\Users\\ASUS\\Downloads\\Amsterdam.jpg"));
        Assert.assertTrue(varMi);
    }
}
