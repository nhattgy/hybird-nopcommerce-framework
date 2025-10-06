package pageObjects.noCommerce.user;

import org.openqa.selenium.WebDriver;
import noCommerce.UserPageUIs.CustomerInfoPageUI;

public class UserCustomerInfoPO extends UserSidebarPO {
    private WebDriver driver;

    public UserCustomerInfoPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isGenderMaleSelected() {
        waitForElementSelected(driver, CustomerInfoPageUI.GENDER_MALE);
        return isControlSelected(driver, CustomerInfoPageUI.GENDER_MALE);
    }

    public String getTextFirstNameValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
        return getAttributeValue(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getTextLastNameValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
        return getAttributeValue(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX, "value");
    }

    public String getTextEmailValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
        return getAttributeValue(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

    public String getTextCompanyValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
        return getAttributeValue(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, "value");
    }



}
