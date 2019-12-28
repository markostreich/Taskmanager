package de.markostreich.taskmanager.gui;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.WindowConstants;

import de.markostreich.taskmanager.entity.Task;
import de.markostreich.taskmanager.gui.renderer.TaskListCellRenderer;
import de.markostreich.taskmanager.persistence.TaskPersistence;

public class TaskList {
	private JFrame frame;
	private JList<Task> list;
	private DefaultListModel<Task> listModel = new DefaultListModel<>();
	private final TaskPersistence persistence;

	private final int frameHeight = 850;
	private final int frameWidth = 300;

	/**
	 * Create the application.
	 */
	public TaskList(final TaskPersistence persistence) {
		this.persistence = persistence;
		initialize();
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);

		frame.setBackground(Color.WHITE);

		frame.setBounds(0, 0, frameWidth, frameHeight);
		
		fillList();
		list.setCellRenderer(new TaskListCellRenderer());
		frame.add(list);
	}

	private void fillList() {
		if (persistence == null) {
			return;
		}
		persistence.getAllTasks().forEach(task -> {
			listModel.addElement(task);
		});
		list = new JList<>(listModel);
	}
}
