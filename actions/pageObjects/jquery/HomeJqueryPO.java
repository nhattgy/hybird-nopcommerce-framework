package pageObjects.jquery;

import HomeJqueryUI.HomeJqueryUI;
import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeJqueryPO extends BasePage {
    private WebDriver driver;
    public HomeJqueryPO(WebDriver driver){
        this.driver = driver;
    }

    public void clickPaging(String numberPaging) {
        waitForElementClickable(driver, HomeJqueryUI.LINK_PAGING_NUMBER, numberPaging);
        clickToElement(driver, HomeJqueryUI.LINK_PAGING_NUMBER, numberPaging);
    }

    public boolean isActive(String numberPaging) {
        waitForElementVisible(driver, HomeJqueryUI.LINK_PAGING_NUMBER, numberPaging);
        String classValue = getAttributeValue(driver, HomeJqueryUI.LINK_PAGING_NUMBER, "class", numberPaging);
        return classValue.contains("active");
    }

    public void searchHomePage(String keyToSend,String nameSearch) {
        waitForElementVisible(driver, HomeJqueryUI.SEARCH_HOMEPAGE, nameSearch);
        sendKeyToElement(driver, HomeJqueryUI.SEARCH_HOMEPAGE,keyToSend, nameSearch);
        sendKeyboardToElement(driver, HomeJqueryUI.SEARCH_HOMEPAGE, Keys.ENTER, nameSearch);
    }

    public boolean isDisplayed(String females, String country, String males) {
        waitForElementVisible(driver, HomeJqueryUI.VERIFY_SEARCH, females, country, males);
        return isControlDisplayed(driver, HomeJqueryUI.VERIFY_SEARCH,  females, country, males);
    }

    public void removeResult(String nameRemove) {
        waitForElementClickable(driver,HomeJqueryUI.REMOVE_RESULT, nameRemove);
        clickToElement(driver, HomeJqueryUI.REMOVE_RESULT, nameRemove);
    }


    public void editHomePage(String nameEdit) {
        waitForElementClickable(driver, HomeJqueryUI.EDIT_RESULT, nameEdit);
        clickToElement(driver, HomeJqueryUI.EDIT_RESULT, nameEdit);
    }

    public boolean displeyIMG(String... restParameter) {
        waitForElementVisible(driver, HomeJqueryUI.IMAGE_DISPLAYED, restParameter);
        return isControlDisplayed(driver, HomeJqueryUI.IMAGE_DISPLAYED, restParameter);
    }

    public boolean displeyIMGLink(String... restParameter) {
        waitForElementVisible(driver, HomeJqueryUI.IMAGE_UPLOADED, restParameter);
        return isControlDisplayed(driver, HomeJqueryUI.IMAGE_UPLOADED, restParameter);
    }

    public void clickButtonStrart() {
        List<WebElement>buttonStart = getElements(driver, HomeJqueryUI.BUTTON_START);
        for (WebElement button:buttonStart){
            button.click();
            sleepInSeconds(2);
        }
    }
}
