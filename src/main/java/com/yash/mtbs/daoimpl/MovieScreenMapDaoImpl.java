package com.yash.mtbs.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.yash.mtbs.dao.MovieScreenMapDao;
import com.yash.mtbs.exceptions.AlreadyExistException;
import com.yash.mtbs.literals.MTBSConstants;
import com.yash.mtbs.model.Movie;
import com.yash.mtbs.model.MovieScreenMap;
import com.yash.mtbs.util.JSONUtil;

public class MovieScreenMapDaoImpl implements MovieScreenMapDao {

	@Override
	public List<Movie> getMovies() {
		List<Movie> movies = new ArrayList<>();
		List<?> movieList = JSONUtil.readJSONFromFile(MTBSConstants.JSON_FILE_PATH, MTBSConstants.MOVIE_JSON_FILE_NAME);
		for (Object movie : movieList) {
			movies.add(JSONUtil.mapObjectToSpecificModelObject(Movie.class, movie));
		}
		return movies;
	}

	@Override
	public int insertMovie(Movie movie) {
		int rowsAffected = 0;
		List<Movie> movies = getMovies();
		if (getMovie(movie.getName()) != null) {
			throw new AlreadyExistException("Movie already exist");
		}
		if (movies == null) {
			movies = new ArrayList<>();
			movies.add(movie);
		} else {
			movies.add(movie);
		}
		JSONUtil.writeJSONToFile(movies, MTBSConstants.JSON_FILE_PATH, MTBSConstants.MOVIE_JSON_FILE_NAME);
		rowsAffected = 1;
		return rowsAffected;
	}

	@Override
	public Movie getMovie(String movieName) {
		Movie existingMovie = null;
		List<Movie> movies = getMovies();
		if (movies != null || movies.size() > 0) {
			for (Movie movie : movies) {
				if (movie.getName().equalsIgnoreCase(movieName)) {
					existingMovie = movie;
					break;
				}
			}
		}
		return existingMovie;
	}

	@Override
	public List<MovieScreenMap> getMovieScreenMaps() {
		List<MovieScreenMap> movieScreenMaps = new ArrayList<>();
		List<?> movieScreenMapList = JSONUtil.readJSONFromFile(MTBSConstants.JSON_FILE_PATH, MTBSConstants.MOVIE_SCREEN_MAP_JSON_FILE_NAME);
		for (Object movieScreenMap : movieScreenMapList) {
			movieScreenMaps.add(JSONUtil.mapObjectToSpecificModelObject(MovieScreenMap.class, movieScreenMap));
		}
		return movieScreenMaps;
	}

	@Override
	public int insertMovieScreenMap(MovieScreenMap movieScreenMap) {
		int rowsAffected = 0;
		List<MovieScreenMap> movieScreenMaps = getMovieScreenMaps();
		if (getMovieSceenMap(movieScreenMap.getMovie().getName(), movieScreenMap.getScreen().getName()) != null) {
			throw new AlreadyExistException("Movie already exist");
		}
		if (movieScreenMaps == null) {
			movieScreenMaps = new ArrayList<>();
			movieScreenMaps.add(movieScreenMap);
		} else {
			movieScreenMaps.add(movieScreenMap);
		}
		JSONUtil.writeJSONToFile(movieScreenMap, MTBSConstants.JSON_FILE_PATH, MTBSConstants.MOVIE_SCREEN_MAP_JSON_FILE_NAME);
		rowsAffected = 1;
		return rowsAffected;
	}

	@Override
	public MovieScreenMap getMovieSceenMap(String movieName, String screenName) {
		MovieScreenMap existingMovieScreenMap = null;
		List<MovieScreenMap> movieScreenMaps = getMovieScreenMaps();
		if (movieScreenMaps != null || movieScreenMaps.size() > 0) {
			for (MovieScreenMap movieScreenMap : movieScreenMaps) {
				if (movieScreenMap.getMovie().getName().equalsIgnoreCase(movieName)
						&& movieScreenMap.getScreen().getName().equalsIgnoreCase(screenName)) {
					existingMovieScreenMap = movieScreenMap;
					break;
				}
			}
		}
		return existingMovieScreenMap;
	}

}
