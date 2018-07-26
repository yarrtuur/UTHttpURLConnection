package ua.com.un_th.http_url.utils;

import com.ebay.xcelite.Xcelite;
import com.ebay.xcelite.reader.SheetReader;
import com.ebay.xcelite.sheet.XceliteSheet;
import ua.com.un_th.http_url.ExitException;
import ua.com.un_th.http_url.data_containers.RequestNode;

import java.io.File;
import java.util.Collection;

public class RequestDataReader {
    private String configRequestData;

    public RequestDataReader(String configRequestData) {
        this.configRequestData = configRequestData;
    }

    public Collection<RequestNode> getRequestData() throws ExitException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try {
            Xcelite xcelite = new Xcelite(new File(classloader.getResource(configRequestData).getFile()));
            XceliteSheet sheet = xcelite.getSheet("request");
            SheetReader<RequestNode> reader = sheet.getBeanReader(RequestNode.class);
            Collection<RequestNode> requestNode = reader.read();
            return requestNode;
        } catch (Exception e) {
            throw new ExitException(e.getMessage());
        }
    }


}
