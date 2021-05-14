
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TableButton extends JButton {

	private JLabel tableIDLabel;
	private JLabel tableNumberLabel;
	private JLabel tableTotalLabel;
	private JLabel tableTimeCreatedLabel;
	private DisplayPanelLabelPanel subtotalPanel;
	private DisplayPanelLabelPanel taxPanel;
	private DisplayPanelLabelPanel totalPanel;
	private List<DisplayPanelLabelPanel> menuItemLabelPanels;
	private List<MenuItem> menuItems;
	private Table table;
	private TableButtonHandler tableButtonHandler;
	
	private List<DisplayPanelLabelPanel> paymentLabelPanels;
	private double[] payments;
	
	public TableButton(Table table) {
		/*
		 * ASSIGN VARIABLES
		 */
		this.table = table;
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
		tableIDLabel = new JLabel(String.format("%f   Table %d", table.getTableID(), table.getTableNum()));
		tableNumberLabel = new JLabel(String.format("Table %d", table.getTableNum()));
		tableTotalLabel = new JLabel(String.format("%f", table.getTotal()));
		tableTimeCreatedLabel = new JLabel("table time created goes here");
		menuItems = new ArrayList<MenuItem>();
		tableButtonHandler = new TableButtonHandler(table);
		/*
		 * LABEL SETTINGS
		 */
		tableIDLabel.setForeground(Main.TABLE_BUTTON_TEXT_COLOR);
		tableNumberLabel.setForeground(Main.TABLE_BUTTON_TEXT_COLOR);
		tableTotalLabel.setForeground(Main.TABLE_BUTTON_TEXT_COLOR);
		tableTimeCreatedLabel.setForeground(Main.TABLE_BUTTON_TEXT_COLOR);
		tableIDLabel.setFont(Main.TABLE_BUTTON_FONT);
		tableNumberLabel.setFont(Main.TABLE_BUTTON_FONT);
		tableTotalLabel.setFont(Main.TABLE_BUTTON_FONT);
		tableTimeCreatedLabel.setFont(Main.TABLE_BUTTON_FONT);
		tableTimeCreatedLabel.setHorizontalAlignment(JLabel.RIGHT);
		/*
		 * ADD LABELS
		 */
		add(tableIDLabel, BorderLayout.WEST);
		add(tableTotalLabel, BorderLayout.CENTER);
		add(tableTimeCreatedLabel, BorderLayout.EAST);
		addActionListener(tableButtonHandler);
	}
	/* _____________________________________________________________________________________________________
	 * TABLE BUTTON HANDLER
	 */
	private class TableButtonHandler implements ActionListener {

		private Table table;
		private int count = 0;
		private int scrollPaneAdjustment;
		
		private TableButtonHandler(Table table) {
			this.table = table;
		}
		public void actionPerformed(ActionEvent event) {
			try {
				table.calculateTotals();
				/*
				 * CLEAR THE CURRENT TABLE INFO
				 */
				Main.currentTable = null;
				/*
				 * REMOVE EVERYTHING TO UPDATE THE PANEL
				 */
				Main.menuItemPanel.removeAll();
				Main.menuItemPanel.repaint();
				Main.menuItemPanel.revalidate();
				/*
				 * ADD THE TABLE INFORMATION
				 */
				Main.menuItemPanel.add(Main.horizonLine, BorderLayout.WEST);
				Main.menuItemPanel.add(table.getTableInformationPanel());
				/*
				 * ADD THE MENU ITEMS
				 */
				Main.menuItemPanel.add(Main.horizonLine2, BorderLayout.WEST);
				for (MenuItem menuItem: table.getMenuItems()) {
					Main.menuItemPanel.add(menuItem.getMenuItemLabelPanel());
					count++;
				}
				/*
				 * ADD UPDATED COST INFORMATION
				 */
				Main.menuItemPanel.add(Main.horizonLine3, BorderLayout.WEST);
				Main.menuItemPanel.add(table.getSubtotalPanel());
				Main.menuItemPanel.add(table.getTaxPanel());
				Main.menuItemPanel.add(table.getTotalPanel());
				Main.menuItemPanel.add(Main.horizonLine4, BorderLayout.WEST);
				/*
				 * GET THE SCROLL PANE VARIABLE
				 */
				scrollPaneAdjustment = (count * 35) - 230;
				/*
				 * RESET THE MENU ITEM PANEL SIZE
				 */
				Main.menuItemPanel.setPreferredSize(new Dimension(Main.MENU_ITEM_PANEL_WIDTH, Main.MENU_ITEM_PANEL_HEIGHT + scrollPaneAdjustment));
				Main.menuItemPanel.repaint();
				Main.menuItemPanel.revalidate();
				/*
				 * RESET VARIABLES
				 */
				count = 0;
				scrollPaneAdjustment = 0;
				/*
				 * MAKE THIS TABLE THE CURRENT TABLE
				 */
				Main.currentTable = table;
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		} 
	}	
	public void setTableIDOnLabel(int tableID, int tableNum) {
		tableIDLabel.setText("Check " + Integer.toString(tableID) + "     " + "Table " + Integer.toString(tableNum) + "      ");
	}
	
	
	public void setTableTotalOnLabel(double tableTotal) {
		tableTotalLabel.setText(String.format("$%.2f", tableTotal));
	}
	
	public void setTimeCreatedOnLabel(Date date, Time time) {
		tableTimeCreatedLabel.setText(date.toString() + "   " + time.toString());
	}
	
	public JLabel getTableIDLabel() {
		return tableIDLabel;
	}
	
	public void setTableIDLabel(JLabel tableIDLabel) {
		this.tableIDLabel = tableIDLabel;
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

	public DisplayPanelLabelPanel getSubtotalPanel() {
		return subtotalPanel;
	}

	public void setSubtotalPanel(DisplayPanelLabelPanel subtotalPanel) {
		this.subtotalPanel = subtotalPanel;
	}

	public DisplayPanelLabelPanel getTaxPanel() {
		return taxPanel;
	}

	public void setTaxPanel(DisplayPanelLabelPanel taxPanel) {
		this.taxPanel = taxPanel;
	}

	public DisplayPanelLabelPanel getTotalPanel() {
		return totalPanel;
	}

	public void setTotalPanel(DisplayPanelLabelPanel totalPanel) {
		this.totalPanel = totalPanel;
	}

	public List<DisplayPanelLabelPanel> getMenuItemLabelPanels() {
		return menuItemLabelPanels;
	}

	public void setMenuItemLabelPanels(List<DisplayPanelLabelPanel> menuItemLabelPanels) {
		this.menuItemLabelPanels = menuItemLabelPanels;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public List<DisplayPanelLabelPanel> getPaymentLabelPanels() {
		return paymentLabelPanels;
	}

	public void setPaymentLabelPanels(List<DisplayPanelLabelPanel> paymentLabelPanels) {
		this.paymentLabelPanels = paymentLabelPanels;
	}

	public double[] getPayments() {
		return payments;
	}

	public void setPayments(double[] payments) {
		this.payments = payments;
	}
}