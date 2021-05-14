/*
 * PROJECT:			Software Engineering Group Project, Restaurant Point-Of-Sale System
 * GROUP:			Round Two
 * MEMBERS:			Dipesh Bhandari, Alex Gayle, Eric Greene, Joshua Henderson
 * COURSE:			CSCI 413, Software Engineering II
 * INSTRUCTOR:		Dr. Bei Xie
 * DATE CREATED:	2/18/2019
 * EDITED BY:		2/18/2019:	Joshua Henderson
 * */

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class KeypadButton extends JButton {
	
	public KeypadButton(String num) {
		setFont(Main.KEYPAD_FONT);
		setForeground(Color.WHITE);
		setBackground(Main.KEYPAD_BUTTON_COLOR);
		setText(num);
	}
}
