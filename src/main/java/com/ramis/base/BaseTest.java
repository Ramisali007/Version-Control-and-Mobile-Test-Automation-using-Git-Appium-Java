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

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * Base Test Class - All test classes extend this class.
 *
 * Uses ThreadLocal storage for both the AppiumDriver and ExtentTest so that
 * parallel test execution (parallel="methods" in testng.xml) is thread-safe.
 * Each test method gets its own driver session and its own report entry.
 *
 * NOTE: Actual parallel execution requires one Android device/emulator per
 * thread. Set thread-count in testng.xml to match the number of connected
 * devices. For a single device run, set parallel="false".
 *
 * Author: Ramis Ali (22f-3703)
 * Class: BSSE-8B
 */
public class BaseTest {

    // ThreadLocal ensures each parallel thread has its own driver and report entry
    private static final ThreadLocal<AppiumDriver> driverThread = new ThreadLocal<>();
    private static final ThreadLocal<ExtentTest>   testThread   = new ThreadLocal<>();

    protected static ExtentReports extent;

    // ── Convenience accessors used by subclasses ───────────────────────────
    protected AppiumDriver getDriver() {
        return driverThread.get();
    }

    protected ExtentTest getTest() {
        return testThread.get();
    }

    // ── Suite lifecycle ────────────────────────────────────────────────────
    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {
        extent = ExtentManager.getInstance();
        System.out.println("===== Test Suite Started =====");
    }

    // ── Method lifecycle ───────────────────────────────────────────────────
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) throws MalformedURLException {
        // Create per-method Extent report entry
        String description = method.isAnnotationPresent(org.testng.annotations.Test.class)
                ? method.getAnnotation(org.testng.annotations.Test.class).description()
                : method.getName();
        testThread.set(extent.createTest(method.getName(), description));

        System.out.println("Setting up driver for: " + method.getName());

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName(ConfigReader.getProperty("deviceName"));
        options.setPlatformVersion(ConfigReader.getProperty("platformVersion"));
        options.setAppPackage(ConfigReader.getProperty("appPackage"));
        options.setAppActivity(ConfigReader.getProperty("appActivity"));
        options.setNoReset(true);
        options.setNewCommandTimeout(Duration.ofSeconds(60));

        String appiumServerUrl = ConfigReader.getProperty("appiumServer");
        driverThread.set(new AndroidDriver(new URL(appiumServerUrl), options));
        driverThread.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Driver initialized successfully");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        ExtentTest test = testThread.get();
        AppiumDriver driver = driverThread.get();

        if (test != null) {
            if (result.getStatus() == ITestResult.FAILURE) {
                test.log(Status.FAIL, "FAILED: " + result.getThrowable().getMessage());
                if (driver != null) {
                    String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
                    test.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
                }
            } else if (result.getStatus() == ITestResult.SKIP) {
                test.log(Status.SKIP, "SKIPPED");
            } else {
                test.log(Status.PASS, "PASSED");
            }
        }

        if (driver != null) {
            driver.quit();
        }
        driverThread.remove();
        testThread.remove();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        ExtentManager.flushReports();
        System.out.println("===== Suite Finished - Report in /extent-reports =====");
    }
}
