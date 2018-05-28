package com.yash.mtbs.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.yash.mtbs.dao.ScreenDao;
import com.yash.mtbs.exceptions.AlreadyExistException;
import com.yash.mtbs.model.Screen;
import com.yash.mtbs.model.SeatingArrangment;

public class ScreenDaoImplTest {

	private ScreenDao screenDao;

	private Screen screen;

	@Before
	public void init() {
		screenDao = new ScreenDaoImpl();
	}

	@Test
	public void getScreens_shouldReturnListOfScreensFromFile_WhenFileContainsScreenList() {
		assertEquals(1, screenDao.getScreens().size());
	}

	@Test
	public void getScreen_shouldReturnScreenObject_WhenFileHasScreenWithSameScreenName() {
		String screenName = "AUDI-1";
		assertTrue(screenDao.getScreen(screenName).getName().equalsIgnoreCase(screenName));
	}

	@Test
	public void getScreen_shouldReturnNull_WhenFileDoesNotContainScreenWithSameScreenName() {
		String screenName = "AUD";
		assertTrue(screenDao.getScreen(screenName) == null);
	}
	
	@Test(expected = AlreadyExistException.class)
	public void addScreen_shouldThrowException_WhenScreenObjectExistWithSameScreenName() {
		screen = new Screen(100, "AUDI-2", null);
		screenDao.addScreen(screen);
	}

	@Test
	public void addScreen_shouldAddNewScreenToListAndReturnOne_WhenScreenObjectIsGiven() {
		screen = new Screen(100, "AUDI-3", null);
		assertEquals(1, screenDao.addScreen(screen));
	}
	
	@Test
	public void updateScreen_shouldUpdateExistingScreenInListAndReturnOne_WhenScreenObjectIsGiven() {
		screen = new Screen(102, "AUDI-3", null);
		assertEquals(1, screenDao.updateScreen(screen));
	}
	
	@Test(expected = NullPointerException.class)
	public void updateScreen_shouldThrowNullException_WhenScreenObjectGivenDoesntExist() {
		screen = new Screen(102, "A", null);
		screenDao.updateScreen(screen);
	}

}
