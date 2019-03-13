import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

/*
 * PROJECT:			Software Engineering Group Project, Restaurant Point-Of-Sale System
 * GROUP:			Round Two
 * MEMBERS:			Dipesh Bhandari, Alex Gayle, Eric Greene, Joshua Henderson
 * COURSE:			CSCI 413, Software Engineering II
 * INSTRUCTOR:		Dr. Bei Xie
 * DATE CREATED:	2/17/2019
 * EDITED BY:		2/17/2019:	Alex Gayle
 * */

public class Table {
	
	private String tableID;
	private int tableCapacity;
	private String timeCreated;
	private String dateCreated;
	private double subtotal;
	private double total;
	private List<MenuItem> menuItems;
	private TableButton tableButton;
	
	public Table(String tableID, int tableCapacity, String timeCreated, String dateCreated) {
		this.tableID = tableID;
		this.tableCapacity = tableCapacity;
		this.timeCreated = timeCreated;
		this.dateCreated = dateCreated;
		this.subtotal = 0;
		this.total = 0;
		tableButton = new TableButton(this);
		menuItems = new ArrayList<MenuItem>();
	}
	
	public void setTableID(String tableID) { 
		this.tableID = tableID;
	}	
	public String getTableID() {
		return this.tableID;
	}
	public void setTableCapacity(int tableCapacity) {
		this.tableCapacity = tableCapacity;
	}	
	public int getTableCapacity() {
		return this.tableCapacity;
	}
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	public String getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated(String timeCreated) {
		this.timeCreated = timeCreated;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public TableButton getTableButton() {
		return tableButton;
	}
	public double getTotal() {
		double sub = getSubtotal();
		return (sub * Main.CALCASIEU_TAX_RATE) + sub;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getSubtotal() {
		if (menuItems != null) {
			for (MenuItem menuItem: menuItems) {
				subtotal += menuItem.getMenuItemPrice();
			}
			return subtotal;
		}
		else
			return 0;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}
