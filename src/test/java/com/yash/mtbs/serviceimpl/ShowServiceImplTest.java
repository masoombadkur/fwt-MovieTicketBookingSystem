package com.yash.mtbs.serviceimpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.mtbs.dao.ShowDao;
import com.yash.mtbs.exceptions.EmptyException;
import com.yash.mtbs.model.MovieScreenMap;
import com.yash.mtbs.model.Show;
import com.yash.mtbs.service.ShowService;

@RunWith(MockitoJUnitRunner.class)
public class ShowServiceImplTest {

	@Mock
	private ShowDao showDao;

	private ShowService showService;

	@Before
	public void init() {
		showService = new ShowServiceImpl(showDao);
	}

	@Test
	public void addShow_ShouldReturnOne_WhenNewShowObjectIsGiven() {
		Show show = new Show(1, new MovieScreenMap(), "10", "2");
		when(showDao.insertShow(show)).thenReturn(1);
		assertEquals(1, showService.addShow(show));
	}

	@Test(expected = NullPointerException.class)
	public void addShow_ShouldThrowNullException_WhenShowObjectGivenIsNull() {
		Show show = null;
		showService.addShow(show);
	}

	@Test(expected = EmptyException.class)
	public void addShow_ShouldThrowEmptyException_WhenShowObjectGivenIsEmpty() {
		Show show = new Show();
		showService.addShow(show);
	}

	@Test(expected = NullPointerException.class)
	public void addShow_ShouldThrowNullException_WhenMovieScreenMapInShowObjectIsEmpty() {
		Show show = new Show(1, null, "10", "2");
		showService.addShow(show);
	}

}
