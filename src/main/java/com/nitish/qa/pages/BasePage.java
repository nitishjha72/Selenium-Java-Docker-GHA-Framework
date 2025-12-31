package com.nitish.qa.pages;

import com.nitish.qa.enums.SelectBy;
import com.nitish.qa.enums.WaitStrategy;
import com.nitish.qa.factories.ExplicitWaitFactory;
import com.nitish.qa.factories.SelectFactory;
import com.nitish.qa.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BasePage {

    protected void waitAndClick(By locator, WaitStrategy strategy, String elementName) {
        ExplicitWaitFactory.performExplicitlyWait(locator, strategy).click();
        ExtentLogger.info("Clicked successfully on element: " + elementName,true);
    }

    protected void waitAndSendKeys(By locator, WaitStrategy strategy, String value, String elementName) {
        ExplicitWaitFactory.performExplicitlyWait(locator, strategy).sendKeys(value);
        ExtentLogger.info("'" + value + "' - entered successfully on element: " + elementName, true);
    }

    protected void waitAndSelect(By locator, WaitStrategy strategy, SelectBy selectBy, String value, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitlyWait(locator, strategy);
        SelectFactory.performSelect(element, selectBy, value);
        ExtentLogger.info("'" + value + "' selected successfully on : " + elementName, true);
    }

    protected String getTextFromElement(By locator,  WaitStrategy strategy) {
        return ExplicitWaitFactory.performExplicitlyWait(locator, strategy).getText();
    }

}
