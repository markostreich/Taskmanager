package de.markostreich.taskmanager.gui.persistence;

import java.awt.Component;
import java.io.File;
import java.util.Optional;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TaskImportExportFileChooser {

	private final JFileChooser fileChooser;

	private final FileFilter filter;

	public TaskImportExportFileChooser() {
		filter = new FileNameExtensionFilter("Tasks", "xml");
		fileChooser = new JFileChooser();
		fileChooser.setFileFilter(filter);
	}

	public Optional<File> getSelectedFile() {
		return Optional.ofNullable(fileChooser.getSelectedFile());
	}

	public void showExportDialog(final Component parent) {
		if (parent == null) {
			throw new NullPointerException();
		}
		fileChooser.showSaveDialog(parent);
	}

	public void showOpenDialog(final Component parent) {
		if (parent == null) {
			throw new NullPointerException();
		}
		fileChooser.showOpenDialog(parent);
	}

}
