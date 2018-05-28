package com.yash.mtbs.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.yash.mtbs.dao.ShowDao;
import com.yash.mtbs.exceptions.AlreadyExistException;
import com.yash.mtbs.model.Show;

public class ShowDaoImplTest {

	private ShowDao showDao;

	@Before
	public void init() {
		showDao = new ShowDaoImpl();
	}

	@Test
	public void getShows_shouldReturnListOfShowsFromFile_WhenFileContainsShowList() {
		assertEquals(1, showDao.getShows().size());
	}

	@Test
	public void getShow_shouldReturnShowObject_WhenFileHasShowWithSameName() {
		String movieName = "AUDI-1";
		String screenName = "";
		assertTrue(showDao.getShow(movieName, screenName).getMovieScreenMap().getScreen().getName()
				.equalsIgnoreCase(screenName));
		assertTrue(showDao.getShow(movieName, screenName).getMovieScreenMap().getMovie().getName()
				.equalsIgnoreCase(movieName));
	}

	@Test
	public void getShow_shouldReturnNull_WhenFileDoesNotContainShowWithSameName() {
		String movieName = "AUDI-1";
		String screenName = "";
		assertTrue(showDao.getShow(movieName, screenName) == null);
	}

	@Test(expected = AlreadyExistException.class)
	public void insertShow_shouldThrowException_WhenShowObjectExistWithSameName() {
		Show show = new Show();
		showDao.insertShow(show);
	}

	@Test
	public void insertShow_shouldAddNewShowToListAndReturnOne_WhenShowObjectIsGiven() {
		Show show = new Show(100, null, "10:00", "12:00");
		assertEquals(1, showDao.insertShow(show));
	}

	@Test
	public void updateShow_shouldUpdateExistingShowInListAndReturnOne_WhenShowObjectIsGiven() {
		Show show = new Show();
		assertEquals(1, showDao.updateShow(show));
	}

	@Test(expected = NullPointerException.class)
	public void updateShow_shouldThrowNullException_WhenShowObjectGivenDoesntExistInList() {
		Show show = new Show();
		showDao.updateShow(show);
	}

}
