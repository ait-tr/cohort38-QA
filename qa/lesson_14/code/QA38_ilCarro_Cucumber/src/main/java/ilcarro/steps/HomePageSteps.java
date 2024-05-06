package ilcarro.steps;

import com.ilcarro.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.ilcarro.pages.BasePage.driver;
import static com.ilcarro.pages.BasePage.wait;

public class HomePageSteps {

    @Given("User launch Chrome browser")
    public void openBrowser() {
        new HomePage(driver, wait).openBrowserInPage();
    }

    @When("User open ilcarro Home Page")
    public void openHomePage() {
        new HomePage(driver, wait).openUrl();
    }

    @Then("User checked Home Page title is displayed")
    public void checkTitle() {
        new HomePage(driver, wait).isHomePageTitlePreset();
    }

    @And("User quites browser")
    public void quitDriver() {
        new HomePage(driver, wait).closeBrowser();
    }
}
