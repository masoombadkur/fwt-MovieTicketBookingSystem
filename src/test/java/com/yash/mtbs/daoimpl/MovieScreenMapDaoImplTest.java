package com.yash.mtbs.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.yash.mtbs.dao.MovieScreenMapDao;
import com.yash.mtbs.exceptions.AlreadyExistException;
import com.yash.mtbs.model.Movie;
import com.yash.mtbs.model.MovieScreenMap;

public class MovieScreenMapDaoImplTest {

	private MovieScreenMapDao movieScreenMapDao;

	@Before
	public void init() {
		movieScreenMapDao = new MovieScreenMapDaoImpl();
	}
	
	@Test
	public void getMovies_ShouldReturnListOfMoviesFromJSON() {
		assertEquals(1, movieScreenMapDao.getMovies().size());
	}
	
	@Test
	public void getMovie_shouldReturnMovieObject_WhenFileHasMovieWithSameMovieName() {
		String movieName = "AUDI-1";
		assertTrue(movieScreenMapDao.getMovie(movieName).getName().equalsIgnoreCase(movieName));
	}

	@Test
	public void getMovie_shouldReturnNull_WhenFileDoesNotContainMovieWithSameMovieName() {
		String movieName = "AUDI-1";
		assertTrue(movieScreenMapDao.getMovie(movieName) == null);
	}
	
	@Test(expected = AlreadyExistException.class)
	public void insertMovie_shouldThrowException_WhenMovieObjectExistWithSameName() {
		Movie movie = new Movie(101, "Veere Di wedding", Arrays.asList("Kareena kapoor", "Sonam kapoor"),
				"Dharma production", "02:30");
		movieScreenMapDao.insertMovie(movie);
	}

	@Test
	public void insertMovie_shouldAddNewMovieToListAndReturnOne_WhenMovieObjectIsGiven() {
		Movie movie = new Movie(101, "Veere Di wedding", Arrays.asList("Kareena kapoor", "Sonam kapoor"),
				"Dharma production", "02:30");
		assertEquals(1, movieScreenMapDao.insertMovie(movie));
	}
	
	@Test
	public void getMovieScreenMaps_ShouldReturnListOfMovieScreenMapsFromJSON() {
		assertEquals(1, movieScreenMapDao.getMovieScreenMaps().size());
	}
	
	@Test
	public void getMovieSceenMap_shouldReturnMovieScreenMapObject_WhenFileHasObjectWithSameMovieNameAndScreenName() {
		String movieName = "AUDI-1";
		String screenName = "";
		assertTrue(movieScreenMapDao.getMovieSceenMap(movieName, screenName).getMovie().getName().equals(movieName));
		assertTrue(movieScreenMapDao.getMovieSceenMap(movieName, screenName).getScreen().getName().equals(screenName));
	}

	@Test
	public void getMovieSceenMap_shouldReturnNull_WhenFileDoesNotContainObjectWithSameMovieNameAndScreenName() {
		String movieName = "AUDI-1";
		String screenName = "";
		assertTrue(movieScreenMapDao.getMovieSceenMap(movieName, screenName) == null);
	}
	
	@Test(expected = AlreadyExistException.class)
	public void insertMovieScreenMap_shouldThrowException_WhenObjectExistWithSameMovieNameAndScreenName() {
		Movie movie = new Movie(101, "Veere Di wedding", Arrays.asList("Kareena kapoor", "Sonam kapoor"),
				"Dharma production", "02:30");
		MovieScreenMap movieScreenMap = new MovieScreenMap();
		movieScreenMapDao.insertMovieScreenMap(movieScreenMap);
	}

	@Test
	public void insertMovieScreenMap_shouldAddNewMovieScreenMapToListAndReturnOne_WhenMovieScreenMapObjectIsGiven() {
		Movie movie = new Movie(101, "Veere Di wedding", Arrays.asList("Kareena kapoor", "Sonam kapoor"),
				"Dharma production", "02:30");
		MovieScreenMap movieScreenMap = new MovieScreenMap();
		movieScreenMapDao.insertMovieScreenMap(movieScreenMap);
	}

}
