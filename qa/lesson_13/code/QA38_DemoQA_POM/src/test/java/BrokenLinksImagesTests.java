import page.BrokenLinksImagesPage;
import page.HomePage;
import page.LeftPannel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("@BrokenLinksImagesTests")
@Tag("@ALL")
public class BrokenLinksImagesTests extends BaseTest {

    @BeforeEach
    void precondition() {
        new HomePage(driver, wait).getElements();
        new LeftPannel(driver, wait).clickBrokenLinksImages();
    }

    @Test
    @Tag("SMOKE")
    @DisplayName("Проверка валидной ссылки")
    void test1() {
        new BrokenLinksImagesPage(driver, wait)
                .checkValidLink();
    }

    @Test
    @DisplayName("Проверка не валидной ссылки")
    void test2() {
        new BrokenLinksImagesPage(driver, wait)
                .checkBrokenLink();
    }

    @Test
    @Tag("SMOKE")
    @DisplayName("Проверка отображения изображения")
    void test3() {
        new BrokenLinksImagesPage(driver, wait)
                .checkValidImage();
    }

    @Test
    @DisplayName("Проверка отсутствия изображения")
    void test4() {
        new BrokenLinksImagesPage(driver, wait)
                .checkBrokenImage();
    }
}
