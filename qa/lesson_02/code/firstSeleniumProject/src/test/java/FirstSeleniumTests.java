import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTests {

    private WebDriver driver;
    private static final String URL_CART = "http://95.140.153.145/litecart";
    private static final String URL_ADMIN = "http://95.140.153.145/litecart/admin";

    @BeforeEach // эта аннотация - указание, что метод выполниться перед каждым тестом
//    @BeforeAll // эта аннотация - указание, что метод выполниться перед всеми тестами
    public void startDriver(){
        driver = new ChromeDriver();
    }

    @Test //Самая главная аннотация, которая указывает что данный метод является тестом
    @Tag("@Test-1") //  нужна для отдельного или группового запуска по тэгу
    @DisplayName("Проверка заголовка страницы магазина")// В данной аннотации мы задаем имя для отображения при запуске
    void testOpenLiteCart(){
//        driver.get(URL_CART); // без истории
        driver.navigate().to(URL_CART);//переход к странице по УРЛс историей
        driver.navigate().back(); //  назад
        driver.navigate().forward();// вперед
        driver.navigate().refresh();  // обновить
        Assertions.assertEquals("Online Store | My Store", driver.getTitle(), "Открылась страница с другим title");
    }

    @Test
    @Disabled // исключает тест из запуска
    @Tag("@Test-2")
    @DisplayName("Проверка заголовка страницы администратора магазина")
    void testOpenAdminLiteCart(){
        driver.navigate().to(URL_ADMIN);
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        Assertions.assertEquals("My Store", driver.getTitle(), "Заголовок страницы не соответствует ожидаемому");
    }

    @Test
    @Tag("@Test-3")
    @DisplayName("Проверка атрибута Web элемента на сайте ilcarro")
    void testCssSelectors(){
        driver.navigate().to("https://ilcarro.web.app/search");
        WebElement elementById = driver.findElement(By.id("city"));

        Assertions.assertEquals("city", elementById.getAttribute("formcontrolname"), "Значение атрибута веб элемента не соответствует ожидаемому");
    }

    @AfterEach // эта аннотация - указание, что метод выполниться после каждого теста
//    @AfterAll // эта аннотация - указание, что метод выполниться после всех тестов
    void afterVoid() {
        driver.quit();
    }

}
