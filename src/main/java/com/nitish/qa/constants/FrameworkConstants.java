package com.nitish.qa.constants;

public final class FrameworkConstants {

    private FrameworkConstants() {}

    private static final int EXPLICIT_WAIT_TIMEOUT = 10;

    private static final String CONFIG_FILE_PATH = "config/config.properties";
    private static final String EXCEL_PATH = "test-data/excelFlightData.xlsx";
    private static final String CSV_FILE_PATH = "test-data/csv-flight-data.csv";
    private static final String EXTENT_REPORT_FOLDER_PATH = System.getProperty("user.dir") + "/extent-reports/";

    public static int getExplicitWaitTimeout() {
        return EXPLICIT_WAIT_TIMEOUT;
    }

    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }

    public static String getExcelPath() {
        return EXCEL_PATH;
    }

    public static String getCSVFilePath() {
        return CSV_FILE_PATH;
    }

    public static String getExtentReportFolderPath() {
        return EXTENT_REPORT_FOLDER_PATH;
    }
}
