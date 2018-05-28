package com.yash.mtbs.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.yash.mtbs.dao.ScreenDao;
import com.yash.mtbs.exceptions.EmptyException;
import com.yash.mtbs.model.Category;
import com.yash.mtbs.model.Screen;
import com.yash.mtbs.model.Seat;
import com.yash.mtbs.model.SeatingArrangment;
import com.yash.mtbs.service.SeatingArrangmentService;

public class SeatingArrangmentServiceImpl implements SeatingArrangmentService {

	private ScreenDao screenDao;

	public SeatingArrangmentServiceImpl(ScreenDao screenDao) {
		this.screenDao = screenDao;
	}

	private Category setSeatsForCategory(Category category) {

		List<Seat> seats = new ArrayList<>();
		int rowCount = category.getTotalRows();
		int seatCountOfFirstRow = category.getNoOfSeatsInFirstRow();

		int startIndex = 0;
		for (int rowNo = 1; rowNo <= rowCount; rowNo++) {
			for (int seatNo = 1; seatNo < rowNo; seatNo++) {
				continue;
			}
			startIndex = 0;
			for (int seatNo = rowNo; seatNo <= seatCountOfFirstRow; seatNo++) {
				startIndex++;
				Seat seat = new Seat();
				seat.setSeatId(startIndex);
				seat.setRowNo(rowNo);
				seat.setSeatNo(seatNo);
				seat.setAvailable(true);
				seats.add(seat);
			}
			seatCountOfFirstRow = seatCountOfFirstRow - 1;
		}
		category.setSeats(seats);
		return category;

	}

	public SeatingArrangment createSeatingArrangement(List<Category> categories) {

		List<Category> updatedCategories = new ArrayList<>();
		SeatingArrangment seatingArrangment = new SeatingArrangment();
		for (Category category : categories) {
			Category updatedCategory = setSeatsForCategory(category);
			updatedCategories.add(updatedCategory);
		}
		seatingArrangment.setSeatingArrangmentId(100);
		seatingArrangment.setCategories(updatedCategories);
		return seatingArrangment;

	}

	public void displaySeatingArrangement(SeatingArrangment seatingArrangment) {
		List<Category> categories = seatingArrangment.getCategories();
		for (Category category : categories) {
			int rowCount = category.getTotalRows();
			int seatCountOfFirstRow = category.getNoOfSeatsInFirstRow();

			List<Seat> seats = category.getSeats();

			for (int rowNo = 1; rowNo <= rowCount; rowNo++) {
				System.out.print(category.getName() + rowNo + "\t");
				for (int seatNo = 1; seatNo < rowNo; seatNo++) {
					System.out.print("\t");
				}
				for (int seatNo = rowNo; seatNo <= seatCountOfFirstRow; seatNo++) {
					Seat currentSeat = null;
					for (Seat seat : seats) {
						if (seat.getRowNo() == rowNo && seat.getSeatNo() == seatNo) {
							currentSeat = seat;
						}
					}
					System.out.print(category.getName() + "-" + currentSeat.getRowNo() + currentSeat.getSeatNo());
					if (currentSeat.isAvailable()) {
						System.out.print("[A]" + "\t");
					} else {
						System.out.print("[N]" + "\t");
					}
				}
				System.out.print("\n");
				seatCountOfFirstRow = seatCountOfFirstRow - 1;
			}
		}

	}

	public int addSeatingArrangmentToScreen(SeatingArrangment seatingArrangment, String screenName) {
		int rowsAffected = 0;
		if (seatingArrangment == null) {
			throw new NullPointerException("Seating arrangment object is null");
		}
		if (seatingArrangment.getSeatingArrangmentId() == 0) {
			throw new EmptyException("Seating arrangment object is empty");
		}
		Screen screen = screenDao.getScreen(screenName);
		screen.setSeatingArrangment(seatingArrangment);
		rowsAffected = screenDao.updateScreen(screen);
		return rowsAffected;
	}
}
