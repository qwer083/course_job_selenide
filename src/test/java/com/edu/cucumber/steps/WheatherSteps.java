package com.edu.cucumber.steps;

import com.codeborne.selenide.Selenide;
import com.edu.cucumber.helpers.Constants;
import com.edu.cucumber.pages.ForecastPage;
import com.edu.cucumber.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WheatherSteps {
    MainPage mainPage = new MainPage();
    ForecastPage forecastPage = new ForecastPage();

    @When("open main wheather page")
    public void openMainWheatherPage() {
        Selenide.open(Constants.BASE_URL);
    }

    @Then("input city name: {string}")
    public void inputCityName(String value) {
        mainPage.fillCityInput(value);
    }

    @And("choice city name")
    public void choiceCityName() {
        mainPage.getCityFromCitiesList();
    }

    @And("check that cities is open: {string}")
    public void checkThatCitiesIsOpen(String value) {
        mainPage.checkMainBannerExistCity(value);
    }

    @Then("choice ten day forecasts")
    public void choiceTenDayForecasts() {
        mainPage.openForecastForTenDays();
    }

    @And("print all forecasts")
    public void printAllForecasts() {
        forecastPage.getWeatherFromDays().forEach(System.out::println);
    }
}
