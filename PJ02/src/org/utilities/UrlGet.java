package org.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlGet {
	public static URL start() {
		URL gurl = null;
		try {
			URL url = new URL("https://raw.githubusercontent.com/HuyMaster/ModpackUpdater/main/url");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				gurl = new URL(inputLine);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gurl;
	}
}
