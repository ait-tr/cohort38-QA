package page_helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageHelper extends BaseHelper {
    public HomePageHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // Нажатие на ссылку HOME
    public void clickOnHomeLink() {
        clickOnElement(By.cssSelector("[href='/home']"));
    }

    public void checkHomeComponentIsPresent() {
        checkElementIsDisplayed(By.xpath("//h1[text()='Home Component']"));
    }
}
