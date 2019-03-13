

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class UserPanel extends JPanel {

	public UserPanel() {
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(100,60));
		
		// We added a white border to keep the user name and buttons off the edge of the panel.
		setBorder(new LineBorder(Color.WHITE, 10));
		
		setLayout(new BorderLayout());
	}
}
