package zadDom2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemSearcher {
    private static WebDriver driver;

    @FindBy(name = "s")
    WebElement searchField;

    public ItemSearcher(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //najprostsze użycie wyszukiwarki na pałę
    public void searchForItem(String item){
        searchField.click();
        searchField.clear();
        searchField.sendKeys(item);
        searchField.submit();
    }
}