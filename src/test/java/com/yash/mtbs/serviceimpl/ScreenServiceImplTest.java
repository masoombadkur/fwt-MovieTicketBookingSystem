package com.yash.mtbs.serviceimpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.mtbs.dao.ScreenDao;
import com.yash.mtbs.exceptions.AlreadyExistException;
import com.yash.mtbs.exceptions.EmptyException;
import com.yash.mtbs.model.Screen;
import com.yash.mtbs.service.ScreenService;

@RunWith(MockitoJUnitRunner.class)
public class ScreenServiceImplTest {

	@Mock
	private ScreenDao screenDao;

	private ScreenService screenService;

	private Screen screen;

	@Before
	public void init() {
		screenService = new ScreenServiceImpl(screenDao);
	}

	@Test(expected = NullPointerException.class)
	public void addScreen_shouldThrowNullException_WhenScreenObjectIsNull() {
		screen = null;
		screenService.addScreen(screen);
	}

	@Test(expected = EmptyException.class)
	public void addScreen_shouldThrowEmptyException_WhenScreenObjectIsEmpty() {
		screen = new Screen();
		screenService.addScreen(screen);
	}

	@Test
	public void addScreen_shouldReturnOne_whenScreenObjectIsGiven() {
		screen = new Screen();
		screen.setScreenId(120);
		screen.setName("AUDI-1");
		screen.setSeatingArrangment(null);

		when(screenDao.addScreen(screen)).thenReturn(1);
		assertEquals(1, screenService.addScreen(screen));
	}

	@Test
	public void getAllScreens_shouldReturnScreensList() {
		List<Screen> screens = new ArrayList<Screen>();
		screens.add(new Screen(100, "AUDI-1", null));
		screens.add(new Screen(100, "AUDI-2", null));
		screens.add(new Screen(100, "AUDI-3", null));

		when(screenDao.getScreens()).thenReturn(screens);
		assertEquals(3, screenService.getAllScreens().size());
	}

	@Test(expected = NullPointerException.class)
	public void getAllScreens_shouldThrowNullException_WhenListReturnedIsNull() {
		List<Screen> screens = null;
		when(screenDao.getScreens()).thenReturn(screens);
		screenService.getAllScreens();
	}

	@Test(expected = EmptyException.class)
	public void getAllScreens_shouldThrowEmptyException_WhenListReturnedIsEmpty() {
		List<Screen> screens = new ArrayList<Screen>();
		when(screenDao.getScreens()).thenReturn(screens);
		screenService.getAllScreens();
	}

	@Test
	public void getScreen_shouldReturnScreenObject_WhenScreenNameIsGiven() {
		Screen screen = new Screen(100, "AUDI-1", null);
		when(screenDao.getScreen("AUDI-1")).thenReturn(screen);
		assertEquals(screen, screenService.getScreen("AUDI-1"));
	}

	@Test(expected = NullPointerException.class)
	public void getScreen_shouldThrowNullException_WhenScreenNameIsNull() {
		String screenName = null;
		screenService.getScreen(screenName);
	}

	@Test(expected = EmptyException.class)
	public void getScreen_shouldThrowEmptyException_WhenScreenNameIsEmpty() {
		String screenName = "";
		screenService.getScreen(screenName);
	}

	@Test
	public void addScreen_shouldReturnZero_WhenScreenListCountExceedsThree() {
		screen = new Screen(120, "Audi-1", null);
		when(screenDao.getScreens()).thenReturn(Arrays.asList(new Screen(), new Screen(), new Screen()));
		assertEquals(0, screenService.addScreen(screen));
	}

	@Test(expected = AlreadyExistException.class)
	public void addScreen_ShouldThrowException_WhenScreenExistWithTheSameName() {
		screen = new Screen(120, "Audi-1", null);
		when(screenDao.getScreen(screen.getName())).thenReturn(new Screen(120, "Audi-1", null));
		screenService.addScreen(screen);
	}

}
