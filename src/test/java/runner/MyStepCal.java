package runner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MyStepCal {

    private AppiumDriver driver;

    @Given("la aplicacion calculadora esta abierta")
    public void laAplicacionCalculadoraEstaAbierta() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "Galaxy J8");
        capabilities.setCapability("appium:platformVersion", "10");
        capabilities.setCapability("appium:appPackage", "com.sec.android.app.popupcalculator");
        capabilities.setCapability("appium:appActivity", ".Calculator");
        capabilities.setCapability("platformName", "Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        // implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @When("presiono el boton {string}")
    public void presionoElBoton(String nameControl) {

        switch (nameControl) {
            case "2":
                driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02")).click();
                // click button +
                driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add")).click();
                // click button 7
                driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07")).click();
                // click button =
                driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")).click();
        }
    }

    @Then("el resultado deberia ser: {}")
    public void elResultadoDeberiaSer(String expectedResult) {
        //explicit
        WebDriverWait explicitWait = new WebDriverWait(driver, 15);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.calculator2:id/formula")));

        // verification result
        String actualResult = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
        Assertions.assertEquals(expectedResult, actualResult, "ERROR! la suma fue incorrecta");
    }
}






