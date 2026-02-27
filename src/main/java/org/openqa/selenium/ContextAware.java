package org.openqa.selenium;

import java.util.Set;

/**
 * Compatibility stub for Appium Java Client 9.1.0.
 *
 * This interface was removed from Selenium 4.x but is still referenced in the
 * compiled bytecode of Appium Java Client 9.1.0 (in HasBrowserCheck,
 * SupportsContextSwitching, and WebDriverUnpackUtility).  Without it on the
 * runtime classpath the JVM throws:
 *   java.lang.NoClassDefFoundError: org/openqa/selenium/ContextAware
 *
 * Providing this stub satisfies the JVM class-loader; Appium's instanceof
 * checks against it simply return false (no AndroidDriver implements it),
 * which is the correct behaviour for the native-app context used in tests.
 *
 * This stub can be removed when upgrading to an Appium Java Client version
 * that no longer references the deleted interface.
 */
public interface ContextAware {
    /**
     * Switch the current context to the one with the given name.
     *
     * @param name the name of the context to switch to
     * @return the current driver (for chaining)
     */
    WebDriver context(String name);

    /**
     * Return the identifier of the current context.
     *
     * @return the current context name, or {@code null} if unknown
     */
    String getContext();

    /**
     * Return the set of all available context names.
     *
     * @return set of context name strings
     */
    Set<String> getContextHandles();
}
