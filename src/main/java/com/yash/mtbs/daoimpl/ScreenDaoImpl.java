package com.yash.mtbs.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.yash.mtbs.dao.ScreenDao;
import com.yash.mtbs.exceptions.AlreadyExistException;
import com.yash.mtbs.literals.MTBSConstants;
import com.yash.mtbs.model.Screen;
import com.yash.mtbs.util.JSONUtil;

public class ScreenDaoImpl implements ScreenDao {

	@Override
	public int addScreen(Screen screen) {
		if(getScreen(screen.getName()) != null){
			throw new AlreadyExistException("Screen already exist");
		}
		List<Screen> screens = getScreens();
		screens.add(screen);
		JSONUtil.writeJSONToFile(screens, MTBSConstants.JSON_FILE_PATH, MTBSConstants.SCREEN_JSON_FILE_NAME);
		return 1;
	}

	@Override
	public List<Screen> getScreens() {
		List<Screen> screens = new ArrayList<>();
		List screenList = JSONUtil.readJSONFromFile(MTBSConstants.JSON_FILE_PATH, MTBSConstants.SCREEN_JSON_FILE_NAME);
			for (Object screen : screenList) {
				screens.add(JSONUtil.mapObjectToSpecificModelObject(Screen.class, screen));
			}
		return screens;
	}

	@Override
	public Screen getScreen(String screenName) {
		Screen existingScreen = null;
		List<Screen> screens = getScreens();
		if(screens != null || screens.size() > 0){
			for (Screen screen : screens) {
				if (screen.getName().equalsIgnoreCase(screenName)) {
					existingScreen = screen;
					break;
				}
			}
		}
		return existingScreen;
	}

}
