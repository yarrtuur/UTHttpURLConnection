package ua.com.un_th.http_url;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConnectionProperties {

	private Properties connProperties = new Properties();
	private static final String CONFIG_SQLCMD_PROPERTIES = "connect.properties";

	public ConnectionProperties() throws ExitException {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		try (
				InputStream in = classloader.getResourceAsStream(CONFIG_SQLCMD_PROPERTIES)
		) {
			connProperties.load(in);
		} catch (IOException | NullPointerException e) {
			throw new ExitException("No file .properties found in " + e.getMessage());
		}
	}

	public String getConnUserName() {
		return connProperties.getProperty("userName");
	}

	public String getConnPasswd() {
		return connProperties.getProperty("password");
	}

	public String getConnUrlConnect() {
		return connProperties.getProperty("urlConnect");
	}




}
