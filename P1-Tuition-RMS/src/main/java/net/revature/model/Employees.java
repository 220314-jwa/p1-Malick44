package net.revature.model;

import java.util.Objects;

public class Employees {
	private int employeeId;
	private String firstName;
	private String lastName;
	private int managerId;
	private int departmentId;

	public Employees() {

		employeeId = 0;
		firstName = "Unassigned";
		lastName = "Unassigned";
		managerId = 0;
		departmentId = 0;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(departmentId, employeeId, firstName, lastName, managerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employees other = (Employees) obj;
		return Objects.equals(departmentId, other.departmentId) && employeeId == other.employeeId
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& managerId == other.managerId;
	}

	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", managerId=" + managerId + ", departmentId=" + departmentId + "]";
	}

}
