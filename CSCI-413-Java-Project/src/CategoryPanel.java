
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CategoryPanel extends JPanel {

	public CategoryPanel() {
		setPreferredSize(new Dimension(Main.CATEGORY_PANEL_WIDTH, Main.CATEGORY_PANEL_HEIGHT));
		setVisible(true);
		setBackground(Main.CATEGORY_PANEL_BG_COLOR);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setAlignmentX(Component.LEFT_ALIGNMENT);
	}
}
