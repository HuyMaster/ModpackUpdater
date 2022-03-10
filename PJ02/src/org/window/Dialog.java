package org.window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Dialog {
	/*
	 * 
	 */
	public static void Message(String message, String title, int icon) {
		JFrame frame = new JFrame();
		frame.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(frame, message, title, icon);
	}
}
