package ua.com.un_th.http_url.data_containers;

import ua.com.un_th.http_url.ExitException;
import ua.com.un_th.http_url.utils.HttpUrlRequest;
import ua.com.un_th.http_url.utils.LoadRequestParams;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataPairMapMaker {
    private Map<DataRequestNode, Map<String, String>> dataPairMap;
    private LoadRequestParams loader;


    public DataPairMapMaker() throws ExitException {
        this.dataPairMap = new LinkedHashMap<>();
        this.loader = new LoadRequestParams();
    }

    public Map<DataRequestNode, Map<String, String>> getDataPairMap() throws ExitException {
        String postUrl = loader.getUrlConnect();
        String userNameAndPasswd = loader.getUserNameAndPasswd();
        Map<String, String> requestList = loader.getRequestList() ;

        for (Map.Entry<String, String> requestFields : requestList.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append("&").append(requestFields.getKey()).append("=").append(requestFields.getValue())

                    .append(userNameAndPasswd);
            String urlParameters = sb.toString();
            HttpUrlRequest huc = new HttpUrlRequest();
            Map<String, String> responseFields = huc.postRequest(postUrl, urlParameters);
            dataPairMap.put(requestFields, responseFields);
        }
        return dataPairMap;
    }
}
