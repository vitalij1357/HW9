package HW;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String url = httpStatusChecker.getStatusImage(code);

        try {
            Connection.Response response = Jsoup.connect(url).
                    ignoreContentType(true).
                    execute();

            try (InputStream is = response.bodyStream();
                 FileOutputStream fos = new FileOutputStream(code + ".jpg")) {
                byte[] buffer = new byte[4096];
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
