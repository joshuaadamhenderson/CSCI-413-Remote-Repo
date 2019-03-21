/*
 * PROJECT:			Software Engineering Group Project, Restaurant Point-Of-Sale System
 * GROUP:			Round Two
 * MEMBERS:			Dipesh Bhandari, Alex Gayle, Eric Greene, Joshua Henderson
 * COURSE:			CSCI 413, Software Engineering II
 * INSTRUCTOR:		Dr. Bei Xie
 * DATE CREATED:	2/1/2019
 *
 * IMPORTED CLASSES
 *
 * The two class libraries we'll be using the most are the Abstract Windows Toolkit (awt), and Java's Swing components.
 * The swing components have an automatic "look and feel" to them, meaning while using Windows, the JFrame will look like
 * a Windows-based window (minimize, maximize, close buttons, title at the top).  *
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
/*
 * MAIN CLASS
 */
public class Main extends JFrame {
	/*
	 * 
	 * 	NAMING CONVENTIONS
	 * 
	 * 	Constants:				MENU_ITEM
	 * 	Classes and Objects:	MenuItem
	 * 	Variables:				menuItem
	 * 
	 *	IMAGES
	 */
	public static final ImageIcon BUTTON_IMAGE_PAYMENTS = new ImageIcon("src/buttonPayments.jpg");
	public static final ImageIcon BUTTON_IMAGE_STYLE = new ImageIcon("src/buttonStyle.jpg");
	public static final ImageIcon BUTTON_IMAGE_OPEN = new ImageIcon("src/buttonOpen.jpg");
	public static final ImageIcon BUTTON_IMAGE_MODIFY = new ImageIcon("src/buttonModify.jpg");
	public static final ImageIcon BUTTON_IMAGE_PRINT = new ImageIcon("src/buttonPrint.jpg");
	public static final ImageIcon BUTTON_IMAGE_EDIT_TIPS = new ImageIcon("src/buttonEditTips.jpg");
	public static final ImageIcon BUTTON_IMAGE_EXIT = new ImageIcon("src/buttonExit.jpg");
	public static final ImageIcon BUTTON_IMAGE_1 = new ImageIcon("src/button_1.jpg");
	public static final ImageIcon BUTTON_IMAGE_5 = new ImageIcon("src/button_5.jpg");
	public static final ImageIcon BUTTON_IMAGE_20 = new ImageIcon("src/button_20.jpg");
	public static final ImageIcon BUTTON_IMAGE_100 = new ImageIcon("src/button_100.jpg");
	public static final ImageIcon BUTTON_IMAGE_CLOCK_IN = new ImageIcon("src/clockIn.png");
	public static final ImageIcon BUTTON_IMAGE_CLOCK_OUT = new ImageIcon("src/clockOut.png");	
	/*
	 * COLORS
	 */
	public static final Color ORIGINAL_DARK_BLUE = new Color(0, 60, 90);
	public static final Color ORIGINAL_DARK_BLUE_2 = new Color(0, 80, 120);
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
	public static final Color WELCOME_LABEL_COLOR = ORIGINAL_DARK_BLUE_2;
	/*
	 * FONTS
	 */
	public static final Font PROGRAM_FONT = new Font("Arial", Font.BOLD, 18);
	public static final Font TABLE_BUTTON_FONT = new Font("Arial", Font.BOLD, 24);
	public static final Font KEYPAD_FONT = new Font("Arial", Font.BOLD, 30);
	public static final Font DISPLAY_PANEL_FONT = new Font("Arial", Font.BOLD, 18);
	public static final Font MENU_ITEM_PRICE_LABEL_FONT = new Font("Arial", Font.PLAIN, 20);
	public static final Font USER_PANEL_FONT = new Font("Arial", Font.BOLD, 20);
	public static final Font TABLE_COSTS_PANEL_FONT = new Font("Arial", Font.BOLD, 20);
	/*
	 * DIMENSIONS
	 */
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
	public static final int USER_PANEL_WIDTH = 0;
	public static final int USER_PANEL_HEIGHT = 90;
	public static final int HEADER_PANEL_WIDTH = 1366;
	public static final int HEADER_PANEL_HEIGHT = 168;
	public static final int KEYPAD_PANEL_WIDTH = 420;
	public static final int KEYPAD_PANEL_HEIGHT = 470;
	public static final int PAYMENT_BUTTON_WIDTH = 250;
	public static final int PAYMENT_BUTTON_HEIGHT = 110;
	public static final int TABLE_BUTTON_HEIGHT = 70;
	public static final int TABLE_BUTTON_WIDTH = 880;
	public static final int MENU_ITEM_LABEL_PANEL_WIDTH = 440;
	public static final int MENU_ITEM_LABEL_PANEL_HEIGHT = 30;
	public static final int TABLE_COSTS_PANEL_WIDTH = 460;
	public static final int TABLE_COSTS_PANEL_HEIGHT = 200;
	public static final int MENU_PANEL_WIDTH = 0;
	public static final int MENU_PANEL_HEIGHT = 48;
	/*
	 * TAX RATE
	 */
	public static final double CALCASIEU_TAX_RATE = .1075;
	public static final double CAMERON_TAX_RATE = .04;
	public static final double CURRENT_TAX_RATE = CALCASIEU_TAX_RATE; // Set a tax region here
	/*
	 * CHECK NUMBERS
	 */
	public static int nextTableCheckNum = 1;
	/*
	 * DATE
	 */
	public static LocalDateTime now = LocalDateTime.now();
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	/*
	 * LABELS
	 */
	public static JLabel welcomeLabel = new JLabel(" USER LOGIN");
	public static JLabel clockedInLabel = new JLabel(" CLOCKED IN AT " + dtf.format(now));
	public static JLabel clockedOutLabel = new JLabel(" CLOCKED OUT AT " + dtf.format(now));
	public static JLabel currentUserLabel = new JLabel("");
	public static JLabel horizonLine = new JLabel("    ***************************************************************************************");
	public static JLabel horizonLine2 = new JLabel("    ***************************************************************************************");
	public static JLabel horizonLine3 = new JLabel("    ***************************************************************************************");
	public static JLabel horizonLine4 = new JLabel("    ***************************************************************************************");
	/*
	 * ERROR LABELS
	 */
	public static ErrorLabel loginError = new ErrorLabel("Incorrect User ID.");
	/*
	 * TEXT FIELDS
	 */
	public static JTextField userLoginTextField = new JTextField(4);
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
	public static CategoryPanel payments = new CategoryPanel();
	/*
	 * USERS
	 */
	public static String currentUserID = ""; // Placeholder
	public static User currentUser = new User("", "", "", "", ""); // Placeholder
	public static User dipeshBhandari = new User("1111", "Dipesh", "Bhandari", "Manager", "11-Apr-2015");
	public static User alexGayle = new User("2222", "Alex", "Gayle", "Waiter", "3-Sep-2018");
	public static User ericGreene = new User("3333", "Eric", "Greene", "Cook", "22-Jan-2017");
	public static User joshuaHenderson = new User("4444", "Joshua", "Henderson", "Busser", "15-Feb-2019");
	/*
	 * TABLES
	 */
	public static Table currentTable = new Table(); // Placeholder
	public static List<Table> currentUserTables = new ArrayList<Table>(); // Placeholder
	/*
	 * MENU ITEMS
	 */
	//appetizers
	public static MenuItem buffaloWings = new MenuItem("1000", "Buffalo Wings", 6.99);
	public static MenuItem chickenTenders = new MenuItem("1005", "Chicken Tenders", 6.99);
	public static MenuItem friedAsparagus = new MenuItem("1010", "Fried Asparagus", 6.99);
	public static MenuItem spicyHummus = new MenuItem("1015", "Spicy Hummus", 6.99);
	public static MenuItem ultimateNachos = new MenuItem("1020", "Ultimate Nachos", 6.99);
	public static MenuItem crabCakes = new MenuItem("1025", "Crab Cakes", 6.99);
	
	
	//entree
	public static MenuItem chickenSalad = new MenuItem("2000", "Chicken Salad", 8.50);
	public static MenuItem cheeseburger = new MenuItem("2005", "Cheeseburger", 8.50);
	public static MenuItem tunaSteak = new MenuItem("2010", "Tuna Steak", 8.50);
	public static MenuItem shrimpAlfredo = new MenuItem("2015", "Shrimp Alfredo", 8.50);
	public static MenuItem lambLollipops = new MenuItem("2020", "Lamb Lollipops", 8.50);
	public static MenuItem friedPorkChops = new MenuItem("2025", "Fried Pork Chops", 8.50);
	
	
	//sides
	public static MenuItem mashedPotatoes = new MenuItem("3000", "mashed Potatoes", 2.35);
	public static MenuItem greenBeans = new MenuItem("3005", "Green Beans", 2.35);
	public static MenuItem redBeansAndRice = new MenuItem("3010", "Red Beans and Rice", 2.35);
	public static MenuItem waffleFries = new MenuItem("3015", "Waffle Fries", 2.35);
	public static MenuItem macAndCheese = new MenuItem("3020", "Mac N' Cheese", 2.35);
	public static MenuItem steamedBroccoli = new MenuItem("3025", "Steamed Broccoli", 2.35);
	
