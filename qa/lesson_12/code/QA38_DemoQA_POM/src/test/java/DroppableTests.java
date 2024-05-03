import page.DroppablePage;
import page.HomePage;
import page.LeftPannel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DroppableTests extends BaseTest {

    @BeforeEach
    void precondition() {
        new HomePage(driver, wait).getInteractions();
        new LeftPannel(driver, wait).clickDroppable();
    }

    @Test
    @DisplayName("Проверка drag and drop элемента")
    void test2() {
        new DroppablePage(driver, wait)
                .dragAndDrop();
    }

}
