import java.awt.Color;

import javax.swing.JButton;

public class TableSelectionButton extends JButton {

	public TableSelectionButton(int num) {
		setFont(Main.KEYPAD_FONT);
		setForeground(Color.WHITE);
		setBackground(Main.KEYPAD_BUTTON_COLOR);
		setText(String.format("%d", num));
	}
}
