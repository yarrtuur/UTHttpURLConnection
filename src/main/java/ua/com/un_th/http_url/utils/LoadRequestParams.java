package ua.com.un_th.http_url.utils;

import com.ebay.xcelite.Xcelite;
import com.ebay.xcelite.annotations.AnyColumn;
import com.ebay.xcelite.converters.CSVColumnValueConverter;
import com.ebay.xcelite.reader.SheetReader;
import com.ebay.xcelite.sheet.XceliteSheet;
import ua.com.un_th.http_url.ExitException;

import java.io.File;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class LoadRequestParams {
    private static final String CONFIG_REQUEST_DATA = "requestFile.xlsx";
    private ConnectionProperties connectionProperties;
    @AnyColumn(converter = CSVColumnValueConverter.class, as = LinkedHashMap.class)
    private Map<String, String> requestList;

    public LoadRequestParams() throws ExitException {
        connectionProperties = new ConnectionProperties();
        getRequestData();
    }

    private void getRequestData() throws ExitException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        try {
            Xcelite xcelite = new Xcelite(new File(classloader.getResource(CONFIG_REQUEST_DATA).getFile()));
            XceliteSheet sheet = xcelite.getSheet("request");
            SheetReader<Collection<Object>> reader = sheet.getSimpleReader();
            reader.skipHeaderRow(true);
            requestList = (Map) reader.read();
        } catch (Exception e) {
            throw new ExitException("No file " + CONFIG_REQUEST_DATA + " found in " + e.getMessage());
        }
    }

    public Map<String, String> getRequestList() {
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
