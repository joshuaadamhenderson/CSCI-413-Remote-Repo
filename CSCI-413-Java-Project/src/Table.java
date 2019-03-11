import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

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
	private String total;
	private MenuItem menuItems[];
	private TableButton tableButton;
	
	// Name the table objects something like "table101, table500"
	public Table(String tableID, int tableCapacity, String timeCreated, String dateCreated, String total) {
		this.tableID = tableID;
		this.tableCapacity = tableCapacity;
		this.timeCreated = timeCreated;
		this.dateCreated = dateCreated;
		this.total = total;
		tableButton = new TableButton(this);
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
	public MenuItem[] getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(MenuItem menuItems[]) {
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
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
}
