package com.jevalab.azure.notifications;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.jevalab.azure.persistence.AzureUser;
import com.jevalab.azure.persistence.GeneralController;
import com.jevalab.helper.classes.EntityConverter;
import com.jevalab.helper.classes.StringConstants;
import com.jevalab.helper.classes.Util;

public class AcceptFriendRequest extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5286224093793272492L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String webKey = req.getParameter("web-key");

		Object o = null;
		Object o1 = null;

		HttpSession session = req.getSession();
		synchronized (session) {
			o = session.getAttribute("notificationPage");
			o1 = session.getAttribute(StringConstants.AZURE_USER);
		}

		if (Util.notNull(webKey) && o != null && o1 != null) {
			NotificationPageBean npb = (NotificationPageBean) o;
			Iterator<NotificationBean> its = npb.getNotifications().iterator();
			while (its.hasNext()) {
				NotificationBean nb = its.next();
				if (nb.getNotificationKey().equals(webKey)) {
					its.remove();
					AzureUser u = (AzureUser) o1;
					List<Key> friends = u.getFriendsId();
					if(friends == null) {
						friends = new ArrayList<>();
					}
					friends.add(KeyFactory.stringToKey(nb.getSender().getWebKey()));
					u.setFriendsId(friends);
					GeneralController.create(EntityConverter.userToEntity(u));
					GeneralController.delete(KeyFactory.stringToKey(nb.getNotificationKey()));
					break;
				}
			}
			synchronized (session) {
				session.setAttribute("notificationPage", npb);
			}

			
		}
	}

}
