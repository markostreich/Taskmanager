package de.markostreich.taskmanager.gui.persistence;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TaskFileChooserTest extends TaskImportExportFileChooser {

	@Test
	public void testGetSelectedFile() {
		final TaskImportExportFileChooser chooser = new TaskImportExportFileChooser();
		var file = chooser.getSelectedFile();
		assertTrue(file.isEmpty());
	}

	@Test(expected = NullPointerException.class)
	public void testShowExportDialog() {
		showOpenDialog(null);
	}

	@Test(expected = NullPointerException.class)
	public void testShowOpenDialog() {
		showExportDialog(null);
	}

}
