package phonebook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("@HomeTests")
@Tag("@ALL")
public class HomePageTests extends BaseTest {

    @BeforeEach
    void precondition() {
        if (appManager.getUserHelper().isSignOutPresent()) {
            appManager.getUserHelper().clickOnSignOutButton();
        }
    }

    @Test
    @Tag("@Positive")
    @DisplayName("Переход в Home")
    void test1() {
        appManager.getHomePageHelper().clickOnHomeLink();
        appManager.getHomePageHelper().checkHomeComponentIsPresent();
    }
}
