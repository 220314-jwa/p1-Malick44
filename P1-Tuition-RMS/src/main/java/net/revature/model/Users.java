package net.revature.model;

import java.util.Objects;

public class Users {

	private int employeeId;
	private String firstName;
	private String lastName;
	private String userName;
	private String passWord;
	private boolean isLoggedIn = false;

	public Users() {
		employeeId = 0;
		firstName = "";
		lastName = "";
		userName = "";
		passWord = "";
		isLoggedIn = false;
	}

//	public static Users getUser(Employees person, String userName, String passWord) {
//
//		List<Users> users = new ArrayList<>();
//
//		Users newuser = new Users();
//		if (userName != null) {
//			newuser.setEmployeeId(person.getEmployeeId());
//			newuser.setFirstName(person.getFirstName());
//			newuser.setLastName(person.getLastName());
//			newuser.setUserName(userName);
//			newuser.setPassWord(passWord);
//			newuser.setLoggedIn(false);
//
//			users.add(newuser);
//
//			return newuser;
//
//		} else
//
//			return null;
//	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int id) {
		this.employeeId = id;
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
		return Objects.hash(firstName, isLoggedIn, lastName, passWord, userName, employeeId);
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
				&& Objects.equals(userName, other.userName) && employeeId == other.employeeId;
	}

	@Override
	public String toString() {
		return "Users [userid=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + "]";
	}

}
