

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CategoryPanel extends JPanel {

	// The CategoryPanel will hold JButtons related to its category (appetizers, entrees, desserts).
	// The FlowLayout will line up buttons horizontally, and adjusting the window size will force them
	// down to new rows as needed. Since the OptionsPanel they will be displayed in is constrained to
	// a certain size, they will create a new row upon reaching the end of the panel, so we don't need
	// to worry about positioning them anywhere. The LEFT constant starts the layout on the left hand
	// side of the panel.
	public CategoryPanel() {
		setPreferredSize(new Dimension(Main.CATEGORY_PANEL_WIDTH, Main.CATEGORY_PANEL_HEIGHT));
		setVisible(true);
		setBackground(Main.CATEGORY_PANEL_BG_COLOR);
		setLayout(new FlowLayout(FlowLayout.LEFT));
	}
}
