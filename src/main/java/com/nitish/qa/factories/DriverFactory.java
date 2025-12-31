package com.nitish.qa.factories;

import com.nitish.qa.drivers.BrowserStrategy;
import com.nitish.qa.drivers.DriverManager;
import com.nitish.qa.drivers.ExecutionStrategy;
import com.nitish.qa.enums.DriverType;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private DriverFactory() {}

    public static void initDriver(DriverType driverType) {
        BrowserStrategy browserStrategy = BrowserStrategyFactory.getStrategy(driverType);
        ExecutionStrategy executionStrategy = ExecutionStrategyFactory.getStrategy();
        WebDriver driver = executionStrategy.createDriver(browserStrategy);
        DriverManager.setDriver(driver);
    }

}
