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

@SpringBootApplication
public class Main extends JFrame {

	public Main() {
		initUI();
	}

	private void initUI() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Taskmanager");
		setSize(1000, 620);
		setLocation(50, 50);
		setResizable(true);
		setVisible(true);
//		Color color = JColorChooser.showDialog(this, "Farbauswahl", null);
//		var fileChooser = new TaskImportExportFileChooser();
//		fileChooser.showOpenDialog(this);
//		var file = fileChooser.getSelectedFile();
//		file.ifPresent(System.out::println);
		ErrorMessage.showErrorMessage("Hilfe!");
		
	}

	public static void main(String[] args) {

		var ctx = new SpringApplicationBuilder(Main.class).headless(false).run(args);
		EventQueue.invokeLater(() -> {
			var ex = ctx.getBean(Main.class);
			ex.setVisible(true);
		});
	}

}
