package com.nitish.qa.drivers;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeBrowserStrategy implements BrowserStrategy{


    @Override
    public Capabilities getCapabilities() {
        return new EdgeOptions();
    }
}
