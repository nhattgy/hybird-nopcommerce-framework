package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class User_01_Register_Login {
    WebDriver driver;
    @BeforeClass
    public void beforClass(){
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void TC_01_Regiser(){

    }
    @Test
    public void TC_02_Login(){

    }
    @AfterClass
    public void clear(){
        if (driver!=null){
            driver.quit();
        }
    }
}
