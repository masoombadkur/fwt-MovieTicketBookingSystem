package com.yash.mtbs.daoimpl;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.yash.mtbs.dao.MovieScreenMapDao;
import com.yash.mtbs.model.Movie;

public class MovieScreenMapDaoImplTest {

	private MovieScreenMapDao movieScreenMapDao;

	@Before
	public void init() {
		movieScreenMapDao = new MovieScreenMapDaoImpl();
	}

	@Test
	public void insertMovie_ShouldReturnOne_WhenNewMovieIsAddedToJSONFile() {
		Movie movie = new Movie(101, "Veere Di wedding", Arrays.asList("Kareena kapoor", "Sonam kapoor"),
				"Dharma production", "02:30:10");
		assertEquals(1, movieScreenMapDao.insertMovie(movie));
	}
	
	@Test
	public void getMovies_ShouldReturnListOfMoviesFromJSON() {
		assertEquals(1, movieScreenMapDao.getMovies().size());
	}

}
