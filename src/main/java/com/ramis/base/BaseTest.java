package com.ramis.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ramis.utils.ConfigReader;
import com.ramis.utils.ExtentManager;
import com.ramis.utils.ScreenshotUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * Base Test Class - All test classes extend this class
 * Handles driver initialization, teardown, and Extent Reporting
 * Author: Ramis Ali (22f-3703)
 * Class: BSSE-8B
 */
public class BaseTest {

    protected static AppiumDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setUpSuite() {
        extent = ExtentManager.getInstance();
        System.out.println("===== Test Suite Started =====");
    }

    @BeforeMethod
    public void setUp(java.lang.reflect.Method method) throws MalformedURLException {
        // Start Extent test entry with method name and description
        test = extent.createTest(method.getName(),
                method.isAnnotationPresent(org.testng.annotations.Test.class)
                        ? method.getAnnotation(org.testng.annotations.Test.class).description()
                        : "");

        System.out.println("Setting up Appium Driver for: " + method.getName());

        // Configure Android Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName(ConfigReader.getProperty("deviceName"));
        options.setPlatformVersion(ConfigReader.getProperty("platformVersion"));

        // Calculator app (pre-installed on all Android devices/emulators)
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity("com.android.calculator2.Calculator");

        options.setNoReset(true);
        options.setNewCommandTimeout(Duration.ofSeconds(60));

        // Initialize driver
        String appiumServerUrl = ConfigReader.getProperty("appiumServer");
        driver = new AndroidDriver(new URL(appiumServerUrl), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Driver initialized successfully");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Log pass/fail to Extent Report and capture screenshot on failure
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test FAILED: " + result.getThrowable().getMessage());
            if (driver != null) {
                String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
                test.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test SKIPPED: " + result.getThrowable());
        } else {
            test.log(Status.PASS, "Test PASSED");
        }

        if (driver != null) {
            System.out.println("Closing driver after: " + result.getName());
            driver.quit();
            driver = null;
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        ExtentManager.flushReports();
        System.out.println("===== Test Suite Finished — Report generated in /extent-reports =====");
    }

    public AppiumDriver getDriver() {
        return driver;
    }
}
