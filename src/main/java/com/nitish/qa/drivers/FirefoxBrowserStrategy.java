package com.nitish.qa.drivers;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowserStrategy implements BrowserStrategy {

    @Override
    public Capabilities getCapabilities() {
        return new FirefoxOptions();
    }
}

