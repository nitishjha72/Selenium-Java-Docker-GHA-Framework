package com.nitish.qa.factories;

import com.nitish.qa.drivers.BrowserStrategy;
import com.nitish.qa.drivers.ChromeBrowserStrategy;
import com.nitish.qa.drivers.EdgeBrowserStrategy;
import com.nitish.qa.drivers.FirefoxBrowserStrategy;
import com.nitish.qa.enums.DriverType;
import com.nitish.qa.exceptions.BrowserInvocationFailedException;
import com.nitish.qa.exceptions.FrameworkException;

import java.util.Map;
import java.util.Optional;

public final class BrowserStrategyFactory {

    private static final Map<DriverType, BrowserStrategy> STRATEGIES =
            Map.of(
                    DriverType.CHROME, new ChromeBrowserStrategy(),
                    DriverType.FIREFOX, new FirefoxBrowserStrategy(),
                    DriverType.EDGE, new EdgeBrowserStrategy()
            );

    private BrowserStrategyFactory() {}

    public static BrowserStrategy getStrategy(DriverType driverType) {
        return Optional.ofNullable(STRATEGIES.get(driverType))
                .orElseThrow(() -> new BrowserInvocationFailedException("Unsupported browser: " + driverType));
    }

}
