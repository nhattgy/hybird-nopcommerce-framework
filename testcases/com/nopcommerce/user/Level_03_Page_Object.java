//package com.nopcommerce.user;
//
//import commons.BaseTest;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.time.Duration;
//
//public class Level_03_Page_Object extends BaseTest {
//    private WebDriver driver;
//    private String firstName, lastName, emailAddress, company, password;
//    HomePageObject homePage;
//    @BeforeClass
//    public void beforClass(){
//        driver = new ChromeDriver();
//        driver.get("https://demo.nopcommerce.com/");
//        homePage = new HomePageObject(driver);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        firstName = "john";
//        lastName = "Hn";
//        emailAddress = "john" + randomNumber() + "@gmail.com";
//        company = "Pany";
//        password = "123456";
//    }
//    @Test
//    public void TC_01_Register(){
//        homePage = new HomePageObject(driver);
//        homePage.clickToRegister();
//        RegisterPageObject registerPage;
//        registerPage = new RegisterPageObject(driver);
//        registerPage.clickGenderToMale();
//        registerPage.enterToFistName(firstName);
//        registerPage.enterToLastName(lastName);
//        registerPage.enterEmailAddress(emailAddress);
//        registerPage.enterCompanyName(company);
//        registerPage.enterPassword(password);
//        registerPage.enterConfirmPassword(password);
//        registerPage.clickToRegister();
//        Assert.assertEquals(registerPage.getTextSuccessfully(),"Your registration completed");
//        registerPage.clickToLogOut();
//    }
//    @Test
//    public void TC_02_Login(){
//        homePage.clickToLoginPage();
//        LoginPageObject loginPage;
//        loginPage = new LoginPageObject(driver);
//        loginPage.enterEmailAddress(emailAddress);
//        loginPage.enterPassword(password);
//        loginPage.clickToButtonLogin();
//        HomePageObject homePage = new HomePageObject(driver);
//        homePage.clickMyAccount();
//    }
//    @Test
//    public void TC_03_MyAccount(){
//        CustomerInfoPageObject customerInfoPage;
//        customerInfoPage = new CustomerInfoPageObject(driver);
//        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
//        Assert.assertEquals(customerInfoPage.getTextFirstNameValue(),firstName);
//        Assert.assertEquals(customerInfoPage.getTextLastNameValue(), lastName);
//        Assert.assertEquals(customerInfoPage.getTextEmailValue(),emailAddress);
//        Assert.assertEquals(customerInfoPage.getTextCompanyValue(),company);
//    }
//    @AfterClass
//    public void afterClass(){
//        driver.quit();
//    }
//}
