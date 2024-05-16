import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ClockPage;

public class ClockPageTest extends BaseTest {


    @Test
    @DisplayName("Проверка добавления нового города")
    void test1() {
        new ClockPage()
                .tapCitiesButton()
                .tapSearchButton()
                .typeBerlinInSearchField()
                .checkAddBerlinInClockPage();
    }
}
