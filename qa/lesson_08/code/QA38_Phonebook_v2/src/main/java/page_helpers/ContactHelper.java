package page_helpers;

import model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Нажатие на ссылку ADD
    public void clickOnAddLink() {
        clickOnElement(By.cssSelector("[href='/add']"));
    }

    //Нажатие на ссылку CONTACT
    public void clickOnContactLink() {
        clickOnElement(By.cssSelector("[href='/contacts']"));
    }


    //Нажатие на кнопку Save
    public void clickOnSaveButton() {
        clickOnElement(By.xpath("//*[text()='Save']"));
    }

    //Нажатие на кнопку Remove
    public void clickOnRemoveButton() {
        clickOnElement(By.xpath("//button[text()='Remove']"));
    }


    //Заполняем поля контакт формы
    public void fillAddContactForm(Contact contact) {
        fillInputField(By.cssSelector("[placeholder='Name']"), contact.getName());
        fillInputField(By.cssSelector("[placeholder='Last Name'"), contact.getLastName());
        fillInputField(By.cssSelector("[placeholder='Phone'"), contact.getPhone());
        fillInputField(By.cssSelector("[placeholder='email'"), contact.getEmail());
        fillInputField(By.cssSelector("[placeholder='Address'"), contact.getAddress());
        fillInputField(By.cssSelector("[placeholder='description'"), contact.getDescription());
    }

    //Нажатие на контакт из списка по имени
    public void clickOnContactByName(String nameContact) {
        clickOnElement(By.xpath(String.format("//h2[text()='%s']", nameContact)));
    }

    //Удаление контакта из списка по имени
    public void removeContactByName(String nameContact) {
        clickOnContactByName(nameContact);
        clickOnRemoveButton();
        waitInSeconds(2);
    }

    //Метод добавления контакта
    public void addContact(Contact contact) {
        clickOnAddLink();
        fillAddContactForm(contact);
        clickOnSaveButton();
    }

    //Получаем количество контактов
    public int sizeOfContacts() {
        if (getElement(By.cssSelector(".contact-item_card__2SOIM")).isDisplayed()) {
            //метод findElements возвращает List<WebElement>. Метод size возвращает число элементов в List
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        } else return 0;
    }

    public void contactIsPresent(Contact contact) {
        checkElementIsDisplayed(By.xpath(String.format("//h2[text()='%s']", contact.getName())));
    }
}
