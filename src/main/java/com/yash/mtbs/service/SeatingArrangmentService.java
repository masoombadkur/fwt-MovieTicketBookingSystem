package com.yash.mtbs.service;

import java.util.List;

import com.yash.mtbs.model.Category;
import com.yash.mtbs.model.SeatingArrangment;

public interface SeatingArrangmentService {
	
	SeatingArrangment createSeatingArrangement(List<Category> categories);
	
	void displaySeatingArrangement(SeatingArrangment seatingArrangment);
	
	int addSeatingArrangmentToScreen(SeatingArrangment seatingArrangment, String screenName);

}
