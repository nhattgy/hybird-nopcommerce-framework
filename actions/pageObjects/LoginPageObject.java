package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmailAddress(String emailTextbox) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX_LOGIN);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX_LOGIN, emailTextbox);
    }

    public void enterPassword(String passwordTextbox) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX_LOGIN);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX_LOGIN, passwordTextbox);
    }

    public void clickToButtonLogin() {
        waitForElementClickable(driver, LoginPageUI.BUTTON_LOGIN);
        clickToElement(driver, LoginPageUI.BUTTON_LOGIN);
    }
}
