package de.markostreich.taskmanager.gui;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TaskForm {

	private JFrame frame;
	private JTextField txtIdtextfield;
	private JTextField txtPrio;
	private JTextField textFieldStartDate;
	private JTextField textFieldDueDate;
	private JTextField textFieldTitle;

	/**
	 * Create the application.
	 */
	public TaskForm() {
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
		txtIdtextfield.setColumns(10);

		JTextArea txtrNotes = new JTextArea();
		txtrNotes.setLineWrap(true);

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

		JList listSubtasks = new JList();

		JLabel lblTitle = new JLabel("Title");

		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);

		JLabel lblSubtasks = new JLabel("Subtasks");

		JList listLinks = new JList();

		JLabel lblLinks = new JLabel("Links");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtIdtextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSubtasks)
								.addComponent(listSubtasks, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
								.addComponent(listLinks, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLinks))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(21)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textFieldTitle, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
											.addGap(18)
											.addComponent(txtPrio, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblTitle)
											.addPreferredGap(ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
											.addComponent(lblPrio))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNotes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGap(309))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(txtrNotes, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblStartDate)
										.addComponent(textFieldStartDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(123)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textFieldDueDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDueDate, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
									.addComponent(chckbxDone)))
							.addGap(24))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSave)
							.addContainerGap(503, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblId, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
							.addGap(457))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitle)
						.addComponent(lblPrio))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtIdtextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPrio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNotes)
						.addComponent(lblSubtasks))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtrNotes, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStartDate)
								.addComponent(lblDueDate))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldStartDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldDueDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(7)
							.addComponent(chckbxDone)
							.addGap(11))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(listSubtasks, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblLinks)
							.addGap(5)
							.addComponent(listLinks, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addGap(33)))
					.addComponent(btnSave)
					.addContainerGap())
		);

		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
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
		mnMenu.add(mntmClose);
	}
}
