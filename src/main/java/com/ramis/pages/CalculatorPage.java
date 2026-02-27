package com.ramis.pages;

import com.ramis.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Calculator Page Object Model
 * Contains locators and methods for Calculator app
 * Author: Ramis Ali (22f-3703)
 * Class: BSSE-8B
 */
public class CalculatorPage extends BasePage {
    
    // Digit Buttons
    @AndroidFindBy(id = "com.android.calculator2:id/digit_0")
    private WebElement digit0;
    
    @AndroidFindBy(id = "com.android.calculator2:id/digit_1")
    private WebElement digit1;
    
    @AndroidFindBy(id = "com.android.calculator2:id/digit_2")
    private WebElement digit2;
    
    @AndroidFindBy(id = "com.android.calculator2:id/digit_3")
    private WebElement digit3;
    
    @AndroidFindBy(id = "com.android.calculator2:id/digit_4")
    private WebElement digit4;
    
    @AndroidFindBy(id = "com.android.calculator2:id/digit_5")
    private WebElement digit5;
    
    @AndroidFindBy(id = "com.android.calculator2:id/digit_6")
    private WebElement digit6;
    
    @AndroidFindBy(id = "com.android.calculator2:id/digit_7")
    private WebElement digit7;
    
    @AndroidFindBy(id = "com.android.calculator2:id/digit_8")
    private WebElement digit8;
    
    @AndroidFindBy(id = "com.android.calculator2:id/digit_9")
    private WebElement digit9;
    
    // Operator Buttons
    @AndroidFindBy(id = "com.android.calculator2:id/op_add")
    private WebElement addButton;
    
    @AndroidFindBy(id = "com.android.calculator2:id/op_sub")
    private WebElement subtractButton;
    
    @AndroidFindBy(id = "com.android.calculator2:id/op_mul")
    private WebElement multiplyButton;
    
    @AndroidFindBy(id = "com.android.calculator2:id/op_div")
    private WebElement divideButton;
    
    @AndroidFindBy(id = "com.android.calculator2:id/eq")
    private WebElement equalsButton;
    
    @AndroidFindBy(id = "com.android.calculator2:id/del")
    private WebElement deleteButton;
    
    @AndroidFindBy(id = "com.android.calculator2:id/clr")
    private WebElement clearButton;
    
    @AndroidFindBy(id = "com.android.calculator2:id/dec_point")
    private WebElement decimalButton;
    
    // Result Display
    @AndroidFindBy(id = "com.android.calculator2:id/result")
    private WebElement resultField;
    
    @AndroidFindBy(id = "com.android.calculator2:id/formula")
    private WebElement formulaField;
    
    public CalculatorPage(AppiumDriver driver) {
        super(driver);
    }
    
    /**
     * Click digit button based on number
     */
    public void clickDigit(int number) {
        switch (number) {
            case 0: digit0.click(); break;
            case 1: digit1.click(); break;
            case 2: digit2.click(); break;
            case 3: digit3.click(); break;
            case 4: digit4.click(); break;
            case 5: digit5.click(); break;
            case 6: digit6.click(); break;
            case 7: digit7.click(); break;
            case 8: digit8.click(); break;
            case 9: digit9.click(); break;
        }
    }
    
    /**
     * Enter a complete number
     */
    public void enterNumber(String number) {
        for (char digit : number.toCharArray()) {
            if (digit == '.') {
                decimalButton.click();
            } else {
                clickDigit(Character.getNumericValue(digit));
            }
        }
    }
    
    /**
     * Click addition button
     */
    public void clickAdd() {
        addButton.click();
    }
    
    /**
     * Click subtraction button
     */
    public void clickSubtract() {
        subtractButton.click();
    }
    
    /**
     * Click multiplication button
     */
    public void clickMultiply() {
        multiplyButton.click();
    }
    
    /**
     * Click division button
     */
    public void clickDivide() {
        divideButton.click();
    }
    
    /**
     * Click equals button
     */
    public void clickEquals() {
        equalsButton.click();
    }
    
    /**
     * Click clear button
     */
    public void clickClear() {
        clearButton.click();
    }
    
    /**
     * Click delete button
     */
    public void clickDelete() {
        deleteButton.click();
    }
    
    /**
     * Get result value
     */
    public String getResult() {
        waitFor(500);
        return resultField.getText();
    }
    
    /**
     * Get formula value
     */
    public String getFormula() {
        return formulaField.getText();
    }
    
    /**
     * Perform addition operation
     */
    public String performAddition(String num1, String num2) {
        clickClear();
        enterNumber(num1);
        clickAdd();
        enterNumber(num2);
        clickEquals();
        return getResult();
    }
    
    /**
     * Perform subtraction operation
     */
    public String performSubtraction(String num1, String num2) {
        clickClear();
        enterNumber(num1);
        clickSubtract();
        enterNumber(num2);
        clickEquals();
        return getResult();
    }
    
    /**
     * Perform multiplication operation
     */
    public String performMultiplication(String num1, String num2) {
        clickClear();
        enterNumber(num1);
        clickMultiply();
        enterNumber(num2);
        clickEquals();
        return getResult();
    }
    
    /**
     * Perform division operation
     */
    public String performDivision(String num1, String num2) {
        clickClear();
        enterNumber(num1);
        clickDivide();
        enterNumber(num2);
        clickEquals();
        return getResult();
    }
}
