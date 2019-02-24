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
	
	private int tableID;
	private int tableCapacity;
	private int tableSeat;
	
	public static final int NUMBER_OF_TABLES = 20;
	
	public Table(int tableID, int tableCapacity, int tableSeat) {
		this.tableID = tableID;
		this.tableCapacity = tableCapacity;
		this.tableSeat = tableSeat;
	}
	
	////////////////////////////////////////////////
	public void setTableID(int tableID) { 
		this.tableID = tableID;
	}
	
	public int getTableID() {
		return this.tableID;
	}
	/////////////////////////////////////////////////
	
	public void setTableCapacity(int tableCapacity) {
		this.tableCapacity = tableCapacity;
	}
	
	public int getTableCapacity() {
		return this.tableCapacity;
	}
	/////////////////////////////////////////////////
	public void setTableSeat(int tableSeat) {
		this.tableSeat = tableSeat;
	}
	
	public int getTableSeat() {
		return this.tableSeat;
	}
	/////////////////////////////////////////////////
}
