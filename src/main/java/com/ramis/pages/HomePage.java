package com.ramis.pages;

import com.ramis.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Home Page Object Model
 * Generic home page for navigation testing
 * Author: Ramis Ali (22f-3703)
 * Class: BSSE-8B
 */
public class HomePage extends BasePage {
    
    @AndroidFindBy(id = "com.example.app:id/home_title")
    private WebElement homeTitle;
    
    @AndroidFindBy(id = "com.example.app:id/menu_button")
    private WebElement menuButton;
    
    @AndroidFindBy(id = "com.example.app:id/settings_button")
    private WebElement settingsButton;
    
    @AndroidFindBy(id = "com.example.app:id/profile_button")
    private WebElement profileButton;
    
    @AndroidFindBy(id = "com.example.app:id/search_button")
    private WebElement searchButton;
    
    @AndroidFindBy(id = "com.example.app:id/notifications_button")
    private WebElement notificationsButton;
    
    public HomePage(AppiumDriver driver) {
        super(driver);
    }
    
    /**
     * Get home page title
     */
    public String getHomeTitle() {
        return homeTitle.getText();
    }
    
    /**
     * Click menu button
     */
    public void clickMenu() {
        menuButton.click();
    }
    
    /**
     * Navigate to settings
     */
    public void navigateToSettings() {
        settingsButton.click();
    }
    
    /**
     * Navigate to profile
     */
    public void navigateToProfile() {
        profileButton.click();
    }
    
    /**
     * Click search button
     */
    public void clickSearch() {
        searchButton.click();
    }
    
    /**
     * Click notifications button
     */
    public void clickNotifications() {
        notificationsButton.click();
    }
    
    /**
     * Check if home page is displayed
     */
    public boolean isHomePageDisplayed() {
        try {
            return homeTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
