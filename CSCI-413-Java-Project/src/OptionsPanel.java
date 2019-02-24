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

public class OptionsPanel extends JPanel {
		
	public OptionsPanel() {
		setPreferredSize(new Dimension(Main.OPTIONS_PANEL_WIDTH, Main.OPTIONS_PANEL_HEIGHT));
		setVisible(true);
		setLayout(new FlowLayout());
		setBackground(Main.OPTIONS_PANEL_BG_COLOR);
	}
	
	public OptionsPanel(JButton ...buttons) {
		setPreferredSize(new Dimension(Main.OPTIONS_PANEL_WIDTH, Main.OPTIONS_PANEL_HEIGHT));
		setVisible(true);
		setLayout(new FlowLayout());
		setBackground(Main.OPTIONS_PANEL_BG_COLOR);
		
		for (JButton each: buttons) {
			add(each);
		}
	}
}