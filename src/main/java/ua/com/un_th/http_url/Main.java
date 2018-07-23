package ua.com.un_th.http_url;

import ua.com.un_th.http_url.data_containers.DataPairMapMaker;
import ua.com.un_th.http_url.data_containers.DataRequestNode;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {

            DataPairMapMaker dataPairMapMaker = new DataPairMapMaker();
            Map<DataRequestNode, Map<String, String>> pairMap = dataPairMapMaker.getDataPairMap();

            for (Map.Entry<DataRequestNode, Map<String, String>> entry : pairMap.entrySet()) {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


