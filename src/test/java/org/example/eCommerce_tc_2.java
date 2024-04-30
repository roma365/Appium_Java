package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class eCommerce_tc_2 extends BaseTest {

    @Test

    public  void  fillForm(){

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vulkan");
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.className("android.widget.Spinner")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.className("android.widget.Button")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));
        //driver.findElement(By.xpath("//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[@text='ADD TO CART']")).click();
        int productCounter = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        System.out.println("  productCounter  =  "+productCounter);

        for (int i = 0; i < productCounter; i++) {
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            System.out.println(productName);
            if (productName.equals("Jordan 6 Rings")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.
                attributeContains(driver.findElement(
                        By.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart" ));

        String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");


    }
}
