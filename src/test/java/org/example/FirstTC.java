package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.internal.Debug;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class FirstTC extends  BaseTest{

    @Test
    public void WifiSettingsTest() throws MalformedURLException {
        //Actual Automation
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]\n")).click();
        driver.findElement(By.id("android:id/checkbox")).click();

        driver.findElement(By.xpath("//android.widget.LinearLayout[2]")).click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");

        driver.findElement(By.id("android:id/edit")).sendKeys("Perturaba Wi-Fi");
        String enteredText = driver.findElement(By.id("android:id/edit")).getText();
        Assert.assertEquals(enteredText, "Perturaba Wi-Fi");

        //driver.findElement(By.id("android:id/button1")).click();
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
    }
}
