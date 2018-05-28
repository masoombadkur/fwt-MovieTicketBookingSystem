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
		if (movieScreenMaps.isEmpty())  {
			throw new EmptyException("Movie Screen map list is empty");
		}
		return movieScreenMaps;
	}

	public int addMovieScreenMap(MovieScreenMap movieScreenMap) {
		int rowsAffected = 0;
		checkIfMovieScreenMapIsNullOrEmpty(movieScreenMap);
		checkIfMovieInMovieScreenMapIsNullOrEmpty(movieScreenMap);
		checkIfScreenInMovieScreenMapIsNullOrEmpty(movieScreenMap);
		if(movieScreenMap.getScreen().getSeatingArrangment() != null){
			rowsAffected = 0;
		}else {
			rowsAffected = movieScreenMapDao.insertMovieScreenMap(movieScreenMap);
		}
		return rowsAffected;
	}

	private void checkIfScreenInMovieScreenMapIsNullOrEmpty(MovieScreenMap movieScreenMap) {
		if(movieScreenMap.getScreen() == null) {
			throw new NullPointerException("Screen in movie screen map is null");
		}
		if(movieScreenMap.getScreen().getScreenId() == 0) {
			throw new EmptyException("Screen in movie screen map is empty");
		}
	}

	private void checkIfMovieInMovieScreenMapIsNullOrEmpty(MovieScreenMap movieScreenMap) {
		if(movieScreenMap.getMovie() == null) {
			throw new NullPointerException("Movie in movie screen map is null");
		}
		if(movieScreenMap.getMovie().getMovieId() == 0) {
			throw new EmptyException("Movie in movie screen map is empty");
		}
	}

	private void checkIfMovieScreenMapIsNullOrEmpty(MovieScreenMap movieScreenMap) {
		if(movieScreenMap == null) {
			throw new NullPointerException("Movie screen map is null");
		}
		if (movieScreenMap.getMovieScreenMapId() == 0) {
			throw new EmptyException("Movie screen map is empty");
		}
	}

}
