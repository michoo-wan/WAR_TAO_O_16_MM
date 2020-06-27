package zadDom2.stepDefs;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import zadDom2.pages.*;

import java.util.concurrent.TimeUnit;

public class StepDefsZad2 {

    WebDriver driver;
    LoginToPage loginToPage;
    OpenLoginPage openLoginPage;
    ItemSearcher itemSearcher;
    ItemChooser itemChooser;
    ItemVariantSelector itemVariantSelector;
    PurchaseProcessor purchaseProcessor;
    ConfirmationPage confirmationPage;
    ScreenShot screenShot;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        openLoginPage = new OpenLoginPage(driver);
        loginToPage = new LoginToPage(driver);
        itemSearcher = new ItemSearcher(driver);
        itemChooser = new ItemChooser(driver);
        itemVariantSelector = new ItemVariantSelector(driver);
        purchaseProcessor = new PurchaseProcessor(driver);
        confirmationPage = new ConfirmationPage(driver);
        screenShot = new ScreenShot();
    }

    @Given("^User is logged in to shop account with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userIsLoggedIn(String emailAddress, String password) {
        openLoginPage.goToLoginForm();  //idzie do strony logowania, bo start na głównej
        loginToPage.loginAs(emailAddress, password); //logowanie z poprzedniego zadania
    }

    @When("^User searches shop for a \"([^\"]*)\"$")
    public void userSearchesItem(String thing) {

        itemSearcher.searchForItem(thing); //po zalogowaniu szuka przedmiotu 'thing' w Gherkin
    }

    @And("^Product catalogue page for \"([^\"]*)\" is opened$")
    public void productCataloguePageIsOpened(String item) {

        itemChooser.pickItemFromList(item); //przeszukuje wyniki wyszukiwania w celu znalezienia właściwego przedmiotu 'item'
    }

    @And("^User chooses \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userChoosesSizeAndAmount(String itemSize, String itemAmount) {

        itemVariantSelector.selectSize(itemSize); //wybieracze nie działają do końca dobrze, wzajemnie sobie przeszkadzają
        itemVariantSelector.selectAmount(itemAmount);
    }

    @And("^User adds item to shopping cart and proceeds to checkout$")
    public void userProceedsToCheckout() {

        itemVariantSelector.proccedToCheckoutPopup(); //tu na pałę z braku czasu na szukanie pozycji zamyka popup
        itemVariantSelector.proccedToCheckout(); //i idzie do koszyka
    }

    @And("^User chooses delivery address and <pickup> method and <payment> method and confirms purchase$")
    public void userChoosesDeliveryAddressAndPickupMethodAndPaymentMethod() {

        purchaseProcessor.purchaseFinalizer(); //to tylko przeklikuje
    }

    @Then("^Confirmation page is displays \"([^\"]*)\"$")
    public void confirmationPageIsDisplayed(String confMsg) {
        confirmationPage.conformationpage(confMsg); //sprawdza asercją czy jest info z potwierdzeniem
    }

    @And("^Screenshot is taken with order ID number$")
    public void screenshotIsTakenWithOrderIDNumber() throws Exception{
        confirmationPage.orderNumberForFile();
        screenShot.takeScreenCapture(driver, confirmationPage.orderNumberForFile()); //robi screenshota o nazwie zamówienia
    }

    @And("^User closes window$")
    public void userClosesWindow() {
        driver.close();
    }
}