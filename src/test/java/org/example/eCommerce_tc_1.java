package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerce_tc_1 extends BaseTest {

    @Test

    public  void  fillForm(){
        driver.findElement(By.className("android.widget.Button")).click();
        String toastMassage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
        Assert.assertEquals(toastMassage, "Please enter your name");
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vulkan");
        //driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.className("android.widget.Spinner")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
    }
}
