package com.yash.mtbs.service;

import java.util.List;

import com.yash.mtbs.model.MovieScreenMap;
import com.yash.mtbs.model.Show;

public interface ShowService {

	int addShow(Show show);
	
	List<Show> createShowsForMovieScreenMap(MovieScreenMap movieScreenMap);

}
