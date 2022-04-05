package net.revature.model;

import java.util.Objects;

public class Users {

	private int userid;
	private String firstName;
	private String lastName;
	private String userName;
	private String passWord;
	private boolean isLoggedIn = false;

	public Users() {
		userid = 0;
		firstName = "";
		lastName = "";
		userName = "";
		passWord = "";
		isLoggedIn = false;
	}

	private static Users userInstance = new Users();

	public static Users getUser(String userName) {
		if (userName == userInstance.getUserName()) {
			return userInstance;
		} else
			return null;
	}

	public Users(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}

	public int getId() {
		return userid;
	}

	public void setId(int id) {
		this.userid = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, isLoggedIn, lastName, passWord, userName, userid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(firstName, other.firstName) && isLoggedIn == other.isLoggedIn
				&& Objects.equals(lastName, other.lastName) && Objects.equals(passWord, other.passWord)
				&& Objects.equals(userName, other.userName) && userid == other.userid;
	}

	@Override
	public String toString() {
		return "Users [userid=" + userid + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + "]";
	}

}
