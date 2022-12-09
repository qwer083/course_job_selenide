package com.edu.cucumber.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends BasePage {
    private SelenideElement choiceCityInput = $(By.xpath("//*[@class='mini-suggest-form__input mini-suggest__input']"));
    private List<SelenideElement> cityFromChoiceInputList = $$(By.xpath("//*[@class='mini-suggest__item mini-suggest__item_type_nav']"));
    private SelenideElement mainBannerSighn = $(By.cssSelector("h1#main_title"));
    private SelenideElement forecastForTenDaysTab = $(By.xpath("//*[@class='forecast-briefly__header-buttons']//a[1]"));

    private String stringForInput;

    public MainPage fillCityInput(String value) {
        fillField(choiceCityInput, value);
        stringForInput = value;
        return this;
    }


    public MainPage getCityFromCitiesList() {
        for (SelenideElement citi : cityFromChoiceInputList) {
            String elementText = citi.text();
            if (elementText.toUpperCase(Locale.ROOT).equals(stringForInput.toUpperCase(Locale.ROOT))) {
                clickElement(citi);
                break;
            }
        }
        return new MainPage();
    }

    public MainPage checkMainBannerExistCity(String cityName) {
        mainBannerSighn.shouldBe(Condition.visible);
        mainBannerSighn.getText().contains(cityName);
        return this;
    }

    public ForecastPage openForecastForTenDays() {
        clickElement(forecastForTenDaysTab);
        return new ForecastPage();
    }


}
