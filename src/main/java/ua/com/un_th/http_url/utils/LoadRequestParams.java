package ua.com.un_th.http_url.utils;

import com.ebay.xcelite.Xcelite;
import com.ebay.xcelite.reader.SheetReader;
import com.ebay.xcelite.sheet.XceliteSheet;
import ua.com.un_th.http_url.ExitException;
import ua.com.un_th.http_url.data_containers.DataRequestNode;

import java.io.File;
import java.util.Collection;

public class LoadRequestParams {
    private static final String CONFIG_REQUEST_DATA = "requestFile.xlsx";
    private ConnectionProperties connectionProperties;
    private Collection<DataRequestNode> requestList;

    public LoadRequestParams() throws ExitException {
        connectionProperties = new ConnectionProperties();
        getRequestData();
    }

    private void getRequestData() throws ExitException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        try {
            Xcelite xcelite = new Xcelite(new File(classloader.getResource(CONFIG_REQUEST_DATA).getFile()));
            XceliteSheet sheet = xcelite.getSheet("request");
            SheetReader<DataRequestNode> reader = sheet.getBeanReader(DataRequestNode.class);
            requestList = reader.read();
        } catch (Exception e) {
            throw new ExitException("No file " + CONFIG_REQUEST_DATA + " found in " + e.getMessage());
        }
    }

    public Collection<DataRequestNode> getRequestList() {
        return requestList;
    }

    public String getUrlConnect() {
        return connectionProperties.getConnUrlConnect();
    }

    public String getUserNameAndPasswd() {
        StringBuilder sb = new StringBuilder();
        return sb.append("&userName=").append(connectionProperties.getConnUserName())
                .append("&password=").append(connectionProperties.getConnPasswd()).toString();
    }
}
