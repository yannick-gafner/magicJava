package apiTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {

	private String url;

	public Request(String url) {
		this.url = url;
	}

	public String sendRequest(String params) throws IOException {
		String returnString = "";
		// Make a URL to the web page
		URL url = new URL(this.url + params);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36");
		conn.setRequestMethod("GET");
		conn.connect();
		int responsecode = conn.getResponseCode();
		if (responsecode != 200) {
			throw new RuntimeException("HttpResponseCode: " + responsecode);
		} else {
			@SuppressWarnings("resource")
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				returnString += inputLine;
			in.close();
		}
		return (returnString);
	}

}