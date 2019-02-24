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

public class StatusPanel extends JPanel {
	
	ImageIcon r2logo = new ImageIcon("src/logo.png");
	JLabel logo = new JLabel(r2logo);
	
	public StatusPanel() {
		setPreferredSize(new Dimension(1366, 50));
		setBackground(new Color(0, 54, 86));
		setLayout(new BorderLayout());
		add(logo, BorderLayout.WEST);

	}
}
