package com.yash.mtbs.serviceimpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.mtbs.dao.SeatingArrangmentDao;
import com.yash.mtbs.exceptions.EmptyException;
import com.yash.mtbs.model.Category;
import com.yash.mtbs.model.SeatingArrangment;
import com.yash.mtbs.service.SeatingArrangmentService;

@RunWith(MockitoJUnitRunner.class)
public class SeatingArrangmentServiceImplTest {

	@Mock
	private SeatingArrangmentDao seatingArrangmentDao;

	private SeatingArrangmentService seatingArrangmentService;

	@Before
	public void init() {
		seatingArrangmentService = new SeatingArrangmentServiceImpl(seatingArrangmentDao);
	}

	@Test
	public void addSeatingArrangment_ShouldReturnOne_WhenSeatArrangmentObjectIsGiven() {
		SeatingArrangment seatingArrangment = new SeatingArrangment(100, Arrays.asList(new Category(200, "Gold")));
		when(seatingArrangmentDao.insertSeatingArrangment(seatingArrangment)).thenReturn(1);
		assertEquals(1, seatingArrangmentService.addSeatingArrangment(seatingArrangment));
	}
	
	@Test(expected = NullPointerException.class)
	public void addSeatingArrangment_ShouldThrowNullException_WhenSeatingArrangmentObjectIsNull(){
		SeatingArrangment seatingArrangment = null;
		seatingArrangmentService.addSeatingArrangment(seatingArrangment);
	}
	
	@Test(expected = EmptyException.class)
	public void addSeatingArrangment_ShouldThrowEmptyException_WhenSeatingArrangmentObjectIsEmpty(){
		SeatingArrangment seatingArrangment = new SeatingArrangment();
		seatingArrangmentService.addSeatingArrangment(seatingArrangment);
	}

}
