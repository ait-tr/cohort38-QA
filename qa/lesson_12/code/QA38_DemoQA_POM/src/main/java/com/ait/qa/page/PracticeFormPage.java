package page;

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
    @FindBy(id = "hobbies-checkbox-1")
    WebElement sports;
    @FindBy(id = "hobbies-checkbox-2")
    WebElement reading;
    @FindBy(id = "hobbies-checkbox-3")
    WebElement music;
    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;
    @FindBy(id="currentAddress")
    WebElement currentAddress;
    @FindBy(id="state")
    WebElement state;
    @FindBy(id="city")
    WebElement city;
    @FindBy(id="submit")
    WebElement submit;



}
