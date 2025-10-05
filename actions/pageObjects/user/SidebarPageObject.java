package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerate;
import UserPageUIs.SidebarPageUI;

public class SidebarPageObject extends BasePage {
    private WebDriver driver;
    public SidebarPageObject(WebDriver driver){
        this.driver = driver;
    }
    public UserAddressesPO openPageAddresses() {
        waitForElementClickable(driver, SidebarPageUI.LINK_ADDRESS);
        clickToElement(driver, SidebarPageUI.LINK_ADDRESS);
        return PageGenerate.getAddressesPage(driver);
    }

    public UserOrderPO openPageOrders() {
        waitForElementClickable(driver, SidebarPageUI.LINK_ORDERS);
        clickToElement(driver, SidebarPageUI.LINK_ORDERS);
        return PageGenerate.getOrderPage(driver);
    }
    public UserRewardPointPO openPageReward() {
        waitForElementClickable(driver, SidebarPageUI.LINK_REWARD);
        clickToElement(driver, SidebarPageUI.LINK_REWARD);
        return PageGenerate.getRewardPage(driver);
    }
    public UserMyProductReviewPO openPageMyProductReview() {
        waitForElementClickable(driver, SidebarPageUI.LINK_MY_PRODUCT_REVIEW);
        clickToElement(driver, SidebarPageUI.LINK_MY_PRODUCT_REVIEW);
        return PageGenerate.getMyProductReview(driver);
    }

}
