import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TableButton extends JButton {

	private Table table;
	private JLabel tableNumberLabel;
	private JLabel tableTotalLabel;
	private JLabel tableTimeCreatedLabel;
	
	public TableButton(Table table) {
		tableNumberLabel = new JLabel(table.getTableID());
		tableNumberLabel.setForeground(Main.MAIN_TEXT_COLOR);
		tableNumberLabel.setFont(Main.TABLE_BUTTON_FONT);
		tableNumberLabel.setPreferredSize(new Dimension(100, 0));
		tableTotalLabel = new JLabel(table.getTotal());
		tableTotalLabel.setForeground(Main.MAIN_TEXT_COLOR);
		tableTotalLabel.setFont(Main.TABLE_BUTTON_FONT);
		tableTimeCreatedLabel = new JLabel(table.getTimeCreated());
		tableTimeCreatedLabel.setForeground(Main.MAIN_TEXT_COLOR);
		tableTimeCreatedLabel.setFont(Main.TABLE_BUTTON_FONT);
		setBackground(Main.MAIN_BG_COLOR);
		setFont(Main.TABLE_BUTTON_FONT);
		setLayout(new BorderLayout());
		add(tableNumberLabel, BorderLayout.WEST);
		add(tableTotalLabel);
		add(tableTimeCreatedLabel, BorderLayout.EAST);
		setPreferredSize(new Dimension(Main.TABLE_BUTTON_WIDTH, Main.TABLE_BUTTON_HEIGHT));
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

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}
}
