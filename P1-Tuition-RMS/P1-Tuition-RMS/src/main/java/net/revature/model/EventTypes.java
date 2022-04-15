package net.revature.model;

import java.util.Objects;

public class EventTypes {
	private int eventTypeId;
	private String eventTypeName;

	public EventTypes() {
		this.eventTypeId = 0;
		this.eventTypeName = "Undifined";
	}

	public int getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(int eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public String getEventTypeName() {
		return eventTypeName;
	}

	public void setEventTypeName(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(eventTypeId, eventTypeName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventTypes other = (EventTypes) obj;
		return eventTypeId == other.eventTypeId && Objects.equals(eventTypeName, other.eventTypeName);

	}

	@Override
	public String toString() {
		return "EventTypes [Id=" + eventTypeId + ", eventTypeName=" + eventTypeName + "]";
	}

}
