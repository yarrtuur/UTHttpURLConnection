package ua.com.un_th.http_url.utils;

import com.ebay.xcelite.Xcelite;
import com.ebay.xcelite.reader.SheetReader;
import com.ebay.xcelite.sheet.XceliteSheet;
import ua.com.un_th.http_url.ExitException;
import ua.com.un_th.http_url.data_containers.RequestNode;
import ua.com.un_th.http_url.utils.LoadRequestParams;

import java.io.File;
import java.util.Collection;

public class RequestReader {
    private static final String CONFIG_REQUEST_DATA = "requestFile.xlsx";
    String userNameAndPasswd;
    private LoadRequestParams loader;
    private String postUrl;


    public RequestReader() throws ExitException {
        this.loader = new LoadRequestParams();
        this.postUrl = loader.getUrlConnect();
        this.userNameAndPasswd = loader.getUserNameAndPasswd();

    }

    public Collection<RequestNode> getRequestData() throws ExitException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try {
            Xcelite xcelite = new Xcelite(new File(classloader.getResource(CONFIG_REQUEST_DATA).getFile()));
            XceliteSheet sheet = xcelite.getSheet("request");
            SheetReader<RequestNode> reader = sheet.getBeanReader(RequestNode.class);
            Collection<RequestNode> requestNode = reader.read();
            return requestNode;
        } catch (Exception e) {
            throw new ExitException(e.getMessage());
        }
    }


}