	//soups
	public static MenuItem clamChowder = new MenuItem("4000", "Clam Chowder", 3.25);
	public static MenuItem loadedBakedPotatoe = new MenuItem("4005", "Loaded Baked Potatoe", 3.25);
	public static MenuItem broccoliChedder = new MenuItem("4010", "Broccoli Chedder", 3.25);
	public static MenuItem tortilla = new MenuItem("4015", "Tortilla Soup", 3.25);
	
	//desserts
	public static MenuItem cheesecake = new MenuItem("5000", "Cheesecake", 5.50);
	public static MenuItem moltenLavaCake = new MenuItem("5005", "Molten Lava Cake", 5.50);
	public static MenuItem cookieSkillet = new MenuItem("5010", "Cookie Skillet", 5.50);
	public static MenuItem breadPudding = new MenuItem("5015", "Bread Pudding", 5.50);
	public static MenuItem friedIceCream = new MenuItem("5020", "Fried Ice Cream", 5.50);
	
	//beverages
	public static MenuItem cocaCola = new MenuItem("6000", "Coca Cola", 2.20);
	public static MenuItem drPepper = new MenuItem("6005", "Dr. Pepper", 2.20);
	public static MenuItem hiC = new MenuItem("6010", "Hi-C", 2.20);
	public static MenuItem rootBeer = new MenuItem("6015", "Root Beer", 2.20);
	public static MenuItem lemonade = new MenuItem("6020", "Lemonade", 2.20);
	public static MenuItem sweetTea = new MenuItem("6025", "Sweet Tea", 2.20);
	public static MenuItem pepsi = new MenuItem("6030", "Pepsi", 2.20);
	
