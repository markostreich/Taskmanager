package de.markostreich.taskmanager.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Main extends JFrame {
	
	public Main() {
		initUI();
	}
	
	private void initUI() {

		setTitle("Taskmanager");
		setSize(1000, 620);
		setLocation(50, 50);
		setResizable(true);
		setVisible(true);
	}

	public static void main(String[] args) {

		var ctx = new SpringApplicationBuilder(Main.class).headless(false).run(args);

		EventQueue.invokeLater(() -> {

			var ex = ctx.getBean(Main.class);
			ex.setVisible(true);
		});
	}

}
