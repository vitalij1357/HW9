package org.example.hw;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.net.HttpURLConnection;

public class HttpStatusChecker {

    public String getStatusImage(int code) {
        try {
            String url = "https://http.cat/" + code + ".jpg";
            Connection.Response response = Jsoup.connect(url).
                    ignoreContentType(true).
                    execute();
            if (response.statusCode()==HttpURLConnection.HTTP_NOT_FOUND) {
                throw new Exception("Image not found " + code);
            }
            return url;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
