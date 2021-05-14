import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class MenuButton extends JButton {
	
	private static JLabel top;
	private static JLabel bottom;
	
	public MenuButton(String text, Color buttonColor, Color textColor) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(172, 80));
		setBackground(buttonColor);
		setText(text);
		setFont(Main.PROGRAM_FONT);
		setForeground(textColor);
		setBorder(new LineBorder(Color.WHITE, 1));

	}
	public MenuButton(String topText, String bottomText, Color buttonColor, Color textColor) {
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(172, 80));
		setBackground(buttonColor);
		setFont(Main.PROGRAM_FONT);
		setForeground(textColor);
		setBorder(new LineBorder(Color.WHITE, 1));
		top = new JLabel(topText, JLabel.CENTER);
		bottom = new JLabel(bottomText, JLabel.CENTER);
		add(top);
		add(bottom);
		top.setVerticalAlignment(BOTTOM);
		top.setPreferredSize(new Dimension(172, 30));
		top.setFont(Main.PROGRAM_FONT);
		top.setForeground(textColor);
		bottom.setVerticalAlignment(TOP);
		bottom.setPreferredSize(new Dimension(172, 30));
		bottom.setFont(Main.PROGRAM_FONT);
		bottom.setForeground(textColor);

	}
}
