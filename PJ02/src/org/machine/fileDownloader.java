package org.machine;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class fileDownloader {
	public static void start(URL url, String filename) {
		System.out.println("\t> Start download");
		try (InputStream in = url.openStream();
	            ReadableByteChannel rbc = Channels.newChannel(in);
	            FileOutputStream fos = new FileOutputStream(filename)) {
	            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	        } catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		System.out.println("\t> Download Success");
	}
}
