package page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends BasePage {

    public BrowserWindowsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "tabButton")
    WebElement tabButton;
    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public BrowserWindowsPage switchToNextWindow(int index) {
        clickElement(tabButton);
        List<String> windows = new ArrayList<>(driver.getWindowHandles());//Получение списка всех окон в браузере
        driver.switchTo().window(windows.get(index));// переключение дравера на другое окно в браузере, по индексу
        return this;
    }

    public BrowserWindowsPage checkSampleHeadingInNewTab() {
        Assertions.assertEquals("This is a sample page",getElement(sampleHeading).getText(), "Переключение на новую вкладку не произошло");
        return this;
    }
}
