import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class DisplayPanelLabelPanel extends JPanel {

	public DisplayPanelLabelPanel() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(460,100));
		setBorder(new LineBorder(Color.WHITE, 10));
	}
}
