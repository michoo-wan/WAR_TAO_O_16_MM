package zadDom1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenLoginPage {
    private static WebDriver driver;

    @FindBy(xpath = "//*[@class='user-info']")
    WebElement userName;

    public OpenLoginPage(WebDriver driver) {
        OpenLoginPage.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void goToLoginForm() {
        userName.click();
    }
}
