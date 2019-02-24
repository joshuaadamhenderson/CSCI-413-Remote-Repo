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
		
	private String userID; // ID of the user
	private String userPosition; // Job title (manager, cook, etc)
	private String userName; // User's name
	private int userAge;  // User's age
	private double userNumber; // User's Phone Number
		
	public User(String userID, String userPosition, String userName, int userAge, double userNumber) {
		this.userID = userID;
		this.userPosition = userPosition; 
		this.userName = userName;
		this.userAge = userAge;
		this.userNumber = userNumber;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
		
	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPositon(String userPosition) {
		this.userPosition = userPosition;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
		
	public int getUserAge() {
		return userAge;
	}
	
	public void setUSerAge(int userAge) {
		this.userAge = userAge;
	}

	public double getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(double userNumber) {
		this.userNumber = userNumber;
	}
}

