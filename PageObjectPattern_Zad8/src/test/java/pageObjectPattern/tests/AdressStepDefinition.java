package pageObjectPattern.tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectPattern.pages.*;

import java.util.concurrent.TimeUnit;

public class AdressStepDefinition {
    LoginPage loginPage;
    WebDriver driver;
    HeaderComponent headerComponent;
    GoToAdressPage goToAdressPage;
    AdressPage adressPage;

    @Given("^User is logged in to CodersLab account$")
    public void userIsLooggedInToCodersLabShop() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        loginPage = new LoginPage(driver);
        headerComponent =new HeaderComponent(driver);
        goToAdressPage = new GoToAdressPage(driver);
        adressPage = new AdressPage(driver);
        loginPage.loginAs("michal.dobrzycki@coderslab.pl", "CodersLab");
    }
    @When("^User goes to UserAdressPage$")
    public void userGoesToUserInformationPage() {
        headerComponent.goToUserInformationView();
        goToAdressPage.goToAdressPage();
    }
    @And("^User puts new delivery address$")
    public void userChangesHisDeliveryAddress() {
        adressPage.setCreateNewAddressButton();
        adressPage.putAddressInfo("Zbigniew", "Zieba", "Dworcowa", "Kalisz", "00-555");
    }

    @And("^User saves information$")
    public void userSavesInfo() {
        adressPage.saveAddress();
    }

    @Then("^User sees \"([^\"]*)\"$")
    public void userSees(String message) {
        Assert.assertEquals(message, adressPage.getUpdateInformation());
    }

    @And("^User close window$")
    public void userCloseWindow() {
        driver.close();
    }

}