	public static MenuItem currentMenuItem = new MenuItem("", "", 0);	
	public static List<MenuItem> currentTableMenuItems = new ArrayList<MenuItem>(); // Placeholder
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
	public static MenuButton buffaloWingsButton = new MenuButton("BUFFALO", "WINGS", Main.MENU_ITEM_BUTTON_COLOR_1, Color.WHITE);		
	public static MenuButton chickenTendersButton = new MenuButton("CHICKEN", "TENDERS", Main.MENU_ITEM_BUTTON_COLOR_1, Color.WHITE);
	public static MenuButton friedAsparagusButton = new MenuButton("FRIED", "ASPARAGUS", Main.MENU_ITEM_BUTTON_COLOR_1, Color.WHITE);
	public static MenuButton spicyHummusButton = new MenuButton("SPICY", "HUMMUS", Main.MENU_ITEM_BUTTON_COLOR_1, Color.WHITE);
	public static MenuButton ultimateNachosButton = new MenuButton("ULTIMATE", "NACHOS", Main.MENU_ITEM_BUTTON_COLOR_1, Color.WHITE);
	public static MenuButton crabCakesButton = new MenuButton("CRAB", "CAKES", Main.MENU_ITEM_BUTTON_COLOR_1, Color.WHITE);
	
	//entrees
	public static MenuButton chickenSaladButton = new MenuButton("CHICKEN", "SALAD", Main.MENU_ITEM_BUTTON_COLOR_2, Color.WHITE);
	public static MenuButton cheeseburgerButton = new MenuButton("CHEESEBURGER", Main.MENU_ITEM_BUTTON_COLOR_2, Color.WHITE);
	public static MenuButton tunaSteakButton = new MenuButton("TUNA", "STEAK", Main.MENU_ITEM_BUTTON_COLOR_2, Color.WHITE);
	public static MenuButton shrimpAlfredoButton = new MenuButton("SHRIMP", "ALFREDO", Main.MENU_ITEM_BUTTON_COLOR_2, Color.WHITE);
	public static MenuButton lambLollipopsButton = new MenuButton("LAMB", "LOLLIPOPS", Main.MENU_ITEM_BUTTON_COLOR_2, Color.WHITE);
	public static MenuButton friedPorkChopsButton = new MenuButton("FRIED", "PORK CHOPS", Main.MENU_ITEM_BUTTON_COLOR_2, Color.WHITE);
	
