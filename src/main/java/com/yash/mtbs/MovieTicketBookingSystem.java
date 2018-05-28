package com.yash.mtbs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import com.yash.mtbs.exceptions.EmptyException;
import com.yash.mtbs.literals.MTBSConstants;
import com.yash.mtbs.util.FileUtil;

public class MovieTicketBookingSystem {

	Scanner scanner = new Scanner(System.in);
	
	private static MovieTicketBookingSystem movieTicketBookingSystem;

	private MovieTicketBookingSystem() {

	}
	
	public static MovieTicketBookingSystem getMovieTicketBookingSystem() {
		movieTicketBookingSystem = new MovieTicketBookingSystem();
		return movieTicketBookingSystem;
	}

	public void start() {
		try {
			getMenu(MTBSConstants.OPERATOR_MENU_FILE_PATH);
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		}

		int selectedMenuOption = getUserSelectedMenuOption();

		getOperationToBePerformedBasedOnMenu(selectedMenuOption);

	}

	public List<String> getMenu(String filePath) throws FileNotFoundException {

		checkIfFilePathIsNull(filePath);

		checkIfFilePathIsEmpty(filePath);

		File operatorMenuFile = new File(filePath);

		checkIfFileExists(operatorMenuFile);

		checkIfFileIsEmpty(operatorMenuFile);

		List<String> menuOptions = FileUtil.readFile(filePath);

		return menuOptions;
	}

	private void checkIfFileIsEmpty(File operatorMenuFile) {
		if (operatorMenuFile.length() == 0) {
			throw new EmptyException("File cannot be empty");
		}
	}

	private void checkIfFileExists(File operatorMenuFile) throws FileNotFoundException {
		if (!operatorMenuFile.exists()) {
			throw new FileNotFoundException("File not found in provided location");
		}
	}

	private void checkIfFilePathIsEmpty(String filePath) {
		if (filePath.isEmpty()) {
			throw new EmptyException("File location cannot be empty");
		}
	}

	private void checkIfFilePathIsNull(String filePath) {
		if (filePath == null) {
			throw new NullPointerException("File location cannot be null");
		}
	}

	private int getUserSelectedMenuOption() {
		int selectedMenuOption = 0;
		System.out.println("Enter your choice: ");
		selectedMenuOption = scanner.nextInt();
		if (selectedMenuOption < 0 && selectedMenuOption > MTBSConstants.MAX_NO_OF_OPERATOR_MENU_OPTIONS) {
			System.out.println("selectedMenuOption: " + selectedMenuOption);
		}
		return selectedMenuOption;
	}

	private void getOperationToBePerformedBasedOnMenu(int selectedMenuOption) {
		switch (selectedMenuOption) {
		case MTBSConstants.ADD_SCREEN:
			addScreen();
			break;

		case MTBSConstants.ADD_MOVIE_TO_SCREEN:
			addMovieToScreen();
			break;

		case MTBSConstants.DESIGN_SEATING_ARRANGEMENT_FOR_SCREEN:
			designSeatingArragementForScreen();
			break;

		case MTBSConstants.ADD_SHOWS_FOR_MOVIE:
			addShowsForMovie();
			break;

		case MTBSConstants.BOOK_TICKET:
			bookTicket();
			break;

		case MTBSConstants.CANCEL_BOOKING:
			cancelBooking();
			break;

		case MTBSConstants.EXIT:
			System.exit(0);
			break;

		default:
			break;
		}
	}

	private void addScreen() {

	}

	private void addMovieToScreen() {

	}

	private void designSeatingArragementForScreen() {

	}

	private void addShowsForMovie() {

	}

	private void bookTicket() {

	}

	private void cancelBooking() {

	}
}
