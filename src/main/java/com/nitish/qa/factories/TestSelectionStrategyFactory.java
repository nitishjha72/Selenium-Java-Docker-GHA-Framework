package com.nitish.qa.factories;

import com.nitish.qa.enums.ConfigProperties;
import com.nitish.qa.selectionstrategy.AnnotationBasedSelectionStrategy;
import com.nitish.qa.selectionstrategy.GroupBasedSelectionStrategy;
import com.nitish.qa.selectionstrategy.TestSelectionStrategy;
import com.nitish.qa.utils.ConfigResolver;

public final class TestSelectionStrategyFactory {

    private TestSelectionStrategyFactory() {}

    public static TestSelectionStrategy getStrategy() {
        String strategy = ConfigResolver.get(ConfigProperties.TEST_SELECTION_STRATEGY);
        return switch (strategy.toUpperCase()) {
            case "GROUPS" -> new GroupBasedSelectionStrategy();
            default -> new AnnotationBasedSelectionStrategy();
        };
    }
}

