package de.markostreich.taskmanager;

import java.awt.EventQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import de.markostreich.taskmanager.config.ApplicationProperties;
import de.markostreich.taskmanager.gui.TaskForm;
import de.markostreich.taskmanager.gui.TaskList;
import de.markostreich.taskmanager.persistence.impl.TaskPersistenceFileSystem;

@SpringBootApplication
public class Main {

	private TaskList mainForm;

	@Autowired
	ApplicationProperties applicationProperties;

	@Autowired
	TaskPersistenceFileSystem taskPersistencefileSystem;

	private void initMainFrame() {
//		mainForm = new TaskForm(taskPersistencefileSystem);
		mainForm = new TaskList(taskPersistencefileSystem);
		mainForm.setVisible(true);
	}

	public static void main(String[] args) {

		var ctx = new SpringApplicationBuilder(Main.class).headless(false).run(args);
		EventQueue.invokeLater(() -> {
			var ex = ctx.getBean(Main.class);
			ex.initMainFrame();
		});
	}

}
