package zadDom1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPageChooser {

    private static WebDriver driver;

    @FindBy(id = "address-link")
    WebElement createNewAddressButton;

    @FindBy(id = "addresses-link")
    WebElement goToAddressesButton;

    @FindBy(xpath = "//*[@data-link-action='add-address']")
    WebElement createNextAddressButton;


    public AddressPageChooser(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//funkcja sprawdza, czy istnieje link do nowego adresu i jeśli nie ma (bo już jest dodany), to klika w 2 linki, żeby dodać kolejny
    public void createOrAddAddress() {
        boolean isPresent;
        try {
            driver.findElement(By.id("address-link"));
            isPresent = true;
        } catch (NoSuchElementException e) {
            isPresent = false;
        }
        if (isPresent) {
            System.out.println("address not there");
            createNewAddressButton.click();
        } else {
            System.out.println("address already there");
            goToAddressesButton.click();
            createNextAddressButton.click();
        }
    }
}