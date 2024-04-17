import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondSeleniumTest {

    private WebDriver webDriver;

    @BeforeEach
    void start(){
        webDriver = new ChromeDriver();
    }

    @AfterEach
    void finish(){
        webDriver.quit();
    }

    @Test
    void test1() {
        webDriver.navigate().to("http://95.140.153.145/litecart/admin");
        Assertions.assertEquals("My Store", webDriver.getTitle(), "Заголовок не соответствует ожидаемому");
    }

    @Test
    void test2() {
        webDriver.navigate().to("http://95.140.153.145/litecart/admin");
        Assertions.assertEquals("My Store", webDriver.getTitle(), "Заголовок не соответствует ожидаемому");
    }
    @Test
    void test3() {
        webDriver.navigate().to("http://95.140.153.145/litecart/admin");
        Assertions.assertEquals("My Store", webDriver.getTitle(), "Заголовок не соответствует ожидаемому");
    }

    @Test
    void test4() {
        webDriver.navigate().to("http://95.140.153.145/litecart/admin");
        Assertions.assertEquals("My Store", webDriver.getTitle(), "Заголовок не соответствует ожидаемому");
    }
    @Test
    void test5() {
        webDriver.navigate().to("http://95.140.153.145/litecart/admin");
        Assertions.assertEquals("My Store", webDriver.getTitle(), "Заголовок не соответствует ожидаемому");
    }

    @Test
    void test6() {
        webDriver.navigate().to("http://95.140.153.145/litecart/admin");
        Assertions.assertEquals("My Store", webDriver.getTitle(), "Заголовок не соответствует ожидаемому");
    }
    @Test
    void test7() {
        webDriver.navigate().to("http://95.140.153.145/litecart/admin");
        Assertions.assertEquals("My Store", webDriver.getTitle(), "Заголовок не соответствует ожидаемому");
    }

    @Test
    void test8() {
        webDriver.navigate().to("http://95.140.153.145/litecart/admin");
        Assertions.assertEquals("My Store", webDriver.getTitle(), "Заголовок не соответствует ожидаемому");
    }



}
