package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class AppManager {

    private static AppiumDriver driver;

    public static void startApp() throws IOException {
        // Запускаем сервер Appium
        AppiumServerStarter.startServer();

        // Создаем объект UiAutomator2Options для настройки параметров сеанса Appium
        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage("com.google.android.deskclock") // Указываем пакет приложения
                .setAppActivity("com.android.deskclock.DeskClock") // Указываем Activity приложения
                .setAvd("android_jenkins_26") // Указываем имя эмулятора
                .setPlatformVersion("8"); //Указываем версию андроид

//       Эквивалетные настройки
//       // Создаем объект DesiredCapabilities для настройки параметров сеанса Appium
//       DesiredCapabilities capabilities = new DesiredCapabilities();
//       // Указываем платформу - Android
//       capabilities.setCapability("platformName", "Android");
//       // Указываем движок автоматизации - UiAutomator2
//       capabilities.setCapability("automationName", "UiAutomator2");
//       // Указываем пакет приложения
//       capabilities.setCapability("appPackage", "com.google.android.deskclock");
//       // Указываем Activity приложения
//       capabilities.setCapability("appActivity", "com.android.deskclock.DeskClock");
//       // Указываем имя эмулятора
//       capabilities.setCapability("avd", "android_jenkins_26");
//       //Указываем версию андроид
//       capabilities.setCapability("platformVersion", "8");

        // Создаем объект AndroidDriver с указанными параметрами
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        // Устанавливаем неявное ожидание в 10 секунд
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void stop() throws IOException {
        // Завершаем сеанс Appium и закрываем драйвер
        driver.quit();
        // Завершаем работу эмулятора
        Runtime.getRuntime().exec("adb -s emulator-5554 emu kill");
        // Останавливаем сервер Appium
        AppiumServerStarter.stopServer();
    }

    // Метод для получения драйвера
    public static AppiumDriver getDriver() {
        return driver;
    }
}
