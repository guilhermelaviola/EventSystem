package com.java.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.EventDAO;
import com.java.model.Event;

public class SearchEvent implements Task {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String filter = request.getParameter("filter");
		Collection<Event> events = new EventDAO().searchingBySimilarity(filter);

		request.setAttribute("events", events);
		return "/WEB-INF/pages/searchCompany.jsp";
	}
}
