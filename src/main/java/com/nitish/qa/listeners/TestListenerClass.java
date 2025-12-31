package com.nitish.qa.listeners;

import com.nitish.qa.annotations.FrameworkAnnotations;
import com.nitish.qa.reports.ExtentLogger;
import com.nitish.qa.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.Arrays;
import java.util.Objects;

/**
 * Implements {@link org.testng.ITestListener} and {@link org.testng.ISuiteListener} to leverage the abstract methods
 * Mostly used to help in extent report generation
 *
 * <pre>Please make sure to add the listener details in the testng.xml file</pre>
 *
 *
 * @author Nitish Jha
 * @version 1.0
 * @since 1.0
 */

public class TestListenerClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReport();

    }

    @Override
    public void onTestStart(ITestResult testResult) {
        ExtentReport.createTest(testResult.getMethod().getMethodName());
        FrameworkAnnotations annotations = testResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class);
        if(Objects.nonNull(annotations)){
            ExtentReport.addCategory(annotations.categories());
            ExtentReport.addAuthors(annotations.authors());
        }
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        ExtentLogger.pass(testResult.getMethod().getMethodName() + " is passed", true);
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        //Screenshot
        ExtentLogger.fail(testResult.getMethod().getMethodName() + " is failed", true);
        ExtentLogger.fail(Arrays.toString(testResult.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {
        ExtentLogger.fail(testResult.getMethod().getMethodName() + " is skipped");
    }


}