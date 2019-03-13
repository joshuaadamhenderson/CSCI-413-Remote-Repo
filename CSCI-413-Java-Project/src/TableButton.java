import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TableButton extends JButton {

	private Table table;
	private JLabel tableNumberLabel;
	private JLabel tableSubtotalNameLabel;
	private JLabel tableSubtotalLabel;
	private JLabel tableTotalNameLabel;
	private JLabel tableTotalLabel;
	private JLabel tableTimeCreatedLabel;
	private TableCostsLabelPanel tableSubtotalLabelPanel;
	private TableCostsLabelPanel tableTotalLabelPanel;
	
	public TableButton(Table table) {
		
		tableNumberLabel = new JLabel(table.getTableID());
		tableNumberLabel.setForeground(Main.MAIN_TEXT_COLOR);
		tableNumberLabel.setFont(Main.TABLE_BUTTON_FONT);
		tableNumberLabel.setPreferredSize(new Dimension(100, 0));
		
		tableSubtotalNameLabel = new JLabel("SUBTOTAL");
		tableSubtotalLabel = new JLabel(Double.toString(table.getSubtotal()));
		
		tableTotalNameLabel = new JLabel("TOTAL");
		tableTotalLabel = new JLabel(Double.toString(table.getTotal()));
		
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
		tableSubtotalLabelPanel = new TableCostsLabelPanel(tableSubtotalNameLabel, tableSubtotalLabel);
		tableTotalLabelPanel = new TableCostsLabelPanel(tableTotalNameLabel, tableTotalLabel);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Main.menuItemPanel.removeAll();
				Main.menuItemPanel.repaint();
				Main.menuItemPanel.revalidate();
				Main.currentTableMenuItems = table.getMenuItems();
				for (MenuItem menuItem: Main.currentTableMenuItems) {
					Main.menuItemPanel.add(menuItem.getMenuItemLabelPanel());
				}
				Main.menuItemPanel.add(tableSubtotalLabelPanel);
				Main.menuItemPanel.add(tableTotalLabelPanel);
				Main.menuItemPanel.repaint();
				Main.menuItemPanel.revalidate();
			} 
		});
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

	public JLabel getTableSubtotalLabel() {
		return tableSubtotalLabel;
	}

	public void setTableSubtotalLabel(JLabel tableSubtotalLabel) {
		this.tableSubtotalLabel = tableSubtotalLabel;
	}
}
