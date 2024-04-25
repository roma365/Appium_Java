package org.example;

//Comment from the wirk computer

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LongPress extends  BaseTest {

    @Test
    public void longPressTest() throws MalformedURLException, InterruptedException {
        //Actual Automation
        driver.findElement(AppiumBy.accessibilityId("Views")).click();;
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]\n"));
        longPressAction(element);
        String popOverMenu = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(popOverMenu, "Sample menu");
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
    }
}
