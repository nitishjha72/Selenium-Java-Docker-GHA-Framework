package com.nitish.qa.pages;

import com.nitish.qa.enums.SelectBy;
import com.nitish.qa.enums.ServiceClass;
import com.nitish.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class FlightSearchPage extends BasePage {

    private final By passengersDropDown = By.id("passengers");
    private final By departingCountryDropDown = By.id("depart-from");
    private final By arrivalCountryDropDown = By.id("arrive-in");
    private final By economyClass = By.id("service-class1");
    private final By firstClass = By.id("service-class2");
    private final By businessClass = By.id("service-class3");
    private final By searchFlightBtn = By.id("search-flights");



    public FlightSearchPage selectPassengers(String passengers) {
        waitAndSelect(passengersDropDown, WaitStrategy.CLICKABLE, SelectBy.INDEX, passengers, "Passengers drop down");
        return this;
    }

    public FlightSearchPage selectDepartingCountry(String departingCountry) {
        waitAndSelect(departingCountryDropDown, WaitStrategy.CLICKABLE, SelectBy.VALUE, departingCountry, "Departing country drop down");
        return this;
    }

    public FlightSearchPage selectArrivalCountry(String arrivalCountry) {
        waitAndSelect(arrivalCountryDropDown, WaitStrategy.CLICKABLE, SelectBy.VALUE, arrivalCountry, "Arrival country drop down");
        return this;
    }

    public FlightSearchPage clickServiceClass(String serviceClass) {
        if(serviceClass.equalsIgnoreCase(ServiceClass.FIRST.toString())) {
            waitAndClick(firstClass, WaitStrategy.CLICKABLE, "First service class");
        } else if(serviceClass.equalsIgnoreCase(ServiceClass.ECONOMY.toString())) {
            waitAndClick(economyClass, WaitStrategy.CLICKABLE, "Economy service class");
        } else if(serviceClass.equalsIgnoreCase(ServiceClass.BUSINESS.toString())) {
            waitAndClick(businessClass, WaitStrategy.CLICKABLE, "Business service class");
        } else{
            waitAndClick(economyClass, WaitStrategy.CLICKABLE, "Default option - Economy service class");
        }
        return this;
    }

    public SelectFlightsPage clickSearchFlights() {
        waitAndClick(searchFlightBtn, WaitStrategy.CLICKABLE, "Search flights option");
        return new SelectFlightsPage();
    }


}
