package phonebook;

import core.AppManager;
import extension.RunnerExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(RunnerExtension.class)
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