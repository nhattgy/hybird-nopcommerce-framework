package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerate;
import UserPageUIs.HomePageUI;

public class UserHomePO extends BasePage {
    private WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegisterPO clickToRegister() {
        waitForElementClickable(driver, HomePageUI.BUTTON_REGISTER_LINK);
        clickToElement(driver, HomePageUI.BUTTON_REGISTER_LINK);
        return PageGenerate.getRegisterPage(driver);
    }

    public UserLoginPO clickToLoginPage() {
        waitForElementClickable(driver, HomePageUI.BUTTON_LOGIN_LINK);
        clickToElement(driver, HomePageUI.BUTTON_LOGIN_LINK);
        return PageGenerate.getLoginPage(driver);
    }

    public UserCustomerInfoPO clickMyAccount() {
        waitForElementClickable(driver, HomePageUI.BUTTON_MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.BUTTON_MY_ACCOUNT_LINK);
        return PageGenerate.getCustomerInfoPage(driver);
    }
}
