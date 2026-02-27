package com.ramis.tests;

import com.ramis.base.BaseTest;
import com.ramis.pages.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Calculator Test Class
 * Contains test cases for Android Calculator app functionality (com.android.calculator2)
 *
 * ⚠️  IMPORTANT – To run these tests, update config.properties:
 *     appPackage=com.android.calculator2
 *     appActivity=com.android.calculator2.Calculator
 *
 * The default test suite (testng.xml) targets the Settings app.
 * These tests are included to demonstrate POM design with a second app.
 *
 * Author: Ramis Ali (22f-3703)
 * Class: BSSE-8B
 */
public class CalculatorTest extends BaseTest {
    
    private CalculatorPage calculatorPage;
    
    @BeforeMethod
    public void initializePage() {
        calculatorPage = new CalculatorPage(getDriver());
    }
    
    @Test(priority = 1, description = "Verify simple addition operation")
    public void testAddition() {
        System.out.println("Test Case 1: Testing Addition");
        String result = calculatorPage.performAddition("5", "3");
        Assert.assertTrue(result.contains("8"), "Addition test failed. Expected: 8, Got: " + result);
        System.out.println("Addition test passed: 5 + 3 = " + result);
    }
    
    @Test(priority = 2, description = "Verify simple subtraction operation")
    public void testSubtraction() {
        System.out.println("Test Case 2: Testing Subtraction");
        String result = calculatorPage.performSubtraction("10", "4");
        Assert.assertTrue(result.contains("6"), "Subtraction test failed. Expected: 6, Got: " + result);
        System.out.println("Subtraction test passed: 10 - 4 = " + result);
    }
    
    @Test(priority = 3, description = "Verify simple multiplication operation")
    public void testMultiplication() {
        System.out.println("Test Case 3: Testing Multiplication");
        String result = calculatorPage.performMultiplication("6", "7");
        Assert.assertTrue(result.contains("42"), "Multiplication test failed. Expected: 42, Got: " + result);
        System.out.println("Multiplication test passed: 6 × 7 = " + result);
    }
    
    @Test(priority = 4, description = "Verify simple division operation")
    public void testDivision() {
        System.out.println("Test Case 4: Testing Division");
        String result = calculatorPage.performDivision("20", "5");
        Assert.assertTrue(result.contains("4"), "Division test failed. Expected: 4, Got: " + result);
        System.out.println("Division test passed: 20 ÷ 5 = " + result);
    }
    
    @Test(priority = 5, description = "Verify decimal number addition")
    public void testDecimalAddition() {
        System.out.println("Test Case 5: Testing Decimal Addition");
        String result = calculatorPage.performAddition("2.5", "3.5");
        Assert.assertTrue(result.contains("6"), "Decimal addition test failed. Expected: 6, Got: " + result);
        System.out.println("Decimal addition test passed: 2.5 + 3.5 = " + result);
    }
    
    @Test(priority = 6, description = "Verify large number multiplication")
    public void testLargeNumberMultiplication() {
        System.out.println("Test Case 6: Testing Large Number Multiplication");
        String result = calculatorPage.performMultiplication("123", "456");
        Assert.assertTrue(result.contains("56088"), "Large number multiplication failed. Expected: 56088, Got: " + result);
        System.out.println("Large number multiplication passed: 123 × 456 = " + result);
    }
    
    @Test(priority = 7, description = "Verify clear function")
    public void testClearFunction() {
        System.out.println("Test Case 7: Testing Clear Function");
        calculatorPage.enterNumber("999");
        calculatorPage.clickClear();
        String formula = calculatorPage.getFormula();
        Assert.assertTrue(formula.isEmpty() || formula.equals("0"), 
            "Clear function failed. Formula should be empty or 0, Got: " + formula);
        System.out.println("Clear function test passed");
    }
    
    @Test(priority = 8, description = "Verify delete function")
    public void testDeleteFunction() {
        System.out.println("Test Case 8: Testing Delete Function");
        calculatorPage.clickClear();
        calculatorPage.enterNumber("123");
        calculatorPage.clickDelete();
        String formula = calculatorPage.getFormula();
        Assert.assertTrue(formula.contains("12"), "Delete function failed. Expected: 12, Got: " + formula);
        System.out.println("Delete function test passed");
    }
    
    @Test(priority = 9, description = "Verify zero division handling")
    public void testDivisionByZero() {
        System.out.println("Test Case 9: Testing Division by Zero");
        calculatorPage.clickClear();
        calculatorPage.enterNumber("10");
        calculatorPage.clickDivide();
        calculatorPage.enterNumber("0");
        calculatorPage.clickEquals();
        String result = calculatorPage.getResult();
        // Calculator should show error or infinity
        Assert.assertTrue(result.contains("∞") || result.contains("Error") || result.toLowerCase().contains("can't"), 
            "Division by zero not handled properly. Got: " + result);
        System.out.println("Division by zero test passed: " + result);
    }
    
    @Test(priority = 10, description = "Verify multiple operations")
    public void testMultipleOperations() {
        System.out.println("Test Case 10: Testing Multiple Operations");
        calculatorPage.clickClear();
        calculatorPage.enterNumber("5");
        calculatorPage.clickAdd();
        calculatorPage.enterNumber("3");
        calculatorPage.clickMultiply();
        calculatorPage.enterNumber("2");
        calculatorPage.clickEquals();
        String result = calculatorPage.getResult();
        // 5 + 3 = 8, then 8 × 2 = 16
        Assert.assertTrue(result.contains("16"), "Multiple operations failed. Expected: 16, Got: " + result);
        System.out.println("Multiple operations test passed: (5 + 3) × 2 = " + result);
    }
}
