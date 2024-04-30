
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.AlertsPage;
import page.HomePage;
import page.LeftPannel;

public class AlertsTests extends BaseTest {

    @BeforeEach
    public void precondition() {
        new HomePage(driver, wait).getAlertFrameWindows();
        new LeftPannel(driver, wait).clickAlertsButton();
    }

    @Test
    @DisplayName("Проверка Alert Timer")
    void test1() {
        new AlertsPage(driver, wait).clickTimerAlertButton();
    }

    @Test
    @DisplayName("Проверка Alert confirmButton")
    void test2() {
        new AlertsPage(driver, wait)
                .clickConfirmButton("ok")
                .checkConfirmResult("Ok");
    }

    @Test
    @DisplayName("Проверка Alert Timer")
    void test3() {
        new AlertsPage(driver, wait).clickTimerAlertButton();
    }
}
