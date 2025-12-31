package com.nitish.qa.selectionstrategy;

import com.nitish.qa.annotations.FrameworkAnnotations;
import org.testng.IMethodInstance;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class AnnotationBasedSelectionStrategy implements TestSelectionStrategy {

    @Override
    public boolean shouldRun(IMethodInstance methodInstance, String filterValue) {

        if (filterValue == null || filterValue.isBlank()) {
            return true;
        }

        FrameworkAnnotations annotation =
                methodInstance.getMethod()
                        .getConstructorOrMethod()
                        .getMethod()
                        .getAnnotation(FrameworkAnnotations.class);

        if (annotation == null) {
            return false;
        }

        Set<String> allowedCategories = Arrays.stream(filterValue.split(","))
                .map(String::trim)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());

        return Arrays.stream(annotation.categories())
                .map(Enum::name)
                .map(String::toUpperCase)
                .anyMatch(allowedCategories::contains);
    }
}
