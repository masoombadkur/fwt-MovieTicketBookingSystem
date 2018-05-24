package com.yash.mtbs.service;

import java.util.List;

import com.yash.mtbs.model.Screen;

public interface ScreenService {

	public int addScreen(Screen screen);

	public List<Screen> getAllScreens();
	
	Screen getScreen(String screenName);

}
