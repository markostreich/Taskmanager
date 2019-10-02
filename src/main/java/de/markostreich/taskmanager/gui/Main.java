package de.markostreich.taskmanager.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import java.util.Optional;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import de.markostreich.taskmanager.gui.error.ErrorMessage;
import de.markostreich.taskmanager.gui.persistence.TaskImportExportFileChooser;
import de.markostreich.taskmanager.persistence.impl.TaskPersistenceFileSystem;

@SpringBootApplication
public class Main {
	
	final private TaskForm mainForm;

	public Main() {
		mainForm = new TaskForm(new TaskPersistenceFileSystem());
	}
	
	private void setVisible(boolean visible) {
		mainForm.setVisible(visible);
	}

	public static void main(String[] args) {

		var ctx = new SpringApplicationBuilder(Main.class).headless(false).run(args);
		EventQueue.invokeLater(() -> {
			var ex = ctx.getBean(Main.class);
			ex.setVisible(true);
		});
	}

}
