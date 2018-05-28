package com.yash.mtbs.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.yash.mtbs.dao.TicketDao;
import com.yash.mtbs.exceptions.AlreadyExistException;
import com.yash.mtbs.literals.MTBSConstants;
import com.yash.mtbs.model.Seat;
import com.yash.mtbs.model.Show;
import com.yash.mtbs.model.Ticket;
import com.yash.mtbs.util.JSONUtil;

public class TicketDaoImpl implements TicketDao {

	@Override
	public int insertTicket(Ticket ticket) {
		int rowsAffected = 0;
		if (getTicketBySeatAndCategory(ticket.getSeat(), ticket.getCategoryName()) != null) {
			throw new AlreadyExistException("Ticket already exist");
		}
		List<Ticket> tickets = getTickets();
		tickets.add(ticket);
		JSONUtil.writeJSONToFile(tickets, MTBSConstants.JSON_FILE_PATH, MTBSConstants.TICKET_JSON_FILE_NAME);
		rowsAffected = 1;
		return rowsAffected;
	}

	@Override
	public Ticket getTicketBySeatAndCategory(Seat seat, String categoryName) {
		Ticket existingTicket = null;
		List<Ticket> tickets = getTickets();
		if (tickets != null || tickets.size() > 0) {
			for (Ticket ticket : tickets) {
				if (ticket.getCategoryName().equalsIgnoreCase(categoryName)
						&& ticket.getSeat().getRowNo() == seat.getRowNo()
						&& ticket.getSeat().getSeatNo() == seat.getSeatNo()) {
					existingTicket = ticket;
					break;
				}
			}
		}
		return existingTicket;
	}

	@Override
	public int updateTicket(Ticket existingTicket) {
		int rowsAffected = 0;
		if (getTicketBySeatAndCategory(existingTicket.getSeat(), existingTicket.getCategoryName()) == null) {
			throw new AlreadyExistException("Ticket doesnt exist");
		}

		List<Ticket> tickets = getTickets();
		for (Ticket ticket : tickets) {
			if (ticket.getCategoryName().equalsIgnoreCase(existingTicket.getCategoryName())
					&& ticket.getSeat().getRowNo() == existingTicket.getSeat().getRowNo()
					&& ticket.getSeat().getSeatNo() == existingTicket.getSeat().getSeatNo()) {
				ticket.setCancelled(existingTicket.isCancelled());
				ticket.setPrice(existingTicket.getPrice());
				ticket.setShow(existingTicket.getShow());
				ticket.setSeat(existingTicket.getSeat());
				break;
			}
		}
		JSONUtil.writeJSONToFile(tickets, MTBSConstants.JSON_FILE_PATH, MTBSConstants.TICKET_JSON_FILE_NAME);
		rowsAffected = 1;
		return rowsAffected;
	}

	@Override
	public List<Ticket> getTickets() {
		List<Ticket> tickets = new ArrayList<>();
		List<?> ticketList = JSONUtil.readJSONFromFile(MTBSConstants.JSON_FILE_PATH,
				MTBSConstants.TICKET_JSON_FILE_NAME);
		for (Object ticket : ticketList) {
			tickets.add(JSONUtil.mapObjectToSpecificModelObject(Ticket.class, ticket));
		}
		return tickets;
	}

}
