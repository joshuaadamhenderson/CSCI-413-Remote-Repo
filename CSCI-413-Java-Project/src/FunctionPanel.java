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

// Each panel extends the JPanel class
public class FunctionPanel extends JPanel {

	public FunctionPanel() {
		
		// FunctionPanel settings. GridLayout will fill the entire panel in equal sections.
		// We can define a specific number of rows and columns for the GridLayout, but leaving
		// the constructor arguments empty just produces one row, which is all we need.
		setVisible(true);
		setLayout(new GridLayout());
		setPreferredSize(new Dimension(Main.FUNCTION_PANEL_WIDTH, Main.FUNCTION_PANEL_HEIGHT));		
	}
}
