/*
 * PROJECT:			Software Engineering Group Project, Restaurant Point-Of-Sale System
 * GROUP:			Round Two
 * MEMBERS:			Dipesh Bhandari, Alex Gayle, Eric Greene, Joshua Henderson
 * COURSE:			CSCI 413, Software Engineering II
 * INSTRUCTOR:		Dr. Bei Xie
 * DATE CREATED:	2/1/2019
 * EDITED BY:		2/1/2019:	Joshua Henderson
 * */

// ******************** IMPORTED CLASSES ********************
// The two class libraries we'll be using the most are the Abstract Windows Toolkit (awt), and
// Java's Swing components. The swing components have an automatic "look and feel" to them,
// meaning while using Windows, the JFrame will look like a Windows-based window (minimize, maximize,
// close buttons, title at the top). 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main extends JFrame {
	
	// We'll keep the constants and panels in the Main class to be referenced by other classes.
	
	// ******************** NAMING CONVENTIONS ********************
	// Constants:				MENU_ITEM
	// Classes and Objects:		MenuItem
	// Variables:				menuItem
	
	// ******************** IMAGES ********************
	// The ImageIcon object needs to be imported (javax.swing.ImageIcon).
	// The images themselves are stored in the src folder, which contains the java files.
	
	// FunctionPanel images
	public static final ImageIcon BUTTON_IMAGE_PAYMENTS = new ImageIcon("src/buttonPayments.jpg");
	public static final ImageIcon BUTTON_IMAGE_STYLE = new ImageIcon("src/buttonStyle.jpg");
	public static final ImageIcon BUTTON_IMAGE_OPEN = new ImageIcon("src/buttonOpen.jpg");
	public static final ImageIcon BUTTON_IMAGE_MODIFY = new ImageIcon("src/buttonModify.jpg");
	public static final ImageIcon BUTTON_IMAGE_PRINT = new ImageIcon("src/buttonPrint.jpg");
	public static final ImageIcon BUTTON_IMAGE_EDIT_TIPS = new ImageIcon("src/buttonEditTips.jpg");
	public static final ImageIcon BUTTON_IMAGE_EXIT = new ImageIcon("src/buttonExit.jpg");
	
	// Payments images
	public static final ImageIcon BUTTON_IMAGE_1 = new ImageIcon("src/button_1.jpg");
	public static final ImageIcon BUTTON_IMAGE_5 = new ImageIcon("src/button_5.jpg");
	public static final ImageIcon BUTTON_IMAGE_20 = new ImageIcon("src/button_20.jpg");
	public static final ImageIcon BUTTON_IMAGE_100 = new ImageIcon("src/button_100.jpg");

	// ******************** COLORS ********************
	// The Color object needs to be imported (java.awt.Color).
	// Color objects can take on different arguments, one of which is the RGB values.
	public static final Color MENU_PANEL_BUTTON_COLOR = new Color(100, 140, 160);
	public static final Color MENU_PANEL_FONT_COLOR = new Color(255, 255, 255);
	public static final Color OPTIONS_PANEL_BG_COLOR = new Color(74, 89, 113);
	public static final Color CATEGORY_PANEL_BG_COLOR = new Color(74, 89, 113);
	public static final Color MAIN_BG_COLOR = new Color(0, 60, 90);
	public static final Color MAIN_TEXT_COLOR = new Color(255, 255, 255);
	public static final Color KEYPAD_BUTTON_COLOR = new Color(0, 55, 85);
	public static final Color MENU_ITEM_BUTTON_COLOR_1 = new Color(52, 147, 59);
	public static final Color MENU_ITEM_BUTTON_COLOR_2 = new Color(216, 135, 91);
	public static final Color MENU_ITEM_BUTTON_COLOR_3 = new Color(191, 91, 216);
	public static final Color MENU_ITEM_BUTTON_COLOR_4 = new Color(91, 215, 216);
	public static final Color MENU_ITEM_BUTTON_COLOR_5 = new Color(216, 103, 91);
	
	// ******************** FONTS ********************
	// The Font object needs to be imported (java.awt.Font).
	// Fonts have three arguments, the name of the font, the weight, and the pixel size.
	// There are predefined constants in the Font class for PLAIN, BOLD, ITALIC, etc.
	public static final Font PROGRAM_FONT = new Font("Arial", Font.BOLD, 18);
	public static final Font KEYPAD_FONT = new Font("Arial", Font.BOLD, 30);
	
	// ******************** DIMENSIONS ********************
	// These are just integers to hold widths and heights across the program.
	public static final int MAIN_WIDTH = 1366;
	public static final int MAIN_HEIGHT = 768;
	public static final int CATEGORY_PANEL_WIDTH = 890;
	public static final int CATEGORY_PANEL_HEIGHT = 540;
	public static final int DISPLAY_PANEL_WIDTH = 466;
	public static final int DISPLAY_PANEL_HEIGHT = 0;
	public static final int FUNCTION_PANEL_WIDTH = 0;
	public static final int FUNCTION_PANEL_HEIGHT = 100;
	public static final int OPTIONS_PANEL_WIDTH = 900;
	public static final int OPTIONS_PANEL_HEIGHT = 550;
	public static final int HEADER_PANEL_WIDTH = 1366;
	public static final int HEADER_PANEL_HEIGHT = 168;
	public static final int KEYPAD_PANEL_WIDTH = 450;
	public static final int KEYPAD_PANEL_HEIGHT = 500;
	public static final int PAYMENT_BUTTON_WIDTH = 250;
	public static final int PAYMENT_BUTTON_HEIGHT = 110;
	
	// ******************** PANELS ******************************************
	// Our JFrames are divided into panels for easy organization and layout.
	public static FunctionPanel functionPanel = new FunctionPanel();			// The very top row of functions
	public static MenuPanel menuPanel = new MenuPanel();						// The row under that with menu categories
	public static HeaderPanel headerPanel = new HeaderPanel();
	public static OptionsPanel optionsPanel = new OptionsPanel();
	public static DisplayPanel displayPanel = new DisplayPanel(); //Table class goes in here
	public static StatusPanel statusPanel = new StatusPanel();
	public static LoginPanel loginPanel = new LoginPanel();
	public static LoginPanel blank = new LoginPanel();
	public static KeypadPanel keypadPanel = new KeypadPanel();
	public static LoginPanel userLoginPanel = new LoginPanel();
	public static UserPanel userPanel = new UserPanel();
	
	// ******************** LABELS ********************
	public static JLabel currentUserLabel = new JLabel("");
	
	// **************** TEXT FIELDS ****************************************
	public static JTextField userLoginTextField = new JTextField(6);
	
	// ******************** STRINGS ***************************************
	public static String currentUserID = new String("");
	public static String currentUserName = new String("");
	
	public static String alexGayle = new String("Alex G.");
	public static String ericGreene = new String("Eric G.");
	public static String joshuaHenderson = new String("Joshua H.");

	public static String alexID = new String("000200");
	public static String ericID = new String("000300");
	public static String joshuaID = new String("000400");
	
	// ******************** USERS ***************************************
	public static User dipeshBhandari = new User("", "", "", "", "");
	
	// ******************** BUTTONS ********************
	// We didn't define these as MenuButtons because we're simply attaching
	// images to them, which is already its own constructor in the JButton
	// class. We've made the MenuButton class separately so we can define a
	// constructor that uses text and colors for the arguments. But again,
	// in this case we only need the corresponding JPG file for each.
	public static JButton buttonPayments = new JButton(BUTTON_IMAGE_PAYMENTS);
	public static JButton buttonOpen = new JButton(BUTTON_IMAGE_OPEN);
	public static JButton buttonPrint = new JButton(BUTTON_IMAGE_PRINT);
	public static JButton buttonModify = new JButton(BUTTON_IMAGE_MODIFY);
	public static JButton buttonEditTips = new JButton(BUTTON_IMAGE_EDIT_TIPS);
	public static JButton button6 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton button7 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton button8 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton button9 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton buttonExit = new JButton(BUTTON_IMAGE_EXIT);
	
	public static JButton button_1 = new JButton(BUTTON_IMAGE_1);
	public static JButton button_5 = new JButton(BUTTON_IMAGE_5);
	public static JButton button_20 = new JButton(BUTTON_IMAGE_20);
	public static JButton button_100 = new JButton(BUTTON_IMAGE_100);
	
	public static KeypadButton button0Key = new KeypadButton("0");
	public static KeypadButton button1Key = new KeypadButton("1");
	public static KeypadButton button2Key = new KeypadButton("2");
	public static KeypadButton button3Key = new KeypadButton("3");
	public static KeypadButton button4Key = new KeypadButton("4");
	public static KeypadButton button5Key = new KeypadButton("5");
	public static KeypadButton button6Key = new KeypadButton("6");
	public static KeypadButton button7Key = new KeypadButton("7");
	public static KeypadButton button8Key = new KeypadButton("8");
	public static KeypadButton button9Key = new KeypadButton("9");
	
	public static KeypadButton buttonConfirmKey = new KeypadButton("OK");
	public static KeypadButton buttonClearKey = new KeypadButton("CLEAR");
	
	public static JButton currentUserChecks = new JButton("Checks");

	// ******************** CATEGORIES ********************
	public static CategoryPanel payments = new CategoryPanel();
	public static CategoryPanel appetizers = new CategoryPanel();
	public static CategoryPanel entrees = new CategoryPanel();
	
	// Constructor for Main. We can make adjustments to the frame properties here. Since the
	// Main class extends JFrame, we can use all of JFrame methods, including settings for the
	// background color, text color(foreground), frame dimensions, and layout manager. The
	// setUndecorated method removes the buttons and title from the top of the JFrame, and the
	// setExtendedState method forces the window to be maximized. Not every JFrame will exit the
	// program when the exit button is clicked, some will open another frame. This method isn't
	// that necessary right now since we've created a separate button to exit the program. Finally,
	// we have to set the frame to be visible.
	public Main() {
		
		// Main window settings
		setBackground(Main.MAIN_BG_COLOR);
		setForeground(Main.MAIN_TEXT_COLOR);
		setSize(MAIN_WIDTH, MAIN_HEIGHT);
		getContentPane().setLayout(new BorderLayout());
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// ********************* HEADER PANEL ****************************************
		headerPanel.add(functionPanel);
		headerPanel.add(menuPanel);
		
		// ********************* DISPLAY PANEL ****************************************
		displayPanel.add(userPanel, BorderLayout.PAGE_START);
		
		// ********************* USER PANEL *******************************************
		userPanel.add(currentUserLabel, BorderLayout.WEST);
		userPanel.add(currentUserChecks, BorderLayout.EAST);
		currentUserLabel.setFont(new Font("Arial", Font.BOLD, 18));
		currentUserChecks.setBackground(Color.WHITE);
		
		// ************************* LOGIN ********************************************
		keypadPanel.add(button1Key);
		keypadPanel.add(button2Key);
		keypadPanel.add(button3Key);
		keypadPanel.add(button4Key);
		keypadPanel.add(button5Key);
		keypadPanel.add(button6Key);
		keypadPanel.add(button7Key);
		keypadPanel.add(button8Key);
		keypadPanel.add(button9Key);
		keypadPanel.add(buttonConfirmKey);
		keypadPanel.add(button0Key);
		keypadPanel.add(buttonClearKey);
		userLoginTextField.setFont(KEYPAD_FONT);
		userLoginTextField.setBackground(MAIN_BG_COLOR);
		userLoginTextField.setForeground(MAIN_TEXT_COLOR);
		blank.setPreferredSize(new Dimension(1366, 150));
		blank.add(userLoginTextField);
		
		loginPanel.add(blank, BorderLayout.PAGE_START);
		loginPanel.add(keypadPanel, BorderLayout.CENTER);
		// ************************** USER BUTTON ************************************
		currentUserChecks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				optionsPanel.removeAll();
				optionsPanel.repaint();
				optionsPanel.revalidate();
				
			}
		});
		//************************* PAYMENTS BUTTON ***********************************
		
		// Set the size of our cash image buttons.
		button_1.setPreferredSize(new Dimension(PAYMENT_BUTTON_WIDTH, PAYMENT_BUTTON_HEIGHT));
		button_5.setPreferredSize(new Dimension(PAYMENT_BUTTON_WIDTH, PAYMENT_BUTTON_HEIGHT));
		button_20.setPreferredSize(new Dimension(PAYMENT_BUTTON_WIDTH, PAYMENT_BUTTON_HEIGHT));
		button_100.setPreferredSize(new Dimension(PAYMENT_BUTTON_WIDTH, PAYMENT_BUTTON_HEIGHT));
		
		// Add the cash buttons to the "payments" CategoryPanel
		payments.add(button_1);
		payments.add(button_5);
		payments.add(button_20);
		payments.add(button_100);
			
		// Add buttonPayments to the FunctionPanel
		functionPanel.add(Main.buttonPayments);
		
		// Define buttonPayments
		Main.buttonPayments.addActionListener(new ActionListener() {
			
			// This new object ActionListener defines a single method
			// of what will happen when the button is pressed.
			// This object requires that you implement its only method,
			// actionPerformed. The @Override annotation replaces the
			// original actionPerformed method with the new one here.
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// We'll modify the OptionsPanel here, which is where we
				// want the buttons to display. The removeAll method removes
				// all the components in optionsPanel. The repaint and validate
				// methods are required to basically reassess the panel.
				Main.optionsPanel.removeAll();
				Main.optionsPanel.repaint();
				Main.optionsPanel.validate();					
				
				// Here is where we'll add the corresponding CategoryPanel.
				// We'll run the repaint and validate methods again.
				Main.optionsPanel.add(Main.payments);
				Main.optionsPanel.repaint();
				Main.optionsPanel.validate();
			}
		});
				
		// ************************** OPEN *****************************
		functionPanel.add(Main.buttonOpen);

		// ************************** PRINT ****************************
		functionPanel.add(Main.buttonPrint);

		// ************************** MODIFY ***************************
		functionPanel.add(Main.buttonModify);
		
		// ************************** EDIT TIPS ************************
		functionPanel.add(Main.buttonEditTips);
		
		// ************************** EXTRA BUTTONS ********************
		functionPanel.add(Main.button6);		
		functionPanel.add(Main.button7);		
		functionPanel.add(Main.button8);
		
		// ************************** EXIT *****************************
		functionPanel.add(Main.buttonExit);
		
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				// For now, we'll have this button just terminate the program.
				System.exit(0);
			} 
		});
	}
