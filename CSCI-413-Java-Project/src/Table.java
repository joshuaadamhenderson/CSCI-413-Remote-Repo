/*
 * PROJECT:			Software Engineering Group Project, Restaurant Point-Of-Sale System
 * GROUP:			Round Two
 * MEMBERS:			Dipesh Bhandari, Alex Gayle, Eric Greene, Joshua Henderson
 * COURSE:			CSCI 413, Software Engineering II
 * INSTRUCTOR:		Dr. Bei Xie
 * DATE CREATED:	2/17/2019
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/*
 * TABLE CLASS
 */
public class Table {
	
	private int tableID;
	private String timeCreated;
	private double subtotal;
	private double tax;
	private double total;
	private List<MenuItem> menuItems;
	private List<DisplayPanelLabelPanel> menuItemLabelPanels;
	private DisplayPanelLabelPanel subtotalPanel;
	private DisplayPanelLabelPanel taxPanel;
	private DisplayPanelLabelPanel totalPanel;
	private TableButton tableButton;

	public Table() {
		this.tableID = 0;
		this.timeCreated = "";
		this.subtotal = 0;
		this.total = 0;
		menuItems = new ArrayList<MenuItem>();
		subtotalPanel = new DisplayPanelLabelPanel();
		totalPanel = new DisplayPanelLabelPanel();
		taxPanel = new DisplayPanelLabelPanel();
		subtotalPanel.add(new JLabel("SUBTOTAL"), BorderLayout.WEST);
		taxPanel.add(new JLabel("TAX"), BorderLayout.WEST);
		totalPanel.add(new JLabel("TOTAL"), BorderLayout.WEST);
		tableButton = new TableButton();
		tableButton.setTableNumberOnLabel(tableID);
		tableButton.setTableTotalOnLabel(total);
	}

	public void calculateTotals() {
		for (MenuItem menuItem: menuItems) {
			subtotal += menuItem.getMenuItemPrice();
		}
		tax = subtotal * Main.CURRENT_TAX_RATE;
		total = tax + subtotal;
	}
	
	public void setTableID(int tableID) { 
		this.tableID = tableID;
	}
	
	public double getTableID() {
		return this.tableID;
	}
	
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	public String getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated(String timeCreated) {
		this.timeCreated = timeCreated;
	}
	public TableButton getTableButton() {
		return tableButton;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	public DisplayPanelLabelPanel getSubtotalPanel() {
		return subtotalPanel;
	}
	public void setSubtotalPanel(DisplayPanelLabelPanel subtotalPanel) {
		this.subtotalPanel = subtotalPanel;
	}

	public List<DisplayPanelLabelPanel> getMenuItemLabelPanels() {
		return menuItemLabelPanels;
	}

	public void setMenuItemLabelPanels(List<DisplayPanelLabelPanel> menuItemLabelPanels) {
		this.menuItemLabelPanels = menuItemLabelPanels;
	}
}
