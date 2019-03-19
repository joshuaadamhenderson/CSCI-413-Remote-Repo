import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TableButton extends JButton {

	private JLabel tableNumberLabel;
	private JLabel tableTotalLabel;
	private JLabel tableTimeCreatedLabel;
	private List<MenuItem> menuItems;
	
	public TableButton() {
		/*
		 * TABLE BUTTON SETTINGS
		 */
		setFont(Main.TABLE_BUTTON_FONT);
		setBackground(Main.TABLE_BUTTON_COLOR);
		setForeground(Main.TABLE_BUTTON_TEXT_COLOR);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(Main.TABLE_BUTTON_WIDTH, Main.TABLE_BUTTON_HEIGHT));
		/*
		 * INSTANTIATE LABELS AND MENUITEM LIST
		 */
		tableNumberLabel = new JLabel("");
		tableTotalLabel = new JLabel("");
		tableTimeCreatedLabel = new JLabel("");
		menuItems = new ArrayList<MenuItem>();
		/*
		 * LABEL SETTINGS
		 */
		tableNumberLabel.setForeground(Main.TABLE_BUTTON_TEXT_COLOR);
		tableTotalLabel.setForeground(Main.TABLE_BUTTON_TEXT_COLOR);
		tableTimeCreatedLabel.setForeground(Main.TABLE_BUTTON_TEXT_COLOR);
		tableNumberLabel.setFont(Main.TABLE_BUTTON_FONT);
		tableTotalLabel.setFont(Main.TABLE_BUTTON_FONT);
		tableTimeCreatedLabel.setFont(Main.TABLE_BUTTON_FONT);
		/*
		 * ADD LABELS
		 */
		add(tableNumberLabel, BorderLayout.WEST);
		add(tableTotalLabel);
		add(tableTimeCreatedLabel, BorderLayout.EAST);
	}
	
	public void setTableNumberOnLabel(int tableNumber) {
		tableNumberLabel.setText("Table " + Integer.toString(tableNumber) + "     ");
	}
	
	public void setTableTotalOnLabel(double tableTotal) {
		tableTotalLabel.setText(Double.toString(tableTotal));
	}
	
	public void setTimeCreatedOnLabel(String timeCreated) {
		tableTotalLabel.setText(timeCreated);
	}
	
	public JLabel getTableNumberLabel() {
		return tableNumberLabel;
	}
	
	public void setTableNumberLabel(JLabel tableNumberLabel) {
		this.tableNumberLabel = tableNumberLabel;
	}

	public JLabel getTableTotalLabel() {
		return tableTotalLabel;
	}
	public void setTableTotalLabel(JLabel tableTotalLabel) {
		this.tableTotalLabel = tableTotalLabel;
	}

	public JLabel getTableTimeCreatedLabel() {
		return tableTimeCreatedLabel;
	}

	public void setTableTimeCreatedLabel(JLabel tableTimeCreatedLabel) {
		this.tableTimeCreatedLabel = tableTimeCreatedLabel;
	}
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
}