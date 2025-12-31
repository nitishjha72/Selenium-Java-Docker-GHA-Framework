package com.nitish.qa.utils;

import com.nitish.qa.exceptions.FrameworkException;
import com.nitish.qa.exceptions.IssuesInCsvFileReadingException;
import com.opencsv.CSVReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public final class CSVUtils {

    private CSVUtils() {}

    public static List<Map<String, String>> readCSV(String filePath) {

        List<Map<String, String>> data = new ArrayList<>();

        try (InputStream is = ResourceLoader.getResourceStream(filePath);
             CSVReader reader = new CSVReader(new InputStreamReader(is))) {

            List<String[]> csvRows = reader.readAll();

            if (csvRows.isEmpty()) {
                throw new IssuesInCsvFileReadingException("CSV file is empty");
            }

            // First row → headers
            String[] headers = csvRows.getFirst();

            // Remaining rows → data
            for (int i = 1; i < csvRows.size(); i++) {
                String[] row = csvRows.get(i);
                Map<String, String> rowMap = new HashMap<>();

                for (int j = 0; j < headers.length; j++) {
                    rowMap.put(headers[j].trim(), row[j].trim());
                }
                data.add(rowMap);
            }

        } catch (Exception e) {
            throw new IssuesInCsvFileReadingException("Error reading CSV file", e);
        }

        return data;
    }
}
