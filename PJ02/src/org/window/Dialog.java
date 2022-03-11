package org.window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Dialog {
	private static JFrame frame = new JFrame();
	public static void Message(String message, String title, int icon) {
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(frame, message, title, icon);
	}
	public static int OptionOK_Cancel(String message, String title, int icon, Object[] customButton) {
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return JOptionPane.showOptionDialog(frame, message, title, icon, JOptionPane.OK_CANCEL_OPTION, null, customButton, customButton[customButton.length-1]);
	}
}
