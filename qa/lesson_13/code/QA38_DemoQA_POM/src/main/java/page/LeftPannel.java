package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeftPannel extends BasePage {

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;
    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;
    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppable;
    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;

    @FindBy(xpath = "//span[.='Upload and Download']")
    WebElement uploadAndDownload;

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brokenLinksImages;


    public LeftPannel(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public AlertsPage clickAlertsButton() {
        clickOnElement(alerts);
        return new AlertsPage(driver, wait);
    }

    public BrokenLinksImagesPage clickBrokenLinksImages() {
        clickOnElement(brokenLinksImages);
        return new BrokenLinksImagesPage(driver, wait);
    }

    public UploadAndDownloadPage clickUploadAndDownload() {
        clickOnElement(uploadAndDownload);
        return new UploadAndDownloadPage(driver, wait);
    }

    public BrowserWindowsPage clickBrowserWindows() {
        clickElement(browserWindows);
        return new BrowserWindowsPage(driver, wait);
    }

    public SelectMenuPage clickSelectMenu() {
        clickElement(selectMenu);
        return new SelectMenuPage(driver, wait);
    }

    public DroppablePage clickDroppable() {
        scrollPage();
        clickElement(droppable);
        return new DroppablePage(driver, wait);
    }

    public DroppablePage clickPracticeForm() {
        scrollPage();
        clickElement(practiceForm);
        return new DroppablePage(driver, wait);
    }
}
