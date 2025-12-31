package com.nitish.qa.factories;

import com.nitish.qa.drivers.ExecutionStrategy;
import com.nitish.qa.drivers.LocalExecutionStrategy;
import com.nitish.qa.drivers.RemoteExecutionStrategy;
import com.nitish.qa.enums.ConfigProperties;
import com.nitish.qa.enums.ExecutionMode;
import com.nitish.qa.exceptions.FrameworkException;
import com.nitish.qa.utils.ConfigResolver;

import java.net.MalformedURLException;
import java.net.URL;

public final class ExecutionStrategyFactory {

    private ExecutionStrategyFactory() {}

    public static ExecutionStrategy getStrategy() {

        ExecutionMode mode = ConfigResolver.getEnum(ConfigProperties.EXECUTION_MODE, ExecutionMode.class, ExecutionMode.LOCAL);

        if (mode == ExecutionMode.REMOTE) {
            try {
                return new RemoteExecutionStrategy(new URL(ConfigResolver.get(ConfigProperties.GRID_URL)));
            } catch (MalformedURLException e) {
                throw new FrameworkException("Invalid grid URL is provided:", e);
            }
        }

        return new LocalExecutionStrategy();
    }
}

