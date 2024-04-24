package page_helpers;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseHelper {

    WebDriver driver;
    WebDriverWait wait;

    public BaseHelper(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Метод заполняет поля ввода по locator значением value
    public void fillInputField(By locator, String value) {
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
}
