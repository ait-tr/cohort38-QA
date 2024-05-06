package ilcarro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//h1")
    WebElement homePageTitle;

    @FindBy(xpath = "//a[.=' Log in ']")
    WebElement loginLink;

    public HomePage isHomePageTitlePreset() {
        assert homePageTitle.isDisplayed();
        return this;
    }

    public LoginPage clickOnLoginLink() {
        clickOnElement(loginLink);
        return new LoginPage(driver, wait);
    }


}
