package zadDom2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//to jest kopia 'headerComponent' zajęć
public class OpenLoginPage {
    private static WebDriver driver;

    @FindBy(xpath = "//*[@class='user-info']")
    WebElement userName;

    public OpenLoginPage(WebDriver driver) {
        zadDom2.pages.OpenLoginPage.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void goToLoginForm() {
        userName.click();
    }
}
