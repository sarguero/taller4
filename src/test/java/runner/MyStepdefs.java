package runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class MyStepdefs {

    /**
     * {int} --> remplaza a cualquier valor numerico
     * {string}--> remplaza a cada string en comillas -->"palabra"
     * {} --> remplaza a cualquier valor
     * {float}--> replaza a un valor flotante 6.55
     * {word}--> remplaza a una palabra
     */
   

    @When("seteo mi email: {string}")
    public void seteoMiEmailSary(String email) {
    }

    @And("seteo mi password: {int}")
    public void seteoMiPassword(int arg0) {
    }

    @And("hago click en el botón {word}")
    public void hagoClickEnElBotónLogin(String nombreBoton) {
    }

    @Then("yo deberia inciar sesison")
    public void yoDeberiaInciarSesison() {
    }
    @Then("yo no deberia iniciar sesion")
    public void yoNoDeberiaIniciarSesion() {
    }

    @And("los labels deberian ser mostrados")
    public void losLabelsDeberianSerMostrados(List<String> myLabels) {
        for ( String label:myLabels
        ) {
            System.out.println("labels: "+label);
        }
    }

    @Given("tengo acceso a facebook")
    public void tengoAccesoAFacebook() {
    }


    @Given("yo tengo acceso a facebook")
    public void yoTengoAccesoAFacebook() {

    }
}