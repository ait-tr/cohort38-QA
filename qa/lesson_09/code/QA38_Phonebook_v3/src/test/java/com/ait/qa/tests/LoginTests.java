package com.ait.qa.tests;

import org.junit.jupiter.api.Test;
import page.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    void test1() {
        new LoginPage(driver, wait).login();
    }
}
