package page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    protected void fillInputField(WebElement element, String value) {
        WebElement elementType = waitForVisibilityElement(element);
        elementType.clear();
        elementType.sendKeys(value);
        Assertions.assertEquals(value, elementType.getAttribute("value"));
    }

    //Метод возвращает Веб Элемент для работы с ним по локатору
    protected WebElement getElement(WebElement elementr) {
        return waitForVisibilityElement(elementr);
    }

    //Метод делает клик по Веб Элемент с указанным локатором
    protected void clickOnElement(WebElement element) {
        waitForClickableElement(element).click();
    }

    //Метод ожидает что элемент станет видимым пользователю
    private WebElement waitForVisibilityElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Метод проверяет что элемент готов к клику.
    private WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Alert getAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;
    }

}
