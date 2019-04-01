import java.util.ArrayList;
import java.util.List;

/*
 * PROJECT:			Software Engineering Group Project, Restaurant Point-Of-Sale System
 * GROUP:			Round Two
 * MEMBERS:			Dipesh Bhandari, Alex Gayle, Eric Greene, Joshua Henderson
 * COURSE:			CSCI 413, Software Engineering II
 * INSTRUCTOR:		Dr. Bei Xie
 * DATE CREATED:	2/20/2019
 * 
 */
public class User {
		
	private String userID;
	private String userFirstName;
	private String userLastName;
	private String userRank;
	private String userHireDate;
	private Double userPayRate;
	private List<Table> tables;
	private boolean clockedIn;
		
	public User(String userID, String userFirstName, String userLastName, String userRank, Double userPayRate, String userHireDate) {
		this.userID = userID;
		this.userFirstName = userFirstName; 
		this.userLastName = userLastName;
		this.userRank = userRank;
		this.userPayRate = userPayRate;
		this.userHireDate = userHireDate;
		this.tables = new ArrayList<Table>();
		this.clockedIn = false;
	}

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	
	public String getUserRank() {
		return userRank;
	}
	public void setUserRank(String userRank) {
		this.userRank = userRank;
	}
	
	public String getUserHireDate() {
		return userHireDate;
	}

	public void setUserHireDate(String userHireDate) {
		this.userHireDate = userHireDate;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void addToTables(Table table) {
		this.tables.add(table);
	}
	
	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	public boolean isClockedIn() {
		return clockedIn;
	}

	public void setClockedIn(boolean clockedIn) {
		this.clockedIn = clockedIn;
	}

	public Double getUserPayRate() {
		return userPayRate;
	}

	public void setUserPayRate(Double userPayRate) {
		this.userPayRate = userPayRate;
	}
}

