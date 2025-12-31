package com.nitish.qa.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private DriverManager() {}

    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return dr.get();
    }

    public static void setDriver(WebDriver driver){
        dr.set(driver);
    }

    public static void quitDriver(){
        WebDriver driver = dr.get();
        if (driver != null) {
            driver.quit();
            dr.remove();
        }
    }

}
