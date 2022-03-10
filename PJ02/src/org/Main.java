package org;

import org.machine.fileAction;
import org.machine.fileReader;
import org.utilities.java;
import org.utilities.processChecker;
import org.utilities.sleep;

public class Main {

	public static void main(String[] args) {
		java java = new java();
		String temp = java.checkVer();
		char dot = '.';
		if (processChecker.start("javaw.exe", "Minecraft 1.7.10") == true) {
			System.out.println("Yeu cau tat Minecraft truoc khi cai dat");
			sleep.sleep(3);
			System.exit(1);
		}
		if (Integer.parseInt(temp.substring(0, temp.indexOf(dot))) >= 11) {
			fileReader.Main();
		} else {
			System.out.println();
			System.err.println("Require JRE(JDK) 11 or above");
			System.out.println();
		}
		sleep.sleep(3);
		
	}

}
