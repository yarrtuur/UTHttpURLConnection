package ua.com.un_th.http_url;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class HttpUrlConnect {
    URL myUrl;
    HttpURLConnection myUrlCon;
   // String userName = "test_api_user", password = "C8v20gAdHjig3LMRWGhm5PK1G00v08V1";

    public String post(String postUrl, String urlParameters) throws Exception {
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
        this.sendData(myUrlCon, postData);
        return this.read(myUrlCon.getInputStream());
    }

    protected void sendData(HttpURLConnection con, byte[] postData) throws IOException {
        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.write(postData);
            wr.flush();
        } catch (IOException ex) {
            throw ex;
        }
    }

    private String read(InputStream is) throws IOException {
        StringBuilder body = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            while (reader.ready()) {
                body.append(reader.readLine());
            }
            return body.toString();
        } catch (Exception ex) {
            throw ex;
        }
    }

}