package com.nitish.qa.drivers;

import com.nitish.qa.exceptions.BrowserInvocationFailedException;
import com.nitish.qa.exceptions.FrameworkException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LocalExecutionStrategy implements ExecutionStrategy {

    @Override
    public WebDriver createDriver(BrowserStrategy browserStrategy) {
        Capabilities capabilities = browserStrategy.getCapabilities();

        if (capabilities instanceof ChromeOptions) {
            return new ChromeDriver((ChromeOptions) capabilities);
        } else if (capabilities instanceof FirefoxOptions) {
            return new FirefoxDriver((FirefoxOptions) capabilities);
        } else if (capabilities instanceof EdgeOptions) {
            return new EdgeDriver((EdgeOptions) capabilities);
        }

        throw new BrowserInvocationFailedException("Unsupported browser provided: " + capabilities);
    }
}

