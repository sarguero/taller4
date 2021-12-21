package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasicAppium {
    private AppiumDriver driver;

    @BeforeEach
    public void before() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName","Galaxy J8");
        capabilities.setCapability("appium:platformVersion","10");
        capabilities.setCapability("appium:appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appium:appActivity",".ui.HomeActivity");
        capabilities.setCapability("platformName","Android");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        // implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterEach
    public void after() throws InterruptedException{
        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void basicTest(){
        // click button 2
  driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02")).click();
        // click button +
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add")).click();
        // click button 7
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07")).click();
        // click button =
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")).click();



  String actualResult= driver.findElementById("com.sec.android.app.popupcalculator:id/calc_edt_formula").getText();
        String expectedResult = "9";
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! la suma es incorrecta");


    }
}
