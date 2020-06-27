package zadDom2.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
    private static WebDriver driver;

    @FindBy(className = "card")
    WebElement conformationMessage;

    @FindBy(xpath = "//html/body/main/section/div/div/section/section[2]/div/div/div[2]/ul/li[1]")
    WebElement orderDetails;

    String tempText;
    String[] ordersListPositions;
    String fileNameForScreenshot;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void conformationpage(String messageText){
        Assert.assertTrue(conformationMessage.getText().contains(messageText)); //tam jest sporo tekstu dlatego znajduje tylko Gherkinowe <message>CONFIRMED
    }
    public String orderNumberForFile(){
        tempText= orderDetails.getText(); //sztywny xpath do pozycji z listy z numerem zamówienia
        ordersListPositions = tempText.split(" "); //splitter tekstu tnie linię po spacjach
        fileNameForScreenshot = "/home/michalm/Obrazy/"+ordersListPositions[2]+".png"; //transformer nazwy i ścieżki pliku
        return fileNameForScreenshot;
    }
}
