package com.nitish.qa.tests;

import com.nitish.qa.annotations.FrameworkAnnotations;
import com.nitish.qa.enums.CategoryType;
import com.nitish.qa.pages.RegistrationPage;
import com.nitish.qa.reports.ExtentLogger;
import com.nitish.qa.utils.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Map;

public final class FlightReservationTest extends BaseTest{

    private FlightReservationTest(){}

    @FrameworkAnnotations(authors = {"Nitish-A"}, categories = {CategoryType.REGRESSION, CategoryType.SANITY})
    @Test(dataProvider = "getDataFromCsv", dataProviderClass = DataProviderUtils.class, groups = {"SANITY", "REGRESSION"})
    public void flightSearchTest(Map<String, String> data) {
        RegistrationPage registrationPage = new RegistrationPage();
        String totalPrice =
                registrationPage
                        .enterFirstName(data.get("firstName"))
                        .enterLastName(data.get("lastName"))
                        .enterEmail(data.get("email"))
                        .enterPassword(data.get("password"))
                        .enterStreet(data.get("street"))
                        .enterCity(data.get("city"))
                        .enterZip(data.get("zip"))
                        .selectState(data.get("state"))
                        .clickRegistrationBtn()
                        .clickGotToFlightSearchBtn()
                        .selectPassengers(data.get("passengers"))
                        .selectDepartingCountry(data.get("departingCountry"))
                        .selectArrivalCountry(data.get("arrivalCountry"))
                        .clickServiceClass(data.get("serviceClass"))
                        .clickSearchFlights()
                        .selectDepartureEmiratesEconomy()
                        .selectArrivalQatarBusiness()
                        .clickConfirmFlights()
                        .getTotalPrice();

        ExtentLogger.info("Total Price: " + totalPrice);
        Assert.assertTrue(totalPrice.contains("USD"));
    }

}
