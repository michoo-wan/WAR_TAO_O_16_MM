package zadDom1.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/zadDom1/features", glue = "zadDom1.stepDefs", plugin = {"pretty", "html:out"})
public class Zad1Runner {}


