
import page.BrowserWindowsPage;
import page.HomePage;
import page.LeftPannel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("@BrowserWindowsTests")
@Tag("@ALL")
public class BrowserWindowsTests extends BaseTest {

    @BeforeEach
    void precondition() {
        new HomePage(driver, wait).getAlertFrameWindows();
        new LeftPannel(driver, wait).clickBrowserWindows();
    }

    @Test
    @Tag("@SMOKE")
    @DisplayName("Проверка перехода в другую вкладку браузера")
    void test1() {
        new BrowserWindowsPage(driver, wait)
                .switchToNextWindow(1)
                .checkSampleHeadingInNewTab();
    }
}
