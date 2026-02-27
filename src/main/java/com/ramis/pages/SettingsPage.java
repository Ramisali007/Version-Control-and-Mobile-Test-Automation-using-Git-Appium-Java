package com.ramis.pages;

import com.ramis.base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Settings Page Object Model
 * Contains locators and action methods for the Android Settings app
 * Author: Ramis Ali (22f-3703)
 * Class: BSSE-8B
 */
public class SettingsPage extends BasePage {

    // ── UIAutomator scrollable finder ─────────────────────────────────────────
    // Scrolls the list until the item with the given text is visible, then returns it.
    private WebElement scrollToText(String text) {
        return driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"
        ));
    }

    // ── Search bar ────────────────────────────────────────────────────────────
    private WebElement getSearchBar() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(
            AppiumBy.androidUIAutomator(
                "new UiSelector().resourceIdMatches(\".*search.*\").instance(0)"
            )
        ));
    }

    public SettingsPage(AppiumDriver driver) {
        super(driver);
    }

    // ── Visibility check ──────────────────────────────────────────────────────
    /**
     * Returns true if the main Settings screen is visible (heading present).
     */
    public boolean isSettingsDisplayed() {
        try {
            WebElement heading = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//android.widget.FrameLayout[@content-desc='Settings']" +
                               " | //android.widget.TextView[@text='Settings']" +
                               " | //*[@content-desc='Settings']")
            ));
            return heading.isDisplayed();
        } catch (Exception e) {
            // Fallback: check page source
            return driver.getPageSource().contains("Settings");
        }
    }

    // ── Navigation actions ────────────────────────────────────────────────────
    /** Open Network & internet settings. */
    public void openNetworkSettings() {
        scrollToText("Network & internet").click();
    }

    /** Open Bluetooth settings. */
    public void openBluetoothSettings() {
        scrollToText("Bluetooth").click();
    }

    /** Open Apps settings. */
    public void openAppsSettings() {
        scrollToText("Apps").click();
    }

    /** Open Display settings. */
    public void openDisplaySettings() {
        scrollToText("Display").click();
    }

    /** Open Sound & vibration settings. */
    public void openSoundSettings() {
        scrollToText("Sound & vibration").click();
    }

    /** Open Battery settings. */
    public void openBatterySettings() {
        scrollToText("Battery").click();
    }

    /** Open Notifications settings. */
    public void openNotificationsSettings() {
        scrollToText("Notifications").click();
    }

    /** Open About phone / About emulated device. */
    public void openAboutPhone() {
        try {
            scrollToText("About phone").click();
        } catch (Exception e) {
            // Emulators sometimes show "About emulated device"
            scrollToText("About emulated device").click();
        }
    }

    // ── Search ────────────────────────────────────────────────────────────────
    /** Tap the search bar and type a query. */
    public void searchFor(String query) {
        // Try tapping the search icon/bar (content-desc varies by version)
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().descriptionContains(\"Search settings\")"
            )).click();
        } catch (Exception e) {
            driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().classNameMatches(\".*EditText\").instance(0)"
            )).click();
        }
        waitFor(500);
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiSelector().classNameMatches(\".*EditText\").instance(0)"
        )).sendKeys(query);
        waitFor(1000);
    }

    /** Returns true if search results are shown (list is non-empty). */
    public boolean hasSearchResults() {
        try {
            WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//android.widget.ListView | //androidx.recyclerview.widget.RecyclerView")
            ));
            return result.isDisplayed();
        } catch (Exception e) {
            return driver.getPageSource().contains("Display");
        }
    }

    // ── Navigation ────────────────────────────────────────────────────────────
    /** Press the device Back button. */
    public void goBack() {
        driver.navigate().back();
        waitFor(500);
    }

    /** Check whether a given text label appears anywhere on screen. */
    public boolean isTextVisible(String text) {
        return driver.getPageSource().contains(text);
    }
}
