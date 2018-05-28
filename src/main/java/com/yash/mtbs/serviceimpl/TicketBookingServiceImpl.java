package com.yash.mtbs.serviceimpl;

import java.util.List;

import com.yash.mtbs.dao.TicketDao;
import com.yash.mtbs.model.Category;
import com.yash.mtbs.model.Customer;
import com.yash.mtbs.model.Movie;
import com.yash.mtbs.model.MovieScreenMap;
import com.yash.mtbs.model.Screen;
import com.yash.mtbs.model.Seat;
import com.yash.mtbs.model.SeatingArrangment;
import com.yash.mtbs.model.Show;
import com.yash.mtbs.model.Ticket;
import com.yash.mtbs.service.TicketBookingService;

public class TicketBookingServiceImpl implements TicketBookingService {

	private TicketDao ticketDao;

	public TicketBookingServiceImpl(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	@Override
	public Ticket bookTicket(Customer customer, Show show, Seat seatBooked, String categoryName) {

		Show updatedShow = updateSeatAvailabilityInShow(show, seatBooked, categoryName, false);

		Category category = getCategoryOfShowByName(show, categoryName);

		seatBooked.setAvailable(false);

		Ticket ticket = new Ticket();
		ticket.setTicketId(100);
		ticket.setCustomer(customer);
		ticket.setShow(updatedShow);
		ticket.setPrice(category.getPrice());
		ticket.setSeat(seatBooked);
		ticket.setCancelled(false);
		ticket.setCategoryName(category.getName());

		ticketDao.insertTicket(ticket);

		return ticket;
	}

	private Category getCategoryOfShowByName(Show show, String categoryName) {
		Category selectedCategory = null;
		List<Category> categories = show.getCategories();
		for (Category category : categories) {
			if (category.getName().equalsIgnoreCase(categoryName)) {
				selectedCategory = category;
			}
		}
		return selectedCategory;
	}

	private Show updateSeatAvailabilityInShow(Show show, Seat seatBooked, String categoryName, boolean isAvailable) {
		List<Category> categories = show.getCategories();
		List<Seat> seats = null;
		Category selectedCategory = getCategoryOfShowByName(show, categoryName);

		seats = selectedCategory.getSeats();

		for (Seat seat : seats) {
			if (seat.getRowNo() == seatBooked.getRowNo() && seat.getSeatNo() == seatBooked.getSeatNo()) {
				seat.setAvailable(isAvailable);
				break;
			}
		}
		selectedCategory.setSeats(seats);

		for (Category category : categories) {
			if (category.getName().equalsIgnoreCase(selectedCategory.getName())) {
				category = selectedCategory;
				break;
			}
		}
		show.setCategories(categories);

		show = updateSeatingArrangementForShow(show, categories);

		return show;
	}

	private Show updateSeatingArrangementForShow(Show show, List<Category> categories) {
		SeatingArrangment seatingArrangment = show.getMovieScreenMap().getScreen().getSeatingArrangment();
		seatingArrangment.setCategories(categories);

		Screen screen = show.getMovieScreenMap().getScreen();
		screen.setSeatingArrangment(seatingArrangment);

		MovieScreenMap movieScreenMap = show.getMovieScreenMap();
		movieScreenMap.setScreen(screen);

		show.setMovieScreenMap(movieScreenMap);

		return show;
	}

	public Ticket cancelBooking(Show show, Seat seatBooked, String categoryName) {
		Show updatedShow = updateSeatAvailabilityInShow(show, seatBooked, categoryName, true);

		seatBooked.setAvailable(true);

		Ticket ticket = ticketDao.getTicketBySeatAndCategory(seatBooked, categoryName);
		ticket.setShow(updatedShow);
		ticket.setPrice(0);
		ticket.setSeat(seatBooked);
		ticket.setCancelled(true);

		ticketDao.updateTicket(ticket);

		return ticket;
	}
}
