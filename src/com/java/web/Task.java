package com.java.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Task {
	
	public String execute(HttpServletRequest request, HttpServletResponse response);
}
