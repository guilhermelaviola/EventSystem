package com.java.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.model.Event;

public class EventDAO {

	private final static Map<Long, Event> COMPANIES = new HashMap<>();

	static {
		generateIDAndAdd(new Event("Google"));
		generateIDAndAdd(new Event("Microsoft"));
		generateIDAndAdd(new Event("Apple"));
		generateIDAndAdd(new Event("Oracle"));
		generateIDAndAdd(new Event("Amazon"));
		generateIDAndAdd(new Event("Java"));
		generateIDAndAdd(new Event("Cisco"));
	}

	public Collection<Event> searchingBySimilarity(String name) {
		if (name == null) {
			return COMPANIES.values();
		}
		List<Event> similars = new ArrayList<>();
		for (Event company : COMPANIES.values()) {
			if (company.getName().toLowerCase().contains(name.toLowerCase()))
				similars.add(company);
		}
		return similars;
	}
	
	public void add(Event company) {
		generateIDAndAdd(company);
	}
	
	private static void generateIDAndAdd(Event company) {
		long id = COMPANIES.size()+1;
		company.setId(id);
		COMPANIES.put(id, company);
	}
}
