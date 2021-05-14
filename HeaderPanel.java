

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
