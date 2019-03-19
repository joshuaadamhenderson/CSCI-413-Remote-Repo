import javax.swing.JLabel;

public class ErrorLabel extends JLabel {
	
	public ErrorLabel(String text) {
		setText(text);
		setBackground(Main.MAIN_BG_COLOR);
		setFont(Main.PROGRAM_FONT);
	}
}
