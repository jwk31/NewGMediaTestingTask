package Helper;

import dataProviders.ConfigReader;
import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HelperMethod {

    public HttpURLConnection httpURLConnection(URL url) throws IOException {
        String auth = ConfigReader.getProperty("login") + ":" + ConfigReader.getProperty("password");
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes());
        String authHeaderValue = "Basic " + new String(encodedAuth);

        HttpURLConnection connection=(HttpURLConnection)url.openConnection();
        connection.setRequestProperty("User-Agent","Chrome/105.0.5195.127");
        connection.setRequestProperty("Authorization", authHeaderValue);
        return connection;
    }
}
