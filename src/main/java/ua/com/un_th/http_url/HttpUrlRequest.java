package ua.com.un_th.http_url;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpUrlRequest {
    URL myUrl;
    HttpURLConnection myUrlCon;
   // String userName = "test_api_user", password = "C8v20gAdHjig3LMRWGhm5PK1G00v08V1";

    public void post(String postUrl, String urlParameters) throws Exception {
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;

        myUrl = new URL(postUrl);
        myUrlCon = (HttpURLConnection) myUrl.openConnection();

        myUrlCon.setRequestMethod("POST");
        myUrlCon.setDoOutput(true);
        myUrlCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        myUrlCon.setRequestProperty("charset", "utf-8");
        myUrlCon.setRequestProperty("Content-Length", Integer.toString(postDataLength));

        myUrlCon.setUseCaches(false);
        sendData(myUrlCon, postData);
        read(myUrlCon);
    }

    protected void sendData(HttpURLConnection con, byte[] postData) throws IOException {
        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.write(postData);
            wr.flush();
        } catch (IOException ex) {
            throw ex;
        }
    }

    private void read(HttpURLConnection myUrlCon) throws IOException {
        Map<String, List<String>> myMap = myUrlCon.getHeaderFields();
        Set<String> myField = myMap.keySet();
        System.out.println("\nДалее следует заголовок:");

        // Вывести все ключи и значения из заголовка
        for(String k : myField) {
            System.out.println("Ключ: " + k + " Значение: "
                    + myMap.get(k));
        }
    }

}