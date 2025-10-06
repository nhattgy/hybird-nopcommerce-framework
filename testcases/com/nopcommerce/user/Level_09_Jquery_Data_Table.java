package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomeJqueryPO;
import pageObjects.jquery.PageGenerate;

public class Level_09_Jquery_Data_Table extends BaseTest {
    private WebDriver driver;
    private HomeJqueryPO homeJquery;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getMultipleBrowser(browserName, url);
        homeJquery = PageGenerate.getHomeJquery(driver);
    }

    @Test
    public void TC_01_Paging() {
        homeJquery.clickPaging("12");
        Assert.assertTrue(homeJquery.isActive("12"));
        homeJquery.clickPaging("15");
        Assert.assertTrue(homeJquery.isActive("15"));
        homeJquery.clickPaging("24");
        Assert.assertTrue(homeJquery.isActive("24"));
        homeJquery.refresh(driver);
    }

    @Test
    public void TC_02_Search() {
        homeJquery.searchHomePage("Aruba", "Country");
        Assert.assertTrue(homeJquery.isDisplayed("750", "Aruba", "756"));
        homeJquery.refresh(driver);
        homeJquery.searchHomePage("939", "Females");
        homeJquery.refresh(driver);
        homeJquery.searchHomePage("1755", "Total");
        homeJquery.refresh(driver);
    }

    @Test
    public void TC_03_Edit() throws InterruptedException {
        homeJquery.searchHomePage("Aruba", "Country");
        homeJquery.removeResult("Aruba");
        Thread.sleep(3000);
    }

    @Test
    public void TC_04_SwitchPageObject() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
