package com.jevalab.azure.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InitAddCommunity extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 349775964506655723L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		synchronized (session) {
			session.removeAttribute("formError");
			session.removeAttribute("formSuccess");
		}
		resp.sendRedirect(resp.encodeRedirectURL("/ca/admin/community/form/new"));
	}

}
