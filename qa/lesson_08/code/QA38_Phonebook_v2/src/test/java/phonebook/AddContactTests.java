package phonebook;

import extension.RunnerExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@Tag("@ContactTests")
@Tag("@ALL")
public class AddContactTests extends BaseTest {

    @BeforeEach
    void precondition() {
        if (appManager.getUserHelper().isSignOutPresent()) {
            appManager.getUserHelper().clickOnSignOutButton();
        }
        appManager.getUserHelper().login(appManager.getTestUser());
    }

    @Test
    @Tag("@Positive")
    @Tag("@1")
    @DisplayName("Успешное создание контакта")
    void test1() {
        appManager.getContactHelper().clickOnAddLink();
        appManager.getContactHelper().fillAddContactForm(appManager.getTestContact());
        appManager.getContactHelper().clickOnSaveButton();
        appManager.getContactHelper().contactIsPresent(appManager.getTestContact());
        appManager.getContactHelper().removeContactByName(appManager.getTestContact().getName());
    }

    @Test
    @Tag("@Negative")
    @DisplayName("Создание контакта с некорректным номером телефона")
    void test2() {
        appManager.getContactHelper().clickOnAddLink();
        appManager.getContactHelper().fillAddContactForm(appManager.getTestContact().setPhone("JJ"));
        appManager.getContactHelper().clickOnSaveButton();
        Assertions.assertTrue(appManager.getContactHelper().getAlertText().contains("Phone not valid"), "Сообщение об ошибке не соответствует ожидаемому");
    }
}
