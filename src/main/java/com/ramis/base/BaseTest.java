package com.ramis.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.ramis.utils.ConfigReader;
import com.ramis.utils.ExtentManager;
import com.aventstack.extentreports.ExtentTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * Base Test Class - All test classes extend this class
 * Handles driver initialization and teardown
 * Author: Ramis Ali (22f-3703)
 * Class: BSSE-8B
 */
public class BaseTest {
    
    protected static AppiumDriver driver;
    protected ExtentTest test;
    
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        System.out.println("Setting up Appium Driver...");
        
        // Configure Android Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName(ConfigReader.getProperty("deviceName"));
        options.setPlatformVersion(ConfigReader.getProperty("platformVersion"));
        
        // For using Calculator app (pre-installed)
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity("com.android.calculator2.Calculator");
        
        // Alternative: For using custom APK
        // options.setApp(System.getProperty("user.dir") + "/apps/sample-app.apk");
        
        options.setNoReset(true);
        options.setNewCommandTimeout(Duration.ofSeconds(60));
        
        // Initialize driver
        String appiumServerUrl = ConfigReader.getProperty("appiumServer");
        driver = new AndroidDriver(new URL(appiumServerUrl), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        System.out.println("Driver initialized successfully");
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            System.out.println("Closing driver...");
            driver.quit();
        }
    }
    
    public AppiumDriver getDriver() {
        return driver;
    }
}
