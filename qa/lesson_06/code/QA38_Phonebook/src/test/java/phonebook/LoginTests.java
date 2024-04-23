package phonebook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginTests extends BaseTest {

    @Test
    @Tag("@LoginTests")
    @DisplayName("Проверка успешной авторизации")
    void test1() {
//        нажимаем кнопку логин
        clickOnLoginLink();
//        вводим емайл и пароль
        fillLoginForm(new User("manuel@gm.com", "Manuel1234$"));
//        нажимаем кнопку логин
        clickOnLoginButton();
//        проверяем что есть  кнопка выход
        checkElementIsDisplayed(By.xpath("//button[text()='Sign Out']"));
    }

    @Test
    @Tag("@LoginTests")
    @DisplayName("Проверка ввода неверного пароля")
    void test2() {
        clickOnLoginLink();
        fillLoginForm(new User("manuel@gm.com", "Manuel12"));
        clickOnLoginButton();
        //Проверяем текст Алерта(Уведомления)
        Assertions.assertEquals("Wrong email or password", getAlert().getText(), "Текст ошибки не соответствует ожидаемому");
    }

    @Test
    @Tag("@LoginTests")
    @DisplayName("Проверка не успешной регистрации")
    void test3() {
        clickOnLoginLink();
        fillLoginForm(new User("manuel@gmll.com", "Man"));
        clickOnRegistrationButton();
        Assertions.assertTrue(getAlert().getText().contains("Password must contain"), "Сообщение об ошибке не соответствует ожидаемому");
    }
}
