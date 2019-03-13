

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