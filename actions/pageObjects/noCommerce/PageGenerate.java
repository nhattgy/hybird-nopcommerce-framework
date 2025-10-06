package pageObjects.noCommerce;

import org.openqa.selenium.WebDriver;
import pageObjects.noCommerce.admin.AdminDasboardPagePO;
import pageObjects.noCommerce.admin.AdminLoginPagePO;
import pageObjects.noCommerce.user.*;

public class PageGenerate {
    public static UserHomePO getHomePage(WebDriver driver) {
        return new UserHomePO(driver);
    }

    public static UserLoginPO getLoginPage(WebDriver driver) {
        return new UserLoginPO(driver);
    }

    public static UserRegisterPO getRegisterPage(WebDriver driver) {
        return new UserRegisterPO(driver);
    }

    public static UserCustomerInfoPO getCustomerInfoPage(WebDriver driver) {
        return new UserCustomerInfoPO(driver);
    }
    public static UserAddressesPO getAddressesPage(WebDriver driver){
        return new UserAddressesPO(driver);
    }
    public static UserMyProductReviewPO getMyProductReview(WebDriver driver){
        return new UserMyProductReviewPO(driver);
    }
    public static UserOrderPO getOrderPage(WebDriver driver){
        return new UserOrderPO(driver);
    }
    public static UserRewardPointPO getRewardPage(WebDriver driver){
        return new UserRewardPointPO(driver);
    }
    public static AdminLoginPagePO getAdminLoginPage(WebDriver driver){
        return new  AdminLoginPagePO(driver);
    }
    public static AdminDasboardPagePO getAdminDasboardPage(WebDriver driver){
        return new  AdminDasboardPagePO(driver);
    }
}
