import com.ait.qa.page.HomePage;
import com.ait.qa.page.LeftPannel;
import com.ait.qa.page.PracticeFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("@PracticeFormTests")
@Tag("@ALL")
public class PracticeFormTests extends BaseTest{

    @BeforeEach
    void precondition() {
        new HomePage(driver, wait).getForms();
        new LeftPannel(driver, wait).clickPracticeForm();
    }

    @Test
    @Tag("@SMOKE")
    @DisplayName("Проверка корректности заполнения формы")
    void test1() {
        new PracticeFormPage(driver, wait)
                .enterPersonalData("Name", "LastName", "qwe@qwe.com", "1234567890", "qwe street")
                .selectGender("Male")
                .selectBirthDay("05 Jul 2000")
                .enterSubjects("Chemistry", "Maths", "Computer Science")
                .selectHobbies("Sports", "Music")
                .selectPicture("/Users/Artur/IdeaProjects/cohort38e-qap/QA38_DemoQA_POM/src/test/resources/ait.png")
                .selectState("Utt")
                .selectCity("Agra")
                .clickSubmit()
                .checkModalTitle("Thanks for submitting the form");
    }
}
