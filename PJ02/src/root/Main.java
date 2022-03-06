package root;

import root.machine.fileAction;
import root.machine.fileReader;
import root.utilities.java;

public class Main {

	public static void main(String[] args) {
		java java = new java();
		String temp = java.checkVer();
		char dot = '.';
		if (Integer.parseInt(temp.substring(0, temp.indexOf(dot))) >= 11) {
			fileReader.Main();
		} else {
			System.out.println();
			System.err.println("Require JRE(JDK) 11 or above");
			System.out.println();
		}
		
		
	}

}
