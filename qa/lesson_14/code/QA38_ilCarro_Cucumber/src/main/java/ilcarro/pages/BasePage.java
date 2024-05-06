package ilcarro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    public static WebDriverWait wait;

    private String url = "https://ilcarro.web.app/";

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public BasePage openBrowserInPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return this;
    }

    public BasePage openUrl() {
        driver.get(url);
        return this;
    }

    public BasePage closeBrowser() {
        driver.quit();
        return this;
    }

    protected void fillInputField(WebElement element, String value) {
        WebElement elementType = waitForVisibilityElement(element);
        elementType.clear();
        elementType.sendKeys(value);
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
}
