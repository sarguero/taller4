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

public class ContactManager {
    private AppiumDriver driver;

    @BeforeEach
    public void before() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName","Galaxy J8");
        capabilities.setCapability("appium:platformVersion","10");
        capabilities.setCapability("appium:appPackage","com.samsung.android.app.contacts");
        capabilities.setCapability("appium:appActivity","com.samsung.android.contacts.contactslist.PeopleActivity");
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
    public void createContact(){
        String nameContact="Nuevo Contacto8";
        // click add contact
        driver.findElement(By.id("com.samsung.android.app.contacts:id/contact_list_floating_action_button")).click();
        // set name
        driver.findElement(By.xpath("//android.widget.EditText[@text='Nombre']")).sendKeys(nameContact);
        //set phone
        //    driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'fono')]")).click();
        //    driver.findElement(By.xpath("//android.widget.EditText[contains(@text,'fono')]"));
        // click save
        driver.findElement(By.id("com.samsung.android.app.contacts:id/smallLabel")).click();

        String actualResult = driver.findElement(By.id("com.samsung.android.app.contacts:id/header")).getText();
        String expectedResult= nameContact;
        Assertions.assertEquals(expectedResult,actualResult,"Error > El contacto no fue creado");
    }
}
