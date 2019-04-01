import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class EmployeePayrollFrame extends JFrame {

	public static final ImageIcon LOGO = new ImageIcon("src/adminWelcomeLabel.png");
	public static JLabel welcomeLabel = new JLabel(LOGO);
	public static JPanel centerPanel = new JPanel();
	public static JPanel headerPanel = new JPanel();
	public static JPanel footerPanel = new JPanel();
	public static JPanel selectionPanel = new JPanel();
	public static JPanel formPanel = new JPanel();
	public static JPanel employeePayrollPanel = new JPanel();
	
	public static JButton exitButton = new JButton("EXIT");
	public static JComboBox employeeSelection;

	public static String[] employees = new String[100];
	
	public static JScrollPane employeePayrollScrollPane = new JScrollPane(employeePayrollPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	public static EmployeePayrollActionListener employeePayrollActionListener;
	public static ExitSystemHandler exitSystemHandler;
	public static int dateIndex = 0;

	public EmployeePayrollFrame() {
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
		employeePayrollScrollPane.setBackground(Color.WHITE);
		employeePayrollPanel.setBackground(Color.WHITE);
		employeePayrollPanel.setPreferredSize(new Dimension((int)(Main.screenSize.getWidth() * 0.70), (int)(Main.screenSize.getHeight() * 0.74)));
		
		add(headerPanel, BorderLayout.PAGE_START);
		add(footerPanel, BorderLayout.PAGE_END);
		add(centerPanel, BorderLayout.CENTER);
		formPanel.add(employeePayrollPanel);
		centerPanel.add(selectionPanel, BorderLayout.WEST);
		centerPanel.add(formPanel, BorderLayout.EAST);
		headerPanel.add(welcomeLabel, BorderLayout.WEST);
		headerPanel.add(exitButton, BorderLayout.EAST);
		
		exitSystemHandler = new ExitSystemHandler();
		employeePayrollActionListener = new EmployeePayrollActionListener();
		exitButton.addActionListener(exitSystemHandler);
		try {
			Connection conn = DriverManager.getConnection(Main.URL, Main.USERNAME, Main.PASSWORD);
			Statement stmt = conn.createStatement();
			String getUsers = "SELECT userID, userFirstName, userLastName FROM Users;";
			ResultSet users = stmt.executeQuery(getUsers);
			Vector comboBoxItems = new Vector();
			comboBoxItems.add("Select an Employee");
			while (users.next()) {
				comboBoxItems.add(users.getString(1) + " - " + users.getString(2) + " " + users.getString(3));
			}
			DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
			employeeSelection = new JComboBox(model);
			employeeSelection.addActionListener(employeePayrollActionListener);
			employeeSelection.setPreferredSize(new Dimension(300, 35));
			employeeSelection.setFont(new Font("Arial", Font.PLAIN, 22));
			selectionPanel.add(employeeSelection);
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
	private class EmployeePayrollActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			if (employeeSelection.getSelectedIndex() != 0) {
				/*
				 * GET CONNECTION
				 */
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/r2db", "root", "");
					Statement stmt = conn.createStatement();
					String getEmployeeShifts = "SELECT * FROM Shifts WHERE userID='" + employeeSelection.getSelectedItem().toString().substring(0, 4) + "';";
					ResultSet employeeShifts = stmt.executeQuery(getEmployeeShifts);
					employeePayrollPanel.removeAll();
					employeePayrollPanel.add(new EmployeePayrollLabelPanel("DATE", "IN", "OUT", "HOURS WORKED", "PAY RATE", "SHIFT PAY"));
					employeePayrollPanel.add(new JLabel("___________________________________________________________________________________________________________________"));
					Double totalPay = 0.0;
					int panelCount = 0;
					while (employeeShifts.next()) {
						panelCount++;
						String employeePayRate = "";
						/*
						 * GET EMPLOYEE PAY RATE
						 */
						try {							
							Statement stmt2 = conn.createStatement();
							String getPayRate = "SELECT userPayRate FROM Users WHERE userID='" + employeeShifts.getString(2) + "';";
							ResultSet payRate = stmt2.executeQuery(getPayRate);
							while (payRate.next()) {
								employeePayRate = payRate.getString(1);
							}
						}
						catch (Exception e) {
							JOptionPane.showMessageDialog(null, e);
						}
						/*
						 * GET THE SHIFT TIME
						 */
						int start = employeeShifts.getInt(3);
						int end = employeeShifts.getInt(4);
						String timeClockedIn = employeeShifts.getTime(5).toString();
						String timeClockedOut = employeeShifts.getTime(6).toString();
						/*
						 * GET THE HOURS WORKED
						 */
						int minutes = (end - start);
						Double hours = Double.valueOf(minutes / 60.0);
						Double payRate = Double.parseDouble(employeePayRate);
						Double shiftPay = hours * payRate;
						totalPay += shiftPay;
						/*
						 * CREATE A NEW RECORD PANEL
						 */
						EmployeePayrollLabelPanel panel = new EmployeePayrollLabelPanel(
								employeeShifts.getString(7), 
								timeClockedIn, 
								timeClockedOut, 
								String.format("%.2f", hours), String.format("%.2f", payRate), String.format("%.2f", shiftPay));
						/*
						 * ADD THE PANEL
						 */
						employeePayrollPanel.add(panel);
						employeePayrollPanel.repaint();
						employeePayrollPanel.revalidate();
					}
					employeePayrollPanel.add(new JLabel("___________________________________________________________________________________________________________________"));
					employeePayrollPanel.add(new EmployeePayrollLabelPanel("", "", "", "", "GROSS PAY", String.format("%.2f", totalPay)));
					employeePayrollPanel.setPreferredSize(new Dimension((int)(Main.screenSize.getWidth() * 0.70), (int)((Main.screenSize.getHeight() * 0.74)) + (panelCount * 22)));
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
