package phonebook;

import org.junit.jupiter.api.*;

@Tag("@ContactTests")
public class AddContactTests extends BaseTest {

    @BeforeEach
    void precondition() {
        if (appManager.getUserHelper().isSignOutPresent()) {
            appManager.getUserHelper().clickOnSignOutButton();
        }
        appManager.getUserHelper().login(appManager.getTestUser());
    }

    @Test
    @DisplayName("Успешное создание контакта")
    void test1() {
        appManager.getContactHelper().clickOnAddLink();
        appManager.getContactHelper().fillAddContactForm(appManager.getTestContact());
        appManager.getContactHelper().clickOnSaveButton();
        appManager.getContactHelper().contactIsPresent(appManager.getTestContact());
        appManager.getContactHelper().removeContactByName(appManager.getTestContact().getName());
    }

    @Test
    @DisplayName("Создание контакта с некорректным номером телефона")
    void test2() {
        appManager.getContactHelper().clickOnAddLink();
        appManager.getContactHelper().fillAddContactForm(appManager.getTestContact().setPhone("JJ"));
        appManager.getContactHelper().clickOnSaveButton();
        Assertions.assertTrue(appManager.getContactHelper().getAlertText().contains("Phone not valid"), "Сообщение об ошибке не соответствует ожидаемому");
    }
}
