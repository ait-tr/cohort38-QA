package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(css = "[href='/login']")
    WebElement loginLink;
    @FindBy(name = "login")
    WebElement loginButton;
    @FindBy(xpath = "//button[text()='Sign Out']")
    WebElement sigOutButton;
    @FindBy(name = "email")
    WebElement emailForm;
    @FindBy(name = "password")
    WebElement passForm;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void login() {
        clickOnLoginLink();
        fillUserLoginForm();
        clickOnLoginButton();
    }

    //заполняем поля логин формы
    public void fillUserLoginForm() {
        //вводим емайл
        fillInputField(emailForm, "manuel@gm.com");
        //вводим пароль
        fillInputField(passForm, "Manuel1234$");
    }

    // Нажатие на ссылку LOGIN
    public void clickOnLoginLink() {
        clickOnElement(loginLink);
    }

    //Нажатие на кнопку Login
    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    //Нажатие на кнопу Sign Out
    public void clickOnSignOutButton() {
        clickOnElement(sigOutButton);
    }

    public boolean isSignOutPresent() {
        return sigOutButton.isDisplayed();
    }

}
