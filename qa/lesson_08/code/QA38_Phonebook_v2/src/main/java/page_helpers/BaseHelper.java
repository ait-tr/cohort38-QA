package page_helpers;

import core.AppManager;
import core.TestProperties;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class BaseHelper {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private final Logger LOGGER = LoggerFactory.getLogger(BaseHelper.class);

    public BaseHelper(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Метод заполняет поля ввода по locator значением value
    public void fillInputField(By locator, String value) {
        LOGGER.info(String.format("Заполняем поле ввода с локатором %s значением %s", locator, value));
        WebElement element = waitForClickableElement(driver.findElement(locator));
        element.click();
        element.clear();
        element.sendKeys(value);
        Assertions.assertEquals(value, element.getAttribute("value"));
    }

    //Метод возвращает Веб Элемент для работы с ним по локатору
    public WebElement getElement(By locator) {
        return waitForVisibilityElement(driver.findElement(locator));
    }

    //Метод делает клик по Веб Элемент с указанным локатором
    public void clickOnElement(By locator) {
        LOGGER.info(String.format("Делаем click по элементу с локатором %s", locator));
        waitForClickableElement(driver.findElement(locator)).click();
    }

    //Метод возвращает всплывающее в браузере окно
    public Alert getAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;
    }

    //Метод ожидает что элемент станет видимым пользователю
    private WebElement waitForVisibilityElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Метод проверяет что элемент готов к клику.
    private WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //Проверяет наличие элемента по локатору
    public void checkElementIsDisplayed(By locator) {
        Assertions.assertTrue(getElement(locator).isDisplayed(), String.format("Ожидаемы елемент по %s локатору не найден", locator));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    //Ожидает указанное количество секунд
    public void waitInSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAlertText() {
        String alertText = getAlert().getText();
        getAlert().accept();
        return alertText;
    }

    public static String takeScreenshot() {
        File tmp = ((TakesScreenshot) AppManager.driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(String.format("screenshots/screen%s.png", System.currentTimeMillis()));
        try {
            Files.copy(tmp.toPath(), screenshot.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }
}
