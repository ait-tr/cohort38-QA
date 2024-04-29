package page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //Метод заполняет поля ввода по locator значением value
    public void fillInputField(WebElement e, String value) {
        LOGGER.info(String.format("Заполняем поле ввода с локатором %s значением %s", e.toString(), value));
        WebElement element = waitForClickableElement(e);
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
    public void clickOnElement(WebElement element) {
        LOGGER.info(String.format("Делаем click по элементу с локатором %s", element.toString()));
        waitForClickableElement(element).click();
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

    public boolean isElementPresent(List<WebElement> elements) {
        return elements.size() > 0;
    }

    //Ожидает указанное количество секунд
    public void waitInSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
