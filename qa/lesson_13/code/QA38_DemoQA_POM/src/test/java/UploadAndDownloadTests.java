import page.HomePage;
import page.LeftPannel;
import page.UploadAndDownloadPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("@UploadAndDownloadTests")
@Tag("@ALL")
public class UploadAndDownloadTests extends BaseTest{

    @BeforeEach
    void precondition() {
        new HomePage(driver, wait).getElements();
        new LeftPannel(driver, wait).clickUploadAndDownload();
    }

    @Test
    @Tag("@SMOKE")
    @DisplayName("Проверка кнопки download")
    void test1() {
        new UploadAndDownloadPage(driver, wait).download();
    }
}
