package com.yash.mtbs.dao;

import java.util.List;

import com.yash.mtbs.model.Seat;
import com.yash.mtbs.model.Ticket;

public interface TicketDao {

	int insertTicket(Ticket ticket);

	Ticket getTicketBySeatAndCategory(Seat seat, String categoryName);

	int updateTicket(Ticket existingTicket);
	
	List<Ticket> getTickets();

}
