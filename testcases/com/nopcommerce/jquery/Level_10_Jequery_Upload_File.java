package com.nopcommerce.jquery;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomeJqueryPO;
import pageObjects.jquery.PageGenerate;

public class Level_10_Jequery_Upload_File extends BaseTest {
    private WebDriver driver;
    private HomeJqueryPO homeJquery;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getMultipleBrowser(browserName, url);
        homeJquery = PageGenerate.getHomeJquery(driver);
        tokyo1 = "tokyo1.jpg";
        tokyo2 ="tokyo2.jpg";
        tokyo3 ="tokyo3.jpg";
    }

    @Test
    public void TC_04_Remove()  {
        homeJquery.uploadMultipleFiles(driver, "tokyo1.jpg","tokyo2.jpg");
        homeJquery.sleepInSeconds(2);
        Assert.assertTrue(homeJquery.displeyIMG("tokyo1.jpg","tokyo2.jpg"));
        homeJquery.clickButtonStrart();
        homeJquery.sleepInSeconds(3);
        Assert.assertTrue(homeJquery.displeyIMGLink("tokyo1.jpg","tokyo2.jpg"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    private String tokyo1, tokyo2, tokyo3;
}
