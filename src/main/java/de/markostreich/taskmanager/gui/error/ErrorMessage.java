package de.markostreich.taskmanager.gui.error;

import javax.swing.JDialog;
import javax.swing.JLabel;

import de.markostreich.taskmanager.gui.GuiConstants;

public class ErrorMessage {

	private static JDialog errorWindow;

	private ErrorMessage() {
	}

	private static void init() {
		errorWindow = new JDialog();
		errorWindow.setModal(true);
		errorWindow.setTitle("" + GuiConstants.APPLICATION_TITLE + ": " + "Fehler");
	}

	public static void showErrorMessage(final String message) {
		init();
		final JLabel label = new JLabel(message);
		final int labelWidth = label.getWidth();
		System.out.println(labelWidth);
		errorWindow.add(label);
		errorWindow.setSize(100,100);
		errorWindow.setLocation(500, 500);
		errorWindow.setVisible(true);
	}
}
