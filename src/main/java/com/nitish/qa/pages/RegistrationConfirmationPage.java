package com.nitish.qa.pages;

import com.nitish.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class RegistrationConfirmationPage extends BasePage {

    private final By confirmationOfFirstName = By.xpath("//div[@id='registration-confirmation-section']/div/div/div/p/b");
    private final By gotToFlightSearchBtn = By.id("go-to-flights-search");

    public String getNameOfRegisteredUserFromConfirmationPage() {
        return getTextFromElement(confirmationOfFirstName, WaitStrategy.CLICKABLE);
    }

    public FlightSearchPage clickGotToFlightSearchBtn() {
        waitAndClick(gotToFlightSearchBtn, WaitStrategy.CLICKABLE, "Go to flights search button");
        return new FlightSearchPage();
    }

}
