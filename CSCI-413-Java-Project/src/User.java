/*
 * PROJECT:			Software Engineering Group Project, Restaurant Point-Of-Sale System
 * GROUP:			Round Two
 * MEMBERS:			Dipesh Bhandari, Alex Gayle, Eric Greene, Joshua Henderson
 * COURSE:			CSCI 413, Software Engineering II
 * INSTRUCTOR:		Dr. Bei Xie
 * DATE CREATED:	2/20/2019
 * EDITED BY:		2/20/2019:	Eric Greene
 * */

// Eric - "This is just a rough draft of the User class.
	// Debating changing the class name to Employee"

public class User {
		
	private String userID;
	private String userFirstName;
	private String userLastName;
	private String userRank;
	private String userHireDate;
		
	public User(String userID, String userFirstName, String userLastName, String userRank, String userHireDate) {
		this.userID = userID;
		this.userFirstName = userFirstName; 
		this.userLastName = userLastName;
		this.userRank = userRank;
		this.userHireDate = userHireDate;
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
}

