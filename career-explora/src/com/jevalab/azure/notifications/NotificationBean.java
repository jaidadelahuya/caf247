package com.jevalab.azure.notifications;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.google.appengine.api.datastore.KeyFactory;
import com.jevalab.azure.people.Person;
import com.jevalab.helper.classes.Util;

public abstract class NotificationBean implements Serializable, Comparable<NotificationBean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5450840151948136304L;
	
	protected String type,display,id, notificationKey, messageId;
	protected Date date;
	protected Person sender;
	protected List<Notification> notifications;
	
	public abstract void initDisplay();

	@Override
	public String toString() {
		return "NotificationBean [type=" + type + ", display=" + display
				+ ", id=" + id + ", date=" + date + ", sender=" + sender
				+ ", notifications=" + notifications + "]";
	}
	
	

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getNotificationKey() {
		return notificationKey;
	}

	public void setNotificationKey(String notificationKey) {
		this.notificationKey = notificationKey;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Person getSender() {
		return sender;
	}

	public void setSender(Person sender) {
		this.sender = sender;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotificationBean other = (NotificationBean) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(NotificationBean o) {
		return date.compareTo(o.getDate());
	}

	public NotificationBean(Notification firstNotification) {
		this.id = KeyFactory.keyToString(firstNotification.getSender());
		this.type = firstNotification.getType();
		this.date = firstNotification.getDate();
		this.sender = Util.getPersonFromIndex(firstNotification.getSender(),null);
		this.notifications = new ArrayList<>();
		this.notifications.add(firstNotification);
		this.notificationKey = KeyFactory.keyToString(firstNotification.getId());
		
				
	}
	
	public void addNotification(Notification n) {
		notifications.add(n);
		Collections.sort(notifications, new Comparator<Notification>() {

			@Override
			public int compare(Notification o1, Notification o2) {
				return o2.getDate().compareTo(o1.getDate());
			}
		});
		date = notifications.get(0).getDate();
		initDisplay();
	}

}
