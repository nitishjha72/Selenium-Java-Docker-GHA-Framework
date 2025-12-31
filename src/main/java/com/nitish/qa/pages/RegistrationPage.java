package com.nitish.qa.pages;

import com.nitish.qa.enums.SelectBy;
import com.nitish.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class RegistrationPage extends BasePage{

    private final By firstNameBox = By.id("firstName");
    private final By lastNameBox = By.id("lastName");
    private final By emailBox = By.id("email");
    private final By passwordBox = By.id("password");
    private final By cityBox = By.name("city");
    private final By streetBox = By.name("street");
    private final By zipBox = By.name("zip");
    private final By stateDropDown = By.id("inputState");
    private final By registrationBtn = By.id("register-btn");


    public RegistrationPage enterFirstName(String firstName) {
        waitAndSendKeys(firstNameBox, WaitStrategy.PRESENCE, firstName,"First name text box");
        return this;
    }

    public RegistrationPage enterLastName(String lastName) {
        waitAndSendKeys(lastNameBox, WaitStrategy.PRESENCE, lastName,"Last name text box");
        return this;
    }

    public RegistrationPage enterEmail(String email) {
        waitAndSendKeys(emailBox, WaitStrategy.PRESENCE, email,"Email text box");
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        waitAndSendKeys(passwordBox, WaitStrategy.PRESENCE, password,"Email text box");
        return this;
    }

    public RegistrationPage enterCity(String city) {
        waitAndSendKeys(cityBox, WaitStrategy.PRESENCE, city,"City text box");
        return this;
    }

    public RegistrationPage enterStreet(String street) {
        waitAndSendKeys(streetBox, WaitStrategy.PRESENCE, street,"Street text box");
        return this;
    }

    public RegistrationPage enterZip(String zip) {
        waitAndSendKeys(zipBox, WaitStrategy.PRESENCE, zip,"Zipcode text box");
        return this;
    }

    public RegistrationPage selectState(String state) {
        waitAndSelect(stateDropDown, WaitStrategy.PRESENCE, SelectBy.VALUE ,state,"State dropdown box");
        return this;
    }

    public RegistrationConfirmationPage clickRegistrationBtn() {
        waitAndClick(registrationBtn, WaitStrategy.CLICKABLE, "Registration button");
        return new RegistrationConfirmationPage();
    }



}
