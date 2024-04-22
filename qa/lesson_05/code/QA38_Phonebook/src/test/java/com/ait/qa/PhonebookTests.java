package com.ait.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PhonebookTests extends BaseTest {

    @Test
    void checkClickAboutTest() {
        driver.get(URL_PHONEBOOK);
        WebElement elementAbout = driver.findElement(By.cssSelector("[href='/about']"));
        waitForClickableElement(elementAbout).click();
        WebElement elementTitle = driver.findElement(By.tagName("h2"));
        Assertions.assertEquals("Test App", elementTitle.getText(), "h2 не Test App");
    }

    @Test
    void checkLoginTest() {
        driver.navigate().to(URL_LITECART_ADMIN);
        fillInputFieldByName("username", "admin");
        fillInputFieldByName("password", "admin38Qa");
        waitForClickableElement(driver.findElement(By.name("login"))).click();
        WebElement logOutElement = waitForVisibilityElement(driver.findElement(By.cssSelector("[title='Logout']")));
        Assertions.assertTrue(logOutElement.isDisplayed(), "Отсутствует копка выход");
        logOutElement.click();
    }
}
