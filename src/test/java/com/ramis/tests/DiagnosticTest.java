package com.ramis.tests;

import com.ramis.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Minimal diagnostic test that EXTENDS BaseTest
 * If this shows 0 tests, BaseTest (or its static initializers) is the problem
 */
public class DiagnosticTest extends BaseTest {

    @Test
    public void testOne() {
        System.out.println("DiagnosticTest.testOne() executed!");
        Assert.assertTrue(true, "Basic assertion should pass");
    }
}
