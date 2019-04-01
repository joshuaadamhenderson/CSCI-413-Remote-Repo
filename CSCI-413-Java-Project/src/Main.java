/*
 * PROJECT:			Software Engineering Group Project, Restaurant Point-Of-Sale System
 * GROUP:			Round Two
 * MEMBERS:			Dipesh Bhandari, Alex Gayle, Eric Greene, Joshua Henderson
 * COURSE:			CSCI 413, Software Engineering II
 * INSTRUCTOR:		Dr. Bei Xie
 * DATE CREATED:	2/1/2019
 *
 * IMPORTED CLASSES
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.lang.Math;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
/*
 * MAIN CLASS
 */
public class Main extends JFrame {
	/*
	 *	IMAGES
	 */
	public static final ImageIcon BUTTON_IMAGE_PAYMENTS = new ImageIcon("src/buttonPayments.jpg");
	public static final ImageIcon BUTTON_IMAGE_STYLE = new ImageIcon("src/buttonStyle.jpg");
	public static final ImageIcon BUTTON_IMAGE_OPEN = new ImageIcon("src/buttonOpen.jpg");
	public static final ImageIcon BUTTON_IMAGE_MODIFY = new ImageIcon("src/buttonModify.jpg");
	public static final ImageIcon BUTTON_IMAGE_PRINT = new ImageIcon("src/buttonPrint.jpg");
	public static final ImageIcon BUTTON_IMAGE_EDIT_TIPS = new ImageIcon("src/buttonEditTips.jpg");
	public static final ImageIcon BUTTON_IMAGE_EMPLOYEES = new ImageIcon("src/buttonEmployees.jpg");
	public static final ImageIcon BUTTON_IMAGE_REPORTS = new ImageIcon("src/buttonReports.jpg");
	public static final ImageIcon BUTTON_IMAGE_EXIT = new ImageIcon("src/buttonExit.jpg");
	public static final ImageIcon BUTTON_IMAGE_1 = new ImageIcon("src/button_1.jpg");
	public static final ImageIcon BUTTON_IMAGE_5 = new ImageIcon("src/button_5.jpg");
	public static final ImageIcon BUTTON_IMAGE_20 = new ImageIcon("src/button_20.jpg");
	public static final ImageIcon BUTTON_IMAGE_100 = new ImageIcon("src/button_100.jpg");
	public static final ImageIcon BUTTON_SALES_REPORTS = new ImageIcon("src/buttonSalesReports.png");
	public static final ImageIcon BUTTON_EMPLOYEE_PAYROLL = new ImageIcon("src/buttonEmployeePayroll.png");
	public static final ImageIcon BUTTON_IMAGE_CLOCK_IN = new ImageIcon("src/clockIn.png");
	public static final ImageIcon BUTTON_IMAGE_CLOCK_OUT = new ImageIcon("src/clockOut.png");	
	public static final ImageIcon LOGO = new ImageIcon("src/welcomeLabel.png");	
	/*
	 * COLORS
	 */
	public static final Color ORIGINAL_DARK_BLUE = new Color(0, 60, 90);
	public static final Color TROUT = new Color(82, 85, 100);
	public static final Color SLATE_GRAY = new Color(116, 130, 143);
	public static final Color HALF_BAKED = new Color(150, 192, 206);
	public static final Color COTTON_SEED = new Color(190, 185, 181);
	public static final Color FUZZY_WUZZY = new Color(194, 91, 86);
	public static final Color ORANGE_WHITE = new Color(254, 246, 235);
	public static final Color WHITE = new Color(255, 255, 255);
	public static final Color MENU_ITEM_BUTTON_COLOR_1 = new Color(52, 147, 59);
	public static final Color MENU_ITEM_BUTTON_COLOR_2 = new Color(216, 135, 91);
	public static final Color MENU_ITEM_BUTTON_COLOR_3 = new Color(191, 91, 216);
	public static final Color MENU_ITEM_BUTTON_COLOR_4 = new Color(91, 215, 216);
	public static final Color MENU_ITEM_BUTTON_COLOR_5 = new Color(216, 103, 91);

	public static final Color MENU_PANEL_BUTTON_COLOR = SLATE_GRAY;
	public static final Color MENU_PANEL_FONT_COLOR = WHITE;
	public static final Color OPTIONS_PANEL_BG_COLOR = HALF_BAKED;
	public static final Color CATEGORY_PANEL_BG_COLOR = HALF_BAKED;
	public static final Color DISPLAY_PANEL_BG_COLOR = HALF_BAKED;
	public static final Color USER_PANEL_BG_COLOR = ORIGINAL_DARK_BLUE;
	public static final Color STATUS_PANEL_BG_COLOR = ORIGINAL_DARK_BLUE;
	public static final Color MENU_ITEM_PANEL_BG_COLOR = ORANGE_WHITE;	
	public static final Color MAIN_BG_COLOR = ORIGINAL_DARK_BLUE;
	public static final Color MAIN_TEXT_COLOR = WHITE;
	public static final Color KEYPAD_BUTTON_COLOR = ORIGINAL_DARK_BLUE;
	public static final Color TABLE_BUTTON_COLOR = ORANGE_WHITE;
	public static final Color TABLE_BUTTON_TEXT_COLOR = FUZZY_WUZZY;
	public static final Color USER_PANEL_BUTTON_COLOR = SLATE_GRAY;
	/*
	 * FONTS
	 */
	public static final Font PROGRAM_FONT = new Font("Arial", Font.BOLD, 18);
	public static final Font TABLE_BUTTON_FONT = new Font("Arial", Font.BOLD, 24);
	public static final Font KEYPAD_FONT = new Font("Arial", Font.BOLD, 30);
	public static final Font ADMIN_PANEL_FONT = new Font("Arial", Font.PLAIN, 22);
	public static final Font DISPLAY_PANEL_FONT = new Font("Arial", Font.BOLD, 18);
	public static final Font MENU_ITEM_PRICE_LABEL_FONT = new Font("Arial", Font.PLAIN, 20);
	public static final Font USER_PANEL_FONT = new Font("Arial", Font.BOLD, 20);
	public static final Font TABLE_COSTS_PANEL_FONT = new Font("Arial", Font.BOLD, 20);
	/*
	 * DIMENSIONS
	 */
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	
	
