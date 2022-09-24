package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.util.List;

public class IndexPage extends BasePage {

    final String SLIDER_XPATH = "//app-home-slider//a";
    public List<WebElement> allLinks = Driver.getDriver().findElements(By.xpath((SLIDER_XPATH)));

}
