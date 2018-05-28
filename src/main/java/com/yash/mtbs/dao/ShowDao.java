package com.yash.mtbs.dao;

import java.util.List;

import com.yash.mtbs.model.Show;

public interface ShowDao {

	int insertShow(Show show);
	
	Show getShow(String movieName, String screenName);
	
	List<Show> getShows();
	
	int updateShow(Show existingShow);

}
