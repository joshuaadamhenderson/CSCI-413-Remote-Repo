/*
 * PROJECT:			Software Engineering Group Project, Restaurant Point-Of-Sale System
 * GROUP:			Round Two
 * MEMBERS:			Dipesh Bhandari, Alex Gayle, Eric Greene, Joshua Henderson
 * COURSE:			CSCI 413, Software Engineering II
 * INSTRUCTOR:		Dr. Bei Xie
 * DATE CREATED:	2/17/2019
 * EDITED BY:		2/17/2019:	Joshua Henderson
 * */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class KeypadPanel extends JPanel {
	
	public KeypadPanel() {
		setVisible(true);
		setBackground(Main.MAIN_BG_COLOR);
		setPreferredSize(new Dimension(Main.KEYPAD_PANEL_WIDTH, Main.KEYPAD_PANEL_HEIGHT));
		setLayout(new GridLayout(4, 3));
	}
}
