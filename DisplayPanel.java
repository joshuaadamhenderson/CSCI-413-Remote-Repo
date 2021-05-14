

import javax.swing.*;

import java.awt.*;

public class DisplayPanel extends JPanel {

	public DisplayPanel() {
		setVisible(true);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(Main.DISPLAY_PANEL_WIDTH, Main.DISPLAY_PANEL_HEIGHT));
		setBackground(Main.DISPLAY_PANEL_BG_COLOR);
	}
}
