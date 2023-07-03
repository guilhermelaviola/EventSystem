package com.java.dao;

import java.util.HashMap;
import java.util.Map;

import com.java.model.User;

public class UserDAO {
	
	private final static Map<String, User> USERS = new HashMap<>();
	
	static {
		USERS.put("andrew.johnson@company.com", new User("andrew.johnson@company.com", "pass123"));
		USERS.put("marcus.malacia@company.com", new User("marcus.malacia@company.com", "marcUsMal0998"));		
	}
	
	public User searchByEmailAndPassword(String email, String password) {
		if (!USERS.containsKey(email)) {
			return null;
		}
		User user = USERS.get(email);
		if (user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
}
