package HomeJqueryUI;

public class HomeJqueryUI {
    public static final String LINK_PAGING_NUMBER = "Xpath=//ul[@class = 'qgrd-pagination-ul']//a[text() = '%s']";
    public static final String SEARCH_HOMEPAGE = "Xpath=//div[@class='qgrd-header-text' and text() = '%s']/parent::div/following-siblininputg::";
    public static final String VERIFY_SEARCH = "Xpath=//td[@data-key = 'females' and text() = '%s']/following-sibling::td[@data-key = 'country' and text() = '%s']/following-sibling::td[@data-key = 'males' and text() = '%s']";
    public static final String REMOVE_RESULT = "Xpath=//td[@data-key = 'country' and text() = '%s']/preceding-sibling::td[@class = 'qgrd-actions']/button[@class='qgrd-remove-row-btn']";
    public static final String EDIT_RESULT = "Xpath=//td[@data-key = 'country' and text() = '%s']/preceding-sibling::td[@class = 'qgrd-actions']/button[@class= 'qgrd-edit-row-btn']";
    public static final String INPUT_UPLOAD = "css=input[type='file']";
    public static final String IMAGE_DISPLAYED = "xpath=//p[text() = '%s']";
    public static final String BUTTON_START = "xpath=//span[normalize-space(text())='Start']/ancestor::button";
    public static final String IMAGE_UPLOADED = "css=a[title = '%s']";

}
