package ua.com.un_th.http_url.utils;

import ua.com.un_th.http_url.ExitException;

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
        return sb.append("userName=").append(connectionProperties.getConnUserName())
                .append("&password=").append(connectionProperties.getConnPasswd()).toString();
    }
}
