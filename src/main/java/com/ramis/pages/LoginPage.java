package com.ramis.pages;

import com.ramis.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Login Page Object Model
 * Generic login page for demonstration
 * Author: Ramis Ali (22f-3703)
 * Class: BSSE-8B
 */
public class LoginPage extends BasePage {
    
    @AndroidFindBy(id = "com.example.app:id/username")
    private WebElement usernameField;
    
    @AndroidFindBy(id = "com.example.app:id/password")
    private WebElement passwordField;
    
    @AndroidFindBy(id = "com.example.app:id/login_button")
    private WebElement loginButton;
    
    @AndroidFindBy(id = "com.example.app:id/error_message")
    private WebElement errorMessage;
    
    @AndroidFindBy(id = "com.example.app:id/forgot_password")
    private WebElement forgotPasswordLink;
    
    @AndroidFindBy(id = "com.example.app:id/signup_button")
    private WebElement signupButton;
    
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }
    
    /**
     * Enter username
     */
    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    
    /**
     * Enter password
     */
    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    
    /**
     * Click login button
     */
    public void clickLogin() {
        loginButton.click();
    }
    
    /**
     * Perform login operation
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    
    /**
     * Get error message
     */
    public String getErrorMessage() {
        return errorMessage.getText();
    }
    
    /**
     * Check if error message is displayed
     */
    public boolean isErrorDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Click forgot password link
     */
    public void clickForgotPassword() {
        forgotPasswordLink.click();
    }
    
    /**
     * Click signup button
     */
    public void clickSignup() {
        signupButton.click();
    }
}
