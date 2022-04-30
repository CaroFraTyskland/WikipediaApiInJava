package helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestHelper {

    /**
     * Makes the get request to the API and returns the response.
     *
     * @param urlString the URL for the request
     * @return the response
     */
    public static String makeGetRequest(String urlString) {
        String response = null;

        try {
            URL url = new URL(urlString);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            response = reader.readLine();
            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}