package ua.com.un_th.http_url;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpUrlRequest {
    private HttpURLConnection myUrlCon;
    private URL myUrl;

    public Map<String, String> postRequest(String postUrl, String urlParameters) throws ExitException {
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        try {
            myUrl = new URL(postUrl);
            myUrlCon = (HttpURLConnection) myUrl.openConnection();
            setMyUrlConProperties(postDataLength);
            sendData(myUrlCon, postData);
            return receiveData(myUrlCon.getInputStream());
        } catch (IOException | ExitException ex) {
            throw new ExitException(ex.getMessage());
        }
    }

    private void setMyUrlConProperties(int postDataLength) throws ProtocolException {
        myUrlCon.setRequestMethod("POST");
        myUrlCon.setDoOutput(true);
        myUrlCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        myUrlCon.setRequestProperty("charset", "utf-8");
        myUrlCon.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        myUrlCon.setUseCaches(false);
    }

    protected void sendData(HttpURLConnection con, byte[] postData) throws IOException {
        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.write(postData);
            wr.flush();
        } catch (IOException ex) {
            throw ex;
        }
    }

    private Map<String, String> receiveData(InputStream in) throws ExitException {
        StringBuilder sb = new StringBuilder();
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))
        ) {
            while (reader.ready()) {
                sb.append(reader.readLine());
            }
        } catch (IOException ex) {
            throw new ExitException(ex.getMessage());
        }
        return makeResponseMap(sb.toString());
    }

    private Map<String, String> makeResponseMap(String responseLine) {
        String[] divideResponse = responseLine.split("\\&");
        Map<String, String> responseMap = new HashMap<>();
        for(String step : divideResponse) {
            String[] divStep = step.split("=");
            if(divStep.length > 1) {
                responseMap.put(divStep[0], divStep[1]);//todo if not [1] data? then intead null
            }else{
                responseMap.put(divStep[0], null);
            }
        }
        return responseMap;
    }

}