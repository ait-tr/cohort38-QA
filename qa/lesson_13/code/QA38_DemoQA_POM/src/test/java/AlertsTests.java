import com.ait.qa.page.AlertsPage;
import com.ait.qa.page.HomePage;
import com.ait.qa.page.LeftPannel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("@AlertsTests")
@Tag("@ALL")
public class AlertsTests extends BaseTest {

    @BeforeEach
    public void precondition() {
        new HomePage(driver, wait).getAlertFrameWindows();
        new LeftPannel(driver, wait).clickAlertsButton();
    }

    @Test
    @Tag("@SMOKE")
    @DisplayName("Проверка Alert Timer")
    void test1() {
        new AlertsPage(driver, wait).clickTimerAlertButton();
    }

    @Test
    @DisplayName("Проверка Alert confirmButton - ok")
    void test2() {
        new AlertsPage(driver, wait)
                .clickConfirmButton("ok")
                .checkConfirmResult("Ok");
    }

    @Test
    @DisplayName("Проверка Alert confirmButton - cancel")
    void test3() {
        new AlertsPage(driver, wait)
                .clickConfirmButton("cancel")
                .checkConfirmResult("Cancel");
    }

    @Test
    @DisplayName("Проверка Promt Alert text")
    void test4() {
        new AlertsPage(driver, wait)
                .clickPromtAlert("Hello")
                .checkPromtResult("Hello");
    }
}
