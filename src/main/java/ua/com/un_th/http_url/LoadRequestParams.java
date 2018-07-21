package ua.com.un_th.http_url;

import com.ebay.xcelite.Xcelite;
import com.ebay.xcelite.reader.SheetReader;
import com.ebay.xcelite.sheet.XceliteSheet;

import java.io.File;
import java.util.Collection;

public class LoadRequestParams {
	private ConnectionProperties connectionProperties;
	private Collection<DataNode> requestList;

	public LoadRequestParams() throws ExitException {
		connectionProperties = new ConnectionProperties();
		getRequestData();
	}

	public Collection<DataNode> getRequestList() {
		return requestList;
	}

	private void getRequestData() {
		Xcelite xcelite = new Xcelite(new File("requestFile.xlsx"));
		XceliteSheet sheet = xcelite.getSheet("request");
		SheetReader<DataNode> reader = sheet.getBeanReader(DataNode.class);
		requestList = reader.read();
	}

	public String getUrlConnect() {
		return connectionProperties.getConnUrlConnect();
	}

}
