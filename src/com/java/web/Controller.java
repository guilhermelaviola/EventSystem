package com.java.web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/execute")
public class Controller extends HttpServlet {
	/*
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * 
	 * @param response servlet response
	 * 
	 * @throws ServletException if a servlet-specific error occurs
	 * 
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task = request.getParameter("task");
		if (task == null)
			throw new IllegalArgumentException("Enter the name of the task.");
			task = "web." + task;
	
		try {
			Class<?> type = Class.forName(task);
			Task instance = (Task) type.newInstance();
			String address = instance.execute(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | InstantiationException ex) {
			Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);

		}
	}
		
}
