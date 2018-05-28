package com.yash.mtbs.daoimpl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.yash.mtbs.dao.ShowDao;
import com.yash.mtbs.dao.TicketDao;
import com.yash.mtbs.exceptions.AlreadyExistException;
import com.yash.mtbs.model.Seat;
import com.yash.mtbs.model.Show;
import com.yash.mtbs.model.Ticket;

public class TicketDaoImplTest {

	private TicketDao ticketDao;

	@Before
	public void init() {
		ticketDao = new TicketDaoImpl();
	}

	@Test
	public void getTickets_shouldReturnListOfTicketsFromFile_WhenFileContainsTicketList() {
		assertEquals(1, ticketDao.getTickets().size());
	}

	@Test
	public void getTicketBySeatAndCategory_shouldReturnTicketObject_WhenFileHasTicketWithSameSeatAndCategory() {
		String categoryName = "AUDI-1";
		Seat seat = new Seat();
		assertTrue(ticketDao.getTicketBySeatAndCategory(seat, categoryName).getCategoryName().equalsIgnoreCase(categoryName));
	}

	@Test
	public void getTicketBySeatAndCategory_shouldReturnNull_WhenFileDoesNotContainTicketWithSameSeatAndCategory() {
		String categoryName = "AUDI-1";
		Seat seat = new Seat();
		assertTrue(ticketDao.getTicketBySeatAndCategory(seat, categoryName) == null);
	}

	@Test(expected = AlreadyExistException.class)
	public void insertTicket_shouldThrowException_WhenTicketObjectExistWithSameSeatAndCategory() {
		Ticket ticket = new Ticket();
		ticketDao.insertTicket(ticket);
	}

	@Test
	public void insertTicket_shouldAddNewTicketToListAndReturnOne_WhenTicketObjectIsGiven() {
		Ticket ticket = new Ticket();
		assertEquals(1, ticketDao.insertTicket(ticket));
	}

	@Test
	public void updateTicket_shouldUpdateExistingTicketInListAndReturnOne_WhenTicketObjectIsGiven() {
		Ticket ticket = new Ticket();
		assertEquals(1, ticketDao.updateTicket(ticket));
	}
	
	@Test(expected = NullPointerException.class)
	public void updateTicket_shouldThrowNullException_WhenTicketObjectGivenDoesntExistInList() {
		Ticket ticket = new Ticket();
		ticketDao.updateTicket(ticket);
	}

}
