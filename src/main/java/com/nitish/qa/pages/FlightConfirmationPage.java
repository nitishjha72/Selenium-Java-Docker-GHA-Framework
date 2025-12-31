package com.nitish.qa.pages;

import com.nitish.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class FlightConfirmationPage extends BasePage {

    private final By totalPrice = By.xpath("//div[@class='card-body']/div[3]/div/p");

    public String getTotalPrice() {
        return getTextFromElement(totalPrice, WaitStrategy.VISIBILITY);
    }

}
