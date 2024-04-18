import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWTests {

    private WebDriver driver;
    private static final String URL = "https://ilcarro.web.app/search";

    @BeforeEach
    public void setDriver(){
        driver = new ChromeDriver();
    }

    @Test
    @Tag("@Test-1")
    @DisplayName("Проверка атрибута Web элемента на сайте ilcarro")
    void test1(){
        driver.navigate().to(URL);
        WebElement elementById = driver.findElement(By.id("0"));
        Assertions.assertEquals("navigation-link", elementById.getAttribute("class"), "Значение атрибута веб элемента не соответствует ожидаемому");
    }

    @Test
    @Tag("@Test-2")
    @DisplayName("Проверка атрибута Web элемента на сайте ilcarro")
    void test2(){
        driver.navigate().to(URL);
        WebElement elementById = driver.findElement(By.id("1"));
        Assertions.assertEquals(" Let the car work ", elementById.getAttribute("text"), "Значение атрибута веб элемента не соответствует ожидаемому");
    }

    @Test
    @Tag("@Test-3")
    @DisplayName("Проверка атрибута Web элемента на сайте ilcarro")
    void test3(){
        driver.navigate().to(URL);
        WebElement elementById = driver.findElement(By.id("2"));
        Assertions.assertEquals("terms-of-use", elementById.getAttribute("ng-reflect-router-link"), "Значение атрибута веб элемента не соответствует ожидаемому");
    }

    @AfterEach
    void afterVoid(){
        driver.quit();
    }
}
