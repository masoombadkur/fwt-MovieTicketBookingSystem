package com.yash.mtbs.service;

import java.util.List;

import com.yash.mtbs.model.Movie;
import com.yash.mtbs.model.MovieScreenMap;

public interface MovieScreenMapService {

	List<Movie> getAllMovies();

	List<MovieScreenMap> getAllMovieScreenMappings();

	int addMovieScreenMap(MovieScreenMap movieScreenMap);

}
