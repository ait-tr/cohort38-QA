package phonebook;

import org.junit.jupiter.api.*;

import static core.AppManager.URL_PHONEBOOK;
import static core.AppManager.properties;

@Tag("@LoginTests")
@Tag("@ALL")
public class LoginTests extends BaseTest {
    @BeforeEach
    void precondition() {
        if (appManager.getUserHelper().isSignOutPresent()) {
            appManager.getUserHelper().clickOnSignOutButton();
        }
        appManager.getTestUser().setPassword(properties.getProperty("test_user_pass"));
    }

    @Test
    @Tag("@1213")
    @Tag("@Negative")
    @DisplayName("Проверка ввода неверного пароля")
    void test1() {
        appManager.getUserHelper().clickOnLoginLink();
        appManager.getUserHelper().fillLoginForm(appManager.getTestUser().setPassword("234t234"));
        appManager.getUserHelper().clickOnLoginButton();
        Assertions.assertEquals("Wrong email or password", appManager.getUserHelper().getAlertText(), "Текст ошибки не соответствует ожидаемому");
    }

    @Test
    @Tag("@Positive")
    @DisplayName("Проверка успешной авторизации")
    void test2() {
        appManager.getUserHelper().clickOnLoginLink();
        appManager.getUserHelper().fillLoginForm(appManager.getTestUser());
        appManager.getUserHelper().clickOnLoginButton();
        Assertions.assertTrue(appManager.getUserHelper().isSignOutPresent());
    }

    @Test
    @Tag("@Negative")
    @DisplayName("Проверка не успешной регистрации")
    void test3() {
        appManager.getUserHelper().clickOnLoginLink();
        appManager.getUserHelper().fillLoginForm(appManager.getTestUser().setPassword("123"));
        appManager.getUserHelper().clickOnRegistrationButton();
        Assertions.assertTrue(appManager.getUserHelper().getAlertText().contains("Password must contain"), "Сообщение об ошибке не соответствует ожидаемому");
    }
}
