package phonebook;

import org.junit.jupiter.api.*;

public class DeleteContactTests extends BaseTest {

   private final Contact TEST_CONTACT = new Contact("Test", "Testoviy", "111111111111", "test@test.com", "Addresss", "Descr");

    @BeforeEach
    void start() {
        login();
        addContact(TEST_CONTACT);
    }

    @Test
    @Tag("@ContactTests")
    @DisplayName("Успешное удаление контакта")
    void test1() {
        clickOnContactLink();
        int beforeRemove = sizeOfContacts();
        clickOnContactByName(TEST_CONTACT.getName());
        clickOnRemoveButton();
        waitInSeconds(3);
        int afterRemove = sizeOfContacts();
        Assertions.assertEquals(beforeRemove - 1, afterRemove, "Количество контактов не изменилось");
    }
}
