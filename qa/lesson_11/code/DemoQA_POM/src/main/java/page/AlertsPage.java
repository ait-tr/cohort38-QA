package page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlertsPage extends BasePage {
    private final Logger LOG = LoggerFactory.getLogger(AlertsPage.class);

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;
    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public AlertsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public AlertsPage clickTimerAlertButton() {
        clickOnElement(timerAlertButton);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return this;
    }

    public AlertsPage clickConfirmButton(String choiceActive) {
        clickOnElement(confirmButton);
        Alert alert = getAlert();
//        Alert alert = driver.switchTo().alert(); - Альтернативный способ переключения драйвера на алерт.
        if (choiceActive != null && choiceActive.equalsIgnoreCase("ok")) {
            alert.accept();
        } else alert.dismiss();
        return this;
    }

    public AlertsPage checkConfirmResult(String expectedResult) {
        String actual = confirmResult.getText();
        LOG.info(String.format("Проверяем confirmResult, expected - %s, actual - %s", expectedResult, actual));
        Assertions.assertTrue(actual.contains(expectedResult));
        return this;
    }
}