	//sides
	public static MenuButton mashedPotatoesButton = new MenuButton("Mashed", "Potatoes", Main.MENU_ITEM_BUTTON_COLOR_3, Color.WHITE);
	public static MenuButton greenBeansButton = new MenuButton("Green", "Beans", Main.MENU_ITEM_BUTTON_COLOR_3, Color.WHITE);
	public static MenuButton redBeansAndRiceButton = new MenuButton("Red Beans", "and Rice",  Main.MENU_ITEM_BUTTON_COLOR_3, Color.WHITE);
	public static MenuButton waffleFriesButton = new MenuButton("Waffle", "Fries", Main.MENU_ITEM_BUTTON_COLOR_3, Color.WHITE);
	public static MenuButton macAndCheeseButton = new MenuButton("Mac and", "Cheese", Main.MENU_ITEM_BUTTON_COLOR_3, Color.WHITE);
	public static MenuButton steamedBroccoliButton = new MenuButton("Steamed", "Broccoli", Main.MENU_ITEM_BUTTON_COLOR_3, Color.WHITE);

	//soup
	public static MenuButton clamChowderButton = new MenuButton("Clam", "Chowder", Main.MENU_ITEM_BUTTON_COLOR_4, Color.WHITE);
	public static MenuButton loadedBakedPotatoeButton = new MenuButton("Loaded Baked", "Potatoe Soup", Main.MENU_ITEM_BUTTON_COLOR_4, Color.WHITE);
	public static MenuButton broccoliChedderButton = new MenuButton("Broccoli", "Chedder Soup", Main.MENU_ITEM_BUTTON_COLOR_4, Color.WHITE);
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
	
	
	
	
	
	
	/*
	 * FUNCTION PANEL BUTTONS
	 */
	public static JButton buttonPayments = new JButton(BUTTON_IMAGE_PAYMENTS);
	public static JButton buttonOpen = new JButton(BUTTON_IMAGE_OPEN);
	public static JButton buttonPrint = new JButton(BUTTON_IMAGE_PRINT);
	public static JButton buttonModify = new JButton(BUTTON_IMAGE_MODIFY);
	public static JButton buttonEditTips = new JButton(BUTTON_IMAGE_EDIT_TIPS);
	public static JButton button6 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton button7 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton button8 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton button9 = new JButton(BUTTON_IMAGE_STYLE);
	public static JButton FunctionPanelExitButton = new JButton(BUTTON_IMAGE_EXIT);
	/*
	 * PAYMENTS CATEGORY PANEL BUTTONS
	 */
	public static JButton button_1 = new JButton(BUTTON_IMAGE_1);
	public static JButton button_5 = new JButton(BUTTON_IMAGE_5);
	public static JButton button_20 = new JButton(BUTTON_IMAGE_20);
	public static JButton button_100 = new JButton(BUTTON_IMAGE_100);
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
	public static MenuItemButtonHandler loadedBakedPotatoeHandler;
	public static MenuItemButtonHandler broccoliChedderHandler;
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
	
