package zadDom1.stepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import zadDom1.pages.*;

import java.util.concurrent.TimeUnit;

public class StepdefsZad1 {

    WebDriver driver;
    LoginToPage loginToPage;
    OpenLoginPage openLoginPage;
    AddressPageChooser addressPageChooser;
    AddressPage addressPage;
    AddressCheck addressCheck;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl");

        openLoginPage = new OpenLoginPage(driver);
        loginToPage = new LoginToPage(driver);
        addressPageChooser = new AddressPageChooser(driver);
        addressPage = new AddressPage(driver);
        addressCheck = new AddressCheck(driver);
    }

    @Given("^User is logged in to shop account with \"(.*)\" and \"(.*)\"$")
    public void logUserToShopAccount(String emailAddress, String password) {

        openLoginPage.goToLoginForm();
        loginToPage.loginAs(emailAddress, password);
    }

    @When("^User opens delivery address form$")
    public void userOpensDeliveryAddressForm() {
        addressPageChooser.createOrAddAddress();
    }

    @And("^User enters \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEntersDeliveryData(String address, String lastname, String firstname, String city, String postcode) {
        addressPage.putAddressInfo(lastname, firstname, address, city, postcode);
        addressPage.chooseCountry();
        addressPage.saveAddress();
    }
    @Then("^User gets \"([^\"]*)\" message$")
    public void userGets(String successMsg) {
        Assert.assertEquals(successMsg, addressCheck.getUpdateInformation());
        System.out.println(successMsg);
    }

    @And("^User address data \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" is correct$")
    public void userAdressDataIsCorrect(String firstname, String lastname, String address, String city, String postcode) {
        addressCheck.isAddressCorrect(firstname, lastname, address, city, postcode);
    }


    @And("^User closes window$")
    public void userClosesWindow() {
        driver.close();
    }
}