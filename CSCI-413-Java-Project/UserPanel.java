/*
 * PROJECT:			Software Engineering Group Project, Restaurant Point-Of-Sale System
 * GROUP:			Round Two
 * MEMBERS:			Dipesh Bhandari, Alex Gayle, Eric Greene, Joshua Henderson
 * COURSE:			CSCI 413, Software Engineering II
 * INSTRUCTOR:		Dr. Bei Xie
 * DATE CREATED:	2/2/2019
 * EDITED BY:		2/2/2019:	Joshua Henderson
 * */

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class UserPanel extends JPanel {

	Font userPanelFont = new Font("Arial", Font.BOLD, 18);
	
	public UserPanel() {
		
		// Background color and dimensions are set.
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(100,60));
		
		// We added a white border to keep the user name and buttons off the edge of the panel.
		setBorder(new LineBorder(Color.WHITE, 10));
		
		setLayout(new BorderLayout());
	}
}
