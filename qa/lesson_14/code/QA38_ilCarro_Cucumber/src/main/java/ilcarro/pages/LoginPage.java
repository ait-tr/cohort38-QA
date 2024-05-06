package ilcarro.pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(css = "[class='message]")
    WebElement messageAfterLogin;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(css = "[type='submit']")
    WebElement submitButton;

    public LoginPage isSuccessLogin() {
        assert getElement(messageAfterLogin).getText().equals("Logged in success");
        return this;
    }

    public LoginPage isIncorrectLogin() {
        assert getElement(messageAfterLogin).getText().equals("Login or Password incorrect");
        return this;
    }

    public LoginPage enterData(String email, String password) {
        fillInputField(emailField, email);
        fillInputField(passwordField, password);
        return this;
    }

    public LoginPage enterData(DataTable table) {
        List<Map<String, String>> dataTableList = table.asMaps();
        return enterData(dataTableList.get(0).get("email"), dataTableList.get(0).get("password"));
    }

    public LoginPage clickSubmitButton() {
        clickOnElement(submitButton);
        return this;
    }
}
