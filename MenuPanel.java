/*
 * PROJECT:			Software Engineering Group Project, Restaurant Point-Of-Sale System
 * GROUP:			Round Two
 * MEMBERS:			Dipesh Bhandari, Alex Gayle, Eric Greene, Joshua Henderson
 * COURSE:			CSCI 413, Software Engineering II
 * INSTRUCTOR:		Dr. Bei Xie
 * DATE CREATED:	2/1/2019
 * EDITED BY:		2/1/2019:	Joshua Henderson
 * */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel {

	public MenuPanel() {
		setVisible(true);
		setLayout(new GridLayout());
		setPreferredSize(new Dimension(Main.MENU_PANEL_WIDTH, Main.MENU_PANEL_HEIGHT));
	}	
}
