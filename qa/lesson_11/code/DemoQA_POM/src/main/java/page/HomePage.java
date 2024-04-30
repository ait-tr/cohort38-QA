package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(xpath = "//h5[.='Alerts, Frame & Windows']")
    WebElement alertFrameWindows;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public LeftPannel getAlertFrameWindows() {
        clickOnElement(alertFrameWindows);
        return new LeftPannel(driver, wait);
    }
}
