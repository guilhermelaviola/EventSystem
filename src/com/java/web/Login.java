package com.java.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dao.UserDAO;
import com.java.model.User;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new UserDAO().searchByEmailAndPassword(email, password);
		
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            if (user == null) {
            	out.println("<h1>User not registered!</h1>");
            } else {
            	HttpSession session = request.getSession();
            	session.setAttribute("userLogged", user);
            	out.println("User " + user.getEmail() + " logged in successfully!");
            }
            out.println("</body>");
            out.println("</html>");
		}		
	}
}
