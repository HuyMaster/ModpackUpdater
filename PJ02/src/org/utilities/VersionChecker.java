package org.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.machine.fileReader;

public class VersionChecker {
	public static boolean start() {
		boolean OldVersion = true;
		Pattern pattern = Pattern.compile("\\d{1,}[.]\\d{1,}[.]\\d{1,}$");
		Pattern major = Pattern.compile("^\\d{1,}");
		Pattern minor = Pattern.compile("[.]\\d{1,}[.]");
		String temp;
		int maj = 0, mino = 0, bugf = 0;
		try {
			String version = null;
			URL url = new URL("https://raw.githubusercontent.com/HuyMaster/ModpackUpdater/main/program.ver");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				Matcher matcher_v = pattern.matcher(inputLine);
				if (matcher_v.find()) {
					version = inputLine.substring(matcher_v.start(),matcher_v.end());
				}
				
				Matcher matcher_ma = major.matcher(version);
				if (matcher_ma.find()) {
					maj = Integer.parseInt(version.substring(matcher_ma.start(), matcher_ma.end()));
				}
				
				Matcher matcher_mi = minor.matcher(inputLine);
				if (matcher_mi.find()) {
					temp = version.substring(matcher_mi.start(), matcher_mi.end());
					mino = Integer.parseInt(temp.substring(temp.indexOf('.')+1, temp.lastIndexOf('.')));
				}
				
				bugf = Integer.parseInt(version.substring(version.lastIndexOf('.') + 1));
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("Lastest verion: %s.%s.%s\n", maj, mino, bugf);
		String localver =  fileReader.readVersion();
		int[] lver = {
				Integer.parseInt(localver.substring(0, localver.indexOf('.'))),
				Integer.parseInt(localver.substring(localver.indexOf('.') + 1, localver.lastIndexOf('.'))),
				Integer.parseInt(localver.substring(localver.lastIndexOf('.') + 1))
		};
		if (maj > lver[0]) {
			OldVersion = true;
		} else {
			if (mino > lver[1]) {
				OldVersion = true;
			} else {
				if (bugf > lver[2]) {
					OldVersion = true;
				} else {
					OldVersion = false;
				}
			}
		}
		System.out.println(OldVersion);
		return OldVersion;
	}
}
