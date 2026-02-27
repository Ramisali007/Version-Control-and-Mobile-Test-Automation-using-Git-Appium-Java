package com.ramis.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Extent Report Manager
 * Creates and manages test execution reports
 * Author: Ramis Ali (22f-3703)
 * Class: BSSE-8B
 */
public class ExtentManager {
    
    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    
    public static ExtentReports getInstance() {
        if (extent == null) {
            String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String reportPath = System.getProperty("user.dir") + "/extent-reports/TestReport_" + timestamp + ".html";
            
            sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setDocumentTitle("Mobile Test Automation Report");
            sparkReporter.config().setReportName("Appium Test Execution Report");
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
            
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Student Name", "Ramis Ali");
            extent.setSystemInfo("Roll Number", "22f-3703");
            extent.setSystemInfo("Class", "BSSE-8B");
            extent.setSystemInfo("Framework", "Appium + Java + TestNG");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        }
        return extent;
    }
    
    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}
