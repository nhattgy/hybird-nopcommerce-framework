package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerate;
import pageObjects.admin.AdminDasboardPagePO;
import pageObjects.admin.AdminLoginPagePO;
import pageObjects.user.*;

import java.time.Duration;

public class Level_07_Switch_Role_Admin_User extends BaseTest {
    private WebDriver driver;

    private String urlUser, urlAdmin;
    @Parameters({"browser", "userUrl","adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String urlUser, String urlAdmin) {
        this.urlUser = urlUser;
        this.urlAdmin = urlAdmin;
        driver = getMultipleBrowser(browserName);
        homePage = PageGenerate.getHomePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        firstName = "john";
        lastName = "Hn";
        emailAddress = "john" + randomNumber() + "@gmail.com";
        company = "Pany";
        password = "123456";
        adminusername = "admin@yourstore.com";
        adminpassword = "admin";
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
    public void TC_04_SwitchAdmin() {
        customerInfoPage.openPageUrl(driver, urlAdmin);
        adminLoginPage = PageGenerate.getAdminLoginPage(driver);
        adminLoginPage.enterUserName(adminusername);
        adminLoginPage.enterPassword(adminpassword);
        adminLoginPage.clickButtonLogin();
        adminDasboardPage = PageGenerate.getAdminDasboardPage(driver);
        //activity
        adminDasboardPage.clickSidebarRight();
    }
    @Test
    public void TC_05_SwitchUser() throws InterruptedException {
        adminDasboardPage.openPageUrl(driver, urlUser);
        homePage = PageGenerate.getHomePage(driver);
        Thread.sleep(3000);
    }
    @Test
    public void TC_06_SwitchAdmin() throws InterruptedException {
        homePage.openPageUrl(driver, urlAdmin);
        adminDasboardPage = PageGenerate.getAdminDasboardPage(driver);
        Thread.sleep(3000);
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private String firstName, lastName, emailAddress, company, password, adminusername, adminpassword;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserAddressesPO addressesPage;
    private UserMyProductReviewPO myProductReviewPage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;
    private AdminLoginPagePO adminLoginPage;
    private AdminDasboardPagePO adminDasboardPage;
}
