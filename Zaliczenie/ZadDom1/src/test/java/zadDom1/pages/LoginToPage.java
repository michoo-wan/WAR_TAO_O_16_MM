package zadDom1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginToPage {
    private static WebDriver driver; //tylko konstrukcja pola

    public LoginToPage(WebDriver driver) { //informacja o sterowaniu stroną porusza się między klasami
        this.driver = driver;
    }

    public void loginAs(String email, String password) {
        WebElement loginInput = driver.findElement(By.name("email"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }
//    public String getLoggedUsername() {
//        WebElement userName = driver.findElement(By.xpath("//a[@class='account']"));
//        return userName.getText();
//    }
}