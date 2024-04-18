import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected static final String URL_LITECART = "http://95.140.153.145/litecart";
    protected static final String URL_LITECART_ADMIN = "http://95.140.153.145/litecart/admin";
    protected static final String URL_PHONEBOOK = "https://telranedu.web.app/";
    protected static final String URL_ILCARRO = "https://ilcarro.web.app/search";

    @BeforeEach // эта аннотация - указание, что метод выполниться перед каждым тестом
//    @BeforeAll // эта аннотация - указание, что метод выполниться перед всеми тестами
    public void startDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // разворачивает окно на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // неявное ожидание 10 секунд на загрузку элементов
    }

    @AfterEach // эта аннатация - указание, что метод выполниться после каждого теста
    void afterVoid() {
        driver.quit();
    }
}
