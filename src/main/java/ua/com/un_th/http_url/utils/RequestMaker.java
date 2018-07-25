package ua.com.un_th.http_url.utils;

import com.ebay.xcelite.column.Col;
import ua.com.un_th.http_url.ExitException;
import ua.com.un_th.http_url.data_containers.RequestNode;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class RequestMaker {
    String userNameAndPasswd;
    private LoadRequestParams loader;
    private String postUrl;
    private HttpUrlRequest httpUrlRequest;

    public RequestMaker(Collection<RequestNode> requestMap) throws ExitException {
        this.loader = new LoadRequestParams();
        this.postUrl = loader.getUrlConnect();
        this.userNameAndPasswd = loader.getUserNameAndPasswd();
    }

    public Map<String, String>  sendRequest()  {
        return Collections.emptyMap();
    }

}
