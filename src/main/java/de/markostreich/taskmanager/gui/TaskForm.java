package de.markostreich.taskmanager.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import de.markostreich.taskmanager.entity.Task;
import de.markostreich.taskmanager.persistence.TaskPersistence;

public class TaskForm {

	private TaskPersistence persistence;

	private JFrame frame;
	private JTextField txtIdtextfield;
	private JTextField txtPrio;
	private JTextField textFieldStartDate;
	private JTextField textFieldDueDate;
	private JTextField textFieldTitle;

	/**
	 * Create the application.
	 */
	public TaskForm(final TaskPersistence persistence) {
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
		frame.setBounds(100, 100, 583, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblId = new JLabel("ID");

		txtIdtextfield = new JTextField();
		txtIdtextfield.setText(Integer.toString(persistence.getNextId()));
		txtIdtextfield.setColumns(10);

		JLabel lblNotes = new JLabel("Notes");

		JLabel lblPrio = new JLabel("Prio");

		txtPrio = new JTextField();
		txtPrio.setColumns(10);

		JLabel lblStartDate = new JLabel("Start Date");

		textFieldStartDate = new JTextField();
		textFieldStartDate.setColumns(10);

		JLabel lblDueDate = new JLabel("Due Date");

		textFieldDueDate = new JTextField();
		textFieldDueDate.setColumns(10);

		JCheckBox chckbxDone = new JCheckBox("Done");

		JButton btnSave = new JButton("Save");

		JList<Task> listSubtasks = new JList<>();

		JLabel lblTitle = new JLabel("Title");

		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);

		JLabel lblSubtasks = new JLabel("Subtasks");

		JList<String> listLinks = new JList<>();

		JLabel lblLinks = new JLabel("Links");

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
						.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtIdtextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSubtasks)
								.addComponent(listSubtasks, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
								.addComponent(listLinks, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLinks))
						.addGap(21)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
								.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldStartDate, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblStartDate))
								.addGap(22)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(textFieldDueDate, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(chckbxDone))
										.addComponent(lblDueDate, GroupLayout.PREFERRED_SIZE, 114,
												GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(textFieldTitle, GroupLayout.DEFAULT_SIZE, 284,
														Short.MAX_VALUE)
												.addGap(18)
												.addComponent(txtPrio, GroupLayout.PREFERRED_SIZE, 49,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblTitle)
												.addPreferredGap(ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
												.addComponent(lblPrio))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblNotes, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(309))))
						.addGap(24))
						.addGroup(groupLayout.createSequentialGroup().addComponent(btnSave).addContainerGap(503,
								Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblId, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE).addGap(457)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTitle).addComponent(lblPrio))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtIdtextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPrio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout
								.createParallelGroup(Alignment.BASELINE).addComponent(lblNotes)
								.addComponent(lblSubtasks))
						.addGap(0)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addGap(10)
										.addComponent(listSubtasks, GroupLayout.PREFERRED_SIZE, 109,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblLinks).addGap(5)
										.addComponent(listLinks, GroupLayout.PREFERRED_SIZE, 129,
												GroupLayout.PREFERRED_SIZE)
										.addGap(33))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblStartDate).addComponent(lblDueDate))
										.addGap(6)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(textFieldStartDate, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldDueDate, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(chckbxDone))
										.addGap(41)))
						.addComponent(btnSave).addGap(11)));

		JTextArea txtrNotes = new JTextArea();
		scrollPane.setViewportView(txtrNotes);

		frame.getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		JMenuItem mntmTasksList = new JMenuItem("Tasks List");
		mnMenu.add(mntmTasksList);

		JMenuItem mntmRefresh = new JMenuItem("Refresh");
		mnMenu.add(mntmRefresh);

		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnMenu.add(mntmClose);

		/*
		 * Save Task.
		 */
		final ActionListener alBtnSave = event -> {
			int id = Integer.valueOf(txtIdtextfield.getText());
			final Task task = new Task();
			task.setId(id++);
			task.setTitle(textFieldTitle.getText());
			task.setDone(chckbxDone.isSelected());
			task.setNotes(txtrNotes.getText());
			task.setPriority(Integer.valueOf(txtPrio.getText().isEmpty() ? "0" : txtPrio.getText()));
			persistence.saveTask(task);
		};
		btnSave.addActionListener(alBtnSave);
	}
}
