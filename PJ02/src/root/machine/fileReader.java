package root.machine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import root.utilities.sleep;

public class fileReader {
	public static final String filepath = System.getProperty("user.home") + "\\Desktop\\pack_of_file\\key";
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
			System.out.println("");
			System.err.println("\t/ / / / File 'key' not found / / / /\n");
			System.out.println("");
			sleep.sleep(5);
		}
		catch (IOException e) {
			System.err.println("Can't access to file\n");
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
				System.out.println("Work done");
				System.out.println("Deleting unused file");
				sleep.sleep(5);
				fileDestroy.delDir(System.getProperty("user.home") + "\\Desktop\\pack_of_file");
			}
		} catch (Exception e) {
		}
	}
}