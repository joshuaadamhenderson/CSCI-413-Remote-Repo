import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TableCostsLabelPanel extends JPanel {
	
	public TableCostsLabelPanel(JLabel costNameLabel, JLabel costLabel) {
		setPreferredSize(new Dimension(Main.MENU_ITEM_LABEL_PANEL_WIDTH, Main.MENU_ITEM_LABEL_PANEL_HEIGHT));
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
	}
}
