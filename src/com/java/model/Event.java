package com.java.model;

public class Event {
	
	private Long id = 0l;
	private String name;
	private String eventType;
	
	public Event(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEventType() {
		return eventType;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}	
}