	public static final int MAIN_WIDTH = (int)screenSize.getWidth();
	public static final int MAIN_HEIGHT = (int)screenSize.getHeight();
	public static final int CATEGORY_PANEL_WIDTH = (int) (MAIN_WIDTH*0.65);
	public static final int CATEGORY_PANEL_HEIGHT = (int) (MAIN_HEIGHT*0.70);
	public static final int DISPLAY_PANEL_WIDTH = (int) (MAIN_WIDTH*0.34);
	public static final int DISPLAY_PANEL_HEIGHT = (int) (MAIN_HEIGHT*0.60);
	public static final int FUNCTION_PANEL_WIDTH = 0;
	public static final int FUNCTION_PANEL_HEIGHT = (int) (MAIN_HEIGHT*0.13);
	public static final int OPTIONS_PANEL_WIDTH = (int) (MAIN_WIDTH*0.66);
	public static final int OPTIONS_PANEL_HEIGHT = (int) (MAIN_HEIGHT*0.71);
	public static final int USER_PANEL_WIDTH = 0;
	public static final int USER_PANEL_HEIGHT = (int) (MAIN_HEIGHT*0.11);
	public static final int HEADER_PANEL_WIDTH = MAIN_WIDTH;
	public static final int HEADER_PANEL_HEIGHT = (int) (MAIN_HEIGHT*0.22);
	public static final int KEYPAD_PANEL_WIDTH = (int) (MAIN_WIDTH*0.31);
	public static final int KEYPAD_PANEL_HEIGHT = (int) (MAIN_HEIGHT*0.61);
	public static final int PAYMENT_BUTTON_WIDTH = (int) (MAIN_WIDTH*0.18);
	public static final int PAYMENT_BUTTON_HEIGHT = (int) (MAIN_HEIGHT*0.14);
	public static final int TABLE_BUTTON_HEIGHT = (int) (MAIN_HEIGHT*0.09);
	public static final int TABLE_BUTTON_WIDTH = (int) (MAIN_WIDTH*0.64);
	public static final int MENU_ITEM_PANEL_WIDTH = (int) (MAIN_WIDTH*0.31);
	public static final int MENU_ITEM_PANEL_HEIGHT = (int) (MAIN_HEIGHT*0.59);
	public static final int MENU_ITEM_PANEL_SCROLL_PANE_WIDTH = (int) (MAIN_WIDTH*0.33);
	public static final int MENU_ITEM_PANEL_SCROLL_PANE_HEIGHT = (int) (MAIN_HEIGHT*0.60);
	public static final int MENU_ITEM_LABEL_PANEL_WIDTH = (int) (MAIN_WIDTH*0.29);
	public static final int MENU_ITEM_LABEL_PANEL_HEIGHT = (int) (MAIN_HEIGHT*0.04);
	public static final int TABLE_COSTS_PANEL_WIDTH = (int) (MAIN_WIDTH*0.33);
	public static final int TABLE_COSTS_PANEL_HEIGHT = (int) (MAIN_HEIGHT*0.26);
	public static final int MENU_PANEL_WIDTH = 0;
	public static final int MENU_PANEL_HEIGHT = (int) (MAIN_HEIGHT*0.06);
	/*
	 * TAX RATE
	 */
	public static final double CALCASIEU_TAX_RATE = .1075;
	public static final double CAMERON_TAX_RATE = .04;
	public static final double CURRENT_TAX_RATE = CALCASIEU_TAX_RATE; // Set a tax region here
	/*
	 * CONNECTION CREDENTIALS
	 */
	public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	public static final String HOSTNAME = "localhost";
	public static final String DATABASE = "r2db";	
	public static final String USERNAME = "root";
	public static final String PASSWORD = "";
	public static final String URL = "jdbc:mysql://" + HOSTNAME + "/" + DATABASE;
	/*
	 * DATE
	 */
	public static LocalDateTime now;
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	public static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");
	/*
	 * LABELS
	 */
	public static JLabel welcomeLabel = new JLabel();
	public static JLabel currentUserLabel = new JLabel("");
	public static JLabel horizonLine = new JLabel("***********************************************************************************");
	public static JLabel horizonLine2 = new JLabel("***********************************************************************************");
	public static JLabel horizonLine3 = new JLabel("***********************************************************************************");
	public static JLabel horizonLine4 = new JLabel("***********************************************************************************");
	/*
	 * ERROR LABELS
	 */
	public static ErrorLabel loginError = new ErrorLabel("Incorrect User ID.");
	/*
	 * TEXT FIELDS
	 */
	public static JTextField userLoginTextField = new JTextField(4);
	/*
	 * FRAMES
	 */
	public static MainAdmin mainAdmin = new MainAdmin();
	public static EmployeePayrollFrame employeePayrollFrame= new EmployeePayrollFrame();
	public static SalesReportFrame salesReportFrame= new SalesReportFrame();
	/*
	 * PANELS
	 */
	public static FunctionPanel functionPanel = new FunctionPanel();
	public static MenuPanel menuPanel = new MenuPanel();
	public static HeaderPanel headerPanel = new HeaderPanel();
	public static OptionsPanel optionsPanel = new OptionsPanel();
	public static DisplayPanel displayPanel = new DisplayPanel();
	public static StatusPanel statusPanel = new StatusPanel();
	public static KeypadPanel keypadPanel = new KeypadPanel();
	public static LoginPanel loginPanel = new LoginPanel();
	public static LoginPanel loginPanelCenter = new LoginPanel();
	public static LoginPanel loginPanelHeader = new LoginPanel();
	public static LoginPanel loginPanelHeader2 = new LoginPanel();
	public static LoginPanel loginPanelFooter = new LoginPanel();
	public static UserPanel userPanel = new UserPanel();
	public static MenuItemPanel menuItemPanel = new MenuItemPanel();
	public static CategoryPanel appetizersPanel = new CategoryPanel();
	public static CategoryPanel entreesPanel = new CategoryPanel();
	public static CategoryPanel	sidesPanel = new CategoryPanel();
	public static CategoryPanel	soupsPanel = new CategoryPanel();
	public static CategoryPanel	dessertsPanel = new CategoryPanel();
	public static CategoryPanel	beveragesPanel = new CategoryPanel();
	public static CategoryPanel	aLaCartePanel = new CategoryPanel();
	public static CategoryPanel	toGoPanel = new CategoryPanel();
	public static CategoryPanel paymentsPanel = new CategoryPanel();
	public static CategoryPanel reportsPanel = new CategoryPanel();
	/*
	 * SCROLL PANES
	 */
	public static JScrollPane menuItemPanelScrollPane = new JScrollPane(menuItemPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	/*
	 * PLACEHOLDERS
	 */
	public static String currentUserID = ""; // Placeholder
	public static User currentUser = new User("", "", "", "", 0.0, ""); // Placeholder
	public static Table currentTable = new Table(); // Placeholder
	public static List<Table> currentUserTables = new ArrayList<Table>(); // Placeholder
	public static MenuItem currentMenuItem = new MenuItem("", "", 0);	
	public static List<MenuItem> currentTableMenuItems = new ArrayList<MenuItem>(); // Placeholder
	/*
	 * MENU ITEMS
	 */
	//appetizers
	public static MenuItem buffaloWings = new MenuItem("100", "Buffalo Wings", 8.50);
	public static MenuItem chickenTenders = new MenuItem("110", "Chicken Tenders", 6.25);
	public static MenuItem friedAsparagus = new MenuItem("120", "Fried Asparagus", 6.50);
	public static MenuItem spicyHummus = new MenuItem("130", "Spicy Hummus", 5.50);
	public static MenuItem ultimateNachos = new MenuItem("140", "Ultimate Nachos", 10.75);
	public static MenuItem crabCakes =  new MenuItem("150", "Crab Cakes", 11.25);
	
	//entree
	public static MenuItem chickenSalad = new MenuItem("200", "Chicken Salad", 12.50);
	public static MenuItem cheeseburger = new MenuItem("210", "Cheeseburger", 10.25);
	public static MenuItem tunaSteak = new MenuItem("220", "Tuna Steak", 13.50);
	public static MenuItem shrimpAlfredo = new MenuItem("230", "Shrimp Alfredo", 14.50);
	public static MenuItem lambLollipops = new MenuItem("240", "Lamb Lollipops", 15.75);
	public static MenuItem friedPorkChops = new MenuItem("250", "Fried Pork Chops", 9.50);
	
	//sides
	public static MenuItem mashedPotatoes = new MenuItem("300", "Mashed Potatoes", 2.50);
	public static MenuItem greenBeans = new MenuItem("310", "Green Beans", 2.50);
	public static MenuItem redBeansAndRice = new MenuItem("320", "Red Beans and Rice", 3.25);
	public static MenuItem waffleFries = new MenuItem("330", "Waffle Fries", 2.50);
	public static MenuItem macAndCheese = new MenuItem("340", "Mac 'N Cheese", 3.25);
	public static MenuItem steamedBroccoli = new MenuItem("350", "Steamed Broccoli", 2.25);
	
	//soups
	public static MenuItem clamChowder = new MenuItem("400", "Clam Chowder", 5.50);
	public static MenuItem loadedBakedPotato = new MenuItem("410", "Loaded Baked Potato", 5.50);
	public static MenuItem broccoliCheddar = new MenuItem("420", "Broccoli Cheddar", 5.50);
	public static MenuItem tortilla = new MenuItem("430", "Tortilla", 5.50);
	
	//desserts
	public static MenuItem cheesecake = new MenuItem("500", "Cheesecake", 4.75);
	public static MenuItem moltenLavaCake = new MenuItem("510", "Molten Lava Cake", 5.75);
	public static MenuItem cookieSkillet = new MenuItem("520", "Cookie Skillet", 5.75);
	public static MenuItem breadPudding = new MenuItem("530", "Bread Pudding", 4.50);
	public static MenuItem friedIceCream = new MenuItem("540", "Fried Ice Cream", 5.75);
	
	//beverages
	public static MenuItem cocaCola = new MenuItem("600", "Coca Cola", 2.25);
	public static MenuItem drPepper = new MenuItem("610", "Dr. Pepper", 2.25);
	public static MenuItem hiC = new MenuItem("620", "Hi-C", 2.25);
	public static MenuItem rootBeer = new MenuItem("630", "Root Beer", 2.25);
	public static MenuItem lemonade = new MenuItem("640", "Lemonade", 2.25);
	public static MenuItem sweetTea = new MenuItem("650", "Sweet Tea", 2.25);
	public static MenuItem pepsi = new MenuItem("660", "Pepsi", 2.25);
	public static MenuItem water = new MenuItem("670", "Water", 0.00);
	/*
	 * MENU PANEL BUTTONS
	 */
	public static MenuPanelButton appetizersButton = new MenuPanelButton("APPETIZERS", Main.MENU_PANEL_BUTTON_COLOR, Main.MENU_PANEL_FONT_COLOR);
	public static MenuPanelButton entreesButton = new MenuPanelButton("ENTREES", Main.MENU_PANEL_BUTTON_COLOR, Main.MENU_PANEL_FONT_COLOR);
	public static MenuPanelButton sidesButton = new MenuPanelButton("SIDES", Main.MENU_PANEL_BUTTON_COLOR, Main.MENU_PANEL_FONT_COLOR);
	public static MenuPanelButton soupsButton = new MenuPanelButton("SOUPS", Main.MENU_PANEL_BUTTON_COLOR, Main.MENU_PANEL_FONT_COLOR);
	public static MenuPanelButton dessertsButton = new MenuPanelButton("DESSERTS", Main.MENU_PANEL_BUTTON_COLOR, Main.MENU_PANEL_FONT_COLOR);
	public static MenuPanelButton beveragesButton = new MenuPanelButton("BEVERAGES", Main.MENU_PANEL_BUTTON_COLOR, Main.MENU_PANEL_FONT_COLOR);
	public static MenuPanelButton aLaCarteButton = new MenuPanelButton("A LA CARTE", Main.MENU_PANEL_BUTTON_COLOR, Main.MENU_PANEL_FONT_COLOR);
	public static MenuPanelButton toGoButton = new MenuPanelButton("TO GO", Main.MENU_PANEL_BUTTON_COLOR, Main.MENU_PANEL_FONT_COLOR);
	/*
	 * CATEGORY PANEL MENU BUTTONS
	 */
	//appetizers
	public static MenuButton buffaloWingsButton = new MenuButton("Buffalo", "Wings", Main.MENU_ITEM_BUTTON_COLOR_1, Color.WHITE);		
	public static MenuButton chickenTendersButton = new MenuButton("Chicken", "Tenders", Main.MENU_ITEM_BUTTON_COLOR_1, Color.WHITE);
	public static MenuButton friedAsparagusButton = new MenuButton("Fried", "Asparagus", Main.MENU_ITEM_BUTTON_COLOR_1, Color.WHITE);
	public static MenuButton spicyHummusButton = new MenuButton("Spicy", "Hummus", Main.MENU_ITEM_BUTTON_COLOR_1, Color.WHITE);
	public static MenuButton ultimateNachosButton = new MenuButton("Ultimate", "Nachos", Main.MENU_ITEM_BUTTON_COLOR_1, Color.WHITE);
	public static MenuButton crabCakesButton = new MenuButton("Crab", "Cakes", Main.MENU_ITEM_BUTTON_COLOR_1, Color.WHITE);
	
	//entrees
	public static MenuButton chickenSaladButton = new MenuButton("Chicken", "Salad", Main.MENU_ITEM_BUTTON_COLOR_2, Color.WHITE);
	public static MenuButton cheeseburgerButton = new MenuButton("Cheeseburger", Main.MENU_ITEM_BUTTON_COLOR_2, Color.WHITE);
	public static MenuButton tunaSteakButton = new MenuButton("Tuna", "Steak", Main.MENU_ITEM_BUTTON_COLOR_2, Color.WHITE);
	public static MenuButton shrimpAlfredoButton = new MenuButton("Shrimp", "Alfredo", Main.MENU_ITEM_BUTTON_COLOR_2, Color.WHITE);
	public static MenuButton lambLollipopsButton = new MenuButton("Lamb", "Lollipops", Main.MENU_ITEM_BUTTON_COLOR_2, Color.WHITE);
	public static MenuButton friedPorkChopsButton = new MenuButton("Fried", "Pork Chops", Main.MENU_ITEM_BUTTON_COLOR_2, Color.WHITE);
	
	//sides
	public static MenuButton mashedPotatoesButton = new MenuButton("Mashed", "Potatoes", Main.MENU_ITEM_BUTTON_COLOR_3, Color.WHITE);
	public static MenuButton greenBeansButton = new MenuButton("Green", "Beans", Main.MENU_ITEM_BUTTON_COLOR_3, Color.WHITE);
	public static MenuButton redBeansAndRiceButton = new MenuButton("Red Beans", "and Rice",  Main.MENU_ITEM_BUTTON_COLOR_3, Color.WHITE);
	public static MenuButton waffleFriesButton = new MenuButton("Waffle", "Fries", Main.MENU_ITEM_BUTTON_COLOR_3, Color.WHITE);
	public static MenuButton macAndCheeseButton = new MenuButton("Mac and", "Cheese", Main.MENU_ITEM_BUTTON_COLOR_3, Color.WHITE);
	public static MenuButton steamedBroccoliButton = new MenuButton("Steamed", "Broccoli", Main.MENU_ITEM_BUTTON_COLOR_3, Color.WHITE);

	//soup
	public static MenuButton clamChowderButton = new MenuButton("Clam", "Chowder", Main.MENU_ITEM_BUTTON_COLOR_4, Color.WHITE);
	public static MenuButton loadedBakedPotatoeButton = new MenuButton("Loaded Baked", "Potato Soup", Main.MENU_ITEM_BUTTON_COLOR_4, Color.WHITE);
	public static MenuButton broccoliChedderButton = new MenuButton("Broccoli", "Cheddar Soup", Main.MENU_ITEM_BUTTON_COLOR_4, Color.WHITE);
	public static MenuButton tortillaButton = new MenuButton("Tortilla Soup", Main.MENU_ITEM_BUTTON_COLOR_4, Color.WHITE);
	
	//desserts
	public static MenuButton cheesecakeButton = new MenuButton("Cheesecake", Main.MENU_ITEM_BUTTON_COLOR_5, Color.WHITE);
	public static MenuButton moltenLavaCakeButton = new MenuButton("Molten Lava", "Cake", Main.MENU_ITEM_BUTTON_COLOR_5, Color.WHITE);
	public static MenuButton cookieSkilletButton = new MenuButton("Cookie", "Skillet",  Main.MENU_ITEM_BUTTON_COLOR_5, Color.WHITE);
	public static MenuButton breadPuddingButton = new MenuButton("Bread", "Pudding", Main.MENU_ITEM_BUTTON_COLOR_5, Color.WHITE);
	public static MenuButton friedIceCreamButton = new MenuButton("Fried", "Ice Cream",  Main.MENU_ITEM_BUTTON_COLOR_5, Color.WHITE);
	
	//beverages
	public static MenuButton cocaColaButton = new MenuButton("Coca Cola", Main.MENU_ITEM_BUTTON_COLOR_5, Color.WHITE);
	public static MenuButton drPepperButton = new MenuButton("Dr. Pepper", Main.MENU_ITEM_BUTTON_COLOR_5, Color.WHITE);
	public static MenuButton hiCButton = new MenuButton("Hi-C", Main.MENU_ITEM_BUTTON_COLOR_5, Color.WHITE);
	public static MenuButton rootBeerButton = new MenuButton("Root Beer", Main.MENU_ITEM_BUTTON_COLOR_5, Color.WHITE);
	public static MenuButton lemonadeButton = new MenuButton("Lemonade", Main.MENU_ITEM_BUTTON_COLOR_5, Color.WHITE);
	public static MenuButton sweetTeaButton = new MenuButton("Sweet Tea", Main.MENU_ITEM_BUTTON_COLOR_5, Color.WHITE);
	public static MenuButton pepsiButton = new MenuButton("Pepsi", Main.MENU_ITEM_BUTTON_COLOR_5, Color.WHITE);
	public static MenuButton waterButton = new MenuButton("Water", Main.MENU_ITEM_BUTTON_COLOR_5, Color.WHITE);
	/*
	 * FUNCTION PANEL BUTTONS
	 */
	public static JButton buttonPayments = new JButton(BUTTON_IMAGE_PAYMENTS);
	public static JButton buttonOpen = new JButton(BUTTON_IMAGE_OPEN);
	public static JButton buttonPrint = new JButton(BUTTON_IMAGE_PRINT);
	public static JButton buttonModify = new JButton(BUTTON_IMAGE_MODIFY);
	public static JButton buttonEditTips = new JButton(BUTTON_IMAGE_EDIT_TIPS);
	public static JButton buttonEmployees = new JButton(BUTTON_IMAGE_EMPLOYEES);
	public static JButton buttonReports = new JButton(BUTTON_IMAGE_REPORTS);
	public static JButton button1 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton button2 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton button3 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton button4 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton button5 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton button6 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton button7 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton button8 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton buttonExit = new JButton(BUTTON_IMAGE_EXIT);
	/*
	 * PAYMENTS CATEGORY PANEL BUTTONS
	 */
	public static JButton button_1 = new JButton(BUTTON_IMAGE_1);
	public static JButton button_5 = new JButton(BUTTON_IMAGE_5);
	public static JButton button_20 = new JButton(BUTTON_IMAGE_20);
	public static JButton button_100 = new JButton(BUTTON_IMAGE_100);
	/*
	 * REPORTS CATEGORY PANEL BUTTONS
	 */
	public static JButton buttonSalesReports = new JButton(BUTTON_SALES_REPORTS);
	public static JButton buttonEmployeePayroll = new JButton(BUTTON_EMPLOYEE_PAYROLL);
	/*
	 * USER PANEL BUTTONS
	 */
	public static JButton currentUserChecks = new JButton("TABLES");
	public static JButton newCheck = new JButton("NEW");
	/*
	 * TABLE BUTTONS
	 */
	public static TableButton currentTableButton = new TableButton(currentTable);
	/*
	 * KEYPAD BUTTONS
	 */
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
	public static KeypadButton loginPanelConfirmKey = new KeypadButton("OK");
	public static KeypadButton loginPanelClearKey = new KeypadButton("CLEAR");
	public static KeypadButton loginPanelExitButton = new KeypadButton("EXIT");
	public static JButton loginPanelClockInButton = new JButton(BUTTON_IMAGE_CLOCK_IN);
	public static JButton loginPanelClockOutButton = new JButton(BUTTON_IMAGE_CLOCK_OUT);
	/*
	 * LOGIN PANEL BUTTON HANDLERS
	 */
	public static LoginPanelKeypadButtonHandler LoginPanelKey1;
	public static LoginPanelKeypadButtonHandler LoginPanelKey2;
	public static LoginPanelKeypadButtonHandler LoginPanelKey3;
	public static LoginPanelKeypadButtonHandler LoginPanelKey4;
	public static LoginPanelKeypadButtonHandler LoginPanelKey5;
	public static LoginPanelKeypadButtonHandler LoginPanelKey6;
	public static LoginPanelKeypadButtonHandler LoginPanelKey7;
	public static LoginPanelKeypadButtonHandler LoginPanelKey8;
	public static LoginPanelKeypadButtonHandler LoginPanelKey9;
	public static LoginPanelKeypadButtonHandler LoginPanelKey0;
	public static LoginPanelConfirmKeyButtonHandler loginPanelConfirmKeyButtonHandler;
	public static LoginPanelClearKeyButtonHandler loginPanelClearKeyButtonHandler;
	public static LoginPanelClockInButtonHandler loginPanelClockInButtonHandler;
	public static LoginPanelClockOutButtonHandler loginPanelClockOutButtonHandler;
	/*
	 * FUNCTION PANEL BUTTON HANDLERS
	 */
	public static FunctionPanelPaymentsButtonHandler functionPanelPaymentsButtonHandler;
	public static FunctionPanelReportsButtonHandler functionPanelReportsButtonHandler;
	public static FunctionPanelEmployeesButtonHandler functionPanelEmployeesButtonHandler;
	/*
	 * PAYMENT BUTTON HANDLERS
	 */
	public static PaymentButtonHandler payment100Handler;
	public static PaymentButtonHandler payment20Handler;
	public static PaymentButtonHandler payment5Handler;
	public static PaymentButtonHandler payment1Handler;	
	/*
	 * MENU PANEL BUTTON HANDLERS
	 */
	public static MenuPanelButtonHandler appetizersHandler;
	public static MenuPanelButtonHandler entreesHandler;
	public static MenuPanelButtonHandler sidesHandler;
	public static MenuPanelButtonHandler soupsHandler;
	public static MenuPanelButtonHandler dessertsHandler;
	public static MenuPanelButtonHandler beveragesHandler;
	public static MenuPanelButtonHandler aLaCarteHandler;
	public static MenuPanelButtonHandler toGoHandler;
	/*
	 * MENU ITEM BUTTON HANDLERS
	 */
	//appetizer
	public static MenuItemButtonHandler buffaloWingsHandler;
	public static MenuItemButtonHandler chickenTendersHandler;
	public static MenuItemButtonHandler friedAsparagusHandler;
	public static MenuItemButtonHandler spicyHummusHandler;
	public static MenuItemButtonHandler ultimateNachosHandler;
	public static MenuItemButtonHandler crabCakesHandler;
	
	//entree
	public static MenuItemButtonHandler chickenSaladHandler;
	public static MenuItemButtonHandler cheeseburgerHandler;
	public static MenuItemButtonHandler tunaSteakHandler;
	public static MenuItemButtonHandler shrimpAlfredoHandler;
	public static MenuItemButtonHandler lambLollipopsHandler;
	public static MenuItemButtonHandler friedPorkChopsHandler;
	
	//sides
	public static MenuItemButtonHandler mashedPotatoesHandler;
	public static MenuItemButtonHandler greenBeansHandler;
	public static MenuItemButtonHandler redBeansAndRiceHandler;
	public static MenuItemButtonHandler waffleFriesHandler;
	public static MenuItemButtonHandler macAndCheeseHandler;
	public static MenuItemButtonHandler steamedBroccoliHandler;
	
	//soup
	public static MenuItemButtonHandler clamChowderHandler;
	public static MenuItemButtonHandler loadedBakedPotatoHandler;
	public static MenuItemButtonHandler broccoliCheddarHandler;
	public static MenuItemButtonHandler tortillaHandler;
	
	//desserts
	public static MenuItemButtonHandler cheesecakeHandler;
	public static MenuItemButtonHandler moltenLavaCakeHandler;
	public static MenuItemButtonHandler cookieSkilletHandler;
	public static MenuItemButtonHandler breadPuddingHandler;
	public static MenuItemButtonHandler friedIceCreamHandler;
	
	//beverages
	public static MenuItemButtonHandler cocaColaHandler;
	public static MenuItemButtonHandler drPepperHandler;
	public static MenuItemButtonHandler hiCHandler;
	public static MenuItemButtonHandler rootBeerHandler;
	public static MenuItemButtonHandler lemonadeHandler;
	public static MenuItemButtonHandler sweetTeaHandler;
	public static MenuItemButtonHandler pepsiHandler;
	public static MenuItemButtonHandler waterHandler;
	/*
	 * OTHER BUTTON HANDLERS
	 */
	public static CurrentUserChecksButtonHandler currentUserChecksButtonHandler;
	public static NewCheckButtonHandler newCheckButtonHandler;
	public static ExitButtonHandler exitButtonHandler;
	public static ExitSystemHandler exitSystemHandler;
	public static SalesReportButtonHandler salesReportButtonHandler;
	public static EmployeePayrollButtonHandler employeePayrollButtonHandler;
	/*
	 ********************
	 * 					*
	 * MAIN CONSTRUCTOR *
	 * 					*
	 ********************
	 */
	public Main() {
		/*
		 * MAIN FRAME SETTINGS
		 */
		setBackground(MAIN_BG_COLOR);
		setForeground(MAIN_TEXT_COLOR);
		setSize(MAIN_WIDTH, MAIN_HEIGHT);
		getContentPane().setLayout(new BorderLayout());
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		/*
		 * UI SETTINGS
		 */
		UIManager.put("OptionPane.background", Main.ORIGINAL_DARK_BLUE);
		UIManager.put("Panel.background", Main.ORIGINAL_DARK_BLUE);
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 28));
		UIManager.put("OptionPane.messageForeground", Color.WHITE);
		UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 28));
		UIManager.put("OptionPane.okButtonText", "      OK      ");
		UIManager.put("OptionPane.border", new LineBorder(Main.ORIGINAL_DARK_BLUE, 50));

		/*
		 * LOGIN PANEL SETTINGS
		 */
		welcomeLabel.setFont(new Font("Impact", Font.PLAIN, 80));
		userLoginTextField.setFont(KEYPAD_FONT);
		userLoginTextField.setBackground(MAIN_BG_COLOR);
		userLoginTextField.setForeground(MAIN_TEXT_COLOR);
		loginPanel.setLayout(new BorderLayout());
		loginPanelExitButton.setPreferredSize(new Dimension(150, 70));
		loginPanelClockInButton.setBackground(MAIN_BG_COLOR);
		loginPanelClockOutButton.setBackground(MAIN_BG_COLOR);
		loginPanelHeader.setLayout(new BorderLayout());
		loginPanelClockInButton.setPreferredSize(new Dimension(160, 130));
		loginPanelClockOutButton.setPreferredSize(new Dimension(160, 130));
		loginError.setFont(new Font("Arial", Font.BOLD, 24));
		/*
		 * USER CHECKS SETTINGS
		 */
		currentUserLabel.setFont(new Font("Arial", Font.BOLD, 20));
		currentUserLabel.setForeground(Color.WHITE);
		newCheck.setBackground(USER_PANEL_BUTTON_COLOR);
		newCheck.setFont(USER_PANEL_FONT);
		newCheck.setForeground(Color.WHITE);
		newCheck.setBorder(new LineBorder(ORIGINAL_DARK_BLUE, 2));
		currentUserChecks.setBackground(USER_PANEL_BUTTON_COLOR);
		currentUserChecks.setFont(USER_PANEL_FONT);
		currentUserChecks.setForeground(Color.WHITE);
		currentUserChecks.setBorder(new LineBorder(ORIGINAL_DARK_BLUE, 2));
		
		button_1.setPreferredSize(new Dimension(PAYMENT_BUTTON_WIDTH, PAYMENT_BUTTON_HEIGHT));
		button_5.setPreferredSize(new Dimension(PAYMENT_BUTTON_WIDTH, PAYMENT_BUTTON_HEIGHT));
		button_20.setPreferredSize(new Dimension(PAYMENT_BUTTON_WIDTH, PAYMENT_BUTTON_HEIGHT));
		button_100.setPreferredSize(new Dimension(PAYMENT_BUTTON_WIDTH, PAYMENT_BUTTON_HEIGHT));
		
		menuItemPanelScrollPane.setPreferredSize(new Dimension(MENU_ITEM_PANEL_SCROLL_PANE_WIDTH, MENU_ITEM_PANEL_SCROLL_PANE_HEIGHT));
		menuItemPanelScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(25, 0));
		menuItemPanelScrollPane.getVerticalScrollBar().setBackground(ORIGINAL_DARK_BLUE);
		
		welcomeLabel.setIcon(LOGO);
			
		/*
		 * ASSEMBLE THE PANELS
		 */
		loginPanelHeader.add(welcomeLabel);
		loginPanelHeader.add(loginPanelExitButton, BorderLayout.EAST);
		loginPanelHeader.add(loginPanelHeader2, BorderLayout.SOUTH);
		loginPanelHeader2.add(userLoginTextField, BorderLayout.SOUTH);
		loginPanelFooter.add(loginPanelClockInButton, BorderLayout.WEST);
		loginPanelFooter.add(loginPanelClockOutButton, BorderLayout.EAST);
		loginPanelCenter.add(keypadPanel, BorderLayout.SOUTH);
		loginPanel.add(loginPanelHeader, BorderLayout.NORTH);
		loginPanel.add(loginPanelCenter, BorderLayout.CENTER);
		loginPanel.add(loginPanelFooter, BorderLayout.SOUTH);
		keypadPanel.add(button1Key);
		keypadPanel.add(button2Key);
		keypadPanel.add(button3Key);
		keypadPanel.add(button4Key);
		keypadPanel.add(button5Key);
		keypadPanel.add(button6Key);
		keypadPanel.add(button7Key);
		keypadPanel.add(button8Key);
		keypadPanel.add(button9Key);
		keypadPanel.add(loginPanelConfirmKey);
		keypadPanel.add(button0Key);
		keypadPanel.add(loginPanelClearKey);
		headerPanel.add(functionPanel);
		headerPanel.add(menuPanel);
		
		paymentsPanel.add(button_1);
		paymentsPanel.add(button_5);
		paymentsPanel.add(button_20);
		paymentsPanel.add(button_100);
		reportsPanel.add(buttonSalesReports);
		reportsPanel.add(buttonEmployeePayroll);		
		appetizersPanel.add(buffaloWingsButton);
		appetizersPanel.add(chickenTendersButton);
		appetizersPanel.add(friedAsparagusButton);
		appetizersPanel.add(spicyHummusButton);
		appetizersPanel.add(ultimateNachosButton);
		appetizersPanel.add(crabCakesButton);
		entreesPanel.add(chickenSaladButton);
		entreesPanel.add(cheeseburgerButton);
		entreesPanel.add(tunaSteakButton);
		entreesPanel.add(shrimpAlfredoButton);
		entreesPanel.add(lambLollipopsButton);
		entreesPanel.add(friedPorkChopsButton);
		sidesPanel.add(mashedPotatoesButton);
		sidesPanel.add(greenBeansButton);
		sidesPanel.add(redBeansAndRiceButton);
		sidesPanel.add(waffleFriesButton);
		sidesPanel.add(macAndCheeseButton);
		sidesPanel.add(steamedBroccoliButton);
		soupsPanel.add(clamChowderButton);
		soupsPanel.add(loadedBakedPotatoeButton);
		soupsPanel.add(broccoliChedderButton);
		soupsPanel.add(tortillaButton);
		dessertsPanel.add(cheesecakeButton);
		dessertsPanel.add(moltenLavaCakeButton);
		dessertsPanel.add(cookieSkilletButton);
		dessertsPanel.add(breadPuddingButton);
		dessertsPanel.add(friedIceCreamButton);
		beveragesPanel.add(cocaColaButton);
		beveragesPanel.add(drPepperButton);
		beveragesPanel.add(hiCButton);
		beveragesPanel.add(rootBeerButton);
		beveragesPanel.add(lemonadeButton);
		beveragesPanel.add(sweetTeaButton);
		beveragesPanel.add(pepsiButton);
		beveragesPanel.add(waterButton);

		menuPanel.add(appetizersButton);
		menuPanel.add(entreesButton);
		menuPanel.add(sidesButton);
		menuPanel.add(soupsButton);
		menuPanel.add(dessertsButton);
		menuPanel.add(beveragesButton);
		menuPanel.add(aLaCarteButton);
		menuPanel.add(toGoButton);

		displayPanel.add(userPanel, BorderLayout.PAGE_START);
		displayPanel.add(menuItemPanelScrollPane, BorderLayout.PAGE_END);
		userPanel.add(currentUserLabel);
		userPanel.add(newCheck);
		userPanel.add(currentUserChecks);

		add(loginPanel);
		repaint();
		revalidate();
		/*
		 * LOGIN PANEL EVENT LISTENERS
		 */
		loginPanelConfirmKeyButtonHandler = new LoginPanelConfirmKeyButtonHandler();
		loginPanelClearKeyButtonHandler = new LoginPanelClearKeyButtonHandler();
		loginPanelClockInButtonHandler = new LoginPanelClockInButtonHandler();
		loginPanelClockOutButtonHandler = new LoginPanelClockOutButtonHandler();
		LoginPanelKey1 = new LoginPanelKeypadButtonHandler(1);
		LoginPanelKey2 = new LoginPanelKeypadButtonHandler(2);
		LoginPanelKey3 = new LoginPanelKeypadButtonHandler(3);
		LoginPanelKey4 = new LoginPanelKeypadButtonHandler(4);
		LoginPanelKey5 = new LoginPanelKeypadButtonHandler(5);
		LoginPanelKey6 = new LoginPanelKeypadButtonHandler(6);
		LoginPanelKey7 = new LoginPanelKeypadButtonHandler(7);
		LoginPanelKey8 = new LoginPanelKeypadButtonHandler(8);
		LoginPanelKey9 = new LoginPanelKeypadButtonHandler(9);
		LoginPanelKey0 = new LoginPanelKeypadButtonHandler(0);
		exitSystemHandler = new ExitSystemHandler();
		/*
		 * USER PANEL BUTTON EVENT LISTENERS
		 */
		currentUserChecksButtonHandler = new CurrentUserChecksButtonHandler();
		newCheckButtonHandler = new NewCheckButtonHandler();
		/*
		 * FUNCTION PANEL BUTTON EVENT LISTENERS
		 */
		functionPanelReportsButtonHandler = new FunctionPanelReportsButtonHandler();
		functionPanelEmployeesButtonHandler = new FunctionPanelEmployeesButtonHandler();
		functionPanelPaymentsButtonHandler = new FunctionPanelPaymentsButtonHandler();
		exitButtonHandler = new ExitButtonHandler();
		/*
		 * PAYMENT BUTTON EVENT LISTENERS
		 */
		payment100Handler = new PaymentButtonHandler(100);
		payment20Handler = new PaymentButtonHandler(20);
		payment5Handler = new PaymentButtonHandler(5);
		payment1Handler = new PaymentButtonHandler(1);
		/*
		 * REPORTS BUTTON EVENT LISTENERS
		 */
		salesReportButtonHandler = new SalesReportButtonHandler();
		employeePayrollButtonHandler = new EmployeePayrollButtonHandler();
		/*
		 * CATEGORY PANEL BUTTON EVENT LISTENERS
		 */
		appetizersHandler = new MenuPanelButtonHandler(appetizersPanel);
		entreesHandler = new MenuPanelButtonHandler(entreesPanel);
		sidesHandler = new MenuPanelButtonHandler(sidesPanel);
		soupsHandler = new MenuPanelButtonHandler(soupsPanel);
		dessertsHandler = new MenuPanelButtonHandler(dessertsPanel);
		beveragesHandler = new MenuPanelButtonHandler(beveragesPanel);
		aLaCarteHandler = new MenuPanelButtonHandler(aLaCartePanel);
		toGoHandler = new MenuPanelButtonHandler(toGoPanel);
		/*
		 * MENU ITEM BUTTON EVENT LISTENERS
		 */
		
		//appetizer	
		buffaloWingsHandler = new MenuItemButtonHandler(buffaloWings);
		chickenTendersHandler = new MenuItemButtonHandler(chickenTenders);
		friedAsparagusHandler = new MenuItemButtonHandler(friedAsparagus);
		spicyHummusHandler = new MenuItemButtonHandler(spicyHummus);
		ultimateNachosHandler = new MenuItemButtonHandler(ultimateNachos);
		crabCakesHandler = new MenuItemButtonHandler(crabCakes);

		//entree
		chickenSaladHandler = new MenuItemButtonHandler(chickenSalad);
		cheeseburgerHandler = new MenuItemButtonHandler(cheeseburger);
		tunaSteakHandler = new MenuItemButtonHandler(tunaSteak);
		shrimpAlfredoHandler = new MenuItemButtonHandler(shrimpAlfredo);
		lambLollipopsHandler = new MenuItemButtonHandler(lambLollipops);
		friedPorkChopsHandler= new MenuItemButtonHandler(friedPorkChops);
		
		//sides
		mashedPotatoesHandler = new MenuItemButtonHandler(mashedPotatoes);
		greenBeansHandler = new MenuItemButtonHandler(greenBeans);
		redBeansAndRiceHandler = new MenuItemButtonHandler(redBeansAndRice);
		waffleFriesHandler = new MenuItemButtonHandler(waffleFries);
		macAndCheeseHandler = new MenuItemButtonHandler(macAndCheese);
		steamedBroccoliHandler = new MenuItemButtonHandler(steamedBroccoli);
		
		//soups
		clamChowderHandler = new MenuItemButtonHandler(clamChowder);
		loadedBakedPotatoHandler = new MenuItemButtonHandler(loadedBakedPotato);
		broccoliCheddarHandler = new MenuItemButtonHandler(broccoliCheddar);
		tortillaHandler = new MenuItemButtonHandler(tortilla);
		
		//desserts
		cheesecakeHandler = new MenuItemButtonHandler(cheesecake);
		moltenLavaCakeHandler = new MenuItemButtonHandler(moltenLavaCake);
		cookieSkilletHandler = new MenuItemButtonHandler(cookieSkillet);
		breadPuddingHandler = new MenuItemButtonHandler(breadPudding);
		friedIceCreamHandler = new MenuItemButtonHandler(friedIceCream);
		
		//beverages
		cocaColaHandler = new MenuItemButtonHandler(cocaCola);
		drPepperHandler = new MenuItemButtonHandler(drPepper);
		hiCHandler = new MenuItemButtonHandler(hiC);
		rootBeerHandler = new MenuItemButtonHandler(rootBeer);
		lemonadeHandler = new MenuItemButtonHandler(lemonade);
		sweetTeaHandler = new MenuItemButtonHandler(sweetTea);
		pepsiHandler = new MenuItemButtonHandler(pepsi);
		waterHandler = new MenuItemButtonHandler(water);
		/*
		 * ADD EVENT LISTENERS
		 */
		loginPanelClearKey.addActionListener(loginPanelClearKeyButtonHandler);
		loginPanelConfirmKey.addActionListener(loginPanelConfirmKeyButtonHandler);
		loginPanelExitButton.addActionListener(exitSystemHandler);
		loginPanelClockInButton.addActionListener(loginPanelClockInButtonHandler);
		loginPanelClockOutButton.addActionListener(loginPanelClockOutButtonHandler);
		button1Key.addActionListener(LoginPanelKey1);
		button2Key.addActionListener(LoginPanelKey2);
		button3Key.addActionListener(LoginPanelKey3);
		button4Key.addActionListener(LoginPanelKey4);
		button5Key.addActionListener(LoginPanelKey5);
		button6Key.addActionListener(LoginPanelKey6);
		button7Key.addActionListener(LoginPanelKey7);
		button8Key.addActionListener(LoginPanelKey8);
		button9Key.addActionListener(LoginPanelKey9);
		button0Key.addActionListener(LoginPanelKey0);
		
		newCheck.addActionListener(newCheckButtonHandler);
		currentUserChecks.addActionListener(currentUserChecksButtonHandler);
		
		buttonPayments.addActionListener(functionPanelPaymentsButtonHandler);
		buttonEmployees.addActionListener(functionPanelEmployeesButtonHandler);
		buttonReports.addActionListener(functionPanelReportsButtonHandler);
		buttonExit.addActionListener(exitButtonHandler);
		
		buttonSalesReports.addActionListener(salesReportButtonHandler);
		buttonEmployeePayroll.addActionListener(employeePayrollButtonHandler);
		
		button_100.addActionListener(payment100Handler);
		button_20.addActionListener(payment20Handler);
		button_5.addActionListener(payment5Handler);
		button_1.addActionListener(payment1Handler);

		appetizersButton.addActionListener(appetizersHandler);
		entreesButton.addActionListener(entreesHandler);
		sidesButton.addActionListener(sidesHandler);
		soupsButton.addActionListener(soupsHandler);
		dessertsButton.addActionListener(dessertsHandler);
		beveragesButton.addActionListener(beveragesHandler);
		aLaCarteButton.addActionListener(aLaCarteHandler);
		toGoButton.addActionListener(toGoHandler);
		
		//appetizer
		buffaloWingsButton.addActionListener(buffaloWingsHandler);
		chickenTendersButton.addActionListener(chickenTendersHandler);
		friedAsparagusButton.addActionListener(friedAsparagusHandler);
		spicyHummusButton.addActionListener(spicyHummusHandler);
		ultimateNachosButton.addActionListener(ultimateNachosHandler);
		crabCakesButton.addActionListener(crabCakesHandler);
		
		//entree
		chickenSaladButton.addActionListener(chickenSaladHandler);
		cheeseburgerButton.addActionListener(cheeseburgerHandler);
		tunaSteakButton.addActionListener(tunaSteakHandler);
		shrimpAlfredoButton.addActionListener(shrimpAlfredoHandler);
		lambLollipopsButton.addActionListener(lambLollipopsHandler);
		friedPorkChopsButton.addActionListener(friedPorkChopsHandler);
		
		//sides
		mashedPotatoesButton.addActionListener(mashedPotatoesHandler);
		greenBeansButton.addActionListener(greenBeansHandler);
		redBeansAndRiceButton.addActionListener(redBeansAndRiceHandler);
		waffleFriesButton.addActionListener(waffleFriesHandler);
		macAndCheeseButton.addActionListener(macAndCheeseHandler);
		steamedBroccoliButton.addActionListener(steamedBroccoliHandler);
		
		//soups
		clamChowderButton.addActionListener(clamChowderHandler);
		loadedBakedPotatoeButton.addActionListener(loadedBakedPotatoHandler);
		broccoliChedderButton.addActionListener(broccoliCheddarHandler);
		tortillaButton.addActionListener(tortillaHandler);
		
		//desserts
		cheesecakeButton.addActionListener(cheesecakeHandler);
		moltenLavaCakeButton.addActionListener(moltenLavaCakeHandler);
		cookieSkilletButton.addActionListener(cookieSkilletHandler);
		breadPuddingButton.addActionListener(breadPuddingHandler);
		friedIceCreamButton.addActionListener(friedIceCreamHandler);
		
		//beverages
		cocaColaButton.addActionListener(cocaColaHandler);
		drPepperButton.addActionListener(drPepperHandler);
		hiCButton.addActionListener(hiCHandler);
		rootBeerButton.addActionListener(rootBeerHandler);
		lemonadeButton.addActionListener(lemonadeHandler);
		sweetTeaButton.addActionListener(sweetTeaHandler);
		pepsiButton.addActionListener(pepsiHandler);
		waterButton.addActionListener(waterHandler);
	}
	/*
	 ***************
	 * 			   *
	 * MAIN METHOD *
	 *			   *
	 ***************
	 */	
	public static void main(String[] args) {

		Main main = new Main();
	}
	/**************
	 * 			  *
	 * SUBCLASSES *
	 *			  *
	/**************
	/* _____________________________________________________________________________________________________
	 * LOGIN PANEL KEYPAD BUTTON HANDLER
	 */
	private class LoginPanelKeypadButtonHandler implements ActionListener {

		private int keyValue;									
																
		private LoginPanelKeypadButtonHandler(int keyValue) {
			this.keyValue = keyValue;
		}
		@Override
		public void actionPerformed(ActionEvent event) {
			
			try {
				/*
				 * CONCATENATE THE KEY VALUE TO THE STRING
				 */
				currentUserID += Integer.toString(keyValue);
				/*
				 * SET THE NEW STRING TO THE TEXT FIELD
				 */
				userLoginTextField.setText(currentUserID);
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	/* _____________________________________________________________________________________________________
	 * LOGIN PANEL CLEAR KEY BUTTON HANDLER
	 */
	private class LoginPanelClearKeyButtonHandler implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent event) {
			
			try {
				/*
				 * RESET THE STRING TO BLANK
				 */
				currentUserID = "";
				/*
				 * ASSIGN THE BLANK STRING TO THE TEXT FIELD
				 */
				userLoginTextField.setText(currentUserID);				
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	/* _____________________________________________________________________________________________________
	 * LOGIN PANEL CLOCK IN BUTTON HANDLER
	 */
	private class LoginPanelClockInButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			/*
			 * GET THE CURRENT TIME
			 */
			now = LocalDateTime.now();
			try {
				/*
				 * CREATE CONNECTION
				 */
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				/*
				 * SEARCH DATABASE FOR USER ID
				 */
				Statement stmt = conn.createStatement();
				String searchForUserID = "SELECT * FROM Users WHERE userID='" + currentUserID + "';";
				ResultSet userIDSearchResults = stmt.executeQuery(searchForUserID);
				if (userIDSearchResults.next()) {
					/*
					 * GET THE CLOCKED IN STATUS OF THE USER ID
					 */
					Statement stmt2 = conn.createStatement();
					String getClockedInStatus = "SELECT userClockedIn FROM Users WHERE userID = '" + currentUserID + "';";
					ResultSet clockedInStatus = stmt2.executeQuery(getClockedInStatus);
					while (clockedInStatus.next()) {
						/*
						 * CHECK CLOCKED IN STATUS
						 */
						if (clockedInStatus.getInt(1) == 0) {
							/*
							 * CHANGE CLOCKED IN STATUS
							 */
							Statement stmt3 = conn.createStatement();
							String setClockedInStatus = "UPDATE Users SET userClockedIn='1' WHERE userID='" + currentUserID + "';";
							stmt3.executeUpdate(setClockedInStatus);						
							/*
							 * DISPLAY CLOCKED IN MESSAGE
							 */
							JOptionPane.showMessageDialog(null, "User " + currentUserID + " clocked in at " + tf.format(now) + ".");
							/*
							 * GET THE TIMESTAMP OF THE CLOCK IN TIME
							 */
							Timestamp clockInTimestamp = new Timestamp(now.atZone(ZoneId.systemDefault()).toEpochSecond());
							long clockInLong = clockInTimestamp.getTime();
							/*
							 * CREATE A NEW SHIFT AND ADD A START TIME
							 */
							String setUserTimeIn = "INSERT INTO Shifts (userID, shiftStart, shiftEnd, shiftClockedIn, shiftClockedOut, shiftDate) VALUES ('"
									+ currentUserID
									+ "', '"
									+ TimeUnit.SECONDS.toMinutes(clockInLong)
									+ "', '"
									+ TimeUnit.SECONDS.toMinutes(clockInLong)
									+ "', '"
									+ tf.format(now)
									+ "', '"
									+ tf.format(now)
									+ "', '"
									+ df.format(now)
									+ "');";
							stmt3.executeUpdate(setUserTimeIn);
							/*
							 * GET THE USER'S ATTRIBUTES
							 */
							Statement stmt4 = conn.createStatement();
							String getUserAttributes = "SELECT userID, userFirstName, userLastName, userRank, userHireDate FROM Users WHERE userID = '" + currentUserID + "';";
							ResultSet userAttributes = stmt4.executeQuery(getUserAttributes);
							/*
							 * SET THE USER'S ATTRIBUTES TO THE CURRENT USER				
							 */
							while (userAttributes.next()) {	
								currentUser.setUserID(userAttributes.getString(1));
								currentUser.setUserFirstName(userAttributes.getString(2));
								currentUser.setUserLastName(userAttributes.getString(3));
								currentUser.setUserRank(userAttributes.getString(4));
								currentUser.setUserHireDate(userAttributes.getString(5));
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "User already clocked in.");
						}
						/*
						 * CLEAR THE ATTEMPTED LOGIN ID
						 */
						userLoginTextField.setText("");
						currentUserID = "";
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "User ID not found.");
					userLoginTextField.setText("");
					currentUserID = "";
				}
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	/* _____________________________________________________________________________________________________
	 * LOGIN PANEL CLOCK OUT BUTTON HANDLER
	 */
	private class LoginPanelClockOutButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			now = LocalDateTime.now();

			try {
				/*
				 * GET CONNECTION
				 */
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				/*
				 * GET THE CLOCKED IN STATUS
				 */
				Statement stmt = conn.createStatement();
				String getClockedInStatus = "SELECT userClockedIn FROM Users WHERE userID = '" + currentUserID + "';";				
				ResultSet clockedInStatus = stmt.executeQuery(getClockedInStatus);
				
				while (clockedInStatus.next()) {
					/*
					 * CHECK THE STATUS
					 */
					if (clockedInStatus.getInt(1) == 1) {
						/*
						 * CLOCK THE USER OUT
						 */
						Timestamp clockInTimestamp = new Timestamp(now.atZone(ZoneId.systemDefault()).toEpochSecond());
						long clockOutLong = clockInTimestamp.getTime();
						JOptionPane.showMessageDialog(null, "User " + currentUserID + " clocked out at " + tf.format(now) + ".");
						Statement stmt2 = conn.createStatement();
						String setClockedOutStatus = "UPDATE Users SET userClockedIn='0' WHERE userID='" + currentUserID + "';";
						String setUserTimeOut = "UPDATE Shifts SET shiftClockedOut='"
						+ tf.format(now)
						+ "', shiftEnd='"
						+ TimeUnit.SECONDS.toMinutes(clockOutLong)
						+ "' WHERE userID='"
						+ currentUserID
						+ "'AND shiftDate='"
						+ df.format(now)
						+ "';";
						stmt2.executeUpdate(setClockedOutStatus);
						stmt2.executeUpdate(setUserTimeOut);
					}
					else {
						JOptionPane.showMessageDialog(null, "User isn't clocked in.");
					}
				}
				userLoginTextField.setText("");
				currentUserID = "";
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	/* _____________________________________________________________________________________________________
	 * LOGIN PANEL CONFIRM KEY BUTTON HANDLER
	 */
	private class LoginPanelConfirmKeyButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
						
			try {
				/*
				 * GET THE CURRENT TIME
				 */
				now = LocalDateTime.now();
				/*
				 * CREATE CONNECTION
				 */
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				/*
				 * GET THE CLOCKED IN STATUS OF THE USER ID
				 */
				Statement stmt = conn.createStatement();
				String getClockedInStatus = "SELECT userClockedIn FROM Users WHERE userID = '" + currentUserID + "';";
				ResultSet clockedInStatus = stmt.executeQuery(getClockedInStatus);
				if (!clockedInStatus.isBeforeFirst()) {
					JOptionPane.showMessageDialog(null, "Invalid user ID.");
					userLoginTextField.setText("");
					currentUserID = "";
				}
				/*
				 * CHECK IF THE USER IS CLOCKED IN
				 */
				while (clockedInStatus.next()) {
					if (clockedInStatus.getInt(1) == 1) {
						/*
						 * GET THE USER'S ATTRIBUTES
						 */
						Statement stmt2 = conn.createStatement();
						String getUserAttributes = "SELECT userID, userFirstName, userLastName, userRank, userHireDate FROM Users WHERE userID = '" + currentUserID + "';";
						ResultSet userAttributes = stmt2.executeQuery(getUserAttributes);
						/*
						 * SET THE CURRENT USER ATTRIBUTES			
						 */
						while (userAttributes.next()) {	
							currentUser.setUserID(userAttributes.getString(1));
							currentUser.setUserFirstName(userAttributes.getString(2));
							currentUser.setUserLastName(userAttributes.getString(3));
							currentUser.setUserRank(userAttributes.getString(4));
							currentUser.setUserHireDate(userAttributes.getString(5));
							currentUserLabel.setText(currentUser.getUserFirstName());
						}
						/*
						 * CLEAR CURRENT TABLES				
						 */
						currentUserTables.clear();
						/*
						 * GET ALL THE USER'S TABLES FROM TODAY
						 */
						Statement stmt3 = conn.createStatement();
						String getUserTables = "SELECT tableID, menuItemListID, tableNum, tableDateCreated, tableTimeCreated "
								+ "FROM Tables WHERE userID='"
								+ currentUser.getUserID()
								+ "' AND tableDateCreated='"
								+ df.format(now)
								+ "';";
						ResultSet userTables = stmt3.executeQuery(getUserTables);
						/*
						 * SET ATTRIBUTES TO EACH TABLE
						 */
						while (userTables.next()) {
							currentTable = new Table();
							currentTable.setTableID(userTables.getInt(1));
							currentTable.setMenuItemListID(userTables.getInt(2));
							currentTable.setTableNum(userTables.getInt(3));
							currentTable.setTableTimeCreatedOnLabel(userTables.getDate(4), userTables.getTime(5));
							/*
							 * ADD TABLE TO THE CURRENT USER TABLES
							 */
							currentUserTables.add(currentTable);
							/*
							 * GET THE MENU ITEMS OF THIS TABLE
							 */
							Statement stmt4 = conn.createStatement();
							String getItemsFromTable = "SELECT menuItemID FROM MenuItemList WHERE menuItemListID='" + (int)currentTable.getTableID() + "';";
							ResultSet tableItems = stmt4.executeQuery(getItemsFromTable);
							while (tableItems.next()) {
								try {
									Statement stmt5 = conn.createStatement();
									String getItemAttributes = "SELECT * FROM MenuItems WHERE menuItemID='" + tableItems.getInt(1) + "';";
									ResultSet itemAttributes = stmt5.executeQuery(getItemAttributes);
									/*
									 * GET THE ATTRIBUTES OF EACH MENU ITEM
									 */
									while (itemAttributes.next()) {
										MenuItem menuItem = new MenuItem(Integer.toString(itemAttributes.getInt(1)), itemAttributes.getString(2), itemAttributes.getDouble(3));
										Main.currentTable.getMenuItems().add(menuItem);
									}
								}
								catch (Exception f) {
									JOptionPane.showMessageDialog(null, f);
								}
								/*
								 * CALCULATE THE TABLE TOTAL
								 */
								currentTable.calculateTotals();
							}
							/*
							 * RESET THE CURRENT TABLE
							 */
							currentTable = null;
						}
						/*
						 * SET THE CURRENT USER TABLES WITH MENU ITEMS ATTACHED
						 */
						currentUser.setTables(currentUserTables);
						/*
						 * REMOVE THE LOGIN PANEL
						 */
						/*
						 * REMOVE THE OPTIONS PANEL TO UPDATE
						 */
						optionsPanel.removeAll();
						optionsPanel.repaint();
						optionsPanel.revalidate();
						/*
						 * ADD THE MAIN PANELS
						 */
						if (currentUser.getUserRank().equals("Manager")) {
							remove(loginPanel);
							repaint();
							revalidate();
							functionPanel.removeAll();
							functionPanel.add(buttonPayments);
							functionPanel.add(buttonEmployees);
							functionPanel.add(buttonReports);
							functionPanel.add(button1);
							functionPanel.add(button2);
							functionPanel.add(button3);
							functionPanel.add(button4);
							functionPanel.add(button5);
							functionPanel.add(button6);
							functionPanel.add(buttonExit);
							add(headerPanel, BorderLayout.PAGE_START);
							add(optionsPanel, BorderLayout.LINE_START);
							add(displayPanel, BorderLayout.LINE_END);
							add(statusPanel, BorderLayout.PAGE_END);
							repaint();
							revalidate();
						}
						else if (currentUser.getUserRank().equals("Server")) {
							remove(loginPanel);
							repaint();
							revalidate();
							functionPanel.removeAll();
							functionPanel.add(buttonPayments);
							functionPanel.add(button1);
							functionPanel.add(button2);
							functionPanel.add(button3);
							functionPanel.add(button4);
							functionPanel.add(button5);
							functionPanel.add(button6);
							functionPanel.add(button7);
							functionPanel.add(button8);
							functionPanel.add(buttonExit);
							add(headerPanel, BorderLayout.PAGE_START);
							add(optionsPanel, BorderLayout.LINE_START);
							add(displayPanel, BorderLayout.LINE_END);
							add(statusPanel, BorderLayout.PAGE_END);
							repaint();
							revalidate();							
						}
						else {
							JOptionPane.showMessageDialog(null, "Must be server or manager to log in.");
							currentUserID = "";
							userLoginTextField.setText("");
						}
						try {
							/*
							 * REMOVE EVERYTHING TO UPDATE PANEL
							 */
							optionsPanel.removeAll();
							optionsPanel.repaint();
							optionsPanel.revalidate();
							/*
							 * ADD EACH OF THE USER'S TABLES BUTTONS
							 */
							for (Table table: currentUser.getTables()) {
								optionsPanel.add(table.getTableButton());
							}
							optionsPanel.repaint();
							optionsPanel.revalidate();
						}
						catch (Exception e) {
							JOptionPane.showMessageDialog(null, e);
						}

					}
					else {
						JOptionPane.showMessageDialog(null, "User needs to be clocked in.");
						currentUserID = "";
						userLoginTextField.setText("");
					}
				}
				
				
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	/* _____________________________________________________________________________________________________
	 * FUNCTION PANEL PAYMENTS BUTTON HANDLER
	 */
	private class FunctionPanelPaymentsButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			optionsPanel.removeAll();
			optionsPanel.repaint();
			optionsPanel.validate();					
			optionsPanel.add(paymentsPanel);
			optionsPanel.repaint();
			optionsPanel.validate();
		}
	}
	/* _____________________________________________________________________________________________________
	 * FUNCTION PANEL REPORTS BUTTON HANDLER
	 */
	private class FunctionPanelReportsButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			optionsPanel.removeAll();
			optionsPanel.repaint();
			optionsPanel.validate();					
			optionsPanel.add(reportsPanel);
			optionsPanel.repaint();
			optionsPanel.validate();
		}
	}
	/* _____________________________________________________________________________________________________
	 * PAYMENT BUTTON HANDLER
	 */
	private class PaymentButtonHandler implements ActionListener {
		
			private int value;
		
		private PaymentButtonHandler(int value) {
			this.value = value;
		}
		
		public void actionPerformed(ActionEvent e) {
			if (currentTable != null) {
				currentTable.setTotal(currentTable.getTotal() - value);
				/*
				 * CHECK IF THE VALUE WAS DROPPED TO ZERO
				 */
				if (currentTable.getTotal() <= 0) {
					/*
					 * GET THE ABSOLUTE VALUE OF THE AMOUNT BELOW ZERO
					 */
					Double change = (Math.abs(currentTable.getTotal()));
					currentTable.setTotal(0);
					/*
					 * PRINT THAT VALUE TO A MESSAGE SHOWING THE CUSTOMER'S CHANGE
					 */
					JOptionPane.showMessageDialog(null, String.format("CHANGE DUE:\n\n $%.2f", change));
					/*
					 * GET CONNECTION
					 */
					try {
						Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
						/*
						 * GET EACH MENU ITEM FROM THE CURRENT TABLE
						 */
						Statement stmt = conn.createStatement();					
						String getMenuItems = "SELECT * FROM MenuItemList WHERE menuItemListID='" + (int)currentTable.getTableID() + "';";
						ResultSet menuItems = stmt.executeQuery(getMenuItems);
							/*
							 * ADD THE MENU ITEM TO THE ORDER ARCHIVE DATABASE
							 */
							while (menuItems.next()) {
								Statement stmt2 = conn.createStatement();
								String addToArchives = "INSERT INTO OrderArchive (userID, menuItemID, tableNum, tableDateCreated, tableTimeCreated) "
										+ "VALUES ('"
										+ currentUser.getUserID()
										+ "', '"
										+ menuItems.getString(3)
										+ "', '"
										+ currentTable.getTableNum()
										+ "', '"
										+ currentTable.getDate()
										+ "', '"
										+ currentTable.getTime()
										+ "');";
								stmt2.executeUpdate(addToArchives);
							}
							/*
							 * REMOVE THIS TABLE FROM THE TABLE DATABASE
							 */
							Statement stmt3 = conn.createStatement();
							String deleteTable = "DELETE FROM Tables WHERE tableID = '" + currentTable.getTableID() + "'";
							stmt3.executeUpdate(deleteTable);
							/*
							 * REMOVE THE MENU ITEM LIST FROM THE DATABASE
							 */
							Statement stmt4 = conn.createStatement();
							String deleteMenuItemList = "DELETE FROM MenuItemList WHERE menuItemListID = '" + currentTable.getTableID() + "'";
							stmt4.executeUpdate(deleteMenuItemList);
							/*
							 * DELETE THIS TABLE FROM THE USER'S TABLES
							 */
							currentUser.getTables().remove(currentTable);
					}
					catch (Exception f) {
						JOptionPane.showMessageDialog(null, f);
					}				
					menuItemPanel.removeAll();
					menuItemPanel.repaint();
					menuItemPanel.revalidate();
					currentTable = null;
				}
			}
		}
	}
	/* _____________________________________________________________________________________________________
	 * SALES REPORT BUTTON HANDLER
	 */	
	private class SalesReportButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			salesReportFrame.setVisible(true);
		}
	}
	/* _____________________________________________________________________________________________________
	 * EMPLOYEE PAYROLL BUTTON HANDLER
	 */	
	private class EmployeePayrollButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			employeePayrollFrame.setVisible(true);
		}
	}
	/* _____________________________________________________________________________________________________
	 * FUNCTION PANEL EMPLOYEES BUTTON HANDLER
	 */
	private class FunctionPanelEmployeesButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			mainAdmin.setVisible(true);
		}
	}
	/* _____________________________________________________________________________________________________
	 * MENU PANEL BUTTON HANDLER
	 */
	private class MenuPanelButtonHandler implements ActionListener {
		
		private CategoryPanel categoryPanel;
		
		private MenuPanelButtonHandler(CategoryPanel categoryPanel) {
			this.categoryPanel = categoryPanel;
		}
		@Override
		public void actionPerformed(ActionEvent event) {
			optionsPanel.removeAll();
			optionsPanel.revalidate();
			optionsPanel.repaint();
			optionsPanel.add(categoryPanel);
			optionsPanel.revalidate();
			optionsPanel.repaint();
		}
	}	
	/* _____________________________________________________________________________________________________
	 * MENU ITEM BUTTON HANDLER
	 */
	private class MenuItemButtonHandler implements ActionListener {
		
		private MenuItem menuItem;
		private int count = 0;
		private int scrollPaneAdjustment;
		
		private MenuItemButtonHandler(MenuItem menuItem) {
			this.menuItem = menuItem;
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			try {
				if (currentTable != null) {
					/*
					 * GET CONNECTION
					 */
					Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					/*
					 * ADD THE ITEM TO A MENU ITEM LIST IN THE DATABASE
					 */
					Statement stmt = conn.createStatement();
					String addToTable = "INSERT INTO MenuItemList (menuItemListID, menuItemID)"
							+ "VALUES ('" + (int)currentTable.getTableID() + "', '" + menuItem.getMenuItemID() + "');";
					stmt.executeUpdate(addToTable);
					/*
					 * GET THE MENU ITEMS
					 */
					currentTableMenuItems = currentTable.getMenuItems();
					/*
					 * MAKE A COPY OF THE MENU ITEM
					 */
					MenuItem currentMenuItemCopy = new MenuItem(menuItem);
					/*
					 * ADD IT TO THE TABLE'S MENU ITEMS
					 */
					currentTableMenuItems.add(currentMenuItemCopy);
					/*
					 * REMOVE EVERYTHING TO UPDATE THE PANEL
					 */
					menuItemPanel.removeAll();
					menuItemPanel.repaint();
					menuItemPanel.revalidate();
					/*
					 * ADD THE TABLE INFORMATION
					 */
					menuItemPanel.add(horizonLine, BorderLayout.WEST);
					menuItemPanel.add(currentTable.getTableInformationPanel());
					/*
					 * ADD THE MENU ITEMS
					 */
					menuItemPanel.add(horizonLine2, BorderLayout.WEST);
					currentTableMenuItems = currentTable.getMenuItems();
					for (MenuItem menuItem: currentTable.getMenuItems()) {
						menuItemPanel.add(menuItem.getMenuItemLabelPanel());
						count++;
					}
					/*
					 * ADD THE UPDATED COST INFORMATION
					 */
					menuItemPanel.add(horizonLine3, BorderLayout.WEST);
					currentTable.calculateTotals();
					menuItemPanel.add(currentTable.getSubtotalPanel());
					menuItemPanel.add(currentTable.getTaxPanel());
					menuItemPanel.add(currentTable.getTotalPanel());
					menuItemPanel.add(horizonLine4, BorderLayout.WEST);
					/*
					 * ADJUST THE SCROLL PANE
					 */
					scrollPaneAdjustment = (count * 35) - 230;
					menuItemPanel.setPreferredSize(new Dimension(Main.MENU_ITEM_PANEL_WIDTH, Main.MENU_ITEM_PANEL_HEIGHT + scrollPaneAdjustment));
					menuItemPanel.repaint();
					menuItemPanel.revalidate();
					/*
					 * RESET VARIABLES
					 */
					count = 0;
					scrollPaneAdjustment = 0;
					
				}
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	/* _____________________________________________________________________________________________________
	 * CURRENT USER CHECKS BUTTON HANDLER
	 */                  
	private class CurrentUserChecksButtonHandler implements ActionListener {
				
		@Override
		public void actionPerformed(ActionEvent event) {
			
			try {
				currentTable = null;
				/*
				 * REMOVE EVERYTHING TO UPDATE PANEL
				 */
				optionsPanel.removeAll();
				optionsPanel.repaint();
				optionsPanel.revalidate();
				/*
				 * ADD EACH OF THE USER'S TABLES BUTTONS
				 */
				for (Table table: currentUser.getTables()) {
					optionsPanel.add(table.getTableButton());
				}
				optionsPanel.repaint();
				optionsPanel.revalidate();
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	/* _____________________________________________________________________________________________________
	 * NEW CHECK BUTTON HANDLER
	 */
	private class NewCheckButtonHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			try {
				currentTable = null;
				/*
				 * GET CONNECTION
				 */
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);				
				/*
				 * GET THE CURRENT TIME
				 */
				now = LocalDateTime.now();			
				/*
				 * MAKE A NEW TABLE
				 */
				Table newTable = new Table();
				try {
					/*
					 * INSERT A NEW TABLE IN THE DATABASE 
					 */
					Statement stmt = conn.createStatement();
					String addTables = "INSERT INTO Tables "
							+ "(userID, "
							+ "tableNum, "
							+ "menuItemListID, "
							+ "tableDateCreated, "
							+ "tableTimeCreated, "
							+ "tableSubtotal, "
							+ "tableTax, "
							+ "tableTotal)"
							+ "VALUES ('"
							+ currentUser.getUserID()
							+ "', '"
							+ newTable.getTableNum()
							+ "', '"
							+ newTable.getTableNum()
							+ "', '"
							+ newTable.getDate()
							+ "', '"
							+ newTable.getTime()
							+ "', '"
							+ newTable.getSubtotal()
							+ "', '"
							+ newTable.getTax()
							+ "', '"
							+ newTable.getTotal()
							+ "');";
					stmt.executeUpdate(addTables);
					/*
					 * GET THE TABLE ID THAT WAS JUST CREATED
					 */
					String getNextTableNumber = "SELECT LAST_INSERT_ID()";
					Statement stmt2 = conn.createStatement();
					ResultSet nextTableNumber = stmt2.executeQuery(getNextTableNumber);
					int next = 0;
					while (nextTableNumber.next()) {
						next = nextTableNumber.getInt(1);
					}
					/*
					 * SET THE TABLE BUTTON VARIABLES
					 */
					newTable.getTableButton().setTableNumberOnLabel(next);
					newTable.getTableButton().setTableTotalOnLabel(newTable.getTotal());
					newTable.setTableTimeCreatedOnLabel(newTable.getDate(), newTable.getTime());
					newTable.setTableID(next);
				}
				catch (Exception e ) {
					JOptionPane.showMessageDialog(null, e);
				}
				/*
				 * REMOVE EVERYTHING TO UPDATE PANEL
				 */
				optionsPanel.removeAll();
				optionsPanel.repaint();
				optionsPanel.revalidate();		
				/*
				 * ADD EACH OF THE USER'S TABLE BUTTONS
				 */
				try {
					Statement stmt = conn.createStatement();
					String getUserTables = "SELECT * FROM Tables WHERE tableDateCreated='" + df.format(now) + "'";
					ResultSet userTables = stmt.executeQuery(getUserTables);
				}
				catch (Exception e ) {
					JOptionPane.showMessageDialog(null, e);
				}
				/*
				 * ADD IT TO THE USER'S TABLES
				 */
				currentUser.addToTables(newTable);
				/*
				 * DISPLAY THE USER'S TABLES
				 */
				for (Table table: currentUser.getTables()) {
					optionsPanel.add(table.getTableButton());
				}
				optionsPanel.repaint();
				optionsPanel.revalidate();
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	/* _____________________________________________________________________________________________________
	 * EXIT BUTTON HANDLER
	 */
	private class ExitButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			/*
			 * RESET ALL USER SETTINGS
			 */
			currentUserID = "";
			currentUser.setUserID("");
			currentUser.setUserFirstName("");
			currentUser.setUserLastName("");
			currentUser.setUserRank("");
			currentUser.setUserHireDate("");
			currentUserTables.clear();
			currentTableMenuItems.clear();
			/*
			 * REMOVE ALL TABLES AND OPEN CHECKS
			 */
			optionsPanel.removeAll();
			optionsPanel.repaint();
			optionsPanel.revalidate();
			menuItemPanel.removeAll();
			menuItemPanel.repaint();
			menuItemPanel.revalidate();
			/*
			 * REMOVE MAIN PANELS
			 */
			remove(headerPanel);
			remove(optionsPanel);
			remove(displayPanel);
			remove(statusPanel);
			repaint();
			revalidate();
			/*
			 * RESET THE LOGIN TEXT FIELD
			 */
			userLoginTextField.setText("");
			/*
			 * ADD THE LOGIN PANEL
			 */
			add(loginPanel);
			repaint();
			revalidate();
		} 
	}
	/* _____________________________________________________________________________________________________
	 * EXIT SYSTEM BUTTON HANDLER
	 */
	private class ExitSystemHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		} 
	}
}
