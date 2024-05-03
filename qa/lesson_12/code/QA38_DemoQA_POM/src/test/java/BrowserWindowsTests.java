
import com.ait.qa.page.BrowserWindowsPage;
import com.ait.qa.page.HomePage;
import com.ait.qa.page.LeftPannel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class BrowserWindowsTests extends BaseTest {

    @BeforeEach
    void precondition() {
        new HomePage(driver, wait).getAlertFrameWindows();
        new LeftPannel(driver, wait).clickBrowserWindows();
    }

    @Test
    @DisplayName("Проверка перехода в другую вкладку браузера")
    void test1() {
        new BrowserWindowsPage(driver, wait)
                .switchToNextWindow(1)
                .checkSampleHeadingInNewTab();
    }
}
