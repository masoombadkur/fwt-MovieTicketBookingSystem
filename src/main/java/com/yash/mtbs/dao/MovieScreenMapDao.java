package com.yash.mtbs.dao;

import java.util.List;

import com.yash.mtbs.model.Movie;
import com.yash.mtbs.model.MovieScreenMap;

public interface MovieScreenMapDao {

	List<Movie> getMovies();

	List<MovieScreenMap> getMovieScreenMaps();

	int insertMovieScreenMap(MovieScreenMap movieScreenMap);

	int insertMovie(Movie movie);

	Movie getMovie(String movieName);
	
	MovieScreenMap getMovieSceenMap(String movieName, String screenName);

}
