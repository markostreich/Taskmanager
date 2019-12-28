package de.markostreich.taskmanager.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import java.awt.Panel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import de.markostreich.taskmanager.gui.adapter.CheckBox;
import de.markostreich.taskmanager.gui.adapter.NavButton;

import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Scrollbar;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MaterialTaskForm {

	private JFrame frame;

	private final int frameHeight = 850;
	private final int frameWidth = 1400;

	private boolean clicked;

	private final int navWidthMax = 200;
	private final int navWidthMin = 50;
	private final int navHorizStart = 0;

	private final int headLineHeight = 25;

	private final Color navBtnColor = new Color(173, 218, 244);

	private final Color colorMain = Color.decode("#c8e6c9");
	private final Color colorLight = Color.decode("#fbfffc");
	private final Color colorDark = Color.decode("#6ec6ff");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaterialTaskForm window = new MaterialTaskForm();
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MaterialTaskForm() {
		initialize();
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

		frame.getContentPane().setLayout(null);
		frame.getContentPane().setPreferredSize(new Dimension(frameWidth, frameHeight));
		frame.pack();

		JPanel headLinePanel = new JPanel();
		headLinePanel.setBackground(colorDark);
		headLinePanel.setBorder(null);
		headLinePanel.setBounds(0, 0, frameWidth, headLineHeight);
		frame.getContentPane().add(headLinePanel);

		JPanel panelNavigation = new JPanel();
		panelNavigation.setLayout(null);
		panelNavigation.setBackground(colorLight);
		panelNavigation.setBorder(null);
		panelNavigation.setBounds(0, headLineHeight, 200, frameHeight - headLineHeight);
		frame.getContentPane().add(panelNavigation);

		// Button Seize
		JButton btnNavSeize = new JButton("<<");
		btnNavSeize.setFont(new Font("Roboto", Font.BOLD, 14));
		btnNavSeize.setBackground(colorMain);
		btnNavSeize.setBorder(BorderFactory.createEmptyBorder());
		btnNavSeize.setBounds(0, frameHeight - headLineHeight - 32, navWidthMax, 32);
		panelNavigation.add(btnNavSeize);

		// Button Tasks
		NavButton btnTasks = new NavButton("Tasks");
		btnTasks.setBounds(0, navHorizStart, navWidthMax, 35);
		panelNavigation.add(btnTasks);

		// Button Email
		NavButton btnMail = new NavButton("Mail");
		btnMail.setBounds(0, navHorizStart + 35, navWidthMax, 35);
		btnMail.setIcon("src/main/resources/images/mail-black-18dp/1x/baseline_mail_black_18dp.png");
		panelNavigation.add(btnMail);

//		JLabel lblMail = new JLabel("Mail");
//		lblMail.setFont(new Font("Roboto", Font.BOLD, 14));
//		lblMail.setIcon(new ImageIcon("src/main/resources/images/mail-black-18dp/1x/baseline_mail_black_18dp.png"));
//		lblMail.setBounds(10, 0, 100, 35);
//		lblMail.setHorizontalAlignment(SwingConstants.LEFT);
//		btnMail.add(lblMail);

		// Button Settings
		JButton btnSettings = new JButton();
		btnSettings.setLayout(null);
		btnSettings.setBounds(0, navHorizStart + 70, navWidthMax, 35);
		btnSettings.setFont(new Font("Roboto", Font.BOLD, 14));
		btnSettings.setBackground(colorLight);
		btnSettings.setForeground(Color.DARK_GRAY);
		btnSettings.setBorder(BorderFactory.createEmptyBorder());
		btnSettings.addMouseListener((new MouseAdapter() {
			public void mouseEntered(final MouseEvent evt) {
				btnSettings.setBackground(colorMain);
				btnSettings.setForeground(Color.WHITE);
			}

			public void mouseExited(final MouseEvent evt) {
				btnSettings.setBackground(colorLight);
				btnSettings.setForeground(Color.DARK_GRAY);
			}
		}));
		panelNavigation.add(btnSettings);

		JLabel lbSettings = new JLabel("Settings");
		lbSettings.setFont(new Font("Roboto", Font.BOLD, 14));
		lbSettings
				.setIcon(new ImageIcon("src/main/resources/images/build-black-18dp/1x/baseline_build_black_18dp.png"));
		lbSettings.setBounds(10, 0, 100, 35);
		lbSettings.setHorizontalAlignment(SwingConstants.LEFT);
		btnSettings.add(lbSettings);

		JPanel panelForm = new JPanel();
		panelForm.setLayout(null);
		panelForm.setBackground(Color.WHITE);
		panelForm.setBounds(navWidthMax, headLineHeight, frameWidth - navWidthMax, frameHeight - headLineHeight);
		frame.getContentPane().add(panelForm);

		CheckBox toggleBtn = new CheckBox();
		toggleBtn.setBounds(20, 400, 100, 100);
		panelForm.add(toggleBtn);

//		CheckBox chckBx = new CheckBox();
//		chckBx.setBounds(20, 460, 50, 30);
//		panelForm.add(chckBx);

		ActionListener btnSmall = event -> {
			if (!clicked) {
				panelNavigation.setBounds(0, headLineHeight, navWidthMin, frameHeight - headLineHeight);
				panelForm.setBounds(navWidthMin, headLineHeight, frameWidth - navWidthMin,
						frameHeight - headLineHeight);
				headLinePanel.setBounds(0, 0, frameWidth, headLineHeight);
				btnNavSeize.setBounds(0, frameHeight - headLineHeight - 32, navWidthMin, 32);
				btnNavSeize.setText(">>");
				btnTasks.setBounds(0, navHorizStart, navWidthMin, 35);
				btnTasks.small();
				btnMail.setBounds(0, navHorizStart + 35, navWidthMin, 35);
				btnMail.small();
				btnSettings.setBounds(0, navHorizStart + 70, navWidthMin, 35);
				lbSettings.setText(null);
				clicked = true;
			} else {
				panelNavigation.setBounds(0, headLineHeight, navWidthMax, frameHeight - headLineHeight);
				panelForm.setBounds(navWidthMax, headLineHeight, frameWidth - navWidthMax,
						frameHeight - headLineHeight);
				headLinePanel.setBounds(0, 0, frameWidth, headLineHeight);
				btnNavSeize.setBounds(0, frameHeight - headLineHeight - 32, navWidthMax, 32);
				btnNavSeize.setText("<<");
				btnTasks.setBounds(0, navHorizStart, navWidthMax, 35);
				btnTasks.normal();
				btnMail.setBounds(0, navHorizStart + 35, navWidthMax, 35);
				btnMail.normal();
				btnSettings.setBounds(0, navHorizStart + 70, navWidthMax, 35);
				lbSettings.setText("Settings");
				clicked = false;
			}
		};
		btnNavSeize.addActionListener(btnSmall);
	}
}