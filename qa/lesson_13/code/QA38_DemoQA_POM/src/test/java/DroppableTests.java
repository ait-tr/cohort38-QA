import com.ait.qa.page.DroppablePage;
import com.ait.qa.page.HomePage;
import com.ait.qa.page.LeftPannel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("@DroppableTests")
@Tag("@ALL")
public class DroppableTests extends BaseTest {

    @BeforeEach
    void precondition() {
        new HomePage(driver, wait).getInteractions();
        new LeftPannel(driver, wait).clickDroppable();
    }

    @Test
    @Tag("@SMOKE")
    @DisplayName("Проверка drag and drop элемента")
    void test2() {
        new DroppablePage(driver, wait)
                .dragAndDrop();
    }

}
