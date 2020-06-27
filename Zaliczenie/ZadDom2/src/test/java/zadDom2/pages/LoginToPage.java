package zadDom2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToPage {
    private static WebDriver driver;

    @FindBy(name = "email")
    WebElement loginInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(id = "submit-login")
    WebElement signInButton;

    public LoginToPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//logowanie mam na pałę od początku zajęć niezmienione
    public void loginAs(String email, String password) {
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(email);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        signInButton.click();
    }
}