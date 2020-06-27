package zadDom2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ItemChooser {
    private static WebDriver driver;

    @FindBy(xpath = "//article")
    List<WebElement> searchedItems;
    WebElement tempElement;

    String itemFromSearchResult;

    public ItemChooser(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //z listy wyników wyszukiwania Gherkinowego 'thing' pobiera tekst z elementów i jeśli jest tam Gherkinowy 'item' to klika
    public void pickItemFromList(String theItem){
    System.out.println(theItem);
    for (int i = 0; i < searchedItems.size(); i++) {
            itemFromSearchResult = searchedItems.get(i).getText();
        System.out.println(itemFromSearchResult);
        if (itemFromSearchResult.contains(theItem)) {
            tempElement = searchedItems.get(i);
            tempElement.click();
        }
    }
    }
}
