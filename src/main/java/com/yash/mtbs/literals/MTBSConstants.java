package com.yash.mtbs.literals;

public interface MTBSConstants {

	// Menu file path
	String OPERATOR_MENU_FILE_PATH = "src/main/resources/menu/OperatorsMenu.txt";
	
	// Tickets pdf filepath
	String TICKET_PDF_FILE_PATH = "src/main/resources/tickets/";
	
	// JSON file paths
	String JSON_FILE_PATH = "src/main/resources/json_files/";
	
	// JSON file names
	String SCREEN_JSON_FILE_NAME = "screens.json";
	String MOVIE_JSON_FILE_NAME = "movies.json";
	String MOVIE_SCREEN_MAP_JSON_FILE_NAME = "movie_screen_map.json";
	String SHOW_JSON_FILE_NAME = "shows.json";
	String TICKET_JSON_FILE_NAME = "tickets.json";

	// Maximum no of options in Menu
	int MAX_NO_OF_OPERATOR_MENU_OPTIONS = 8;

	// Operator menu option constants
	int ADD_SCREEN = 1;
	int ADD_MOVIE_TO_SCREEN = 2;
	int DESIGN_SEATING_ARRANGEMENT_FOR_SCREEN = 3;
	int ADD_SHOWS_FOR_MOVIE = 4;
	int BOOK_TICKET = 5;
	int CANCEL_BOOKING = 6;
	int EXIT = 7;

	// Category constants
	String GOLD = "G";
	String SILVER = "S";
	String PREMIER = "P";
	
	//Time constants
	int TOTAL_HRS_IN_DAY_TO_BE_ALLOTED = 14;
	int TIME_INTERVAL_BTW_SHOWS = 30;
	String START_TIME = "10:00";

}
