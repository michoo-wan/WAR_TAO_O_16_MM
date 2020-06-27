package zadDom1.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddressCheck {
    private static WebDriver driver;

    @FindBy(css = ".alert.alert-success")
    WebElement successInformation;

    @FindBy(xpath = "//address")
    List<WebElement> addressList;

    public AddressCheck(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUpdateInformation() {
        return successInformation.getText();
    }
    public void isAddressCorrect(String firstname, String lastname, String address, String city, String postcode) {
        WebElement lastAddedAddress = addressList.get(addressList.size() - 1);
        Assert.assertTrue(lastAddedAddress.getText().contains(firstname));
        Assert.assertTrue(lastAddedAddress.getText().contains(lastname));
        Assert.assertTrue(lastAddedAddress.getText().contains(address));
        Assert.assertTrue(lastAddedAddress.getText().contains(city));
        Assert.assertTrue(lastAddedAddress.getText().contains(postcode));
    }
}
