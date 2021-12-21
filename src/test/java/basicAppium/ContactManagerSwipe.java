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

public class ContactManagerSwipe {
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
        TouchAction touchActions = new TouchAction(driver);
        WebElement firstControl=driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"com.samsung.android.app.contacts:id/contact_list\"]/android.widget.LinearLayout[3]"));
        WebElement secondControl=driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"com.samsung.android.app.contacts:id/contact_list\"]/android.widget.LinearLayout[1]"));

        int firstX = firstControl.getLocation().getX();
        int firstY = firstControl.getLocation().getY();

        int secondX = secondControl.getLocation().getX();
        int secondY = secondControl.getLocation().getY();

        touchActions.press(PointOption.point(firstX,firstY))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(secondX,secondY))
                .release().perform();
    }
}
