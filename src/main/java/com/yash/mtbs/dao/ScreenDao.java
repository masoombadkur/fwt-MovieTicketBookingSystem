package com.yash.mtbs.dao;

import java.util.List;

import com.yash.mtbs.model.Screen;

public interface ScreenDao {

	int addScreen(Screen screen);

	List<Screen> getScreens();

	Screen getScreen(String screenName);

}
