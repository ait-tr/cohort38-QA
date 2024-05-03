package page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "userNumber")
    WebElement userNumber;
    @FindBy(css = "[for='gender-radio-1']")
    WebElement male;
    @FindBy(css = "[for='gender-radio-2']")
    WebElement female;
    @FindBy(css = "[for='gender-radio-3']")
    WebElement other;
    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;
    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;
    @FindBy(xpath = "//*[.='Sports']")
    WebElement sports;
    @FindBy(xpath = "//*[.='Reading']")
    WebElement reading;
    @FindBy(xpath = "//*[.='Music']")
    WebElement music;
    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;
    @FindBy(id = "currentAddress")
    WebElement currentAddress;
    @FindBy(id = "state")
    WebElement state;
    @FindBy(id = "react-select-3-input")
    WebElement stateField;
    @FindBy(id = "react-select-4-input")
    WebElement cityField;
    @FindBy(id = "city")
    WebElement city;
    @FindBy(id = "submit")
    WebElement submit;
    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement modalTitle;

    public PracticeFormPage enterPersonalData(String name, String surname, String email, String phone, String address) {
        fillInputField(firstName, name);
        fillInputField(lastName, surname);
        fillInputField(userEmail, email);
        fillInputField(userNumber, phone);
        fillInputField(currentAddress, address);
        return this;
    }

    public PracticeFormPage selectGender(String gender) {
        switch (gender) {
            case "Male":
                clickElement(male);
                break;
            case "Female":
                clickElement(female);
                break;
            default:
                clickElement(other);
                break;
        }
        return this;
    }

    public PracticeFormPage selectBirthDay(String date) {
        clickElement(dateOfBirthInput);
        dateOfBirthInput.sendKeys(Keys.COMMAND, "a");
        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage enterSubjects(String... subjects) {
        for (String subject : subjects) {
            fillInputField(subjectsInput, subject);
            subjectsInput.sendKeys(Keys.ENTER);
        }
        return this;
    }

    public PracticeFormPage selectHobbies(String... hobbies) {
        for (String hobby : hobbies) {
            switch (hobby) {
                case "Sports":
                    clickOnElement(sports);
                    break;
                case "Reading":
                    clickOnElement(reading);
                    break;
                case "Music":
                    clickOnElement(music);
                    break;
            }
        }
        return this;
    }

    public PracticeFormPage selectPicture(String path) {
        uploadPicture.sendKeys(path);
        return this;
    }

    public PracticeFormPage selectState(String stateInput) {
        state.click();
        stateField.sendKeys(stateInput);
        stateField.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage selectCity(String cityInput) {
        city.click();
        cityField.sendKeys(cityInput);
        cityField.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage clickSubmit() {
        clickElement(submit);
        return this;
    }

    public PracticeFormPage checkModalTitle(String title) {
        Assertions.assertEquals(modalTitle.getText(), title, "Title не соответствует ожидаемому");
        return this;
    }
}
