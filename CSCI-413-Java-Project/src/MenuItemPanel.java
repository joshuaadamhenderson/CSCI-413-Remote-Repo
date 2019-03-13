import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MenuItemPanel extends JPanel {

	public MenuItemPanel() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(100,485));
		setBorder(new LineBorder(Color.WHITE, 10));
	}
}
