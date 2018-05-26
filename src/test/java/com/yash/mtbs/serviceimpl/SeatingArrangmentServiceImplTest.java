package com.yash.mtbs.serviceimpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.mtbs.dao.ScreenDao;
import com.yash.mtbs.daoimpl.ScreenDaoImpl;
import com.yash.mtbs.exceptions.EmptyException;
import com.yash.mtbs.model.Category;
import com.yash.mtbs.model.SeatingArrangment;
import com.yash.mtbs.service.SeatingArrangmentService;

@RunWith(MockitoJUnitRunner.class)
public class SeatingArrangmentServiceImplTest {
	
	
	private ScreenDao screenDao = new ScreenDaoImpl();

	private SeatingArrangmentService seatingArrangmentService;

	@Before
	public void init() {
		seatingArrangmentService = new SeatingArrangmentServiceImpl(screenDao);
	}

//	@Test
//	public void createSeatingArrangement_ShouldReturnSeatingArrangementObject_WhenRowCountAndSeatCountOfFirstRowIsGiven() {
//		assertTrue(seatingArrangmentService.createSeatingArrangement() != null);
//	}
	
	@Test
	public void test() {
		SeatingArrangment seatingArrangment = seatingArrangmentService.createSeatingArrangement(Arrays.asList(new Category(101, "G", null, 3, 10), new Category(102, "S", null, 4, 10), new Category(103, "P", null, 5, 10)));
		seatingArrangmentService.displaySeatingArrangement(seatingArrangment);
	}

}
