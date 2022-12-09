package com.edu.cucumber.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class BasePage {

    protected void clickElement(SelenideElement element) {
        element.shouldBe(Condition.visible).click();
    }

    protected void fillField(SelenideElement element, String text) {
        element.shouldBe(Condition.visible).sendKeys(text);
    }

}
