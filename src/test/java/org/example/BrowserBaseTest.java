package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserBaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public  void configureAppium() throws MalformedURLException {
         service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
         service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        //options.setPlatformName("Android").noReset().withBrowserName("Browser");
        options.setDeviceName("Pixel 6 Pro API 33");
        options.setChromedriverExecutable("D:\\Program\\Work\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
        options.setCapability("browserName", "Chrome");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public Double getFormattedAmount(String amount){
       Double price = Double.parseDouble(amount.substring(1));
       return price;
    }

    @AfterClass
    public  void tearDown(){
        driver.quit();
        service.stop();
    }
}
