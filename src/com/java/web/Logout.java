package com.java.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("loggedUser");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/logout.html");
		dispatcher.forward(request, response);
	}
}
