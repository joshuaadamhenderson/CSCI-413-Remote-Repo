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
import java.time.LocalDateTime;
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
	private DisplayPanelLabelPanel tableInformationPanel;
	private DisplayPanelLabelPanel subtotalPanel;
	private DisplayPanelLabelPanel taxPanel;
	private DisplayPanelLabelPanel totalPanel;
	private JLabel subtotalTitleLabel;
	private JLabel taxTitleLabel;
	private JLabel totalTitleLabel;
	private JLabel subtotalLabel;
	private JLabel taxLabel;
	private JLabel totalLabel;
	private JLabel tableIDLabel;
	private JLabel tableTimeCreatedLabel;
	private TableButton tableButton;
	private LocalDateTime now;

	public Table() {
		/*
		 * GET VARIABLES
		 */
		now = LocalDateTime.now();
		/*
		 * ASSIGN VALUES TO VARIABLES
		 */
		this.tableID = 0;
		this.timeCreated = Main.dtf.format(now);
		this.subtotal = 0;
		this.tax = subtotal * Main.CURRENT_TAX_RATE;
		this.total = 0;
		/*
		 * INSTANTIATE NEW OBJECTS FOR THE TABLE
		 */
		menuItems = new ArrayList<MenuItem>();
		tableInformationPanel = new DisplayPanelLabelPanel();
		subtotalPanel = new DisplayPanelLabelPanel();
		totalPanel = new DisplayPanelLabelPanel();
		taxPanel = new DisplayPanelLabelPanel();
		tableIDLabel = new JLabel("Table " + Integer.toString(tableID));
		tableTimeCreatedLabel = new JLabel(timeCreated);
		subtotalTitleLabel = new JLabel("Subtotal");
		taxTitleLabel = new JLabel("Tax");
		totalTitleLabel = new JLabel("Total");
		subtotalLabel = new JLabel(String.format("$%.2f", subtotal));
		taxLabel = new JLabel(String.format("$%.2f", tax));
		totalLabel = new JLabel(String.format("$%.2f", total));
		tableButton = new TableButton(this);
		/*
		 * ADD LABELS TO TABLE INFORMATION PANEL
		 */
		tableInformationPanel.add(tableIDLabel, BorderLayout.WEST);
		tableInformationPanel.add(tableTimeCreatedLabel, BorderLayout.EAST);
		/*
		 * ADD LABELS TO COST PANELS
		 */
		subtotalPanel.add(subtotalTitleLabel, BorderLayout.WEST);
		taxPanel.add(taxTitleLabel, BorderLayout.WEST);
		totalPanel.add(totalTitleLabel, BorderLayout.WEST);
		subtotalPanel.add(subtotalLabel, BorderLayout.EAST);
		taxPanel.add(taxLabel, BorderLayout.EAST);
		totalPanel.add(totalLabel, BorderLayout.EAST);
		/*
		 * GIVE SETTINGS TO LABELS
		 */
		subtotalTitleLabel.setFont(Main.DISPLAY_PANEL_FONT);
		taxTitleLabel.setFont(Main.DISPLAY_PANEL_FONT);
		totalTitleLabel.setFont(Main.DISPLAY_PANEL_FONT);
		subtotalLabel.setFont(Main.DISPLAY_PANEL_FONT);
		taxLabel.setFont(Main.DISPLAY_PANEL_FONT);
		totalLabel.setFont(Main.DISPLAY_PANEL_FONT);
		tableIDLabel.setFont(Main.DISPLAY_PANEL_FONT);
		tableTimeCreatedLabel.setFont(Main.DISPLAY_PANEL_FONT);
		/*
		 * SET LABELS ON TABLE'S TABLE BUTTON
		 */
		tableButton.setTable(this);
		tableButton.setTableNumberOnLabel(tableID);
		tableButton.setTableTotalOnLabel(total);
		tableButton.setTimeCreatedOnLabel(timeCreated);
	}

	public void calculateTotals() {
		
		double sub = 0;
		for (MenuItem menuItem: menuItems) {
			sub += menuItem.getMenuItemPrice();
		}
		subtotal = sub;
		tax = subtotal * Main.CURRENT_TAX_RATE;
		total = tax + subtotal;
		setTotal(total);
		setTax(tax);
		setSubtotal(subtotal);
	}
	
	public void setTableID(int tableID) {
		tableButton.setTableNumberOnLabel(tableID);
		this.tableID = tableID;
	}
	
	public double getTableID() {
		return this.tableID;
	}
	
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItem> menuItems) {
		tableButton.setMenuItems(menuItems);
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
		totalLabel.setText(String.format("$%.2f", total));
		tableButton.setTableTotalOnLabel(total);
		this.total = total;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		subtotalLabel.setText(String.format("$%.2f", subtotal));
		this.subtotal = subtotal;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		taxLabel.setText(String.format("$%.2f", tax));
		this.tax = tax;
	}
	public DisplayPanelLabelPanel getSubtotalPanel() {
		return subtotalPanel;
	}
	public void setSubtotalPanel(DisplayPanelLabelPanel totalPanel) {
		tableButton.setTotalPanel(totalPanel);
		this.totalPanel = totalPanel;
	}
	public DisplayPanelLabelPanel getTotalPanel() {
		return totalPanel;
	}
	public void setTotalPanel(DisplayPanelLabelPanel subtotalPanel) {
		tableButton.setSubtotalPanel(subtotalPanel);
		this.subtotalPanel = subtotalPanel;
	}
	public DisplayPanelLabelPanel getTaxPanel() {
		return taxPanel;
	}
	public void setTaxPanel(DisplayPanelLabelPanel taxPanel) {
		tableButton.setTaxPanel(taxPanel);
		this.taxPanel = taxPanel;
	}

	public List<DisplayPanelLabelPanel> getMenuItemLabelPanels() {
		return menuItemLabelPanels;
	}

	public void setMenuItemLabelPanels(List<DisplayPanelLabelPanel> menuItemLabelPanels) {
		tableButton.setMenuItemLabelPanels(menuItemLabelPanels);
		this.menuItemLabelPanels = menuItemLabelPanels;
	}

	public DisplayPanelLabelPanel getTableInformationPanel() {
		return tableInformationPanel;
	}

	public void setTableInformationPanel(DisplayPanelLabelPanel tableInformationPanel) {
		this.tableInformationPanel = tableInformationPanel;
	}

	public JLabel getSubtotalLabel() {
		return subtotalLabel;
	}

	public void setSubtotalLabel(JLabel subtotalLabel) {
		this.subtotalLabel = subtotalLabel;
	}

	public JLabel getTaxLabel() {
		return taxLabel;
	}

	public void setTaxLabel(JLabel taxLabel) {
		this.taxLabel = taxLabel;
	}

	public JLabel getTotalLabel() {
		return totalLabel;
	}

	public void setTotalLabel(JLabel totalLabel) {
		this.totalLabel = totalLabel;
	}
}
