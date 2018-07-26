package ua.com.un_th.http_url;

import ua.com.un_th.http_url.data_containers.RequestNode;
import ua.com.un_th.http_url.utils.RequestDataReader;
import ua.com.un_th.http_url.utils.RequestHolder;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        try {

            RequestDataReader requestDataReader = new RequestDataReader("requestFile.xlsx");
            Collection<RequestNode> collectionRequests = requestDataReader.getRequestData();
            RequestHolder requestHolder = new RequestHolder(collectionRequests);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


