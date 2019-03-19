import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MenuItemPanel extends JPanel {

	public MenuItemPanel() {
		setBackground(Main.MENU_ITEM_PANEL_BG_COLOR);
		setPreferredSize(new Dimension(100,460));
		setBorder(new LineBorder(Main.MENU_ITEM_PANEL_BG_COLOR));
	}
}
