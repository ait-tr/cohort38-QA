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


    public LeftPannel(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public AlertsPage clickAlertsButton(){
        clickOnElement(alerts);
        return new AlertsPage(driver, wait);
    }
}
