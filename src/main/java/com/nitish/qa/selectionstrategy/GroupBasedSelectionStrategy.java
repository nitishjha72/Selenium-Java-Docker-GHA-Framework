package com.nitish.qa.selectionstrategy;

import org.testng.IMethodInstance;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupBasedSelectionStrategy implements TestSelectionStrategy {

    @Override
    public boolean shouldRun(IMethodInstance methodInstance, String filterValue) {

        if (filterValue == null || filterValue.isBlank()) {
            return true;
        }

        Set<String> allowedGroups = Arrays.stream(filterValue.split(","))
                .map(String::trim)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        return Arrays.stream(methodInstance.getMethod().getGroups())
                .map(String::toLowerCase)
                .anyMatch(allowedGroups::contains);
    }

}
