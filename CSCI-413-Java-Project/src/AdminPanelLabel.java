import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AdminPanelLabel extends JLabel {

	public AdminPanelLabel(String string) {
		setText(string);
		setFont(Main.ADMIN_PANEL_FONT);
		setForeground(Color.WHITE);
		setAlignmentX(Component.RIGHT_ALIGNMENT);
		setPreferredSize(new Dimension(200, 30));
		setHorizontalAlignment(SwingConstants.RIGHT);
	}
}
