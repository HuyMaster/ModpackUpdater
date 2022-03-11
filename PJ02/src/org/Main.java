package org;

import java.io.IOException;

import org.machine.*;
import org.utilities.*;
import org.window.Dialog;

public class Main {

	public static void main(String[] args) {
		java java = new java();
		String temp = java.checkVer();
		char dot = '.';
		boolean oldVer = VersionChecker.start();
		if (oldVer) {
			int click = 1;
			String url = "https://github.com/HuyMaster/ModpackUpdater/releases/";
			Object[] button = {
					"\u0110i lu\u00F4n",
					"\u0110\u1EC3 sau"
			};
			click = Dialog.OptionOK_Cancel("Phi\u00EAn b\u1EA3n c\u1EE7a b\u1EA1n \u0111\u00E3 l\u1ED7i th\u1EDDi so v\u1EDBi b\u1EA3n m\u1EDBi nh\u1EA5t\n"
					+ "\u0110\u1EBFn trang ch\u1EE7 \u0111\u1EC3 t\u1EA3i b\u1EA3n m\u1EDBi nh\u1EA5t ?", "Th\u00F4ng b\u00E1o", 2, button);
			if (click == 0) {
				try {
					Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.exit(0);
		}
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
		System.exit(0);
	}

}
