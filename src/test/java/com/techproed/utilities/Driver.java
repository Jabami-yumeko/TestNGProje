package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // eger bir class tan nesne uretilmesini istemiyorsaniz
    // constructor i private yapabilirsiniz (Singleton class)
    private Driver(){

    }

    // WebDriver nesnemizi, static olarak olusturduk, cunku program baslar baslamaz
    // hafizada yer almasini istiyoruz
    static WebDriver driver;

    // Programin herhangi bir yerinden getDriver() methodu cagirilarak hafiza STATIC olarak olusturulmus
    // DRIVER nesnesine erisebiliriz. Yani yeniden WebDriver nesnesi olusturmak zorunda degiliz.
    // Driver.getDriver()

    public static WebDriver getDriver(){

        // Eger driver nesnesi hafizada bossa, olusturulmamissa yeniden olusturmaya gerek yok.
        // Eger null ise , yeniden olusturulabilir.

        // Sadece ilk cagirildiginda bir tane nesne uret, sonraki cagirmalarda var olan nesneyi kullan.
        if(driver == null) {

            switch (ConfigurationReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                case "headless-chrome": // Headless arayuzu gostermeden islemi arkada yapar
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }

        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;

    }
    public static void closeDriver(){

        // Eğer driver nesnesi NULL değilse, yani hafızada varsa
        if (driver != null){
            driver.quit();  // driver'ı kapat
            driver = null;  // driver'ı hafızadan temizle.
        }
    }


}
