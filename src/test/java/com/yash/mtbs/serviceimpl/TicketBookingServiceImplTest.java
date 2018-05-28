package com.yash.mtbs.serviceimpl;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.mtbs.dao.TicketDao;
import com.yash.mtbs.model.Customer;
import com.yash.mtbs.model.Seat;
import com.yash.mtbs.model.Show;
import com.yash.mtbs.service.TicketBookingService;

@RunWith(MockitoJUnitRunner.class)
public class TicketBookingServiceImplTest {
	
	@Mock
	private TicketDao ticketDao;

	private TicketBookingService ticketBookingService;

	@Before
	public void init() {
		ticketBookingService = new TicketBookingServiceImpl(ticketDao);
	}

	@Test
	public void bookTicket_ShouldReturnTicket_WhenCustomerShowCategoryAndSeatObjectIsGiven() {
		Customer customer = new Customer();
		Show show = new Show();
		Seat seat = new Seat();
		assertTrue(ticketBookingService.bookTicket(customer, show, seat, "G") != null);
	}
	
	@Test
	public void cancelTicket_ShouldReturnUpdatedTicketObject_WhenCustomerShowCategoryAndSeatObjectIsGiven() {
		Customer customer = new Customer();
		Show show = new Show();
		Seat seat = new Seat();
		assertTrue(ticketBookingService.bookTicket(customer, show, seat, "G") != null);
	}

}
