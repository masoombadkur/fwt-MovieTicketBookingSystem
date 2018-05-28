package com.yash.mtbs.service;

import com.yash.mtbs.model.Customer;
import com.yash.mtbs.model.Seat;
import com.yash.mtbs.model.Show;
import com.yash.mtbs.model.Ticket;

public interface TicketBookingService {

	Ticket bookTicket(Customer customer, Show show, Seat seatBooked, String categoryName);
	
	Ticket cancelBooking(Show show, Seat seatBooked, String categoryName);

}
