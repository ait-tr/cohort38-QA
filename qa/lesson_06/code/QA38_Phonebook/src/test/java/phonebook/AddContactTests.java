package phonebook;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

public class AddContactTests extends BaseTest {

    private final Contact TEST_CONTACT = new Contact("Test", "Testoviy", "111111111111", "test@test.com", "Addresss", "Descr");

    @BeforeEach
    void start(){
        login();
    }

    @Test
    @Tag("@ContactTests")
    @DisplayName("Успешное создание контакта")
    void test1(){
        clickOnAddLink();
        fillAddContactForm(TEST_CONTACT);
        clickOnSaveButton();
        checkElementIsDisplayed(By.xpath(String.format("//h2[text()='%s']", TEST_CONTACT.getName())));
        removeContactByName(TEST_CONTACT.getName());
    }

    @Test
    @Tag("@ContactTests")
    @DisplayName("Создание контакта с некорректным номером телефона")
    void test2(){
        clickOnAddLink();
        fillAddContactForm(TEST_CONTACT.setPhone("JJ"));
        clickOnSaveButton();
        Assertions.assertTrue(getAlert().getText().contains("Phone not valid"),"Сообщение об ошибке не соответствует ожидаемому");
    }
}
