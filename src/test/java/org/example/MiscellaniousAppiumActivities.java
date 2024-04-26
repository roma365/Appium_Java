package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MiscellaniousAppiumActivities extends  BaseTest{

    @Test
    public void WifiSettingsTest() throws MalformedURLException {

        //Navigate directly to the particular app page
        //Terminal command to define the app package and activity: adb shell dumpsys window | find "mCurrentFocus"
        //[packageName]/activityName
        //io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies
        Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
        ((JavascriptExecutor)driver).executeScript("mobile: startActivity",
                ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));

        //Actual Automation
        driver.findElement(By.id("android:id/checkbox")).click();

        //Rotate device to landscape
        DeviceRotation landscape = new DeviceRotation(0, 0, 90 );
        driver.rotate(landscape);

        driver.findElement(By.xpath("//android.widget.LinearLayout[2]")).click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");

        //Clipboard
        driver.setClipboardText("WAAAAAAAAAAAAAAAGH");//copy text
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());

        //Press Key
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        String enteredText = driver.findElement(By.id("android:id/edit")).getText();
        Assert.assertEquals(enteredText, "WAAAAAAAAAAAAAAAGH\n");

        //driver.findElement(By.id("android:id/button1")).click();
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
    }
}
