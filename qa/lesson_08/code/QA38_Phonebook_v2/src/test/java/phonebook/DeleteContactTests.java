package phonebook;

import org.junit.jupiter.api.*;

@Tag("@ContactTests")
@Tag("@ALL")
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
    @Tag("@Positive")
    @DisplayName("Успешное удаление контакта")
    void test1() {
        appManager.getContactHelper().clickOnContactLink();
        int beforeRemove = appManager.getContactHelper().sizeOfContacts();
        appManager.getContactHelper().clickOnContactByName(appManager.getTestContact().getName());
        appManager.getContactHelper().clickOnRemoveButton();
        appManager.getContactHelper().waitInSeconds(3);
        int afterRemove = appManager.getContactHelper().sizeOfContacts();
        Assertions.assertEquals(beforeRemove - 2, afterRemove, "Количество контактов не изменилось");
    }
}
