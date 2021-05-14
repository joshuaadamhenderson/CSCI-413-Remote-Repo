import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class DisplayPanelLabelPanel extends JPanel {

	public DisplayPanelLabelPanel() {
		setBackground(Main.ORANGE_WHITE);
		setPreferredSize(new Dimension(Main.MENU_ITEM_LABEL_PANEL_WIDTH, Main.MENU_ITEM_LABEL_PANEL_HEIGHT));
		setLayout(new BorderLayout());
	}
}
