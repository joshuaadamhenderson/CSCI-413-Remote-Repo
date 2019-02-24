/*
 * PROJECT:			Software Engineering Group Project, Restaurant Point-Of-Sale System
 * GROUP:			Round Two
 * MEMBERS:			Dipesh Bhandari, Alex Gayle, Eric Greene, Joshua Henderson
 * COURSE:			CSCI 413, Software Engineering II
 * INSTRUCTOR:		Dr. Bei Xie
 * DATE CREATED:	2/11/2019
 * EDITED BY:		2/11/2019:	Joshua Henderson
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HeaderPanel extends JPanel {
	
	public HeaderPanel() {
		setVisible(true);
		setPreferredSize(new Dimension(Main.HEADER_PANEL_WIDTH, Main.HEADER_PANEL_HEIGHT));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
}
