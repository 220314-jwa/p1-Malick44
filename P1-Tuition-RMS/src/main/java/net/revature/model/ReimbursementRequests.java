package net.revature.model;

import java.sql.Date;

public class ReimbursementRequests {
	private int requestId;
	private int employeeId;
	private int eventTypeId;
	private int statusId;
	private double cost;
	private Date eventDate;
	private String description;
	private String lacation;
	private Date submissionTime;

	public ReimbursementRequests() {
		requestId = 0;
		employeeId = 0;
		eventTypeId = 0;
		statusId = 0;
		cost = 0;
		eventDate = null;
		description = "";
		lacation = null;
		submissionTime = null;
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

	public int getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(int eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLacation() {
		return lacation;
	}

	public void setLacation(String lacation) {
		this.lacation = lacation;
	}

	public Date getSubmissionTime() {
		return submissionTime;
	}

	public void setSubmissionTime(Date submissionTime) {
		this.submissionTime = submissionTime;
	}

	@Override
	public String toString() {
		return "ReimbursementRequests [requestId=" + requestId + ", employeeId=" + employeeId + ", eventTypeId="
				+ eventTypeId + ", statusId=" + statusId + ", cost=" + cost + ", eventDate=" + eventDate
				+ ", description=" + description + ", lacation=" + lacation + ", submissionTime=" + submissionTime
				+ "]";
	}

}
