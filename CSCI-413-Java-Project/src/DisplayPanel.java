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

public class DisplayPanel extends JPanel {

	// The DisplayPanel holds the UserPanel at the top portion of it, and information
	// about the current check below it. We've arranged it using a BorderLayout. See
	// Main.java for an example of this.
	public DisplayPanel() {
		setVisible(true);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(Main.DISPLAY_PANEL_WIDTH, Main.DISPLAY_PANEL_HEIGHT));
		setBackground(Color.WHITE);
	}
}
