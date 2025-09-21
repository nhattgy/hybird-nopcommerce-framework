package com.nopcommerce.user;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_InitBasPage_I {
    WebDriver driver;
    WebDriverWait explicitwait;
    private String firstName, lastName, emailAddress, company, password;
    BasePage basePage;

    @BeforeClass
    public void beforClass() {
        driver = new ChromeDriver();
        basePage = new BasePage();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        firstName = "john";
        lastName = "Hn";
        emailAddress = "john" + randomNumber() + "@gmail.com";
        company = "Pany";
        password = "123456";
        explicitwait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void TC_01_Register() {
        basePage.waitForElementClickable(driver, "//a[@class = 'ico-register']");
        basePage.clickToElement(driver, "//a[@class = 'ico-register']");
        basePage.clickToElement(driver, "//input[@id='gender-male']");
        basePage.sendKeyToElement(driver, "//input[@id='FirstName']", firstName);
        basePage.sendKeyToElement(driver, "//input[@id='LastName']", lastName);
        basePage.sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
        basePage.sendKeyToElement(driver, "//input[@id='Company']", company);
        basePage.sendKeyToElement(driver, "//input[@id='Password']", password);
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", password);
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getTextElement(driver, "//div[@class='result']"), "Your registration completed");
        basePage.clickToElement(driver, "//a[@class='ico-logout']");
    }

    @Test
    public void TC_02_Login() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-login']");
        basePage.clickToElement(driver, "//a[@class='ico-login']");
        basePage.sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
        basePage.sendKeyToElement(driver, "//input[@id='Password']", password);
        basePage.clickToElement(driver, "//button[contains(@class, 'login-button')]");
    }

    @Test(priority = 3, dependsOnMethods = "TC_02_Login")
    public void TC03_MyAccount() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-account']");
        basePage.clickToElement(driver, "//a[@class='ico-account']");
        Assert.assertTrue(basePage.isControlSelected(driver, "//input[@id='gender-male']"));
        Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='FirstName']", "value"), firstName);
        Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='LastName']", "value"), lastName);
        Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='Email']", "value"), emailAddress);
        Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='Company']", "value"), company);
    }

    @AfterClass
    public void clear() {
        if (driver != null) {
            driver.quit();
        }
    }

    public int randomNumber() {
        return new Random().nextInt(9999);
    }
}
