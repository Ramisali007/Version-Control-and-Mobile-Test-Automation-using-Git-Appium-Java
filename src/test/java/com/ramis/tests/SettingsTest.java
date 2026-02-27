package com.ramis.tests;

import com.ramis.base.BaseTest;
import com.ramis.pages.SettingsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Settings App Test Class
 * Contains 10 functional test cases for the Android Settings application
 * Author: Ramis Ali (22f-3703)
 * Class: BSSE-8B
 */
public class SettingsTest extends BaseTest {

    private SettingsPage settingsPage;

    @BeforeMethod
    public void initializePage() {
        settingsPage = new SettingsPage(getDriver());
    }

    // ── TC-01 ──────────────────────────────────────────────────────────────────
    @Test(priority = 1, description = "Verify Settings app launches and main screen is displayed")
    public void testSettingsAppLaunches() {
        System.out.println("TC-01: Verify Settings app launches");
        boolean displayed = settingsPage.isSettingsDisplayed();
        Assert.assertTrue(displayed, "Settings app should be displayed on launch");
        System.out.println("PASSED: Settings app is displayed");
    }

    // ── TC-02 ──────────────────────────────────────────────────────────────────
    @Test(priority = 2, description = "Verify Network & internet option is visible on main screen")
    public void testNetworkOptionVisible() {
        System.out.println("TC-02: Verify Network & internet option is visible");
        boolean visible = settingsPage.isTextVisible("Network & internet") 
                       || settingsPage.isTextVisible("Network & Internet")
                       || settingsPage.isTextVisible("Internet");
        Assert.assertTrue(visible, "'Network & internet' should appear on Settings main screen");
        System.out.println("PASSED: Network & internet option is visible");
    }

    // ── TC-03 ──────────────────────────────────────────────────────────────────
    @Test(priority = 3, description = "Verify navigation to Network & internet settings screen")
    public void testNetworkSettingsNavigation() {
        System.out.println("TC-03: Navigate to Network & internet");
        settingsPage.openNetworkSettings();
        boolean inNetwork = settingsPage.isTextVisible("Network & internet")
                         || settingsPage.isTextVisible("Wi-Fi")
                         || settingsPage.isTextVisible("Internet");
        Assert.assertTrue(inNetwork, "Should navigate to Network settings screen");
        System.out.println("PASSED: Network & internet screen opened");
    }

    // ── TC-04 ──────────────────────────────────────────────────────────────────
    @Test(priority = 4, description = "Verify back navigation returns to main Settings screen")
    public void testBackNavigationFromNetwork() {
        System.out.println("TC-04: Test back navigation from Network screen");
        settingsPage.openNetworkSettings();
        try { Thread.sleep(2000); } catch (InterruptedException e) { }
        settingsPage.goBack();
        try { Thread.sleep(2000); } catch (InterruptedException e) { }
        boolean backOnMain = settingsPage.isSettingsDisplayed() 
                          || settingsPage.isTextVisible("Settings") 
                          || settingsPage.isTextVisible("Network & internet")
                          || settingsPage.isTextVisible("Display");
        Assert.assertTrue(backOnMain, "Pressing back should return to main Settings screen");
        System.out.println("PASSED: Back navigation works correctly");
    }

    // ── TC-05 ──────────────────────────────────────────────────────────────────
    @Test(priority = 5, description = "Verify navigation to Bluetooth settings screen")
    public void testBluetoothSettingsNavigation() {
        System.out.println("TC-05: Navigate to Bluetooth");
        settingsPage.openBluetoothSettings();
        boolean inBluetooth = settingsPage.isTextVisible("Bluetooth") 
                           || settingsPage.isTextVisible("Connected devices") 
                           || settingsPage.isTextVisible("Pair new device");
        Assert.assertTrue(inBluetooth, "Should navigate to Bluetooth settings screen");
        System.out.println("PASSED: Bluetooth settings screen opened");
    }

    // ── TC-06 ──────────────────────────────────────────────────────────────────
    @Test(priority = 6, description = "Verify navigation to Apps settings screen")
    public void testAppsSettingsNavigation() {
        System.out.println("TC-06: Navigate to Apps settings");
        settingsPage.openAppsSettings();
        boolean inApps = settingsPage.isTextVisible("Apps")
                       || settingsPage.isTextVisible("All apps")
                       || settingsPage.isTextVisible("See all apps");
        Assert.assertTrue(inApps, "Should navigate to Apps settings screen");
        System.out.println("PASSED: Apps settings screen opened");
    }

    // ── TC-07 ──────────────────────────────────────────────────────────────────
    @Test(priority = 7, description = "Verify navigation to Display settings screen")
    public void testDisplaySettingsNavigation() {
        System.out.println("TC-07: Navigate to Display settings");
        settingsPage.openDisplaySettings();
        boolean inDisplay = settingsPage.isTextVisible("Display")
                          || settingsPage.isTextVisible("Brightness")
                          || settingsPage.isTextVisible("Screen");
        Assert.assertTrue(inDisplay, "Should navigate to Display settings screen");
        System.out.println("PASSED: Display settings screen opened");
    }

    // ── TC-08 ──────────────────────────────────────────────────────────────────
    @Test(priority = 8, description = "Verify navigation to Sound & vibration settings screen")
    public void testSoundSettingsNavigation() {
        System.out.println("TC-08: Navigate to Sound & vibration settings");
        settingsPage.openSoundSettings();
        boolean inSound = settingsPage.isTextVisible("Sound & vibration")
                        || settingsPage.isTextVisible("Volume")
                        || settingsPage.isTextVisible("Ringtone");
        Assert.assertTrue(inSound, "Should navigate to Sound & vibration settings screen");
        System.out.println("PASSED: Sound & vibration settings screen opened");
    }

    // ── TC-09 ──────────────────────────────────────────────────────────────────
    @Test(priority = 9, description = "Verify search functionality in Settings")
    public void testSearchFunctionality() {
        System.out.println("TC-09: Test Settings search for 'Display'");
        settingsPage.searchFor("Display");
        boolean hasResults = settingsPage.hasSearchResults()
                           || settingsPage.isTextVisible("Display");
        Assert.assertTrue(hasResults, "Searching 'Display' should return results");
        System.out.println("PASSED: Search returned results for 'Display'");
    }

    // ── TC-10 ──────────────────────────────────────────────────────────────────
    @Test(priority = 10, description = "Verify navigation to About phone screen")
    public void testAboutPhoneNavigation() {
        System.out.println("TC-10: Navigate to About phone");
        settingsPage.openAboutPhone();
        boolean inAbout = settingsPage.isTextVisible("About phone")
                        || settingsPage.isTextVisible("About emulated device")
                        || settingsPage.isTextVisible("Android version")
                        || settingsPage.isTextVisible("Model");
        Assert.assertTrue(inAbout, "Should navigate to About phone screen");
        System.out.println("PASSED: About phone screen opened");
    }
}
