

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class UserPanel extends JPanel {

	public UserPanel() {
		
		setBackground(Main.USER_PANEL_BG_COLOR);
		setPreferredSize(new Dimension(Main.USER_PANEL_WIDTH ,Main.USER_PANEL_HEIGHT));
		setBorder(new LineBorder(Main.USER_PANEL_BG_COLOR, 10));
		setLayout(new GridLayout());
	}
}
