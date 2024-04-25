package core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    private final Properties properties = new Properties();
    private final Logger LOG = LoggerFactory.getLogger(TestProperties.class);
    private static TestProperties INSTANCE = null;

    private TestProperties() {
        try {
            LOG.info("Загружаем application.properties");
            properties.load(TestProperties.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TestProperties getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }

    public Properties getProperties() {
        return properties;
    }
}