package org;

import org.machine.*;
import org.utilities.*;
import org.window.Dialog;

public class Main {

	public static void main(String[] args) {
		java java = new java();
		String temp = java.checkVer();
		char dot = '.';
		if (processChecker.start("javaw.exe", "Minecraft 1.7.10") == true) {
			System.out.println("T\u1EAFt Minecraft tr\u01B0\u1EDBc khi c\u00E0i \u0111\u1EB7t");
			sleep.sleep(3);
			System.exit(1);
		}
		if (Integer.parseInt(temp.substring(0, temp.indexOf(dot))) >= 11) {
			fileReader.Main();
		} else {
			Dialog.Message("Y\u00EAu c\u1EA7u Java 11 tr\u1EDF l\u00EAn", "", dot);
		}
		sleep.sleep(3);
	}

}
