package phonebook;

import core.AppManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    protected static AppManager appManager = new AppManager();

    @BeforeAll
    public static void startTest() {
        appManager.init();
    }

    @AfterAll
    public static void afterAll() {
        appManager.stop();
    }
}