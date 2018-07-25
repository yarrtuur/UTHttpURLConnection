package ua.com.un_th.http_url;

import ua.com.un_th.http_url.data_containers.RequestReader;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            RequestReader requestReader = new RequestReader();
            ArrayList<String> reqMap = requestReader.getRequestMap();
            System.out.println(reqMap.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


