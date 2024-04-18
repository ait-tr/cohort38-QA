import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElementByTests extends BaseTest {

    @BeforeEach
    void start() {
        driver.get(URL_ILCARRO);
    }
    @Test
    public void findElementByTagName() {
        WebElement element = driver.findElement(By.tagName("h1"));
        Assertions.assertTrue(element.isDisplayed(), "Элемент не отображается на странице"); // проверка отображения элемента на странице
        //assertTrue - проверка, что ожидается true
        //element.isDisplayed() - метод, который проверяет, что элемент отображается на странице или нет

        WebElement element1 = driver.findElement(By.tagName("a"));
        Assertions.assertTrue(element1.isDisplayed(), "Элемент не отображается на странице");

        List<WebElement> elements = driver.findElements(By.tagName("a")); // findElements - возвращает список элементов
        Assertions.assertFalse(elements.isEmpty(), "Список элементов не отображается на странице");
    }

    @Test
    public void findElementByLocators() {
        //id
        WebElement element = driver.findElement(By.id("city"));
        Assertions.assertTrue(element.isDisplayed(), "Элемент по id не отображается на странице");
        //className
        WebElement element1 = driver.findElement(By.className("title"));
        Assertions.assertTrue(element1.isDisplayed(), "Элемент по ClassName не отображается на странице");
        //linkText
        WebElement element2 = driver.findElement(By.linkText("Let the car work"));
        Assertions.assertTrue(element2.isDisplayed(), "Элемент по LinkText не отображается на странице");
        //name
        WebElement element3 = driver.findElement(By.name("viewport"));
        Assertions.assertFalse(element3.isDisplayed(), "Элемент по Name отображается на странице");
    }

    @Test
    public void findElementByCssSelector() {
        //tag name = tag name
        // WebElement element = driver.findElement(By.tagName("h1"));
        WebElement element = driver.findElement(By.cssSelector("h1"));
        Assertions.assertTrue(element.isDisplayed(), "Элемент по css тэгу не отображается на странице");

        //id -> #id
        //WebElement element = driver.findElement(By.id("city"));
        WebElement element1 = driver.findElement(By.cssSelector("#city"));
        Assertions.assertTrue(element1.isDisplayed(), "Элемент по css id не отображается на странице");

        //class -> .class
        //WebElement element = driver.findElement(By.className("hide-div"));
        WebElement element2 = driver.findElement(By.cssSelector(".title"));
        Assertions.assertTrue(element2.isDisplayed(), "Элемент по css классу не отображается на странице");

        //name -> [name='name']
        WebElement element3 = driver.findElement(By.cssSelector("[for='city']"));
        Assertions.assertTrue(element3.isDisplayed(), "Элемент по css атрибуту не отображается на странице");

        //contains -> * [class='ng-untouched ng-pristine ng-invalid']
        WebElement element4 = driver.findElement(By.cssSelector("[class*='ng-pristine']"));
        Assertions.assertTrue(element4.isDisplayed(), "Элемент по css атрибуту не отображается на странице");

        //start -> ^ [class='ng-untouched ng-pristine ng-invalid']
        WebElement element5 = driver.findElement(By.cssSelector("[class^='ng-untouched']"));
        Assertions.assertTrue(element5.isDisplayed(), "Элемент по css атрибуту не отображается на странице");

        //end on -> $ [class='ng-untouched ng-pristine ng-invalid']
        WebElement element6 = driver.findElement(By.cssSelector("[class$='ng-invalid']"));
        Assertions.assertTrue(element6.isDisplayed(), "Элемент по css атрибуту не отображается на странице");
    }

    //xPath
    @Test
    public void findElementByXpath() {
        //    //form[@class="ng-untouched ng-pristine ng-invalid"]
        //    //form[contains(@class, 'ng-pristine')
        //    /html/body/app-root/app-navigator/app-search/div/div/form
    }
}