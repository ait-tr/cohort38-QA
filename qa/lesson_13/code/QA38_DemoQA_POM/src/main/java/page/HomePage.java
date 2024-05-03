package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(xpath = "//h5[.='Alerts, Frame & Windows']")
    WebElement alertFrameWindows;
    @FindBy(xpath = "//h5[.='Widgets']")
    WebElement widgets;
    @FindBy(xpath = "//h5[.='Interactions']")
    WebElement interactions;
    @FindBy(xpath = "//h5[.='Forms']")
    WebElement forms;

    @FindBy(xpath = "//h5[.='Elements']")
    WebElement elements;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public LeftPannel getAlertFrameWindows() {
        scrollPage();
        clickElement(alertFrameWindows);
        return new LeftPannel(driver, wait);
    }

    public LeftPannel getElements() {
        scrollPage();
        clickElement(elements);
        return new LeftPannel(driver, wait);
    }

    public LeftPannel getWidgets() {
        scrollPage();
        clickElement(widgets);
        return new LeftPannel(driver, wait);
    }

    public LeftPannel getInteractions() {
        scrollPage();
        clickElement(interactions);
        return new LeftPannel(driver, wait);
    }

    public LeftPannel getForms() {
        scrollPage();
        clickElement(forms);
        return new LeftPannel(driver, wait);
    }
}
