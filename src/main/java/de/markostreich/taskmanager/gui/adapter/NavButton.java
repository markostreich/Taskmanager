package de.markostreich.taskmanager.gui.adapter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class NavButton extends JButton {

	private final JLabel lblBtn;
	private String lblTxt;

	private final Color colorLight = Color.decode("#fbfffc");
	private final Color colorMain = Color.decode("#c8e6c9");

	public NavButton(final String lblTxt) {
		this.lblTxt = lblTxt;
		setLayout(null);
		setFont(new Font("Roboto", Font.BOLD, 14));
		setBackground(colorLight);
		setForeground(Color.DARK_GRAY);
		setBorder(BorderFactory.createEmptyBorder());
		addMouseListener((new MouseAdapter() {
			public void mouseEntered(final MouseEvent evt) {
				setBackground(colorMain);
				setForeground(Color.WHITE);
			}

			public void mouseExited(final MouseEvent evt) {
				setBackground(colorLight);
				setForeground(Color.DARK_GRAY);
			}
		}));

		lblBtn = new JLabel(this.lblTxt);
		lblBtn.setFont(new Font("Roboto", Font.BOLD, 14));
		lblBtn.setIcon(new ImageIcon("src/main/resources/images/toc-black-18dp/1x/baseline_toc_black_18dp.png"));
		lblBtn.setBounds(10, 0, 100, 35);
		lblBtn.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblBtn);
	}

	public NavButton small() {
		lblBtn.setText(null);
		return this;
	}

	public NavButton normal() {
		lblBtn.setText(lblTxt);
		return this;
	}

	public NavButton setIcon(final String pathToImage) {
		lblBtn.setIcon(new ImageIcon(pathToImage));
		return this;
	}
}
