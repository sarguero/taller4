package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MiLista {
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
    public void createActividad(){

        String nameActivity="Nuevo Actividad1.7";
        //String notes="Nota1.6";
        // click add activity
      //  driver.findElement(By.id("com.samsung.android.app.contacts:id/contact_list_floating_action_button")).click();
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        // set
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(nameActivity);
        //set phone
      //  driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(notes);
        // click save
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
/*
        String actualResult = driver.findElement(By.id("com.vrproductiveapps.whendo:id/notesList")).getText();
        String expectedResult= nameActivity;
        Assertions.assertEquals(expectedResult,actualResult,"Error > La actividad no fue creada");*/
    }
}
