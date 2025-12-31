package com.nitish.qa.listeners;

import com.nitish.qa.enums.ConfigProperties;
import com.nitish.qa.utils.ConfigResolver;
import com.nitish.qa.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int count = 0;
    int maxAttempts = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count < maxAttempts && ConfigResolver.get(ConfigProperties.RETRY_FAILED_TESTS).equalsIgnoreCase("YES")) {
            count++;
            return true;
        }
        return false;
    }
}
