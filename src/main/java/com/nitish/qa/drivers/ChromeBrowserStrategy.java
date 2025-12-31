package com.nitish.qa.drivers;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowserStrategy implements BrowserStrategy {

    @Override
    public Capabilities getCapabilities() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return options;
    }
}
