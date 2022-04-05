package net.revature.model;

import java.util.Objects;

public class RequestStatus {
	private int statusId;
	private String status = "";

	public RequestStatus() {

		statusId = 0;
		status = "";
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
	public int hashCode() {
		return Objects.hash(status, statusId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestStatus other = (RequestStatus) obj;
		return Objects.equals(status, other.status) && statusId == other.statusId;
	}

	@Override
	public String toString() {
		return "RequestStatus [statusId=" + statusId + ", status=" + status + "]";
	}

}
