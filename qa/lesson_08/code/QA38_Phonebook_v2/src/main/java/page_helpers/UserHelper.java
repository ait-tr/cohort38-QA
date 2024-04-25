package page_helpers;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Вынесли авторизацию отдельным методом
    public void login() {
        login(new User("manuel@gm.com", "Manuel1234$"));
    }

    //Метод авторизации на сайте Phonebook c переданным параметром User
    public void login(User user) {
        clickOnLoginLink();
        fillLoginForm(user);
        clickOnLoginButton();
    }

    //заполняем поля логин формы
    public void fillLoginForm(User user) {
        //вводим емайл
        fillInputField(By.name("email"), user.getEmail());
        //вводим пароль
        fillInputField(By.name("password"), user.getPassword());
    }

    // Нажатие на ссылку LOGIN
    public void clickOnLoginLink() {
        clickOnElement(By.cssSelector("[href='/login']"));
    }

    //Нажатие на кнопку Login
    public void clickOnLoginButton() {
        clickOnElement(By.name("login"));
    }

    //Нажатие на кнопку registration
    public void clickOnRegistrationButton() {
        clickOnElement(By.name("registration"));
    }

    //Нажатие на кнопу Sign Out
    public void clickOnSignOutButton() {
        clickOnElement(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isSignOutPresent() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

}