	/*
	 * OTHER BUTTON HANDLERS
	 */
	public static CurrentUserChecksButtonHandler currentUserChecksButtonHandler;
	public static NewCheckButtonHandler newCheckButtonHandler;
	public static ExitButtonHandler exitButtonHandler;
	public static ExitSystemHandler exitSystemHandler;
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
		 * LOGIN PANEL SETTINGS
		 */
		welcomeLabel.setFont(new Font("Impact", Font.PLAIN, 80));
		welcomeLabel.setForeground(WELCOME_LABEL_COLOR);
		clockedInLabel.setFont(new Font("Arial", Font.BOLD, 24));
		clockedInLabel.setBackground(MAIN_BG_COLOR);
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
		displayPanel.add(userPanel, BorderLayout.PAGE_START);
		displayPanel.add(menuItemPanel, BorderLayout.PAGE_END);
		userPanel.add(currentUserLabel);
		userPanel.add(newCheck);
		userPanel.add(currentUserChecks);
		functionPanel.add(buttonPayments);
		functionPanel.add(buttonOpen);
		functionPanel.add(buttonPrint);
		functionPanel.add(buttonModify);
		functionPanel.add(buttonEditTips);
		functionPanel.add(button6);		
		functionPanel.add(button7);		
		functionPanel.add(button8);
		functionPanel.add(FunctionPanelExitButton);
		payments.add(button_1);
		payments.add(button_5);
		payments.add(button_20);
		payments.add(button_100);
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
		
		menuPanel.add(appetizersButton);
		menuPanel.add(entreesButton);
		menuPanel.add(sidesButton);
		menuPanel.add(soupsButton);
		menuPanel.add(dessertsButton);
		menuPanel.add(beveragesButton);
		menuPanel.add(aLaCarteButton);
		menuPanel.add(toGoButton);
		add(loginPanel);
		repaint();
		revalidate();
		/*
		 * INSTANTIATE EVENT LISTENERS
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

		currentUserChecksButtonHandler = new CurrentUserChecksButtonHandler();
		newCheckButtonHandler = new NewCheckButtonHandler();
		exitButtonHandler = new ExitButtonHandler();
		exitSystemHandler = new ExitSystemHandler();
		functionPanelPaymentsButtonHandler = new FunctionPanelPaymentsButtonHandler();

		appetizersHandler = new MenuPanelButtonHandler(appetizersPanel);
		entreesHandler = new MenuPanelButtonHandler(entreesPanel);
		sidesHandler = new MenuPanelButtonHandler(sidesPanel);
		soupsHandler = new MenuPanelButtonHandler(soupsPanel);
		dessertsHandler = new MenuPanelButtonHandler(dessertsPanel);
		beveragesHandler = new MenuPanelButtonHandler(beveragesPanel);
		aLaCarteHandler = new MenuPanelButtonHandler(aLaCartePanel);
		toGoHandler = new MenuPanelButtonHandler(toGoPanel);
		
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
		loadedBakedPotatoeHandler = new MenuItemButtonHandler(loadedBakedPotatoe);
		broccoliChedderHandler = new MenuItemButtonHandler(broccoliChedder);
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
		
		
		
		currentUserChecksButtonHandler = new CurrentUserChecksButtonHandler();
		newCheckButtonHandler = new NewCheckButtonHandler();
		exitButtonHandler = new ExitButtonHandler();
		exitSystemHandler = new ExitSystemHandler();
		functionPanelPaymentsButtonHandler = new FunctionPanelPaymentsButtonHandler();
		/*
		 * ADD EVENT LISTENERS
		 */
		loginPanelClearKey.addActionListener(loginPanelClearKeyButtonHandler);
		loginPanelConfirmKey.addActionListener(loginPanelConfirmKeyButtonHandler);
		loginPanelExitButton.addActionListener(exitSystemHandler);
		loginPanelClockInButton.addActionListener(loginPanelClockInButtonHandler);
		loginPanelClockOutButton.addActionListener(loginPanelClockOutButtonHandler);
		
