package com.nitish.qa.tests;

import com.nitish.qa.drivers.DriverManager;
import com.nitish.qa.enums.ConfigProperties;
import com.nitish.qa.enums.DriverType;
import com.nitish.qa.factories.DriverFactory;
import com.nitish.qa.utils.ConfigResolver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected BaseTest() {}

    @BeforeMethod
    protected void setUp() {

        DriverType browser = ConfigResolver.getEnum(ConfigProperties.BROWSER, DriverType.class, DriverType.CHROME);
        DriverFactory.initDriver(browser);

        WebDriver driver = DriverManager.getDriver();
        driver.get(ConfigResolver.get(ConfigProperties.URL));
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        DriverManager.quitDriver();
    }
}
