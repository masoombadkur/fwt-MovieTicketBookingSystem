package com.yash.mtbs.serviceimpl;

import java.util.List;

import com.yash.mtbs.exceptions.EmptyException;
import com.yash.mtbs.model.Movie;
import com.yash.mtbs.model.MovieScreenMap;
import com.yash.mtbs.dao.MovieScreenMapDao;
import com.yash.mtbs.service.MovieScreenMapService;

public class MovieScreenMapServiceImpl implements MovieScreenMapService {

	private MovieScreenMapDao movieScreenMapDao;

	public MovieScreenMapServiceImpl(MovieScreenMapDao movieScreenMapDao) {
		this.movieScreenMapDao = movieScreenMapDao;
	}

	public List<Movie> getAllMovies() {
		List<Movie> movies = movieScreenMapDao.getMovies();
		if (movies == null) {
			throw new NullPointerException("Movies list is null");
		}
		if (movies.isEmpty()) {
			throw new EmptyException("Movies list is empty");
		}
		return movies;
	}

	public List<MovieScreenMap> getAllMovieScreenMappings() {
		List<MovieScreenMap> movieScreenMaps = movieScreenMapDao.getMovieScreenMaps();
		if (movieScreenMaps == null) {
			throw new NullPointerException("Movie Screen map list is null");
		}
		if (movieScreenMaps.isEmpty()) {
			throw new EmptyException("Movie Screen map list is empty");
		}
		return movieScreenMaps;
	}

	public int addMovieScreenMap(MovieScreenMap movieScreenMap) {
		int rowsAffected = 0;
		if(movieScreenMap == null) {
			throw new NullPointerException("Movie screen map is null");
		}
		if (movieScreenMap.getMovieScreenMapId() == 0) {
			throw new EmptyException("Movie screen map is empty");
		}
		rowsAffected = movieScreenMapDao.insertMovieScreenMap(movieScreenMap);
		return rowsAffected;
	}

}
