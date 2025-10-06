package pageObjects.noCommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import noCommerce.UserPageUIs.RegisterPageUI;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickGenderToMale() {
        waitForElementClickable(driver, RegisterPageUI.CLICK_RADIO_BUTTON_MALE);
        clickToElement(driver, RegisterPageUI.CLICK_RADIO_BUTTON_MALE);
    }

    public void enterToFistName(String firstnameInput) {
        waitForElementVisible(driver, RegisterPageUI.TEXTBOX_FIRSTNAME);
        sendKeyToElement(driver, RegisterPageUI.TEXTBOX_FIRSTNAME, firstnameInput);
    }

    public void enterToLastName(String lastnameInput) {
        waitForElementVisible(driver, RegisterPageUI.TEXTBOX_LASTNAME);
        sendKeyToElement(driver, RegisterPageUI.TEXTBOX_LASTNAME, lastnameInput);
    }

    public void enterEmailAddress(String emailAddressInput) {
        waitForElementVisible(driver, RegisterPageUI.TEXTBOX_EMAIL);
        sendKeyToElement(driver, RegisterPageUI.TEXTBOX_EMAIL, emailAddressInput);
    }

    public void enterCompanyName(String companyNameInput) {
        waitForElementVisible(driver, RegisterPageUI.TEXTBOX_COMPANY);
        sendKeyToElement(driver, RegisterPageUI.TEXTBOX_COMPANY, companyNameInput);
    }

    public void enterPassword(String password) {
        waitForElementVisible(driver, RegisterPageUI.TEXTBOX_PASSWORD);
        sendKeyToElement(driver, RegisterPageUI.TEXTBOX_PASSWORD, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD);
        sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD, confirmPassword);
    }

    public void clickToRegister() {
        waitForElementClickable(driver, RegisterPageUI.BUTTON_REGISTER);
        clickToElement(driver, RegisterPageUI.BUTTON_REGISTER);
    }

    public String getTextSuccessfully() {
        waitForElementVisible(driver, RegisterPageUI.TEXT_SUCCESSFULLY_REGISTER);
        return getTextElement(driver, RegisterPageUI.TEXT_SUCCESSFULLY_REGISTER);
    }

    public void clickToLogOut() {
        waitForElementClickable(driver, RegisterPageUI.BUTTON_LOGOUT_LINK);
        clickToElement(driver, RegisterPageUI.BUTTON_LOGOUT_LINK);
    }
}
