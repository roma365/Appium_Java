package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest{
    @Test
    public void browserTest() {
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());

        driver.findElement(By.name("q")).sendKeys("perturaba primarch", Keys.ENTER);

    }
}
