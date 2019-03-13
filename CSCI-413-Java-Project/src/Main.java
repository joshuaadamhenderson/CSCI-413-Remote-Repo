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
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main extends JFrame {
	
	// **********************************************************************************************************************************************
	// *																																			*
	// *														DECLARED VARIABLES																	*
	// *																																			*
	// **********************************************************************************************************************************************
	
	// ******************** NAMING CONVENTIONS ***********************************************************************************************
	// Constants:				MENU_ITEM
	// Classes and Objects:		MenuItem
	// Variables:				menuItem
	
	// ******************** IMAGES ***********************************************************************************************************
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

	// ******************** COLORS ***********************************************************************************************************
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
	
	// ******************** FONTS ***********************************************************************************************************
	public static final Font PROGRAM_FONT = new Font("Arial", Font.BOLD, 18);					// The Font object needs to be imported (java.awt.Font).
	public static final Font TABLE_BUTTON_FONT = new Font("Arial", Font.BOLD, 24);				// Fonts have three arguments, the name of the font, the
	public static final Font KEYPAD_FONT = new Font("Arial", Font.BOLD, 30);					// weight, and the pixel size. There are predefined 
	public static final Font MENU_ITEM_NAME_LABEL_FONT = new Font("Arial", Font.BOLD, 20);		// constants in the Font class for PLAIN, BOLD, ITALIC, etc.
	public static final Font MENU_ITEM_PRICE_LABEL_FONT = new Font("Arial", Font.PLAIN, 20);
	public static final Font USER_PANEL_FONT = new Font("Arial", Font.BOLD, 20);
	
	// ******************** DIMENSIONS ***********************************************************************************************************
	public static final int MAIN_WIDTH = 1366;					// These are just integers to hold widths and heights across the program.
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
	public static final int TABLE_BUTTON_HEIGHT = 70;
	public static final int TABLE_BUTTON_WIDTH = 880;
	public static final int MENU_ITEM_LABEL_PANEL_WIDTH = 440;
	public static final int MENU_ITEM_LABEL_PANEL_HEIGHT = 30;

	// ******************** TAX RATE ***********************************************************************************************************
	public static final double CALCASIEU_TAX_RATE = .1075;		// Tax rates for particular regions
	
	// ******************** PANELS ***********************************************************************************************************
	public static FunctionPanel functionPanel = new FunctionPanel();
	public static MenuPanel menuPanel = new MenuPanel();
	public static HeaderPanel headerPanel = new HeaderPanel();
	public static OptionsPanel optionsPanel = new OptionsPanel();
	public static DisplayPanel displayPanel = new DisplayPanel();
	public static StatusPanel statusPanel = new StatusPanel();
	public static LoginPanel loginPanel = new LoginPanel();
	public static LoginPanel blank = new LoginPanel();
	public static KeypadPanel keypadPanel = new KeypadPanel();
	public static LoginPanel userLoginPanel = new LoginPanel();
	public static UserPanel userPanel = new UserPanel();
	public static MenuItemPanel menuItemPanel = new MenuItemPanel();
	
	// ******************** USERS ***********************************************************************************************************
	public static String currentUserID = "";	// This will store the login String being typed in. It will start out empty.
	public static User currentUser;				// An empty User object that is set with a getUser() method from the String above.
	public static User dipeshBhandari = new User("1111", "Dipesh", "Bhandari", "Manager", "11-Apr-2015");
	public static User alexGayle = new User("2222", "Alex", "Gayle", "Waiter", "3-Sep-2018");
	public static User ericGreene = new User("3333", "Eric", "Greene", "Cook", "22-Jan-2017");
	public static User joshuaHenderson = new User("4444", "Joshua", "Henderson", "Busser", "15-Feb-2019");

	// ******************** TABLES ***********************************************************************************************************
	public static Table currentTable = new Table("", 0, "", "");
	public static Table table100 = new Table("100", 2, "10:05 PM", "7-Mar-2019");
	public static Table table101 = new Table("101", 1, "10:08 PM", "7-Mar-2019");
	public static Table table200 = new Table("200", 4, "10:15 PM", "7-Mar-2019");
	public static Table table201 = new Table("201", 2, "10:22 PM", "7-Mar-2019");
	public static Table table300 = new Table("300", 4, "11:05 PM", "7-Mar-2019");
	public static Table table301 = new Table("301", 2, "11:24 PM", "7-Mar-2019");

	public static List<Table> currentUserTables = new ArrayList<Table>();	// An empty array of Tables used for the currentUser object.
	public static List<Table> dipeshTables = new ArrayList<Table>();		// This array of Tables will be dedicated to Dipesh. This one is also null.
																			// We'll be adding the tables in the Main constructor using the User.setTables() method.

	// ******************** MENU ITEMS ********************************************************************************************************
	public static MenuItem buffaloWings = new MenuItem("1000", "Buffalo Wings", 6.99);		// These MenuItems will be declared and initialized.
	public static MenuItem chickenTenders = new MenuItem("1005", "Chicken Tenders", 6.99);	// The values won't need to change while the program is running.
	public static MenuItem friedAsparagus = new MenuItem("1010", "Fried Asparagus", 6.99);
	public static MenuItem spicyHummus = new MenuItem("1015", "Spicy Hummus", 6.99);
	public static MenuItem ultimateNachos = new MenuItem("1020", "Ultimate Nachos", 6.99);
	public static MenuItem crabCakes = new MenuItem("1025", "Crab Cakes", 6.99);

	public static List<MenuItem> currentTableMenuItems = new ArrayList<MenuItem>();		// An empty array of MenuItems for the currentTable
	public static List<MenuItem> table100MenuItems = new ArrayList<MenuItem>();			// Another empty array of MenuItems for Table 100

	// ******************** LABELS *************************************************************************************************************
	public static JLabel currentUserLabel = new JLabel("");		// This label holds an empty String for now. Logging in will assign the User's name here.
	
	// **************** TEXT FIELDS ***********************************************************************************************************
	public static JTextField userLoginTextField = new JTextField(4);	// This shows the login numbers being punched in.
	
	// ******************** BUTTONS ***********************************************************************************************************	
	public static JButton buttonPayments = new JButton(BUTTON_IMAGE_PAYMENTS);		// We didn't define these as MenuButtons because we're simply attaching
	public static JButton buttonOpen = new JButton(BUTTON_IMAGE_OPEN);				// images to them, which is already its own constructor in the JButton
	public static JButton buttonPrint = new JButton(BUTTON_IMAGE_PRINT);			// class. We've made the MenuButton class separately so we can define a
	public static JButton buttonModify = new JButton(BUTTON_IMAGE_MODIFY);			// constructor that uses text and colors for the arguments. But again,
	public static JButton buttonEditTips = new JButton(BUTTON_IMAGE_EDIT_TIPS);		// in this case we only need the corresponding JPG file for each, which
	public static JButton button6 = new JButton(BUTTON_IMAGE_STYLE);				// we previously defined as constants.
	public static JButton button7 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton button8 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton button9 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton buttonExit = new JButton(BUTTON_IMAGE_EXIT);
	
	public static JButton button_1 = new JButton(BUTTON_IMAGE_1);
	public static JButton button_5 = new JButton(BUTTON_IMAGE_5);
	public static JButton button_20 = new JButton(BUTTON_IMAGE_20);
	public static JButton button_100 = new JButton(BUTTON_IMAGE_100);
	
	public static JButton currentUserChecks = new JButton("Checks");

	// ******************** KEYPAD BUTTONS ***********************************************************************************************************
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
	
	// ************************* LOGIN KEY HANDLERS ********************************************
	public static LoginKeyHandler key_1;
	public static LoginKeyHandler key_2;
	public static LoginKeyHandler key_3;
	public static LoginKeyHandler key_4;
	public static LoginKeyHandler key_5;
	public static LoginKeyHandler key_6;
	public static LoginKeyHandler key_7;
	public static LoginKeyHandler key_8;
	public static LoginKeyHandler key_9;
	public static LoginKeyHandler key_0;
	
	// ******************** CATEGORIES ***********************************************************************************************************
	public static CategoryPanel payments = new CategoryPanel();
	public static CategoryPanel appetizers = new CategoryPanel();
	public static CategoryPanel entrees = new CategoryPanel();
	
	
	// **********************************************************************************************************************************************
	// *																																			*
	// *														MAIN CONSTRUCTOR																	*
	// *																																			*
	// **********************************************************************************************************************************************
	
	// Constructor for Main. We can make adjustments to the frame properties here. Since the Main class extends JFrame, we can use all of JFrame
	// methods, including settings for the background color, text color(foreground), frame dimensions, and layout manager. The setUndecorated 
	// method removes the buttons and title from the top of the JFrame, and the setExtendedState method forces the window to be maximized.
	// Not every JFrame will exit the program when the exit button is clicked, some will open another frame. This method isn't that necessary right
	// now since we've created a separate button to exit the program. Finally, we have to set the frame to be visible.
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
		
		// *******************************************************		|
		// *    											 	 *		|
		// *   The following part will assemble all the panels 	 *		|
		// *    											 	 *		|
		// *******************************************************		V
		
		// ********************* HEADER PANEL ****************************************
		headerPanel.add(functionPanel);
		headerPanel.add(menuPanel);
		
		// ********************* DISPLAY PANEL ****************************************
		displayPanel.add(userPanel, BorderLayout.PAGE_START);		// PAGE_START puts the userPanel at the top
		displayPanel.add(menuItemPanel, BorderLayout.PAGE_END);		// PAGE_END aligns menuItemPanel to the bottom
		
		// ********************* USER PANEL *******************************************
		userPanel.add(currentUserLabel, BorderLayout.WEST);			// currentUserLabel will be aligned WEST,
		userPanel.add(currentUserChecks, BorderLayout.EAST);		// and will be assigned when logging in.
		currentUserLabel.setFont(new Font("Arial", Font.BOLD, 18));	// The currentUserChecks button will be on
		currentUserChecks.setBackground(Color.WHITE);				// the right (EAST).
		// ************************* LOGIN KEY HANDLERS ********************************************
		key_1 = new LoginKeyHandler(1);
		key_2 = new LoginKeyHandler(2);
		key_3 = new LoginKeyHandler(3);
		key_4 = new LoginKeyHandler(4);
		key_5 = new LoginKeyHandler(5);
		key_6 = new LoginKeyHandler(6);
		key_7 = new LoginKeyHandler(7);
		key_8 = new LoginKeyHandler(8);
		key_9 = new LoginKeyHandler(9);
		key_0 = new LoginKeyHandler(0);
		
		// ************************* LOGIN ********************************************
		keypadPanel.add(button1Key);	// Add all the buttons for the keypadPanel, which will be using
		keypadPanel.add(button2Key);	// a GridLayout. This will fill the entire panel with equally sized
		keypadPanel.add(button3Key);	// buttons. If we adjust the size of the keypadPanel, the buttons
		keypadPanel.add(button4Key);	// will reflect.
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
		blank.setPreferredSize(new Dimension(1366, 150));	// "blank" is a keypadPanel, but only because we want the same
		blank.add(userLoginTextField);						// look as the keypad. The only thing it will contain is the
		loginPanel.add(blank, BorderLayout.PAGE_START);		// login text field. We add blank to the top, and keypadPanel
		loginPanel.add(keypadPanel, BorderLayout.CENTER);	// in the center.

		
		// ************************** TESTING SAMPLES ************************************
		
		// Add MenuItems to Table 100's MenuItem array.
		table100MenuItems.add(chickenTenders);
		table100MenuItems.add(friedAsparagus);

		// Set the MenuItem array to the Table.
		table100.setMenuItems(table100MenuItems);
		
		// Add these tables to a Table array.
		dipeshTables.add(table100);
		dipeshTables.add(table101);
		dipeshTables.add(table200);
		dipeshTables.add(table201);

		// Set a User with an array of Tables.
		dipeshBhandari.setTables(dipeshTables);
	
		//************************* CURRENT USER CHECKS BUTTON ***********************************		
		currentUserChecks.setFont(USER_PANEL_FONT);
		currentUserChecks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				optionsPanel.removeAll();
				optionsPanel.repaint();
				optionsPanel.revalidate();
				
				currentUserTables = currentUser.getTables();
				for (Table table: currentUserTables) {
					optionsPanel.add(table.getTableButton());
				}
				
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
		functionPanel.add(Main.buttonOpen);
		functionPanel.add(Main.buttonPrint);
		functionPanel.add(Main.buttonModify);
		functionPanel.add(Main.buttonEditTips);
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
		// loadData();
		
		// Create a new Main object and add the panels to it. Each swing component
		// has the method add.		
		Main main = new Main();
		loadLoginKeyValues(main);
		loadLoginScreen(main);
	}

	
	// ************************ LOGIN KEY HANDLER **********************************************************************************
	private class LoginKeyHandler implements ActionListener { 	// We can define this sub-class inside of the Main class.
																// It controls what happens when you click a number button to login.
		private int keyValue;									
																
		private LoginKeyHandler(int keyValue) {					// We put a constructor in it so we can pass a value to it that we
			this.keyValue = keyValue;							// want for the login key (keyValue).
		}
		@Override
		public void actionPerformed(ActionEvent event) {
			currentUserID += Integer.toString(keyValue);		// This converts the integer keyValue to a String object, which we'll
			userLoginTextField.setText(currentUserID);			// need it to be in order to concatenate it to the currentUserID String.
		}														// The results are then set to the text field.
	}
	
	// **********************************************************************************************************************************
	// *																																*
	// *													OTHER METHODS																*
	// *																																*
	// **********************************************************************************************************************************
	
	// METHOD:		loadLoginKeyValues
	// PARAMETERS:	Main object
	// PURPOSE:		Give all the login keys their button event handlers.
	// **********************************************************************************************************************************
	public static void loadLoginKeyValues(Main main) {
		button1Key.addActionListener(key_1);	// We declared these handlers, then initialized them in the Main constructor for
		button2Key.addActionListener(key_2);	// reuse and less code. They'll be assigned to each KeyPadButton here.
		button3Key.addActionListener(key_3);
		button4Key.addActionListener(key_4);
		button5Key.addActionListener(key_5);
		button6Key.addActionListener(key_6);
		button7Key.addActionListener(key_7);
		button8Key.addActionListener(key_8);
		button9Key.addActionListener(key_9);
		button0Key.addActionListener(key_0);
		buttonClearKey.addActionListener(new ActionListener() { // We didn't predefine the CLEAR or OK keys because their functions
			public void actionPerformed(ActionEvent event) {	// are a little different. We're declaring and initializing them here.
				currentUserID = "";								
				userLoginTextField.setText(currentUserID);		// CLEAR will set the String in the text field back to null.
			}
		});			
		buttonConfirmKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				currentUser = getUser(currentUserID); // getUser() is another function in this class that will select a list of Users based on currentUserID.
				currentUserLabel.setText(currentUser.getUserFirstName() + " " + currentUser.getUserLastName());
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
	// **********************************************************************************************************************************
	public static void loadLoginScreen(Main main) {
		main.add(loginPanel);
		main.repaint();
		main.revalidate();
	}	
	// **********************************************************************************************************************************
	public static User getUser(String id) {
		
		switch (id) {
		case "1111": return dipeshBhandari;
		case "2222": return alexGayle;
		case "3333": return ericGreene;
		case "4444": return joshuaHenderson;
		default: return null;
		}
	}
	// **********************************************************************************************************************************
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
