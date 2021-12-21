package runner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
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
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MyStepLista {
    private AppiumDriver driver;

    @Given("la aplicacion mi Lista esta abierta")
    public void laAplicacionMiListaEstaAbierta() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "Galaxy J8");
        capabilities.setCapability("appium:platformVersion", "10");
        capabilities.setCapability("appium:appPackage", "com.vrproductiveapps.whendo");
        capabilities.setCapability("appium:appActivity", ".ui.HomeActivity");
        capabilities.setCapability("platformName", "Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        // implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("presiono el boton agregar")
    public void presionoElBotonAgregar(Actividad actividad) {
        // click add activity
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        //set title
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(actividad.getTitulo());
        //set note
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(actividad.getNota());
        // click save
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
        }
@DataTableType
public Actividad convert (Map<String,String>entry){
        return new Actividad(entry.get("titulo"),entry.get("nota"));
}
    @Then("se deberia mostrar titulo {string} should be created")
    public void seDeberiaMostrarTituloShouldBeCreated(String nameNota) {
        Assertions.assertTrue(driver.findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_text")).isDisplayed(), "Error> La nota no fue creada");
    }
}
