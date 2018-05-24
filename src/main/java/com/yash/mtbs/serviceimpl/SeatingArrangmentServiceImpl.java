package com.yash.mtbs.serviceimpl;

import com.yash.mtbs.dao.SeatingArrangmentDao;
import com.yash.mtbs.exceptions.EmptyException;
import com.yash.mtbs.model.Screen;
import com.yash.mtbs.model.SeatingArrangment;
import com.yash.mtbs.service.SeatingArrangmentService;

public class SeatingArrangmentServiceImpl implements SeatingArrangmentService {
	
	private SeatingArrangmentDao seatingArrangmentDao;

	public SeatingArrangmentServiceImpl(SeatingArrangmentDao seatingArrangmentDao) {
		this.seatingArrangmentDao = seatingArrangmentDao;
	}

	public int addSeatingArrangment(SeatingArrangment seatingArrangment) {
		int rowsAffected = 0;
		if(seatingArrangment == null){
			throw new NullPointerException("Seating arrangment object is null");
		}
		if(seatingArrangment.getSeatingArrangmentId() == 0){
			throw new EmptyException("Seating arrangment object is empty");
		}
		rowsAffected = seatingArrangmentDao.insertSeatingArrangment(seatingArrangment);
		return rowsAffected;
	}
}
