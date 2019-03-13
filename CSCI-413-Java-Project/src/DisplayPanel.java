

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
