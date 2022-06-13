package net.revature.model;

import java.util.Objects;

public class Department {
	private int departmentId;
	private String departmentName;
	private int departmentHeadId;

	public Department() {
		departmentHeadId = 0;
		departmentHeadId = 0;
		departmentName = null;

	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getDepartmentHeadId() {
		return departmentHeadId;
	}

	public void setDepartmentHeadId(int departmentHeadId) {
		this.departmentHeadId = departmentHeadId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(departmentHeadId, departmentId, departmentName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return departmentHeadId == other.departmentHeadId && departmentId == other.departmentId
				&& Objects.equals(departmentName, other.departmentName);
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", departmentHeadId="
				+ departmentHeadId + "]";
	}

}
