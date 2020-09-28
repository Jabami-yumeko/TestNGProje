package com.techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class TestBaseCross {
    protected WebDriver driver;
    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional String browser){
        driver = DriverCross.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        DriverCross.closeDriver();
    }
}
