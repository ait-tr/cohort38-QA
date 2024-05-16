package core;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class AppiumServerStarter {

    private static AppiumDriverLocalService service;

    private static Logger logger = LoggerFactory.getLogger(AppiumServerStarter.class);

    public static void startServer() throws IOException {
        // Создаем объект AppiumServiceBuilder
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        // Устанавливаем путь к Appium
        builder.withAppiumJS(new File("/opt/homebrew/bin/appium"));
        // Устанавливаем порт для сервера Appium
        builder.withIPAddress("127.0.0.1").usingPort(4723);
        // Создаем экземпляр AppiumDriverLocalService
        service = AppiumDriverLocalService.buildService(builder);
        // Запускаем сервер Appium
        try {
            service.start();
        } catch (AppiumServerHasNotBeenStartedLocallyException e) {
            //Если запуск прошел не успешно, и порт стал занят, выполняем команду в командной строке
            //И снова пытаемся стартануть сервер
            Runtime.getRuntime().exec("pkill -9 -f appium");
            service.start();
        }
        //Проверяем что сервер запустился
        if (service.isRunning()) {
            logger.info("Appium server started");
        } else {
            logger.info("Appium server failed start");
        }
    }

    public static void stopServer() {
        //Останавливаем сервер
        service.stop();
        logger.info("Appium server stopped");
    }

}
