package pageObjects.noCommerce.user;

import org.openqa.selenium.WebDriver;

public class UserMyProductReviewPO extends UserSidebarPO {
    private WebDriver driver;
    public UserMyProductReviewPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

}
