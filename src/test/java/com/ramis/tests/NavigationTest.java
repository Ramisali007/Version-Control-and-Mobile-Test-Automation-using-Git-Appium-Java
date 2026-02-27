package com.ramis.tests;

import com.ramis.base.BaseTest;
import com.ramis.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Navigation Test Class
 * Contains test cases for app navigation
 * Author: Ramis Ali (22f-3703)
 * Class: BSSE-8B
 */
public class NavigationTest extends BaseTest {
    
    private HomePage homePage;
    
    @BeforeMethod
    public void initializePage() {
        homePage = new HomePage(getDriver());
    }
    
    @Test(priority = 1, description = "Verify home page is displayed", enabled = false)
    public void testHomePageDisplay() {
        System.out.println("Test Case 15: Testing Home Page Display");
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page should be displayed");
        System.out.println("Home page display test passed");
    }
    
    @Test(priority = 2, description = "Verify navigation to settings", enabled = false)
    public void testNavigateToSettings() {
        System.out.println("Test Case 16: Testing Navigation to Settings");
        homePage.navigateToSettings();
        System.out.println("Navigation to settings test executed");
    }
    
    @Test(priority = 3, description = "Verify navigation to profile", enabled = false)
    public void testNavigateToProfile() {
        System.out.println("Test Case 17: Testing Navigation to Profile");
        homePage.navigateToProfile();
        System.out.println("Navigation to profile test executed");
    }
}
