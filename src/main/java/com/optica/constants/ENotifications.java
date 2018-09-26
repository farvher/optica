package com.optica.constants;

public enum ENotifications {

	INFO("INFO"), SUCCESS("SUCCESS"), WARNING("WARNING"), DANGER("DANGER");

	private String notification;

	private ENotifications(String notification) {
		this.notification = notification;
	}

	public String getNotification() {
		return notification;
	}

	
	
}