// ************************ MAIN METHOD *****************************************
	public static void main(String[] args) {

		// Load database elements
		loadData();
		
		// Create a new Main object and add the panels to it. Each swing component
		// has the method add.		
		Main main = new Main();
		loadLoginKeyValues(main);
		loadLoginScreen(main);
	}

// ************************** OTHER METHODS *************************************
	public static void loadLoginKeyValues(Main main) {
		
		button1Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				currentUserID += "1";
				userLoginTextField.setText(currentUserID);
			}
		});
		button2Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				currentUserID += "2";
				userLoginTextField.setText(currentUserID);
			}
		});
		button3Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				currentUserID += "3";
				userLoginTextField.setText(currentUserID);
			}
		});
		button4Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				currentUserID += "4";
				userLoginTextField.setText(currentUserID);
			}
		});
		button5Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				currentUserID += "5";
				userLoginTextField.setText(currentUserID);
			}
		});
		button6Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				currentUserID += "6";
				userLoginTextField.setText(currentUserID);
			}
		});
		button7Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				currentUserID += "7";
				userLoginTextField.setText(currentUserID);
			}
		});
		button8Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				currentUserID += "8";
				userLoginTextField.setText(currentUserID);
			}
		});
		button9Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				currentUserID += "9";
				userLoginTextField.setText(currentUserID);
			}
		});
		button0Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				currentUserID += "0";
				userLoginTextField.setText(currentUserID);
			}
		});

		buttonClearKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				currentUserID = "";
				userLoginTextField.setText(currentUserID);
			}
		});			
		buttonConfirmKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				currentUserName = getUserName(currentUserID);
				currentUserLabel.setText(currentUserName);
				userPanel.removeAll();
				userPanel.repaint();
				userPanel.revalidate();
				userPanel.add(currentUserLabel, BorderLayout.WEST);
				userPanel.add(currentUserChecks, BorderLayout.EAST);
				userPanel.repaint();
				userPanel.revalidate();
				main.remove(loginPanel);
				main.repaint();
				main.revalidate();
				
				loadMainMenu(main);
			}
		});
	}
	public static void loadLoginScreen(Main main) {
		main.add(loginPanel);
		main.repaint();
		main.revalidate();
	}	
	public static String getUserName(String id) {
		
		switch (id) {
			case "000200": return alexGayle;
			case "000300": return ericGreene;
			case "000400": return joshuaHenderson;
			default: return null;
		}
	}
	public static void loadMainMenu(Main main) {
		main.add(headerPanel, BorderLayout.PAGE_START);
		main.add(optionsPanel, BorderLayout.LINE_START);
		main.add(displayPanel, BorderLayout.LINE_END);
		main.add(statusPanel, BorderLayout.PAGE_END);
		main.repaint();
		main.revalidate();
		// The BorderLayout positions can be seen here. We've squeezed the
		// center out of our layout by forcing widths on the adjacent panels.
		
		//********************** BORDER LAYOUT ******************************
		/*   _______________________________________________________________
		 *  |                                                               |
		 *  |                          PAGE_START                           |
		 *  |_______________________________________________________________|
		 *  |                   |                     |                     |
		 *  |                   |                     |                     |
		 *  |                   |                     |                     |
		 *  |     LINE_START    |        CENTER       |      LINE_END       |
		 *  |                   |                     |                     |
		 *  |                   |                     |                     |
		 *  |                   |                     |                     |
		 *  |___________________|_____________________|_____________________|
		 *  |                                                               |
		 *  |                           PAGE_END                            |
		 *  |_______________________________________________________________| 
		 */
		
		//************************* OUR LAYOUT ******************************
		/*   _______________________________________________________________
		 *  |                                                               |        _______________________
		 *  |                          headerPanel                          | <---- |     functionPanel     |
		 *  |_______________________________________________________________|       |_______________________|
		 *  |                                   |  _______________________  |       |       menuPanel       |
		 *  |                                   | |      userPanel        | |       |_______________________|
		 *  |                                   | |_______________________| |
		 *  |           optionsPanel            |                           |
		 *  |                                   |       displayPanel        |
		 *  |                                   |                           |
		 *  |                                   |                           |
		 *  |___________________________________|___________________________|
		 *  |                          statusPanel                          |
		 *  |_______________________________________________________________| 
		 */
	}
	public static void loadData() {
		
		// Load database elements
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://108.167.172.113:3306/jhenders_group_project", "jhenders_1", "password");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT userID FROM Users WHERE userFirstName = 'Dipesh'");
			
			while (rs.next()) {
				dipeshBhandari.setUserID(rs.getString(1));
				dipeshBhandari.setUserFirstName(rs.getString(2));
				dipeshBhandari.setUserLastName(rs.getString(3));
				dipeshBhandari.setUserRank(rs.getString(4));
				dipeshBhandari.setUserHireDate(rs.getString(5));
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
