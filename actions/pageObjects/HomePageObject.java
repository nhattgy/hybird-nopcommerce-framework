package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPageObject clickToRegister() {
        waitForElementClickable(driver, HomePageUI.BUTTON_REGISTER_LINK);
        clickToElement(driver, HomePageUI.BUTTON_REGISTER_LINK);
        return PageGenerate.getRegisterPage(driver);
    }

    public LoginPageObject clickToLoginPage() {
        waitForElementClickable(driver, HomePageUI.BUTTON_LOGIN_LINK);
        clickToElement(driver, HomePageUI.BUTTON_LOGIN_LINK);
        return PageGenerate.getLoginPage(driver);
    }

    public CustomerInfoPageObject clickMyAccount() {
        waitForElementClickable(driver, HomePageUI.BUTTON_MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.BUTTON_MY_ACCOUNT_LINK);
        return PageGenerate.getCustomerInfoPage(driver);
    }
}
