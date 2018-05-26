package com.yash.mtbs.literals;

public interface MTBSConstants {

	// Menu file path
	String OPERATOR_MENU_FILE_PATH = "src/main/resources/menu/OperatorsMenu.txt";
	
	// JSON file paths
	String JSON_FILE_PATH = "src/main/resources/json_files/";
	
	// JSON file names
	String SCREEN_JSON_FILE_NAME = "screens.json";
	String MOVIE_JSON_FILE_NAME = "movies.json";
	String MOVIE_SCREEN_MAP_JSON_FILE_NAME = "movie_screen_map.json";

	// Maximum no of options in Menu
	int MAX_NO_OF_OPERATOR_MENU_OPTIONS = 8;

	// Operator menu option constants
	int ADD_SCREEN = 1;

	// Category constants
	String GOLD = "G";
	String SILVER = "S";
	String PREMIER = "P";
	
	//Time constants
	int TOTAL_HRS_IN_DAY_TO_BE_ALLOTED = 14;
	int TIME_INTERVAL_BTW_SHOWS = 30;

}
