package com.jevalab.azure.notifications;

import com.google.appengine.api.datastore.KeyFactory;

public class MessageNotification extends NotificationBean {

	private static final long serialVersionUID = -6367829134895412276L;

	public MessageNotification(Notification firstNotification) {
		super(firstNotification);
		initDisplay();
	}

	@Override
	public void initDisplay() {
		if (notifications == null) {
			display = "";
		} else if (notifications.size() == 1) {
			display = "";
			messageId = KeyFactory.keyToString(notifications.get(0).getId());
			String[] arr = notifications.get(0).getMessage().getValue().trim()
					.split(" ");
			for (int i = 0; i < arr.length; i++) {
				display += arr[i] + " ";
				if (i == 10) {
					display = display.trim();
					display += "...";
					return;
				}
			}
			display = display.trim();
		} else {
			messageId = KeyFactory.keyToString(notifications.get(notifications.size()-1).getId());
			display = "sent you " + notifications.size() + " messages";
		}

	}

}
