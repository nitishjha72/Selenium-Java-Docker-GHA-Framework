package com.nitish.qa.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class RemoteExecutionStrategy implements ExecutionStrategy {

    private final URL gridUrl;

    public RemoteExecutionStrategy(URL gridUrl) {
        this.gridUrl = gridUrl;
    }

    @Override
    public WebDriver createDriver(BrowserStrategy browserStrategy) {
        return new RemoteWebDriver(gridUrl, browserStrategy.getCapabilities());
    }
}

