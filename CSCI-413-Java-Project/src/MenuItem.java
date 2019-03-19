/*
 * PROJECT:			Software Engineering Group Project, Restaurant Point-Of-Sale System
 * GROUP:			Round Two
 * MEMBERS:			Dipesh Bhandari, Alex Gayle, Eric Greene, Joshua Henderson
 * COURSE:			CSCI 413, Software Engineering II
 * INSTRUCTOR:		Dr. Bei Xie
 * DATE CREATED:	2/12/2019
 * EDITED BY:		2/12/2019:	Joshua Henderson
 * */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

public class MenuItem implements Serializable {

	private String menuItemID;
	private String menuItemName;
	private double menuItemPrice;
	private JLabel menuItemNameLabel;
	private JLabel menuItemPriceLabel;
	private MenuItemLabelPanel menuItemLabelPanel;
		
	public MenuItem(String menuItemID, String menuItemName, double menuItemPrice) {
		this.menuItemID = menuItemID;
		this.menuItemName = menuItemName;
		this.menuItemPrice = menuItemPrice;
		setMenuItemNameLabel(new JLabel(menuItemName));
		setMenuItemPriceLabel(new JLabel(Double.toString(menuItemPrice)));
		menuItemNameLabel.setFont(Main.MENU_ITEM_NAME_LABEL_FONT);
		menuItemPriceLabel.setFont(Main.MENU_ITEM_PRICE_LABEL_FONT);
		menuItemLabelPanel = new MenuItemLabelPanel(menuItemNameLabel, menuItemPriceLabel);
	}
	public MenuItem(MenuItem menuItem) {
		this(menuItem.getMenuItemID(), menuItem.getMenuItemName(), menuItem.getMenuItemPrice());
	}
	
	public void setMenuItemID(String menuItemID) {
		this.menuItemID = menuItemID;
	}
	
	public String getMenuItemID() {
		return this.menuItemID;
	}
	
	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}
	
	public String getMenuItemName() {
		return this.menuItemName;
	}
	
	public void setMenuItemPrice(double menuItemPrice) {
		this.menuItemPrice = menuItemPrice;
	}
	
	public double getMenuItemPrice() {
		return this.menuItemPrice;
	}

	public JLabel getMenuItemNameLabel() {
		return menuItemNameLabel;
	}

	public void setMenuItemNameLabel(JLabel menuItemNameLabel) {
		this.menuItemNameLabel = menuItemNameLabel;
	}

	public JLabel getMenuItemPriceLabel() {
		return menuItemPriceLabel;
	}

	public void setMenuItemPriceLabel(JLabel menuItemPriceLabel) {
		this.menuItemPriceLabel = menuItemPriceLabel;
	}

	public MenuItemLabelPanel getMenuItemLabelPanel() {
		return menuItemLabelPanel;
	}

	public void setMenuItemLabelPanel(MenuItemLabelPanel menuItemLabelPanel) {
		this.menuItemLabelPanel = menuItemLabelPanel;
	}	
}
