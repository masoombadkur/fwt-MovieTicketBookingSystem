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
		List movieList = JSONUtil.readJSONFromFile(MTBSConstants.JSON_FILE_PATH, MTBSConstants.MOVIE_JSON_FILE_NAME);
			for (Object movie : movieList) {
				movies.add(JSONUtil.mapObjectToSpecificModelObject(Movie.class, movie));
			}
		return movies;
	}
	
	@Override
	public int insertMovie(Movie movie) {
		int rowsAffected = 0;
		List<Movie> movies = getMovies();
		if(getMovie(movie.getName()) != null){
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
	public List<MovieScreenMap> getMovieScreenMaps() {
		return null;
	}

	@Override
	public int insertMovieScreenMap(MovieScreenMap movieScreenMap) {
		return 0;
	}
	
	@Override
	public Movie getMovie(String movieName) {
		Movie existingMovie = null;
		List<Movie> movies = getMovies();
		if(movies != null || movies.size() > 0){
			for (Movie movie: movies) {
				if (movie.getName().equalsIgnoreCase(movieName)) {
					existingMovie = movie;
					break;
				}
			}
		}
		return existingMovie;
	}


}
