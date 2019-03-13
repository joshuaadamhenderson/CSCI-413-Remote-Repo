/*
 * PROJECT:			Software Engineering Group Project, Restaurant Point-Of-Sale System
 * GROUP:			Round Two
 * MEMBERS:			Dipesh Bhandari, Alex Gayle, Eric Greene, Joshua Henderson
 * COURSE:			CSCI 413, Software Engineering II
 * INSTRUCTOR:		Dr. Bei Xie
 * DATE CREATED:	2/1/2019
 * EDITED BY:		2/1/2019:	Joshua Henderson
 * */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel {
	
	// MenuPanel Buttons
	private final MenuButton appetizerButton;
	private final MenuButton entreeButton;
	private final MenuButton sidesButton;
	private final MenuButton soupsButton;
	private final MenuButton dessertsButton;
	private final MenuButton beveragesButton;
	private final MenuButton aLaCarteButton;
	private final MenuButton toGoButton;
	
	// CategoryPanel Buttons
	private final MenuButton buffaloWings;
	private final MenuButton chickenTenders;
	private final MenuButton friedAsparagus;
	private final MenuButton spicyHummus;
	private final MenuButton ultimateNachos;
	private final MenuButton crabCakes;
	
	private final MenuButton chickenSalad;
	private final MenuButton cheeseburger;
	private final MenuButton tunaSteak;
	private final MenuButton shrimpAlfredo;
	private final MenuButton lambLollipops;
	private final MenuButton friedPorkChops;

	// Categories
	private final CategoryPanel appetizers;
	private final CategoryPanel entrees;
	private final CategoryPanel sides;
	private final CategoryPanel soups;
	private final CategoryPanel desserts;
	private final CategoryPanel beverages;
	private final CategoryPanel aLaCarte;
	private final CategoryPanel toGo;
	
	
	public MenuPanel() {
		
		// Basic settings
		setVisible(true);
		setLayout(new GridLayout());
		setPreferredSize(new Dimension(0, 48));
		// Instantiate the MenuButtons
		
			// Appetizers
		buffaloWings = new MenuButton("BUFFALO", "WINGS", Main.MENU_ITEM_BUTTON_COLOR_1, Color.WHITE);
		buffaloWings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Main.currentTableMenuItems.add(Main.buffaloWings);
				Main.menuItemPanel.removeAll();
				Main.menuItemPanel.repaint();
				Main.menuItemPanel.revalidate();
				Main.currentTableMenuItems = Main.currentTable.getMenuItems();
				for (MenuItem menuItem: Main.currentTableMenuItems) {
					JOptionPane.showMessageDialog(null, menuItem);
					Main.menuItemPanel.add(menuItem.getMenuItemLabelPanel());
				}
				TableButton currentTableButton = Main.currentTable.getTableButton();
				Main.menuItemPanel.add(currentTableButton.getTableSubtotalLabel());
				Main.menuItemPanel.add(currentTableButton.getTableTotalLabel());
				Main.menuItemPanel.repaint();
				Main.menuItemPanel.revalidate();
			}
		});
		chickenTenders = new MenuButton("CHICKEN", "TENDERS", Main.MENU_ITEM_BUTTON_COLOR_1, Color.WHITE);
		friedAsparagus = new MenuButton("FRIED", "ASPARAGUS", Main.MENU_ITEM_BUTTON_COLOR_1, Color.WHITE);
		spicyHummus = new MenuButton("SPICY", "HUMMUS", Main.MENU_ITEM_BUTTON_COLOR_1, Color.WHITE);
		ultimateNachos = new MenuButton("ULTIMATE", "NACHOS", Main.MENU_ITEM_BUTTON_COLOR_1, Color.WHITE);
		crabCakes = new MenuButton("CRAB", "CAKES", Main.MENU_ITEM_BUTTON_COLOR_1, Color.WHITE);
			
			// Entrees
		chickenSalad = new MenuButton("CHICKEN", "SALAD", Main.MENU_ITEM_BUTTON_COLOR_2, Color.WHITE);
		cheeseburger = new MenuButton("CHEESEBURGER", Main.MENU_ITEM_BUTTON_COLOR_2, Color.WHITE);
		tunaSteak = new MenuButton("TUNA", "STEAK", Main.MENU_ITEM_BUTTON_COLOR_2, Color.WHITE);
		shrimpAlfredo = new MenuButton("SHRIMP", "ALFREDO", Main.MENU_ITEM_BUTTON_COLOR_2, Color.WHITE);
		lambLollipops = new MenuButton("LAMB", "LOLLIPOPS", Main.MENU_ITEM_BUTTON_COLOR_2, Color.WHITE);
		friedPorkChops = new MenuButton("FRIED", "PORK CHOPS", Main.MENU_ITEM_BUTTON_COLOR_2, Color.WHITE);

		// Instantiate the CategoryPanels, and populate with MenuButtons
		appetizers = new CategoryPanel();
		appetizers.add(buffaloWings);
		appetizers.add(chickenTenders);
		appetizers.add(friedAsparagus);
		appetizers.add(spicyHummus);
		appetizers.add(ultimateNachos);
		appetizers.add(crabCakes);
			
		entrees = new CategoryPanel();
		entrees.add(chickenSalad);
		entrees.add(cheeseburger);
		entrees.add(tunaSteak);
		entrees.add(shrimpAlfredo);
		entrees.add(lambLollipops);
		entrees.add(friedPorkChops);
		
		sides = new CategoryPanel();
		
		soups = new CategoryPanel();
		
		desserts = new CategoryPanel();
		
		beverages = new CategoryPanel();
		
		aLaCarte = new CategoryPanel();
		
		toGo = new CategoryPanel();
		
		
		// Appetizer button
		appetizerButton = new MenuButton("APPETIZERS", Main.MENU_PANEL_BUTTON_COLOR, Main.MENU_PANEL_FONT_COLOR);
		add(appetizerButton);
		appetizerButton.setFont(Main.PROGRAM_FONT);
		appetizerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.optionsPanel.removeAll();
				Main.optionsPanel.revalidate();
				Main.optionsPanel.repaint();

				Main.optionsPanel.add(appetizers);
				Main.optionsPanel.revalidate();
				Main.optionsPanel.repaint();
			}
		});
		
		entreeButton = new MenuButton("ENTREES", Main.MENU_PANEL_BUTTON_COLOR, Main.MENU_PANEL_FONT_COLOR);
		add(entreeButton);
		entreeButton.setFont(Main.PROGRAM_FONT);
		entreeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.optionsPanel.removeAll();
				Main.optionsPanel.revalidate();
				Main.optionsPanel.repaint();

				Main.optionsPanel.add(entrees);
				Main.optionsPanel.revalidate();
				Main.optionsPanel.repaint();
			}
		});
		
		sidesButton = new MenuButton("SIDES", Main.MENU_PANEL_BUTTON_COLOR, Main.MENU_PANEL_FONT_COLOR);
		add(sidesButton);
		sidesButton.setFont(Main.PROGRAM_FONT);
		sidesButton.setBackground(Main.MENU_PANEL_BUTTON_COLOR);
		
		soupsButton = new MenuButton("SOUPS", Main.MENU_PANEL_BUTTON_COLOR, Main.MENU_PANEL_FONT_COLOR);
		add(soupsButton);
		soupsButton.setFont(Main.PROGRAM_FONT);
		soupsButton.setBackground(Main.MENU_PANEL_BUTTON_COLOR);
		
		dessertsButton = new MenuButton("DESSERTS", Main.MENU_PANEL_BUTTON_COLOR, Main.MENU_PANEL_FONT_COLOR);
		add(dessertsButton);
		dessertsButton.setFont(Main.PROGRAM_FONT);
		dessertsButton.setBackground(Main.MENU_PANEL_BUTTON_COLOR);
		
		beveragesButton = new MenuButton("BEVERAGES", Main.MENU_PANEL_BUTTON_COLOR, Main.MENU_PANEL_FONT_COLOR);
		add(beveragesButton);
		beveragesButton.setFont(Main.PROGRAM_FONT);
		beveragesButton.setBackground(Main.MENU_PANEL_BUTTON_COLOR);
		
		aLaCarteButton = new MenuButton("A LA CARTE", Main.MENU_PANEL_BUTTON_COLOR, Main.MENU_PANEL_FONT_COLOR);
		add(aLaCarteButton);
		aLaCarteButton.setFont(Main.PROGRAM_FONT);
		aLaCarteButton.setBackground(Main.MENU_PANEL_BUTTON_COLOR);
		
		toGoButton = new MenuButton("TO-GO", Main.MENU_PANEL_BUTTON_COLOR, Main.MENU_PANEL_FONT_COLOR);
		add(toGoButton);
		toGoButton.setFont(Main.PROGRAM_FONT);
		toGoButton.setBackground(Main.MENU_PANEL_BUTTON_COLOR);
	}
}
