package com.nitish.qa.factories;

import com.nitish.qa.constants.FrameworkConstants;
import com.nitish.qa.drivers.DriverManager;
import com.nitish.qa.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public final class ExplicitWaitFactory {

    private ExplicitWaitFactory() {}

    public static WebElement performExplicitlyWait(By locator, WaitStrategy waitStrategy) {
        if (waitStrategy == WaitStrategy.CLICKABLE) {
            return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWaitTimeout()))
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWaitTimeout()))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } else if (waitStrategy == WaitStrategy.VISIBILITY) {
            return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWaitTimeout()))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } else if(waitStrategy == WaitStrategy.NONE) {
            return DriverManager.getDriver().findElement(locator);
        } else{
            return DriverManager.getDriver().findElement(locator);
        }
    }

}
