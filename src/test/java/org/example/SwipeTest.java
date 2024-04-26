package org.example;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class SwipeTest extends  BaseTest{
    @Test
    public void scrollTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
        scrollToEnd();
    }
}
