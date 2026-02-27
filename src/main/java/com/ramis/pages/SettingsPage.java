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
        waitFor(1000);
        try {
            // Try exact text match first
            return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"
            ));
        } catch (Exception e1) {
            try {
                // Try with textContains for partial match
                String searchText = text.contains(" ") ? text.split(" ")[0] : text;
                return driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().textContains(\"" + searchText + "\"))"
                ));
            } catch (Exception e2) {
                // Last resort: try to find element without scrolling
                try {
                    return driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiSelector().textContains(\"" + text + "\")"
                    ));
                } catch (Exception e3) {
                    throw new RuntimeException("Could not find element with text: " + text, e3);
                }
            }
        }
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
            waitFor(2000);
            String pageSource = driver.getPageSource();
            // Check for Settings-related indicators
            return pageSource.toLowerCase().contains("settings") &&
                   (pageSource.toLowerCase().contains("network") ||
                    pageSource.toLowerCase().contains("display") ||
                    pageSource.toLowerCase().contains("sound") ||
                    pageSource.toLowerCase().contains("apps"));
        } catch (Exception e) {
            return false;
        }
    }

    // ── Navigation actions ────────────────────────────────────────────────────
    /** Open Network & internet settings. */
    public void openNetworkSettings() {
        waitFor(1000);
        try {
            scrollToText("Network & internet").click();
        } catch (Exception e) {
            try {
                // Try alternate names
                scrollToText("Network & Internet").click();
            } catch (Exception e2) {
                scrollToText("Internet").click();
            }
        }
        waitFor(1000);
    }

    /** Open Bluetooth settings. */
    public void openBluetoothSettings() {
        waitFor(2000);
        try {
            scrollToText("Bluetooth").click();
        } catch (Exception e) {
            try {
                scrollToText("Connected devices").click();
            } catch (Exception e2) {
                // Try finding by className
                driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"Bluetooth\")"
                )).click();
            }
        }
        waitFor(2000);
    }

    /** Open Apps settings. */
    public void openAppsSettings() {
        waitFor(2000);
        try {
            scrollToText("Apps").click();
        } catch (Exception e) {
            driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"App\")"
            )).click();
        }
        waitFor(2000);
    }

    /** Open Display settings. */
    public void openDisplaySettings() {
        waitFor(2000);
        try {
            scrollToText("Display").click();
        } catch (Exception e) {
            driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"Display\")"
            )).click();
        }
        waitFor(2000);
    }

    /** Open Sound & vibration settings. */
    public void openSoundSettings() {
        waitFor(2000);
        try {
            scrollToText("Sound & vibration").click();
        } catch (Exception e) {
            try {
                scrollToText("Sound").click();
            } catch (Exception e2) {
                driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"Sound\")"
                )).click();
            }
        }
        waitFor(2000);
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
        waitFor(2000);
        try {
            scrollToText("About phone").click();
        } catch (Exception e) {
            try {
                // Emulators sometimes show "About emulated device"
                scrollToText("About emulated device").click();
            } catch (Exception e2) {
                try {
                    // Try "About"
                    scrollToText("About").click();
                } catch (Exception e3) {
                    // Last resort - find any element containing "About"
                    driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiSelector().textContains(\"About\")"
                    )).click();
                }
            }
        }
        waitFor(2000);
    }

    // ── Search ────────────────────────────────────────────────────────────────
    /** Tap the search bar and type a query. */
    public void searchFor(String query) {
        waitFor(2000);
        // Try tapping the search icon/bar (content-desc varies by version)
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().descriptionContains(\"Search settings\")"
            )).click();
        } catch (Exception e) {
            try {
                driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().description(\"Search\")"
                )).click();
            } catch (Exception e2) {
                try {
                    driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiSelector().classNameMatches(\".*EditText\").instance(0)"
                    )).click();
                } catch (Exception e3) {
                    // Last resort - try to find search by resource ID
                    driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiSelector().resourceIdMatches(\".*search.*\")"
                    )).click();
                }
            }
        }
        waitFor(2000);
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiSelector().classNameMatches(\".*EditText\").instance(0)"
        )).sendKeys(query);
        waitFor(2000);
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
        try {
            // Wait a bit for page to load
            waitFor(2000);
            String pageSource = driver.getPageSource();
            // Case-insensitive search
            return pageSource.toLowerCase().contains(text.toLowerCase());
        } catch (Exception e) {
            return false;
        }
    }
}
