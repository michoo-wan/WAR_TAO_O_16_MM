package zadDom2.pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;

//funkcja inspirowana internetem xD, działa nieźle chociaż wolałbym żeby brała element strony a nie ekran
public class ScreenShot {

    public void takeScreenCapture(WebDriver webdriver, String screenFilePath) throws Exception{
        //Exception wymusza FileUtils
        TakesScreenshot screenCapture = ((TakesScreenshot)webdriver);
        //deklaracje z biblioteki Selenium
        File screenFile = screenCapture.getScreenshotAs(OutputType.FILE);
        File screenFileLocation = new File(screenFilePath);
        FileUtils.copyFile(screenFile, screenFileLocation);
        //zapis pliku FileUtils
    }
}