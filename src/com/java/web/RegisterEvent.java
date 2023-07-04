package com.java.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.EventDAO;
import com.java.model.Event;

@WebServlet(urlPatterns = "/registerEvent")
public class RegisterEvent extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Event event = new Event(request.getParameter("name"));
		new EventDAO().add(event);
		request.setAttribute("event", event);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/newCompany.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
		writer.println("Search result: <br />");
		
		String filter = request.getParameter("filter");
		Collection<Event> events = new EventDAO().searchingBySimilarity(filter);
		
		writer.println("<il>");
		
		events.forEach(event -> writer.println("<li>" + event.getId() + ": " + event.getName() + "</li>"));
		writer.println("</ul>");
		
		writer.println("</body></html>");
	}
}
