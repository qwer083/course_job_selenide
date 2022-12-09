package com.edu.cucumber.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class ForecastPage extends BasePage {
    private List<SelenideElement> forecastsByDayList = $$(By.xpath("//*[@class='card']"));
    //локаторы искать отностильно элемента из forecastsByDayList
    private static String weatherInDayLocator = "td .a11y-hidden";
    private static String dayOfMothLocator = "h2 .a11y-hidden";


    public List<String> getWeatherFromDays() {
        List<String> weather = new ArrayList<>();
        for (SelenideElement forecasts : forecastsByDayList) {
            String temperature = forecasts.$(By.cssSelector(weatherInDayLocator)).getOwnText();
            String day = forecasts.$(By.cssSelector(dayOfMothLocator)).getOwnText();

            String resultString = String.format("%s\n%s\n--------", day, temperature);
            weather.add(resultString);
        }
        return weather;
    }
}
