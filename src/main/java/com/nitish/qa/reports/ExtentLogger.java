package com.nitish.qa.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.nitish.qa.enums.ConfigProperties;
import com.nitish.qa.utils.ConfigResolver;
import com.nitish.qa.utils.PropertyUtils;
import com.nitish.qa.utils.ScreenshotUtils;


public final class ExtentLogger {

    private ExtentLogger(){}

    public static void pass(String message){
        ExtentManager.getExtentTest().pass(message);
    }
    public static void fail(String message){
        ExtentManager.getExtentTest().fail(message);
    }
    public static void skip(String message){
        ExtentManager.getExtentTest().skip(message);
    }
    public static void info(String message){
        ExtentManager.getExtentTest().info(message);
    }

    public static void pass(String message, boolean isScreenshotNeeded){
        if(ConfigResolver.get(ConfigProperties.PASSED_STEPS_SCREENSHOTS).equalsIgnoreCase("YES") && isScreenshotNeeded){
            ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.takeScreenshotInBase64()).build());
        } else{
            ExtentManager.getExtentTest().pass(message);
        }
    }

    public static void fail(String message, boolean isScreenshotNeeded){
        if(ConfigResolver.get(ConfigProperties.FAILED_STEPS_SCREENSHOTS).equalsIgnoreCase("YES") && isScreenshotNeeded){
            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.takeScreenshotInBase64()).build());
        } else {
            ExtentManager.getExtentTest().fail(message);
        }
    }

    public static void skip(String message, boolean isScreenshotNeeded){
        if(ConfigResolver.get(ConfigProperties.SKIPPED_STEPS_SCREENSHOTS).equalsIgnoreCase("YES") && isScreenshotNeeded){
            ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.takeScreenshotInBase64()).build());
        } else {
            ExtentManager.getExtentTest().skip(message);
        }
    }

    public static void info(String message, boolean isScreenshotNeeded){
        if(isScreenshotNeeded){
            ExtentManager.getExtentTest().info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.takeScreenshotInBase64()).build());
        } else{
            ExtentManager.getExtentTest().info(message);
        }
    }

}
