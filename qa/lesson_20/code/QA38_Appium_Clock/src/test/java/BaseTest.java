import core.AppManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

public class BaseTest {

    @BeforeAll
    static void start() throws IOException {
        AppManager.startApp();
    }

    @AfterAll
    static void stop() throws IOException {
        AppManager.stop();
    }
}
