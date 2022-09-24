package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;

public class SliderTests extends BaseTest {

    @Test
    public void TestAllLinks() {

        for (WebElement link : indexPage.allLinks) {
            try {
                String urlLink = link.getAttribute("href");
                URL url = new URL(urlLink);

                HttpURLConnection connection = helper.httpURLConnection(url);
//                connection.setConnectTimeout(5000);
                connection.connect();

                System.out.println(urlLink + " - " + connection.getResponseMessage());
                Assert.assertEquals(HttpURLConnection.HTTP_OK, connection.getResponseCode());
                Assert.assertFalse(urlLink.contains("/404"));

            } catch (Exception e) {
            }
        }

    }
}
