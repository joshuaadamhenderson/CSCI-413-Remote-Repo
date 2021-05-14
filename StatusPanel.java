

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StatusPanel extends JPanel {
	
	ImageIcon r2logo = new ImageIcon("src/logo.png");
	JLabel logo = new JLabel(r2logo);
	
	public StatusPanel() {
		setPreferredSize(new Dimension(1366, 50));
		setBackground(Main.STATUS_PANEL_BG_COLOR);
		setLayout(new BorderLayout());
		add(logo, BorderLayout.WEST);

	}
}
