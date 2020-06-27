package zadDom1.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddressPage {
    private static WebDriver driver;

    @FindBy(id = "address-link")
    WebElement createNewAddressButton;

    @FindBy(id = "addresses-link")
    WebElement goToAddressesButton;

    @FindBy(xpath = "//*[@data-link-action='add-address']")
    WebElement createNextAddressButton;

    @FindBy(name = "firstname")
    WebElement firstnameInput;

    @FindBy(name = "lastname")
    WebElement lastnameInput;

    @FindBy(name = "address1")
    WebElement address1Input;

    @FindBy(name = "city")
    WebElement cityInput;

    @FindBy(name = "postcode")
    WebElement postcodeInput;

    @FindBy(name = "id_country")
    WebElement countryList;

    @FindBy(css = ".btn.btn-primary.float-xs-right")
    WebElement submitButton;

    @FindBy(css = ".alert.alert-success")
    WebElement successInformation;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void putAddressInfo(String firstname, String lastname, String address1, String city, String postcode) {
        firstnameInput.click();
        firstnameInput.clear();
        firstnameInput.sendKeys(firstname);

        lastnameInput.click();
        lastnameInput.clear();
        lastnameInput.sendKeys(lastname);

        address1Input.click();
        address1Input.clear();
        address1Input.sendKeys(address1);

        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);

        postcodeInput.click();
        postcodeInput.clear();
        postcodeInput.sendKeys(postcode);
    }
    public void chooseCountry(){
            countryList.click();
        Select chooseCountry = new Select(countryList);
        chooseCountry.selectByVisibleText("United Kingdom");
    }

    public void saveAddress() {
        submitButton.click();
    }

    public String getUpdateInformation() {
        return successInformation.getText();
    }
}