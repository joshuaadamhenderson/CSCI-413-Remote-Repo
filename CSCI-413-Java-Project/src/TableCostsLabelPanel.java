import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TableCostsLabelPanel extends JPanel {

	private double tableSubtotal;
	private double tableTotal;
	private JLabel tableSubtotalNameLabel;
	private JLabel tableSubtotalLabel;
	private JLabel tableTotalNameLabel;
	private JLabel tableTotalLabel;
	private JLabel horizonLine;
	private MenuItemLabelPanel subtotalPanel;
	private MenuItemLabelPanel totalPanel;
	
	public TableCostsLabelPanel(double tableSubtotal, double tableTotal) {
		
		this.setTableSubtotal(tableSubtotal);
		this.setTableTotal(tableTotal);
		setPreferredSize(new Dimension(Main.TABLE_COSTS_PANEL_WIDTH, Main.TABLE_COSTS_PANEL_HEIGHT));
		setLayout(new FlowLayout());
		setBackground(Color.WHITE);
		tableSubtotalNameLabel = new JLabel("SUBTOTAL");
		tableSubtotalLabel = new JLabel(String.format("$%.2f", tableSubtotal));
		tableTotalNameLabel = new JLabel("TOTAL");
		tableTotalLabel = new JLabel(String.format("$%.2f", tableTotal));
		horizonLine = new JLabel("    ***************************************************************************************");
		
		tableSubtotalNameLabel.setFont(Main.DISPLAY_PANEL_FONT);
		tableSubtotalLabel.setFont(Main.MENU_ITEM_PRICE_LABEL_FONT);
		tableTotalNameLabel.setFont(Main.DISPLAY_PANEL_FONT);
		tableTotalLabel.setFont(Main.MENU_ITEM_PRICE_LABEL_FONT);
		
		subtotalPanel = new MenuItemLabelPanel(tableSubtotalNameLabel, tableSubtotalLabel);
		totalPanel = new MenuItemLabelPanel(tableTotalNameLabel, tableTotalLabel);

		add(horizonLine, BorderLayout.WEST);
		add(subtotalPanel);
		add(totalPanel);
	}

	public void setTableSubtotalLabel() {
		tableSubtotalLabel.setText(String.format("$%.2f", tableSubtotal));
	}
	public void setTableTotalLabel() {
		tableTotalLabel.setText(String.format("$%.2f", tableTotal));
	}
	
	public double getTableSubtotal() {
		return tableSubtotal;
	}
	public void setTableSubtotal(double tableSubtotal) {
		this.tableSubtotal = tableSubtotal;
	}
	public double getTableTotal() {
		return tableTotal;
	}
	public void setTableTotal(double tableTotal) {
		this.tableTotal = tableTotal;
	}
}
