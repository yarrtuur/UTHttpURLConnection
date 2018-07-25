package ua.com.un_th.http_url;

import ua.com.un_th.http_url.data_containers.RequestNode;
import ua.com.un_th.http_url.utils.RequestReader;

import java.util.Collection;


public class Main {
    public static void main(String[] args) {
        try {

            RequestReader requestReader = new RequestReader();
            Collection<RequestNode> collectionRequests = requestReader.getRequestData();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


