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
    private ConnectionProperties connectionProperties;

    public LoadRequestParams() throws ExitException {
        connectionProperties = new ConnectionProperties();
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
