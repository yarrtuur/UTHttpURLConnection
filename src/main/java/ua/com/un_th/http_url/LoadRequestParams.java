package ua.com.un_th.http_url;

import com.ebay.xcelite.Xcelite;
import com.ebay.xcelite.reader.SheetReader;
import com.ebay.xcelite.sheet.XceliteSheet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;

public class LoadRequestParams {
	private ConnectionProperties connectionProperties;
	private Collection<DataNode> requestList;
	private static final String CONFIG_REQUEST_DATA = "requestFile.xlsx";

	public LoadRequestParams() throws ExitException {
		connectionProperties = new ConnectionProperties();
		getRequestData();
	}

	private void getRequestData() throws ExitException {
		URL url;
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		try (
				InputStream in = classloader.getResourceAsStream(CONFIG_REQUEST_DATA)

		) {
			url = classloader.getResource("requestFile.xlsx");
			System.out.println(url);
		} catch (IOException | NullPointerException e) {
			throw new ExitException("No file .properties found in " + e.getMessage());
		}
		Xcelite xcelite = new Xcelite(new File(String.valueOf(url)));
		XceliteSheet sheet = xcelite.getSheet("request");
		SheetReader<DataNode> reader = sheet.getBeanReader(DataNode.class);
		requestList = reader.read();
	}

	public Collection<DataNode> getRequestList() {
		return requestList;
	}

	public String getUrlConnect() {
		return connectionProperties.getConnUrlConnect();
	}

}
