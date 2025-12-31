package com.nitish.qa.utils;

import com.nitish.qa.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {

    private DataProviderUtils() {}

    @DataProvider(name = "getDataFromCsv")
    public static Object[] getDataFromCsv(){
        List<Map<String,String>> data = CSVUtils.readCSV(FrameworkConstants.getCSVFilePath());
        return data.toArray();
    }

}