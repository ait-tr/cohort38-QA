package phonebook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class HomePageTests extends BaseTest {

    @Test
    @Tag("@HomeTests")
    @DisplayName("Переход в Home")
    void test1() {
        //нажимаем кнопку HOME
        clickOnHomeLink();
        //проверяем корректность перехода в страницу HOME
        checkElementIsDisplayed(By.xpath("//h1[text()='Home Component']"));
    }
}
