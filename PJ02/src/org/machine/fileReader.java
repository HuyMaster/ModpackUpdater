package org.machine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.utilities.sleep;
import org.window.Dialog;

public class fileReader {
	public static final String filepath = System.getProperty("user.home") + "\\Desktop\\packer\\key";
	public static void Main() {
		String[] fileData = new String[Byte.MAX_VALUE];
		try {
			BufferedReader file = new BufferedReader(new FileReader(filepath));
			String cache;int i = 0;
			while (true) {
				if ((cache = file.readLine()) != null) {
					if (cache.equals("")) {
						fileData[i] = "-";
						i++;
					} else {
						fileData[i] = cache;
						i++;
					}
				} else {
					file.close();
					System.out.println("BufferedReader closed");
				}
			}
		} catch (FileNotFoundException e) {
			Dialog.Message("Kh\u00F4ng t\u00ECm th\u1EA5y file ch\u1EC9 d\u1EABn c\u00E0i \u0111\u1EB7t", "Th\u00F4ng b\u00E1o fR", 2);
			sleep.sleep(0);
		} catch (IOException e) {
			StackTraceElement[] a = e.getStackTrace();
			for (int i = 0; i < a.length; i++) {
				System.out.println(a[i]);
			}
		}
		
		char comma = ',';
		String cache = null;
		String fn = null;
		String ext = null;
		int act = 0;
		try {
			for (int i = 0; i < fileData.length; i++) {
				if (fileData[i].equals("-")) {System.out.println();} else {
					cache = fileData[i];
					int sep = cache.lastIndexOf(comma);
					if (sep < 1) {
					} else {
						fn = cache.substring(0, sep);
						ext = cache.substring(sep + 1);
						if (ext.equals("add")) {
							act = 1;
						} else {
							if (ext.equals("remove")) {
								act = 2;
							} else {
								act = 0;
							}
						}
						fileAction fileAction = new fileAction();
						sleep.sleep(1);
						fileAction.process(fn, act, (i + 1));
					}
				}
			}
		} catch (Exception e) {
		}
		fileDestroy.delDir(System.getProperty("user.home") + "\\Desktop\\packer");
		sleep.sleep(0);
	}
}