		//appetizer
		buffaloWingsButton.addActionListener(buffaloWingsHandler);
		chickenTendersButton.addActionListener(chickenTendersHandler);
		friedAsparagusButton.addActionListener(friedAsparagusHandler);
		spicyHummusButton.addActionListener(spicyHummusHandler);
		ultimateNachosButton.addActionListener(ultimateNachosHandler);
		crabCakesButton.addActionListener(crabCakesHandler);
		appetizersButton.addActionListener(appetizersHandler);
		//entree
		chickenSaladButton.addActionListener(chickenSaladHandler);
		cheeseburgerButton.addActionListener(cheeseburgerHandler);
		tunaSteakButton.addActionListener(tunaSteakHandler);
		shrimpAlfredoButton.addActionListener(shrimpAlfredoHandler);
		lambLollipopsButton.addActionListener(lambLollipopsHandler);
		friedPorkChopsButton.addActionListener(friedPorkChopsHandler);
		entreesButton.addActionListener(entreesHandler);
		//sides
		mashedPotatoesButton.addActionListener(mashedPotatoesHandler);
		greenBeansButton.addActionListener(greenBeansHandler);
		redBeansAndRiceButton.addActionListener(redBeansAndRiceHandler);
		waffleFriesButton.addActionListener(waffleFriesHandler);
		macAndCheeseButton.addActionListener(macAndCheeseHandler);
		steamedBroccoliButton.addActionListener(steamedBroccoliHandler);
		sidesButton.addActionListener(sidesHandler);
		
		//soups
		clamChowderButton.addActionListener(clamChowderHandler);
		loadedBakedPotatoeButton.addActionListener(loadedBakedPotatoeHandler);
		broccoliChedderButton.addActionListener(broccoliChedderHandler);
		tortillaButton.addActionListener(tortillaHandler);
		soupsButton.addActionListener(soupsHandler);
		//desserts
		cheesecakeButton.addActionListener(cheesecakeHandler);
		moltenLavaCakeButton.addActionListener(moltenLavaCakeHandler);
		cookieSkilletButton.addActionListener(cookieSkilletHandler);
		breadPuddingButton.addActionListener(breadPuddingHandler);
		friedIceCreamButton.addActionListener(friedIceCreamHandler);
		dessertsButton.addActionListener(dessertsHandler);
		//beverages
		cocaColaButton.addActionListener(cocaColaHandler);
		drPepperButton.addActionListener(drPepperHandler);
		hiCButton.addActionListener(hiCHandler);
		rootBeerButton.addActionListener(rootBeerHandler);
		lemonadeButton.addActionListener(lemonadeHandler);
		sweetTeaButton.addActionListener(sweetTeaHandler);
		pepsiButton.addActionListener(pepsiHandler);
		beveragesButton.addActionListener(beveragesHandler);
		
