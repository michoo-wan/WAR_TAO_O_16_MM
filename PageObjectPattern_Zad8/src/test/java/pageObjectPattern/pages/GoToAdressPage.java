package pageObjectPattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoToAdressPage {
    private static WebDriver driver;
    @FindBy(id = "addresses-link")
    WebElement informationButton;
    public GoToAdressPage(WebDriver driver) {
        GoToAdressPage.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void goToAdressPage() {
        informationButton.click();
    }
}

