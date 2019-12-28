package de.markostreich.taskmanager.gui.adapter;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class CheckBox extends JCheckBox {

	public CheckBox() {
		setLayout(null);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setBorder(BorderFactory.createEmptyBorder());
		setText("Open");
		setIcon(new ImageIcon("src/main/resources/images/toggle_off-black-18dp/2x/outline_toggle_off_black_18dp.png"));
		setFocusPainted(false);
		setFont(new Font("Roboto", Font.BOLD, 19));
		addActionListener(event -> {
			if (isSelected()) {
				setIcon(new ImageIcon(
						"src/main/resources/images/toggle_on-black-18dp/2x/outline_toggle_on_black_18dp.png"));
				setText("Done");
			} else {
				setIcon(new ImageIcon(
						"src/main/resources/images/toggle_off-black-18dp/2x/outline_toggle_off_black_18dp.png"));
				setText("Open");
			}
		});
	}
}
