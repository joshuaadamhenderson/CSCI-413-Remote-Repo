import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class MenuPanelButton extends JButton {

	public MenuPanelButton(String text, Color buttonColor, Color textColor) {
		setFont(Main.PROGRAM_FONT);
		setBackground(buttonColor);
		setBorder(new LineBorder(Color.WHITE, 1));
		setForeground(textColor);
		setText(text);
	}
}
