package com.yash.mtbs;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import com.yash.mtbs.exceptions.EmptyException;

public class MovieTicketBookingSystemTest {
	
	private MovieTicketBookingSystem movieTicketBookingSystem;
	
	@Before
	public void initMovieTicketBookingSystem() {
		movieTicketBookingSystem = new MovieTicketBookingSystem();
	}

	@Test(expected = NullPointerException.class)
	public void getMenu_shouldThrowNullException_whenFilePathIsNull() throws FileNotFoundException {
		movieTicketBookingSystem.getMenu(null);
	}
	
	@Test(expected = EmptyException.class)
	public void getMenu_shouldThrowEmptyException_whenFilePathIsEmpty() throws FileNotFoundException {
		movieTicketBookingSystem.getMenu("");
	}
	
	@Test(expected = FileNotFoundException.class)
	public void getMenu_shouldThrowNotFoundException_whenFileDoesnotExistInGivenPath() throws FileNotFoundException {
		movieTicketBookingSystem.getMenu("src/test/resources/menu/Operators_Menu_not_exist.txt");
	}
	
	@Test(expected = EmptyException.class)
	public void getMenu_shouldThrowEmptyException_whenFileIsEmpty() throws FileNotFoundException {
		movieTicketBookingSystem.getMenu("src/test/resources/menu/Operators_Menu_empty.txt");
	}
	
	@Test(expected = FileNotFoundException.class)
	public void getMenu_shouldThrowEmptyException_whenFilePathIsIncorrect() throws FileNotFoundException {
		movieTicketBookingSystem.getMenu("src/resources/OperatorsMenu.txt");
	}
	
	@Test
	public void getMenu_shouldReturnNoOfLinesInFileAsList_whenFilePathIsGiven() throws FileNotFoundException {
		assertEquals(11, movieTicketBookingSystem.getMenu("src/test/resources/menu/OperatorsMenu.txt").size());
	}
	
}
