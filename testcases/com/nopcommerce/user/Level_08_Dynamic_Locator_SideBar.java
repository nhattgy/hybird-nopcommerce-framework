package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.noCommerce.PageGenerate;
import pageObjects.noCommerce.user.*;

import java.time.Duration;

public class Level_08_Dynamic_Locator_SideBar extends BaseTest {
    private WebDriver driver;
    private String firstName, lastName, emailAddress, company, password;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserAddressesPO addressesPage;
    private UserMyProductReviewPO myProductReviewPage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getMultipleBrowser(browserName,url);
        homePage = PageGenerate.getHomePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        firstName = "john";
        lastName = "Hn";
        emailAddress = "john" + randomNumber() + "@gmail.com";
        company = "Pany";
        password = "123456";
    }

    @Test
    public void TC_01_Register() {
        registerPage = homePage.clickToRegister();
        registerPage.clickGenderToMale();
        registerPage.enterToFistName(firstName);
        registerPage.enterToLastName(lastName);
        registerPage.enterEmailAddress(emailAddress);
        registerPage.enterCompanyName(company);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.clickToRegister();
        Assert.assertEquals(registerPage.getTextSuccessfully(), "Your registration completed");
        registerPage.clickToLogOut();
    }

    @Test
    public void TC_02_Login() {
        loginPage = homePage.clickToLoginPage();
        loginPage.enterEmailAddress(emailAddress);
        loginPage.enterPassword(password);
        loginPage.clickToButtonLogin();
    }

    @Test
    public void TC_03_MyAccount() {
        customerInfoPage = homePage.clickMyAccount();
        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getTextFirstNameValue(), firstName);
        Assert.assertEquals(customerInfoPage.getTextLastNameValue(), lastName);
        Assert.assertEquals(customerInfoPage.getTextEmailValue(), emailAddress);
        Assert.assertEquals(customerInfoPage.getTextCompanyValue(), company);
    }

    @Test
    public void TC_04_SwitchPageObject() {
        customerInfoPage = PageGenerate.getCustomerInfoPage(driver);
        customerInfoPage.openMenuSideBar("Addresses");
        addressesPage = PageGenerate.getAddressesPage(driver);
        addressesPage.openMenuSideBar("Orders");
        orderPage = PageGenerate.getOrderPage(driver);
        addressesPage.openMenuSideBar("Reward points");
        rewardPointPage = PageGenerate.getRewardPage(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
