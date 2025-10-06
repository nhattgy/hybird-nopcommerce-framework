package pageObjects.noCommerce.admin;

import noCommerce.AdminPageUI.AdminLoginPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AdminLoginPagePO extends BasePage {
    private WebDriver driver;
    public AdminLoginPagePO(WebDriver driver){
        this.driver = driver;
    }

    public void enterUserName(String username) {
        waitForElementVisible(driver, AdminLoginPageUI.INPUT_EMAIL);
        sendKeyToElement(driver, AdminLoginPageUI.INPUT_EMAIL, username);
    }

    public void enterPassword(String password) {
        waitForElementVisible(driver, AdminLoginPageUI.INPUT_PASSWORD);
        sendKeyToElement(driver, AdminLoginPageUI.INPUT_PASSWORD, password);

    }

    public void clickButtonLogin() {
        waitForElementClickable(driver, AdminLoginPageUI.BUTTON_LOGIN);
        clickToElement(driver, AdminLoginPageUI.BUTTON_LOGIN);
    }
}
