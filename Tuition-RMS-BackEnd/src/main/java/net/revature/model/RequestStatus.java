package net.revature.model;

import java.util.Objects;

public class RequestStatus {
	private int employeeId;
	private int requestId;
	private int statusId;
	private String status;

	public RequestStatus() {
		requestId = 0;
		statusId = 0;
		status = "";
		employeeId=0;

	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		RequestStatus that = (RequestStatus) o;

		if (employeeId != that.employeeId) return false;
		if (requestId != that.requestId) return false;
		if (statusId != that.statusId) return false;
		return status != null ? status.equals(that.status) : that.status == null;
	}

	@Override
	public int hashCode() {
		int result = employeeId;
		result = 31 * result + requestId;
		result = 31 * result + statusId;
		result = 31 * result + (status != null ? status.hashCode() : 0);
		return result;
	}
}
