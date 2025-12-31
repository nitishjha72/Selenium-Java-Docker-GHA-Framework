package com.nitish.qa.utils;

import com.nitish.qa.constants.FrameworkConstants;
import com.nitish.qa.exceptions.FrameworkException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtils {

    private ExcelUtils() {}

    public static List<Map<String, String>> getTestDetails(String sheetName) {

        List<Map<String, String>> data = new ArrayList<>();

        try (
                InputStream is = ResourceLoader.getResourceStream(FrameworkConstants.getExcelPath());
                XSSFWorkbook workbook = new XSSFWorkbook(is)
        ) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new FrameworkException("Sheet not found: " + sheetName);
            }

            int lastRowNum = sheet.getLastRowNum();
            int lastColNum = sheet.getRow(0).getLastCellNum();

            for (int i = 1; i <= lastRowNum; i++) {
                Map<String, String> rowMap = new HashMap<>();
                for (int j = 0; j < lastColNum; j++) {
                    String key = sheet.getRow(0)
                            .getCell(j)
                            .getStringCellValue()
                            .trim();

                    String value = "";

                    if (sheet.getRow(i) != null && sheet.getRow(i).getCell(j) != null) {
                        value = sheet.getRow(i).getCell(j).toString().trim();
                    }

                    rowMap.put(key, value);
                }
                data.add(rowMap);
            }

        } catch (IOException e) {
            throw new FrameworkException("Error reading Excel file", e);
        }

        return data;
    }
}
