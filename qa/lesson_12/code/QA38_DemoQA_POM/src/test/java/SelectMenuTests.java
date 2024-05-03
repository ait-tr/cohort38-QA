import com.ait.qa.page.HomePage;
import com.ait.qa.page.LeftPannel;
import com.ait.qa.page.SelectMenuPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SelectMenuTests extends BaseTest {

    @BeforeEach
    void precondition() {
        new HomePage(driver, wait).getWidgets();
        new LeftPannel(driver, wait).clickSelectMenu();
    }


    @Test
    @DisplayName("Проверка работы выпадающего списка")
    void test1() {
        new SelectMenuPage(driver, wait)
                .selectOldMenuColor("Black");
    }

    @Test
    @DisplayName("Проверка работы мульти списка")
    void test2() {
        new SelectMenuPage(driver, wait)
                .multiSelectColor("Black", "gree");
    }
}
