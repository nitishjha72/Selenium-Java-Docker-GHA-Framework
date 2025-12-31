package com.nitish.qa.listeners;

import com.nitish.qa.enums.ConfigProperties;
import com.nitish.qa.factories.TestSelectionStrategyFactory;
import com.nitish.qa.selectionstrategy.TestSelectionStrategy;
import com.nitish.qa.utils.ConfigResolver;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.List;
import java.util.stream.Collectors;

public class MethodInterceptor implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods,
                                           ITestContext context) {

        String testCategory = resolveTestCategory(context);
        TestSelectionStrategy strategy =
                TestSelectionStrategyFactory.getStrategy();

        return methods.stream()
                .filter(method -> strategy.shouldRun(method, testCategory))
                .collect(Collectors.toList());
    }

    /**
     * Resolution priority:
     * 1. CI / ENV
     * 2. JVM
     * 3. config.properties
     * 4. testng.xml (fallback only)
     */
    private String resolveTestCategory(ITestContext context) {

        // Primary source (CI → JVM → config.properties)
        String category =
                ConfigResolver.get(ConfigProperties.TEST_CATEGORY, null);

        if (category != null && !category.isBlank()) {
            return category;
        }

        // Secondary fallback (TestNG XML)
        return context.getCurrentXmlTest()
                .getParameter("TEST_CATEGORY");
    }
}
