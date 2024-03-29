
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuItemLabelPanel extends JPanel {

	public MenuItemLabelPanel(JLabel menuItemNameLabel, JLabel menuItemPriceLabel) {
		setPreferredSize(new Dimension(Main.MENU_ITEM_LABEL_PANEL_WIDTH, Main.MENU_ITEM_LABEL_PANEL_HEIGHT));
		setLayout(new BorderLayout());
		setBackground(Main.ORANGE_WHITE);
		menuItemNameLabel.setFont(Main.DISPLAY_PANEL_FONT);
		menuItemPriceLabel.setFont(Main.DISPLAY_PANEL_FONT);
		add(menuItemNameLabel, BorderLayout.WEST);
		add(menuItemPriceLabel, BorderLayout.EAST);
	}
}
