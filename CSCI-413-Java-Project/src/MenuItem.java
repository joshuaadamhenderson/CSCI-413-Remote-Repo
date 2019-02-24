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

public class MenuItem {

	private String menuItemID;
	private String menuItemName;
	private double menuItemPrice;
		
	public MenuItem(String menuItemID, String menuItemName, double menuItemPrice) {
		this.menuItemID = menuItemID;
		this.menuItemName = menuItemName;
		this.menuItemPrice = menuItemPrice;
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
}