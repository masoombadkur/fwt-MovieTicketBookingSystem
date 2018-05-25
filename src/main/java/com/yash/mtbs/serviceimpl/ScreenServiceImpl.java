package com.yash.mtbs.serviceimpl;

import java.util.List;

import com.yash.mtbs.dao.ScreenDao;
import com.yash.mtbs.exceptions.AlreadyExistException;
import com.yash.mtbs.exceptions.EmptyException;
import com.yash.mtbs.model.Screen;
import com.yash.mtbs.service.ScreenService;

public class ScreenServiceImpl implements ScreenService {

	private ScreenDao screenDao;

	public ScreenServiceImpl(ScreenDao screenDao) {
		this.screenDao = screenDao;
	}

	public int addScreen(Screen screen) {

		int rowsAffected = 0;
		if (screen == null) {
			throw new NullPointerException("Screen cannot be null");
		}
		if (screen.getScreenId() == 0) {
			throw new EmptyException("Screen cannot be empty");
		}
		
		if(screenDao.getScreen(screen.getName()) != null) {
			throw new AlreadyExistException("Screen already exist");
		}
		if (screenDao.getScreens().size() == 3) {
			rowsAffected = 0;
		} else {
			rowsAffected = screenDao.addScreen(screen);
		}
		return rowsAffected;
	}

	public List<Screen> getAllScreens() {
		List<Screen> screens = screenDao.getScreens();
		if (screens == null) {
			throw new NullPointerException("Screen list is null");
		}

		if (screens.isEmpty()) {
			throw new EmptyException("Screen list is empty");
		}
		return screens;
	}

	public Screen getScreen(String screenName) {
		if (screenName == null) {
			throw new NullPointerException("Screen name is null");
		}
		if (screenName.isEmpty()) {
			throw new EmptyException("Screen name is empty");
		}
		Screen screen = screenDao.getScreen(screenName);

		if (screen == null) {
			throw new NullPointerException("Screen is null");
		}
		return screen;
	}

}
