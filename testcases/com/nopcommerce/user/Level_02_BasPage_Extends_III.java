package com.nopcommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasPage_Extends_III extends BasePage {
    WebDriver driver;
    WebDriverWait explicitwait;
    private String firstName, lastName, emailAddress, company, password;
  

    @BeforeClass
    public void beforClass() {
        driver = new ChromeDriver();
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
        waitForElementClickable(driver, "//a[@class = 'ico-register']");
        clickToElement(driver, "//a[@class = 'ico-register']");
        clickToElement(driver, "//input[@id='gender-male']");
        sendKeyToElement(driver, "//input[@id='FirstName']", firstName);
        sendKeyToElement(driver, "//input[@id='LastName']", lastName);
        sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
        sendKeyToElement(driver, "//input[@id='Company']", company);
        sendKeyToElement(driver, "//input[@id='Password']", password);
        sendKeyToElement(driver, "//input[@id='ConfirmPassword']", password);
        clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(getTextElement(driver, "//div[@class='result']"), "Your registration completed");
        clickToElement(driver, "//a[@class='ico-logout']");
    }

    @Test
    public void TC_02_Login() {
        waitForElementClickable(driver, "//a[@class='ico-login']");
        clickToElement(driver, "//a[@class='ico-login']");
        sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
        sendKeyToElement(driver, "//input[@id='Password']", password);
        clickToElement(driver, "//button[contains(@class, 'login-button')]");
    }

    @Test(priority = 3, dependsOnMethods = "TC_02_Login")
    public void TC03_MyAccount() {
        waitForElementClickable(driver, "//a[@class='ico-account']");
        clickToElement(driver, "//a[@class='ico-account']");
        Assert.assertTrue(isControlSelected(driver, "//input[@id='gender-male']"));
        Assert.assertEquals(getAttributeValue(driver, "//input[@id='FirstName']", "value"), firstName);
        Assert.assertEquals(getAttributeValue(driver, "//input[@id='LastName']", "value"), lastName);
        Assert.assertEquals(getAttributeValue(driver, "//input[@id='Email']", "value"), emailAddress);
        Assert.assertEquals(getAttributeValue(driver, "//input[@id='Company']", "value"), company);
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
