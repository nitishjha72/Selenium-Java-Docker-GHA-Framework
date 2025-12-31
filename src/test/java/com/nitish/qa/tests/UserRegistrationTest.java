package com.nitish.qa.tests;

import com.nitish.qa.annotations.FrameworkAnnotations;
import com.nitish.qa.enums.CategoryType;
import com.nitish.qa.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class UserRegistrationTest extends BaseTest {

    private UserRegistrationTest(){}

    @FrameworkAnnotations(authors = {"Nitish-B"}, categories = {CategoryType.REGRESSION, CategoryType.SANITY})
    @Test(groups = {"REGRESSION", "SANITY"})
    public void userRegistrationTest() {
        RegistrationPage registrationPage = new RegistrationPage();
        String nameOfUserRegistered = registrationPage.enterFirstName("Nitish")
                .enterLastName("Jha")
                .enterEmail("nitishjha72@gmail.com")
                .enterPassword("Nitish123")
                .enterStreet("123 main street")
                .enterCity("Bangalore")
                .enterZip("30011")
                .selectState("Georgia")
                .clickRegistrationBtn().getNameOfRegisteredUserFromConfirmationPage();

        Assert.assertEquals(nameOfUserRegistered, "Nitish");
    }
}
