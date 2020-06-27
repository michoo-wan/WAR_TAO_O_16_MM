package zadDom2.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class ItemVariantSelector {
    private static WebDriver driver;

    @FindBy(name = "group[1]")
    WebElement sizeLetter;

    @FindBy(name = "qty")
    WebElement itemAmountField;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    WebElement goToCheckout;

    @FindBy(xpath = "//button[@class='close']")
    WebElement getGoToCheckoutPopup;

    @FindBy(id = "_desktop_cart")
    WebElement goToCart;

    public ItemVariantSelector(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //te funkcje działają osobno od siebie, ale razem wpisująca liczbę (selectAmount) się kasuje - do poprawki
    public void selectSize(String itemSize) {
        sizeLetter.click();
        Select chooseSize = new Select(sizeLetter);
        chooseSize.selectByVisibleText(itemSize);
    }
    public void selectAmount(String itemAmount) {
        itemAmountField.click();
        itemAmountField.clear();
        itemAmountField.sendKeys(itemAmount);
        itemAmountField.sendKeys(Keys.ENTER);
    }
    public void proccedToCheckout(){
        //goToCheckout.click();
        goToCart.click(); //[down] dlatego po zamknięciu popupu idzie na pałę do koszyka

    }
    public void proccedToCheckoutPopup(){ //musiałem dopisać zamykacz popupu, bo nie mogłem trafić w guzik, żeby szedł dalej [up]
        getGoToCheckoutPopup.click();

    }
}