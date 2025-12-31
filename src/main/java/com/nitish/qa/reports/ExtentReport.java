package com.nitish.qa.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.nitish.qa.constants.FrameworkConstants;
import com.nitish.qa.enums.CategoryType;
import com.nitish.qa.enums.ConfigProperties;
import com.nitish.qa.utils.ConfigResolver;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport(){}

    private static ExtentReports extent;

    public static void initReport(){
        if(Objects.isNull(extent)){
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(resolveReportPath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setReportName("Automation Test Report by Nitish");
            spark.config().setEncoding("UTF-8");
            spark.config().setDocumentTitle("Automation Test Report by Nitish");
        }
    }

    public static void flushReport(){
        if(Objects.nonNull(extent)){
            extent.flush();
            ExtentManager.clearExtentTest();
//            try {
//                Desktop.getDesktop().browse(new File(resolveReportPath()).toURI());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    private static String resolveReportPath() {

        String basePath = FrameworkConstants.getExtentReportFolderPath();
        boolean override = ConfigResolver.get(ConfigProperties.OVERRIDE_REPORTS, "YES").equalsIgnoreCase("YES");

        if (override) {
            return basePath + "index.html";
        }

        return basePath + System.currentTimeMillis() + "_index.html";
    }

    public static void createTest(String testName){
        ExtentManager.setExtentTest(extent.createTest(testName));
    }

    public static void addAuthors(String... authors){
        ExtentManager.getExtentTest().assignAuthor(authors);
    }

    public static void addCategory(CategoryType... categoryTypes){
        for(CategoryType category : categoryTypes){
            ExtentManager.getExtentTest().assignCategory(category.toString());
        }
    }

}
