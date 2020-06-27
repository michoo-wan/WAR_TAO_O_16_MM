package zadDom2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
//tu nie mogłem trafić w guziki i leci na pałę dalej-dalej-dalej
public class PurchaseProcessor {
    private static WebDriver driver;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement proccedButton;

    @FindBy(xpath = "//button[@name='confirm-addresses']")
    WebElement continueButton;

    @FindBy(className = "custom-radio float-xs-left")
    List<WebElement> shippingOpts;

    @FindBy(xpath = "//button[@name='confirmDeliveryOption']")
    WebElement confirmButton;

    @FindBy(className = "payment-options")
    List<WebElement> paymentOpt;

    @FindBy(id = "payment-option-1")
    WebElement paymentOpt2hadrcoded;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement conditionsCheckbox;

    @FindBy(id = "payment-confirmation")
    WebElement orderWithObligationButton;

    public PurchaseProcessor(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void purchaseFinalizer(){
        proccedButton.click();
        continueButton.click();
        //shippingOpts.get(1).click();
        confirmButton.click();
        //paymentOpt.get(1).click();
        paymentOpt2hadrcoded.click();
        conditionsCheckbox.click();
        orderWithObligationButton.click();
    }
}