		aLaCarteButton.addActionListener(aLaCarteHandler);
		toGoButton.addActionListener(toGoHandler);
		currentUserChecks.addActionListener(currentUserChecksButtonHandler);
		newCheck.addActionListener(newCheckButtonHandler);
		FunctionPanelExitButton.addActionListener(exitButtonHandler);
		buttonPayments.addActionListener(functionPanelPaymentsButtonHandler);
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
		FunctionPanelExitButton.addActionListener(exitButtonHandler);
		newCheck.addActionListener(newCheckButtonHandler);
		currentUserChecks.addActionListener(currentUserChecksButtonHandler);
		buttonPayments.addActionListener(functionPanelPaymentsButtonHandler);
		appetizersButton.addActionListener(appetizersHandler);
		entreesButton.addActionListener(entreesHandler);
		sidesButton.addActionListener(sidesHandler);
		soupsButton.addActionListener(soupsHandler);
		dessertsButton.addActionListener(dessertsHandler);
		beveragesButton.addActionListener(beveragesHandler);
		aLaCarteButton.addActionListener(aLaCarteHandler);
		toGoButton.addActionListener(toGoHandler);
		buffaloWingsButton.addActionListener(buffaloWingsHandler);
		chickenTendersButton.addActionListener(chickenTendersHandler);
		friedAsparagusButton.addActionListener(friedAsparagusHandler);
		spicyHummusButton.addActionListener(spicyHummusHandler);
		ultimateNachosButton.addActionListener(ultimateNachosHandler);
		crabCakesButton.addActionListener(crabCakesHandler);
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
	 * 
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
	/*
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
	/*
	 * LOGIN PANEL CONFIRM KEY BUTTON HANDLER
	 */
	private class LoginPanelConfirmKeyButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			
			/*
			 * THIS SWITCH STATEMENT NEEDS TO BE CHANGED TO A DATABASE CALL!
			 * 
				switch (currentUserID) {
				case "1111": currentUser = dipeshBhandari;
				break;
				case "2222": currentUser = alexGayle;
				break;
				case "3333": currentUser = ericGreene;
				break;
				case "4444": currentUser = joshuaHenderson;
				break;
				default: JOptionPane.showMessageDialog(null, loginError);
			}
			 *
			 *
			 */
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/r2db", "root", "");
				Statement stmt = conn.createStatement();
				String statement = "SELECT userID, userFirstName, userLastName, userRank, userHireDate FROM Users WHERE userID = '" + currentUserID + "';";				
				ResultSet rs = stmt.executeQuery(statement);
				
			
				while (rs.next()) {	
					currentUser.setUserID(rs.getString(1));
					currentUser.setUserFirstName(rs.getString(2));
					currentUser.setUserLastName(rs.getString(3));
					currentUser.setUserRank(rs.getString(4));
					currentUser.setUserHireDate(rs.getString(5));
				}
				/*
				 * GET USER VARIABLES
				 * 
				 */
				currentUserTables = currentUser.getTables();
				currentUserLabel.setText(currentUser.getUserFirstName());
				/*
				 * REMOVE THE LOGIN PANEL
				 */
				remove(loginPanel);
				repaint();
				revalidate();
				/*
				 * ADD EACH OF THE USER'S TABLE BUTTONS
				 */
				for (Table table: currentUserTables) {
					optionsPanel.add(table.getTableButton());
				}
				optionsPanel.repaint();
				optionsPanel.revalidate();
				/*
				 * ADD THE MAIN PANELS
				 */
				add(headerPanel, BorderLayout.PAGE_START);
				add(optionsPanel, BorderLayout.LINE_START);
				add(displayPanel, BorderLayout.LINE_END);
				add(statusPanel, BorderLayout.PAGE_END);
				repaint();
				revalidate();					
				
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}

	/*
	 * LOGIN PANEL CLOCK IN BUTTON HANDLER
	 */
	private class LoginPanelClockInButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, clockedInLabel, "", JOptionPane.PLAIN_MESSAGE);
		}
	}
	/*
	 * LOGIN PANEL CLOCK OUT BUTTON HANDLER
	 */
	private class LoginPanelClockOutButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}
	/*
	 * FUNCTION PANEL PAYMENTS BUTTON HANDLER
	 */
	private class FunctionPanelPaymentsButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			optionsPanel.removeAll();
			optionsPanel.repaint();
			optionsPanel.validate();					
			optionsPanel.add(payments);
			optionsPanel.repaint();
			optionsPanel.validate();
		}
	}

	/*
	 * MENU PANEL BUTTON HANDLER
	 */
	private class MenuPanelButtonHandler implements ActionListener {
		
		private CategoryPanel categoryPanel;
		
		private MenuPanelButtonHandler(CategoryPanel categoryPanel) {
			this.categoryPanel = categoryPanel;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			optionsPanel.removeAll();
			optionsPanel.revalidate();
			optionsPanel.repaint();
			optionsPanel.add(categoryPanel);
			optionsPanel.revalidate();
			optionsPanel.repaint();
		}
	}	
	/*
	 * MENU ITEM BUTTON HANDLER
	 */
	private class MenuItemButtonHandler implements ActionListener {
		
		private MenuItem menuItem;
		
		private MenuItemButtonHandler(MenuItem menuItem) {
			this.menuItem = menuItem;
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			try {
				/*
				 * GET VARIABLES
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
				 * ADD A HORIZON LINE AT THE TOP
				 */
				menuItemPanel.add(horizonLine, BorderLayout.WEST);
				/*
				 * ADD THE TABLE INFORMATION
				 */
				menuItemPanel.add(currentTable.getTableInformationPanel());
				/*
				 * ADD ANOTHER HORIZON LINE
				 */
				menuItemPanel.add(horizonLine2, BorderLayout.WEST);
				/*
				 * ADD THE MENU ITEMS
				 */
				currentTableMenuItems = currentTable.getMenuItems();
				for (MenuItem menuItem: currentTable.getMenuItems()) {
					menuItemPanel.add(menuItem.getMenuItemLabelPanel());
				}
				/*
				 * ADD ANOTHER HORIZON LINE
				 */
				menuItemPanel.add(horizonLine3, BorderLayout.WEST);
				/*
				 * CALCULATE TOTALS
				 */
				currentTable.calculateTotals();
				/*
				 * ADD THE COST INFORMATION
				 */
				menuItemPanel.add(currentTable.getSubtotalPanel());
				menuItemPanel.add(currentTable.getTaxPanel());
				menuItemPanel.add(currentTable.getTotalPanel());
				/*
				 * ADD ANOTHER HORIZON LINE
				 */
				menuItemPanel.add(horizonLine4, BorderLayout.WEST);
				menuItemPanel.repaint();
				menuItemPanel.revalidate();				
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	/*
	 * CURRENT USER CHECKS BUTTON HANDLER
	 */                  
	private class CurrentUserChecksButtonHandler implements ActionListener {
				
		@Override
		public void actionPerformed(ActionEvent event) {
			
			try {
				/*
				 * GET VARIABLES
				 */
				currentUserTables = currentUser.getTables();
				/*
				 * REMOVE EVERYTHING TO UPDATE PANEL
				 */
				optionsPanel.removeAll();
				optionsPanel.repaint();
				optionsPanel.revalidate();
				/*
				 * ADD EACH OF THE USER'S TABLES BUTTONS
				 */
				for (Table table: currentUserTables) {
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
	/*
	 * NEW CHECK BUTTON HANDLER
	 */
	private class NewCheckButtonHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			try {
				/*
				 * GET VARIABLES
				 */
				currentUserTables = currentUser.getTables();
				now = LocalDateTime.now();			
				/*
				 * MAKE A NEW TABLE AND APPLY ATTRIBUTES
				 */
				Table newTable = new Table();
				newTable.calculateTotals();
				/*
				 * ADD IT TO THE USER'S TABLES
				 */
				currentUserTables.add(newTable);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/r2db", "root", "");
					Statement stmt = conn.createStatement();
					String statement = "INSERT INTO Tables (userID, tableCheckNum, tableNum, tableTimeCreated, tableTotal)"
							+ "VALUES ('"
							+ currentUserID
							+ "', '"
							+ nextTableCheckNum
							+ "', '"
							+ currentTable.getTableID()
							+ "', '"
							+ currentTable.getTimeCreated()
							+ "', '"
							+ currentTable.getTotal()
							+ "');";
					stmt.executeUpdate(statement);
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
				for (Table table: currentUserTables) {
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
	/*
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
			currentUserTables = null;
			currentTableMenuItems = null;
			/*
			 * REMOVE ALL TABLES AND OPEN CHECKS
			 */
			optionsPanel.removeAll();
			menuItemPanel.removeAll();
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
	/*
	 * EXIT SYSTEM BUTTON HANDLER
	 */
	private class ExitSystemHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		} 
	}
	
	/*
	 * 
	 * 
	public static void loadData() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/r2db", "root", "");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE userFirstName = 'Dipesh'");
			
			while (rs.next()) {
				JOptionPane.showMessageDialog(null, rs.getString(1));
				JOptionPane.showMessageDialog(null, rs.getString(2));
				JOptionPane.showMessageDialog(null, rs.getString(3));
				JOptionPane.showMessageDialog(null, rs.getString(4));
				JOptionPane.showMessageDialog(null, rs.getString(5));
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	*
	*
	*/
}
