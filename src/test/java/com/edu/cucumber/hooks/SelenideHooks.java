package com.edu.cucumber.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SelenideHooks {
    @Before
    public void initDriver() {
        Configuration.timeout = 10;
        Selenide.open();
    }

    @After
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }
}
