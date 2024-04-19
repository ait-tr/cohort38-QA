import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeWorkTests extends BaseTest{

    @BeforeEach
    void start(){
        driver.get(URL_HW);
    }

    @Test
    public void findElementByCssSelector(){
        WebElement element = driver.findElement(By.cssSelector(".footer"));
        Assertions.assertTrue(element.isDisplayed(), "Элемент по css классу не отображается на странице");

        WebElement element1 = driver.findElement(By.cssSelector(".master-wrapper-page"));
        Assertions.assertTrue(element1.isDisplayed(), "Элемент по css классу не отображается на странице");

        WebElement element2 = driver.findElement(By.cssSelector("h2"));
        Assertions.assertTrue(element2.isDisplayed(), "Элемент по css классу не отображается на странице");

        WebElement element3 = driver.findElement(By.cssSelector("h3"));
        Assertions.assertTrue(element3.isDisplayed(), "Элемент по css классу не отображается на странице");

        WebElement element4 = driver.findElement(By.cssSelector("[alt='Picture of Simple Computer']"));
        Assertions.assertTrue(element4.isDisplayed(), "Элемент по css классу не отображается на странице");

        WebElement element5 = driver.findElement(By.cssSelector("[alt='Tricentis Demo Web Shop']"));
        Assertions.assertTrue(element5.isDisplayed(), "Элемент по css классу не отображается на странице");

        WebElement element6 = driver.findElement(By.cssSelector("[class*='header-links-wrapper']"));
        Assertions.assertTrue(element6.isDisplayed(), "Элемент по css классу не отображается на странице");

        WebElement element7 = driver.findElement(By.cssSelector("[class^='search']"));
        Assertions.assertTrue(element7.isDisplayed(), "Элемент по css классу не отображается на странице");

        WebElement element8 = driver.findElement(By.cssSelector("[class$='menu']"));
        Assertions.assertTrue(element8.isDisplayed(), "Элемент по css классу не отображается на странице");

        WebElement element9 = driver.findElement(By.cssSelector("#small-searchterms"));
        Assertions.assertTrue(element9.isDisplayed(), "Элемент по css классу не отображается на странице");
    }
}
