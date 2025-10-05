package pageObjects.admin;

import AdminPageUI.AdminDasboardPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AdminDasboardPagePO extends BasePage {
    private WebDriver driver;
    public AdminDasboardPagePO(WebDriver driver){
        this.driver = driver;
    }

    public void clickSidebarRight() {
        waitForElementClickable(driver, AdminDasboardPageUI.SIDEBAR_RIGHT);
        clickToElement(driver, AdminDasboardPageUI.SIDEBAR_RIGHT);
    }
}
