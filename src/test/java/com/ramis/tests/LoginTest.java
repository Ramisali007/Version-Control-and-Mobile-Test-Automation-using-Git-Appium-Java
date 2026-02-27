package com.ramis.tests;

import com.ramis.base.BaseTest;
import com.ramis.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Login Test Class
 * Contains test cases for Login functionality
 * Author: Ramis Ali (22f-3703)
 * Class: BSSE-8B
 */
public class LoginTest extends BaseTest {
    
    private LoginPage loginPage;
    
    @BeforeMethod
    public void initializePage() {
        loginPage = new LoginPage(driver);
    }
    
    @Test(priority = 1, description = "Verify login with valid credentials", enabled = false)
    public void testValidLogin() {
        System.out.println("Test Case 11: Testing Valid Login");
        loginPage.login("testuser", "password123");
        // Add assertion based on your app's behavior
        System.out.println("Valid login test executed");
    }
    
    @Test(priority = 2, description = "Verify login with invalid credentials", enabled = false)
    public void testInvalidLogin() {
        System.out.println("Test Case 12: Testing Invalid Login");
        loginPage.login("invaliduser", "wrongpass");
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed for invalid login");
        System.out.println("Invalid login test passed - Error displayed");
    }
    
    @Test(priority = 3, description = "Verify login with empty username", enabled = false)
    public void testEmptyUsername() {
        System.out.println("Test Case 13: Testing Empty Username");
        loginPage.login("", "password123");
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed for empty username");
        System.out.println("Empty username test passed");
    }
    
    @Test(priority = 4, description = "Verify login with empty password", enabled = false)
    public void testEmptyPassword() {
        System.out.println("Test Case 14: Testing Empty Password");
        loginPage.login("testuser", "");
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed for empty password");
        System.out.println("Empty password test passed");
    }
}
