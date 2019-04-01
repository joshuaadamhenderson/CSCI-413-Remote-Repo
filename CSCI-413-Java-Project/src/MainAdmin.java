import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainAdmin extends JFrame {
	/*
	 * VARIABLES
	 */
	public static final ImageIcon LOGO = new ImageIcon("src/adminWelcomeLabel.png");
	public static JPanel centerPanel = new JPanel();
	public static JPanel headerPanel = new JPanel();
	public static JPanel fieldPanel = new JPanel();
	public static JPanel boxPanel = new JPanel();
	public static JPanel footerPanel = new JPanel();
	public static JPanel spacerPanel = new JPanel();
	public static JPanel spacerPanel2 = new JPanel();
	public static JPanel selectionPanel = new JPanel();
	/*
	 * LABELS
	 */
	public static JLabel welcomeLabel = new JLabel(LOGO);
	public static JLabel createNewEmployeeLabel = new JLabel("Employee Records");
	
	public static AdminPanelLabel userIDLabel = new AdminPanelLabel("User ID");
	public static AdminPanelLabel userFirstNameLabel = new AdminPanelLabel("First Name");
	public static AdminPanelLabel userLastNameLabel = new AdminPanelLabel("Last Name");
	public static AdminPanelLabel userRankLabel = new AdminPanelLabel("Position");
	public static AdminPanelLabel userPayRateLabel = new AdminPanelLabel("Pay Rate");
	public static AdminPanelLabel userHireDateLabel = new AdminPanelLabel("Date Hired");
	/*
	 * TEXT FIELDS
	 */
	public static AdminPanelTextField userIDTextField = new AdminPanelTextField();
	public static AdminPanelTextField userFirstNameTextField = new AdminPanelTextField();
	public static AdminPanelTextField userLastNameTextField = new AdminPanelTextField();
	public static AdminPanelTextField userRankTextField = new AdminPanelTextField();
	public static AdminPanelTextField userPayRateTextField = new AdminPanelTextField();
	public static AdminPanelTextField userHireDateTextField = new AdminPanelTextField();
	/*
	 * COMBO BOX
	 */
	public static String[] existingUsers = new String[] {"Create New User"};
	public static DefaultComboBoxModel<String> userSelectionModel = new DefaultComboBoxModel<String>(existingUsers);
	public static JComboBox<String> userSelection = new JComboBox<>(userSelectionModel);
	/*
	 * BUTTONS
	 */
	public static JButton exitButton = new JButton("EXIT");
	public static JButton createNewUserButton = new JButton("Create New Employee");
	public static JButton saveChangesButton = new JButton("Save Changes");
	public static JButton deleteUserButton = new JButton("Delete Employee");
	/*
	 * HANDLERS
	 */
	public static ExitSystemHandler exitSystemHandler;
	public static CreateNewUserHandler createNewUserHandler;
	public static SaveChangesHandler saveChangesHandler;
	public static DeleteUserHandler deleteUserHandler;
	public static UserSelectionHandler userSelectionHandler;
	/*
	 * USERS
	 */
	public static List<User> userList = new ArrayList<User>();
	/*
	 * EXCEPTIONS
	 */
	public static Exception userIDExists = new Exception("User already exists. Please enter a different User ID.");
	public static Exception userIDNull = new Exception("You must enter a user ID.");
	/*
	 * MAIN CONSTRUCTOR
	 */
	public MainAdmin() {
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
		/*
		 * INSTANTIATIONS
		 */
		exitSystemHandler = new ExitSystemHandler();
		createNewUserHandler = new CreateNewUserHandler();
		deleteUserHandler = new DeleteUserHandler();
		saveChangesHandler = new SaveChangesHandler();
		userSelectionHandler = new UserSelectionHandler();
		
		spacerPanel.setPreferredSize(new Dimension(200, 20));
		spacerPanel.setBackground(Main.ORIGINAL_DARK_BLUE);
		spacerPanel2.setPreferredSize(new Dimension(200, 20));
		spacerPanel2.setBackground(Main.ORIGINAL_DARK_BLUE);
		centerPanel.setBackground(Main.ORIGINAL_DARK_BLUE);
		headerPanel.setLayout(new BorderLayout());
		headerPanel.setBackground(Main.ORIGINAL_DARK_BLUE);
		headerPanel.setPreferredSize(new Dimension(0, 200));
		footerPanel.setLayout(new BorderLayout());
		footerPanel.setBackground(Main.ORIGINAL_DARK_BLUE);
		footerPanel.setPreferredSize(new Dimension(0, 100));
		fieldPanel.setLayout(new FlowLayout());
		fieldPanel.setBackground(Main.ORIGINAL_DARK_BLUE);
		fieldPanel.setPreferredSize(new Dimension(200, 800));
		boxPanel.setBackground(Main.ORIGINAL_DARK_BLUE);
		boxPanel.setPreferredSize(new Dimension(400, 800));
		selectionPanel.setBackground(Main.ORIGINAL_DARK_BLUE);
		selectionPanel.setPreferredSize(new Dimension(1366, 70));
		userSelection.setPreferredSize(new Dimension(406, 35));
		userSelection.setFont(new Font("Arial", Font.PLAIN, 22));
		fieldPanel.setBackground(Main.ORIGINAL_DARK_BLUE);

		exitButton.setBackground(Main.ORIGINAL_DARK_BLUE);
		exitButton.setPreferredSize(new Dimension(150, 70));
		exitButton.setFont(Main.KEYPAD_FONT);
		exitButton.setForeground(Color.WHITE);
		exitButton.addActionListener(exitSystemHandler);
		
		createNewUserButton.addActionListener(createNewUserHandler);
		createNewUserButton.setPreferredSize(new Dimension(274,30));
		createNewUserButton.setFont(new Font("Arial", Font.BOLD, 16));
		
		saveChangesButton.addActionListener(saveChangesHandler);
		saveChangesButton.setPreferredSize(new Dimension(274,30));
		saveChangesButton.setFont(new Font("Arial", Font.BOLD, 16));

		deleteUserButton.addActionListener(deleteUserHandler);
		deleteUserButton.setPreferredSize(new Dimension(274,30));
		deleteUserButton.setFont(new Font("Arial", Font.BOLD, 16));
		deleteUserButton.setForeground(Color.RED);

		createNewEmployeeLabel.setPreferredSize(new Dimension(1366, 100));
		createNewEmployeeLabel.setHorizontalAlignment(JLabel.CENTER);
		createNewEmployeeLabel.setFont(new Font("Arial", Font.BOLD, 45));
		createNewEmployeeLabel.setForeground(Color.WHITE);
		
		add(headerPanel, BorderLayout.PAGE_START);
		add(footerPanel, BorderLayout.PAGE_END);
		add(centerPanel, BorderLayout.CENTER);
		headerPanel.add(welcomeLabel, BorderLayout.WEST);
		headerPanel.add(exitButton, BorderLayout.EAST);
		headerPanel.add(createNewEmployeeLabel, BorderLayout.PAGE_END);
		centerPanel.add(selectionPanel);
		centerPanel.add(fieldPanel, BorderLayout.WEST);
		centerPanel.add(boxPanel, BorderLayout.EAST);
		
		selectionPanel.add(userSelection);
		fieldPanel.add(userIDLabel);
		fieldPanel.add(userFirstNameLabel);
		fieldPanel.add(userLastNameLabel);
		fieldPanel.add(userRankLabel);
		fieldPanel.add(userPayRateLabel);
		fieldPanel.add(userHireDateLabel);
		
		boxPanel.add(userIDTextField);
		boxPanel.add(userFirstNameTextField);
		boxPanel.add(userLastNameTextField);
		boxPanel.add(userRankTextField);
		boxPanel.add(userPayRateTextField);
		boxPanel.add(userHireDateTextField);
		boxPanel.add(spacerPanel);
		boxPanel.add(createNewUserButton);
		boxPanel.add(saveChangesButton);
		boxPanel.add(spacerPanel2);
		boxPanel.add(deleteUserButton);
		
		saveChangesButton.setEnabled(false);
		deleteUserButton.setEnabled(false);
		
		userSelection.addItemListener(userSelectionHandler);
		
		GetUsers();
		
		for (User user: userList) {
			userSelectionModel.addElement(user.getUserID() + " - " + user.getUserFirstName() + " " + user.getUserLastName());
		}			
	}
	/*
	 * GET USERS
	 */
	public void GetUsers() {
		
		try {
			Connection conn = DriverManager.getConnection(Main.URL, Main.USERNAME, Main.PASSWORD);
			Statement stmt = conn.createStatement();
			
			String string = "SELECT * FROM Users;";
			ResultSet rs = stmt.executeQuery(string);
			
			while (rs.next()) {
				userList.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6)));
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	/*
	 * USER SELECTION ITEM LISTENER
	 */
	private class UserSelectionHandler implements ItemListener {
		
		@Override
		public void itemStateChanged(ItemEvent event) {
			
			if (userSelection.getSelectedIndex() == 0) {
				createNewUserButton.setEnabled(true);
				saveChangesButton.setEnabled(false);
				deleteUserButton.setEnabled(false);
				userIDTextField.setEditable(true);
				userIDTextField.setText("");
				userIDTextField.setForeground(Color.BLACK);
				userFirstNameTextField.setText("");
				userLastNameTextField.setText("");
				userRankTextField.setText("");
				userPayRateTextField.setText("");
				userHireDateTextField.setText("");															
			}
			else {
				createNewUserButton.setEnabled(false);
				saveChangesButton.setEnabled(true);
				deleteUserButton.setEnabled(true);
				userIDTextField.setText(userList.get(userSelection.getSelectedIndex() - 1).getUserID());
				userIDTextField.setEditable(false);
				userIDTextField.setForeground(Color.GRAY);
				userFirstNameTextField.setText(userList.get(userSelection.getSelectedIndex() - 1).getUserFirstName());
				userLastNameTextField.setText(userList.get(userSelection.getSelectedIndex() - 1).getUserLastName());
				userRankTextField.setText(userList.get(userSelection.getSelectedIndex() - 1).getUserRank());
				userPayRateTextField.setText(userList.get(userSelection.getSelectedIndex() - 1).getUserPayRate().toString());
				userHireDateTextField.setText(userList.get(userSelection.getSelectedIndex() - 1).getUserHireDate());
			}
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
	/*
	 * CREATE NEW USER BUTTON HANDLER
	 */
	private class CreateNewUserHandler implements ActionListener {
				
		@Override
		public void actionPerformed(ActionEvent event) {
			
			try {
				Connection conn = DriverManager.getConnection(Main.URL, Main.USERNAME, Main.PASSWORD);
				Statement stmt = conn.createStatement();
				
				String userRequest = "SELECT * FROM Users WHERE userID = '" + userIDTextField.getText() + "';";
				ResultSet userResults = stmt.executeQuery(userRequest);
				
				while (userResults.next()) {
					if (userResults.getString(1) != null) {
						throw userIDExists;
					}
				}

				if (userIDTextField.getText() == "" || userIDTextField == null) {
					JOptionPane.showMessageDialog(null, "Must enter user ID.");
				}
				else {
					String insertUser = "INSERT INTO Users (userID, userFirstName, userLastName, userRank, userHireDate)"
							+ "VALUES ('"
							+ userIDTextField.getText()
							+ "', '"
							+ userFirstNameTextField.getText()
							+ "', '"
							+ userLastNameTextField.getText()
							+ "', '"
							+ userRankTextField.getText()
							+ "', '"
							+ userPayRateTextField.getText()
							+ "', '"
							+ userHireDateTextField.getText()
							+ "');";
					stmt.executeUpdate(insertUser);
					JOptionPane.showMessageDialog(null, String.format("User %s created.", userIDTextField.getText()));
					userIDTextField.setText("");
					userFirstNameTextField.setText("");
					userLastNameTextField.setText("");
					userRankTextField.setText("");
					userPayRateTextField.setText("");
					userHireDateTextField.setText("");															
				}
			}
			
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
				userIDTextField.setText("");
			}
		} 
	}
	/*
	 * SAVE CHANGES HANDLER
	 */
	private class SaveChangesHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			try {
				Connection conn = DriverManager.getConnection(Main.URL, Main.USERNAME, Main.PASSWORD);
				Statement stmt = conn.createStatement();
				
				String userUpdate = "UPDATE Users SET "
						+ "userFirstName='"
						+ userFirstNameTextField.getText() 
						+ "', userLastName='"
						+ userLastNameTextField.getText()
						+ "', userRank='"
						+ userRankTextField.getText()
						+ "', userHireDate='"
						+ userHireDateTextField.getText()
						+ "', userPayRate='"
						+ userPayRateTextField.getText()
						+ "' WHERE userID='"
						+ userIDTextField.getText()
						+ "';";
				stmt.executeUpdate(userUpdate);
				JOptionPane.showMessageDialog(null, "User " + userIDTextField.getText() + " updated.");
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
			userIDTextField.setText("");
			userFirstNameTextField.setText("");
			userLastNameTextField.setText("");
			userRankTextField.setText("");
			userPayRateTextField.setText("");
			userHireDateTextField.setText("");																		
		}
	}
	/*
	 * DELETE USER HANDLER
	 */
	private class DeleteUserHandler implements ActionListener {
		
		int dialogResponse;
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			dialogResponse = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?\n\n WARNING: THIS CANNOT BE UNDONE\n", "Delete Record", JOptionPane.YES_NO_OPTION);
			
			if (dialogResponse == JOptionPane.YES_OPTION) {
				try {
					Connection conn = DriverManager.getConnection(Main.URL, Main.USERNAME, Main.PASSWORD);
					Statement stmt = conn.createStatement();
					
					String userDelete = "DELETE FROM Users WHERE userID='" + userIDTextField.getText() + "';";
					stmt.executeUpdate(userDelete);
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				userIDTextField.setText("");
				userFirstNameTextField.setText("");
				userLastNameTextField.setText("");
				userRankTextField.setText("");
				userPayRateTextField.setText("");
				userHireDateTextField.setText("");															
			}
		}
	}
}
