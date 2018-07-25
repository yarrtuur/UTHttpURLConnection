package ua.com.un_th.http_url.data_containers;

import com.ebay.xcelite.Xcelite;
import com.ebay.xcelite.annotations.AnyColumn;
import com.ebay.xcelite.converters.CSVColumnValueConverter;
import com.ebay.xcelite.reader.SheetReader;
import com.ebay.xcelite.sheet.XceliteSheet;
import ua.com.un_th.http_url.ExitException;
import ua.com.un_th.http_url.utils.HttpUrlRequest;
import ua.com.un_th.http_url.utils.LoadRequestParams;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class RequestReader {
    private static final String CONFIG_REQUEST_DATA = "requestFile.xlsx";
    private LoadRequestParams loader;
    private String postUrl;
    String userNameAndPasswd;


    public RequestReader() throws ExitException {
        this.loader = new LoadRequestParams();
        this.postUrl = loader.getUrlConnect();
        this.userNameAndPasswd = loader.getUserNameAndPasswd();

    }

    private void getRequestData() throws ExitException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try {
            Xcelite xcelite = new Xcelite(new File(classloader.getResource(CONFIG_REQUEST_DATA).getFile()));
            XceliteSheet sheet = xcelite.getSheet("request");
            SheetReader<RequestNode>  reader = sheet.getBeanReader(RequestNode.class);
            reader.skipHeaderRow(true);
              reader.read();
        } catch (Exception e) {
            throw new ExitException(e.getMessage());
        }
    }


}
