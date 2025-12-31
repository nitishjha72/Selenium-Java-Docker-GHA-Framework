package com.nitish.qa.drivers;

import org.openqa.selenium.WebDriver;

public interface ExecutionStrategy {
    WebDriver createDriver(BrowserStrategy browserStrategy);
}
