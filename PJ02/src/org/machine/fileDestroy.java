package org.machine;

import java.io.File;

import org.utilities.sleep;

public class fileDestroy {
	public static boolean delDir(File path) {
		if (path.isDirectory()) {
			String[] list = path.list();
			for (int i = 0; i < list.length; i++) {
				boolean success = delDir (new File(path, list[i]));
	            if (!success) {
	               return success;
	            }
	            sleep.sleep(1);
			}
		}
		return path.delete();
	}
	public static boolean delDir(String rawpath) {
		File path = new File(rawpath);
		if (path.isDirectory()) {
			String[] list = path.list();
			for (int i = 0; i < list.length; i++) {
				boolean success = delDir (new File(path, list[i]));
	            if (!success) {
	               return success;
	            }
	            sleep.sleep(1);
			}
		}
		return path.delete();
	}
}
