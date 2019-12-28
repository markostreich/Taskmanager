package de.markostreich.taskmanager.gui.renderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import de.markostreich.taskmanager.entity.Task;

public class TaskListCellRenderer extends JLabel implements ListCellRenderer<Task> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1636958255036253002L;
	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

	@Override
	public Component getListCellRendererComponent(JList<? extends Task> list, Task value, int index, boolean isSelected,
			boolean cellHasFocus) {
		final Task task = value;
		setText(String.format("%-5s %s", task.getId(), task.getTitle()));
//		if (isSelected) {
//			setBackground(HIGHLIGHT_COLOR);
//			setForeground(Color.white);
//		} else {
//			setBackground(Color.white);
//			setForeground(Color.black);
//		}
		return this;
	}

}
