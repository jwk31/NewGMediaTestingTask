package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class SliderTests extends BaseTest{

    @Test
    public void TestAllLinks() {
        final String LINKS_ATTRIBUTE = "href";
        final String SLIDER_XPATH = "//app-home-slider//a";

        List<WebElement> allLinks = Driver.getDriver().findElements(By.xpath((SLIDER_XPATH)));

        for(WebElement link:allLinks){
            try {
                String urlLink = link.getAttribute(LINKS_ATTRIBUTE);
                URL url = new URL(urlLink);

                HttpURLConnection connection = helper.httpURLConnection(url);
//                connection.setConnectTimeout(5000);
                connection.connect();

                System.out.println(urlLink+" - "+connection.getResponseMessage());
                Assert.assertTrue(connection.getResponseCode()<400, connection.getResponseMessage());

            } catch (Exception e) {
            }
        }

    }
}
