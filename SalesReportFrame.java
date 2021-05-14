import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SalesReportFrame extends JFrame {

	public static final ImageIcon LOGO = new ImageIcon("src/adminWelcomeLabel.png");
	public static JLabel welcomeLabel = new JLabel(LOGO);
	public static JPanel centerPanel = new JPanel();
	public static JPanel headerPanel = new JPanel();
	public static JPanel footerPanel = new JPanel();
	public static JPanel selectionPanel = new JPanel();
	public static JPanel formPanel = new JPanel();
	public static JPanel salesRecordsPanel = new JPanel();
	
	public static JButton exitButton = new JButton("EXIT");
	public static JComboBox dateSelection;

	public static String[] dates = new String[100];
	
	public static JScrollPane salesRecordsScrollPane = new JScrollPane(salesRecordsPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	public static ExitSystemHandler exitSystemHandler;
	public static SalesReportActionListener salesReportActionListener;
	public static int dateIndex = 0;

	public SalesReportFrame() {
		/*
		 * SETTINGS
		 */
		setBackground(Main.MAIN_BG_COLOR);
		setForeground(Main.MAIN_TEXT_COLOR);
		setSize(Main.MAIN_WIDTH, Main.MAIN_HEIGHT);
		getContentPane().setLayout(new BorderLayout());
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
				
		centerPanel.setBackground(Main.ORIGINAL_DARK_BLUE);
		centerPanel.setLayout(new BorderLayout());
		headerPanel.setLayout(new BorderLayout());
		headerPanel.setBackground(Main.ORIGINAL_DARK_BLUE);
		headerPanel.setPreferredSize(new Dimension(0, (int)(Main.screenSize.getHeight() * 0.15)));
		footerPanel.setLayout(new BorderLayout());
		footerPanel.setBackground(Main.ORIGINAL_DARK_BLUE);
		footerPanel.setPreferredSize(new Dimension(0, (int)(Main.screenSize.getHeight() * 0.10)));
		selectionPanel.setBackground(Main.ORIGINAL_DARK_BLUE);
		selectionPanel.setPreferredSize(new Dimension((int)(Main.screenSize.getWidth() * 0.25), (int)(Main.screenSize.getHeight() * 0.75)));
		formPanel.setBackground(Main.ORIGINAL_DARK_BLUE);
		formPanel.setPreferredSize(new Dimension((int)(Main.screenSize.getWidth() * 0.74), (int)(Main.screenSize.getHeight() * 0.75)));
		exitButton.setBackground(Main.ORIGINAL_DARK_BLUE);
		exitButton.setPreferredSize(new Dimension(150, 70));
		exitButton.setFont(Main.KEYPAD_FONT);
		exitButton.setForeground(Color.WHITE);
		salesRecordsScrollPane.setBackground(Color.WHITE);
		salesRecordsPanel.setBackground(Color.WHITE);
		salesRecordsPanel.setPreferredSize(new Dimension((int)(Main.screenSize.getWidth() * 0.70), (int)(Main.screenSize.getHeight() * 0.74)));

		add(headerPanel, BorderLayout.PAGE_START);
		add(footerPanel, BorderLayout.PAGE_END);
		add(centerPanel, BorderLayout.CENTER);
		formPanel.add(salesRecordsScrollPane);
		centerPanel.add(selectionPanel, BorderLayout.WEST);
		centerPanel.add(formPanel, BorderLayout.EAST);
		headerPanel.add(welcomeLabel, BorderLayout.WEST);
		headerPanel.add(exitButton, BorderLayout.EAST);

		exitSystemHandler = new ExitSystemHandler();
		salesReportActionListener = new SalesReportActionListener();
		exitButton.addActionListener(exitSystemHandler);
		
		try {
			Connection conn = DriverManager.getConnection(Main.URL, Main.USERNAME, Main.PASSWORD);
			Statement stmt = conn.createStatement();
			String string = "SELECT DISTINCT tableDateCreated FROM OrderArchive;";
			ResultSet orderDates = stmt.executeQuery(string);
			Vector comboBoxItems = new Vector();
			comboBoxItems.add("Select a Date");
			while (orderDates.next()) {
				comboBoxItems.add(orderDates.getDate(1).toString());
				
			}
			DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
			dateSelection = new JComboBox(model);
			dateSelection.addActionListener(salesReportActionListener);
			dateSelection.setPreferredSize(new Dimension(300, 35));
			dateSelection.setFont(new Font("Arial", Font.PLAIN, 22));
			selectionPanel.add(dateSelection);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	/*
	 * EXIT SYSTEM BUTTON HANDLER
	 */
	private class ExitSystemHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			setVisible(false);
		} 
	}
	private class SalesReportActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			if (dateSelection.getSelectedIndex() != 0) {
				/*
				 * GET CONNECTION
				 */
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/r2db", "root", "");
					Statement stmt = conn.createStatement();
					String getArchiveOrders = "SELECT * FROM OrderArchive WHERE tableDateCreated='" + dateSelection.getSelectedItem().toString() + "';";
					ResultSet archiveOrders = stmt.executeQuery(getArchiveOrders);
					salesRecordsPanel.removeAll();
					salesRecordsPanel.add(new SalesRecordLabelPanel("DATE", "TIME", "EMPLOYEE", "TABLE", "ITEM", "PRICE"));
					salesRecordsPanel.add(new JLabel("___________________________________________________________________________________________________________________"));
					Double totalSales = 0.0;
					int panelCount = 0;
					while (archiveOrders.next()) {
						panelCount++;
						String employeeFirstName = "";
						String employeeLastName = "";
						String menuItemName = "";
						Double menuItemPrice = 0.0;
						/*
						 * GET MENU ITEM ATTRIBUTES
						 */
						try {							
							Statement stmt2 = conn.createStatement();
							String getItemAttributes = "SELECT menuItemName, menuItemPrice FROM MenuItems WHERE menuItemID='" + archiveOrders.getString(3) + "';";
							ResultSet itemAttributes = stmt2.executeQuery(getItemAttributes);
							while (itemAttributes.next()) {
								menuItemName = itemAttributes.getString(1);
								menuItemPrice = itemAttributes.getDouble(2);
								totalSales += itemAttributes.getDouble(2);
							}
						}
						catch (Exception e) {
							JOptionPane.showMessageDialog(null, e);
						}
						/*
						 * GET THE EMPLOYEE NAME
						 */
						try {
							Statement stmt3 = conn.createStatement();
							String getName = "SELECT userFirstName, userLastName FROM Users WHERE userID='" + archiveOrders.getString(2) + "';";
							ResultSet empName = stmt3.executeQuery(getName);
							while (empName.next()) {
								employeeFirstName = empName.getString(1);
								employeeLastName = empName.getString(2);
							}
						}
						catch (Exception e) {
							JOptionPane.showMessageDialog(null, e);
						}
						/*
						 * CREATE A NEW RECORD PANEL
						 */
						SalesRecordLabelPanel panel = new SalesRecordLabelPanel(
								archiveOrders.getString(5), 
								archiveOrders.getString(6), 
								employeeFirstName + " " + employeeLastName, 
								archiveOrders.getString(4), 
								menuItemName, String.format("%.2f", menuItemPrice));
						/*
						 * ADD THE PANEL
						 */
						salesRecordsPanel.add(panel);
						salesRecordsPanel.repaint();
						salesRecordsPanel.revalidate();
					}
					salesRecordsPanel.add(new JLabel("____________________________________________________________________________________________________________"));
					salesRecordsPanel.add(new SalesRecordLabelPanel("", "", "", "", "TOTAL SALES", String.format("%.2f", totalSales)));
					salesRecordsPanel.setPreferredSize(new Dimension((int)(Main.screenSize.getWidth() * 0.70), (int)((Main.screenSize.getHeight() * 0.74) + (panelCount * 32))));
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		}
	}
	
	/*
	 * SALES REPORT ITEM LISTENER
	 */
}
