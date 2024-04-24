package phonebook;

import org.junit.jupiter.api.*;

@Tag("@ContactTests")
public class DeleteContactTests extends BaseTest {

    @BeforeEach
    void precondition() {
        if (appManager.getUserHelper().isSignOutPresent()) {
            appManager.getUserHelper().clickOnSignOutButton();
        }
        appManager.getUserHelper().login(appManager.getTestUser());
        appManager.getContactHelper().addContact(appManager.getTestContact());
    }

    @Test
    @DisplayName("Успешное удаление контакта")
    void test1() {
        appManager.getContactHelper().clickOnContactLink();
        int beforeRemove = appManager.getContactHelper().sizeOfContacts();
        appManager.getContactHelper().clickOnContactByName(appManager.getTestContact().getName());
        appManager.getContactHelper().clickOnRemoveButton();
        appManager.getContactHelper().waitInSeconds(3);
        int afterRemove = appManager.getContactHelper().sizeOfContacts();
        Assertions.assertEquals(beforeRemove - 1, afterRemove, "Количество контактов не изменилось");
    }
}
