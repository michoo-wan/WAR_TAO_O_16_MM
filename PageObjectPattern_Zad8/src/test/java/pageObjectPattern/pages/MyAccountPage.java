package pageObjectPattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private static WebDriver driver;
    @FindBy(id = "identity-link")
    WebElement informationButton;
    public MyAccountPage(WebDriver driver) {
        MyAccountPage.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void goToInformationPage() {
        informationButton.click();
    }
}