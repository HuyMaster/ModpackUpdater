package org.machine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.utilities.sleep;
import org.window.Dialog;

public class fileAction {
	private static final Path modPath = Paths.get((System.getProperty("user.home")) + "\\AppData\\Roaming\\.minecraft\\mods");
	/**
	 * 
	 * @param filename
	 *  : Including file extensions. Example: abc.xyz, ab_c123.jar
	 * @param action
	 *  : 1=add mod , 2=remove mod , other is unknown
	 *  @param line
	 *  : line number
	 */
	public void process(String filename, int action, Object line) {
		switch (action) {
			case 1 :
				add(filename, line, "ADD");
				break;
			case 2 :
				remove(filename, line, "REMOVE");
				break;
			default :
				System.out.printf("Line %s: Unknown Action\n", line);
				break;
		}
	}
	
	private void add(String filename, Object line, Object action) {
		System.out.println("=============================================================");
		System.out.printf("Line %s: Start %s " + filename + " to mods dir\n", line, action);
		Path sourcePath = Paths.get(System.getProperty("user.home") + "\\Desktop\\packer\\" + filename);
		Path destPath = Paths.get(modPath + "\\" + filename);
		try {
			Files.move(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			Dialog.Message("L\u1ED7i khi truy nh\u1EADp t\u1EC7p\n" + filename, "Th\u00F4ng b\u00E1o fA", 0);
		}
		System.out.println("=============================================================");
		sleep.sleep(1);
	}
	
	private void remove(String filename, Object line, Object action) {
		System.out.println("=============================================================");
		System.out.printf("Line %s: Start %s " + filename + " from mods dir\n", line, action);
		Path destPath = Paths.get(modPath + "\\" + filename);
		try {
			Files.delete(destPath);
		} catch (IOException e) {
			Dialog.Message("L\u1ED7i khi truy nh\u1EADp t\u1EC7p\n" + filename, "Th\u00F4ng b\u00E1o fA", 0);
		}
		System.out.println("=============================================================");
		sleep.sleep(1);
	}
}
