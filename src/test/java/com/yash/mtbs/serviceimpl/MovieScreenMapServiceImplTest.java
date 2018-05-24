package com.yash.mtbs.serviceimpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.mtbs.exceptions.EmptyException;
import com.yash.mtbs.model.Movie;
import com.yash.mtbs.model.MovieScreenMap;
import com.yash.mtbs.dao.MovieScreenMapDao;
import com.yash.mtbs.service.MovieScreenMapService;

@RunWith(MockitoJUnitRunner.class)
public class MovieScreenMapServiceImplTest {

	@Mock
	private MovieScreenMapDao movieScreenMapDao;

	private MovieScreenMapService movieScreenMapService;

	@Before
	public void init() {
		movieScreenMapService = new MovieScreenMapServiceImpl(movieScreenMapDao);
	}

	@Test
	public void getAllMovies_shouldReturnListOfMovies() {
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie(100, "Razzi"));
		when(movieScreenMapDao.getMovies()).thenReturn(movies);
		assertEquals(1, movieScreenMapService.getAllMovies().size());
	}

	@Test(expected = NullPointerException.class)
	public void getAllMovies_shouldThrowNullException_WhenMovieListIsNull() {
		List<Movie> movies = null;
		when(movieScreenMapDao.getMovies()).thenReturn(movies);
		movieScreenMapService.getAllMovies();
	}
	
	@Test(expected = EmptyException.class)
	public void getAllMovies_shouldThrowEmptyException_WhenMovieListIsEmpty() {
		List<Movie> movies = new ArrayList<Movie>();
		when(movieScreenMapDao.getMovies()).thenReturn(movies);
		movieScreenMapService.getAllMovies();
	}
	
	@Test
	public void getAllMovieScreenMappings_shouldReturnListOfMovieScreenMaps() {
		List<MovieScreenMap> movieScreenMaps = new ArrayList<MovieScreenMap>();
		movieScreenMaps.add(new MovieScreenMap(100, new Movie(100, "Razzi")));
		when(movieScreenMapDao.getMovieScreenMaps()).thenReturn(movieScreenMaps);
		assertEquals(1, movieScreenMapService.getAllMovieScreenMappings().size());
	}
	
	@Test(expected = NullPointerException.class)
	public void getAllMovieScreenMappings_shouldThrowNullException_WhenMovieScreenMapListIsNull() {
		List<MovieScreenMap> movieScreenMaps = null;
		when(movieScreenMapDao.getMovieScreenMaps()).thenReturn(movieScreenMaps);
		movieScreenMapService.getAllMovieScreenMappings();
	}
	
	@Test(expected = EmptyException.class)
	public void getAllMovieScreenMappings_shouldThrowNullException_WhenMovieScreenMapListIsEmpty() {
		List<MovieScreenMap> movieScreenMaps = new ArrayList<MovieScreenMap>();
		when(movieScreenMapDao.getMovieScreenMaps()).thenReturn(movieScreenMaps);
		movieScreenMapService.getAllMovieScreenMappings();
	}
	
	@Test
	public void addMovieScreenMap_ShouldReturnOne_WhenMovieScreenMapObjectIsGiven(){
		MovieScreenMap movieScreenMap = new MovieScreenMap(100, new Movie(100, "Razzi"));
		when(movieScreenMapDao.insertMovieScreenMap(movieScreenMap)).thenReturn(1);
		assertEquals(1, movieScreenMapService.addMovieScreenMap(movieScreenMap));
	}
	
	@Test(expected = NullPointerException.class)
	public void addMovieScreenMap_ShouldThrowNullException_WhenMovieScreenMapObjectIsNull(){
		MovieScreenMap movieScreenMap = null;
		movieScreenMapService.addMovieScreenMap(movieScreenMap);
	}
	
	@Test(expected = EmptyException.class)
	public void addMovieScreenMap_ShouldThrowEmptyException_WhenMovieScreenMapObjectIsEmpty(){
		MovieScreenMap movieScreenMap = new MovieScreenMap();
		movieScreenMapService.addMovieScreenMap(movieScreenMap);
	}

}
