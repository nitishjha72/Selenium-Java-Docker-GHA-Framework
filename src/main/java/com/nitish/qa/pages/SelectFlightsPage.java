package com.nitish.qa.pages;

import com.nitish.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class SelectFlightsPage extends BasePage {

    private final By confirmFlightBtn = By.id("confirm-flights");
    private final By departureEmiratesEconomyClass = By.id("dep-emirates-economy");
    private final By arrivalQatarBusinessClass = By.id("arr-qatar-business");

    public SelectFlightsPage selectDepartureEmiratesEconomy() {
        waitAndClick(departureEmiratesEconomyClass, WaitStrategy.CLICKABLE, "Departure emirates economy radio button");
        return this;
    }

    public SelectFlightsPage selectArrivalQatarBusiness() {
        waitAndClick(arrivalQatarBusinessClass, WaitStrategy.CLICKABLE, "Arrival qatar business radio button");
        return this;
    }

    public FlightConfirmationPage clickConfirmFlights() {
        waitAndClick(confirmFlightBtn, WaitStrategy.CLICKABLE, "Confirm flights Button");
        return new FlightConfirmationPage();
    }


}
