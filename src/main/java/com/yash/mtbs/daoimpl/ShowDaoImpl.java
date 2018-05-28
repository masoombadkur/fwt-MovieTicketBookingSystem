package com.yash.mtbs.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.yash.mtbs.dao.ShowDao;
import com.yash.mtbs.exceptions.AlreadyExistException;
import com.yash.mtbs.literals.MTBSConstants;
import com.yash.mtbs.model.Screen;
import com.yash.mtbs.model.Show;
import com.yash.mtbs.util.JSONUtil;

public class ShowDaoImpl implements ShowDao {

	@Override
	public int insertShow(Show show) {
		int rowsAffected = 0;
		if (getShow(show.getMovieScreenMap().getMovie().getName(),
				show.getMovieScreenMap().getScreen().getName()) != null) {
			throw new AlreadyExistException("Show already exist");
		}
		List<Show> shows = getShows();
		shows.add(show);
		JSONUtil.writeJSONToFile(shows, MTBSConstants.JSON_FILE_PATH, MTBSConstants.SHOW_JSON_FILE_NAME);
		rowsAffected = 1;
		return rowsAffected;
	}

	@Override
	public Show getShow(String movieName, String screenName) {
		Show existingShow = null;
		List<Show> shows = getShows();
		if (shows != null || shows.size() > 0) {
			for (Show show : shows) {
				if (show.getMovieScreenMap().getMovie().getName().equalsIgnoreCase(movieName)
						&& show.getMovieScreenMap().getScreen().getName().equalsIgnoreCase(screenName)) {
					existingShow = show;
					break;
				}
			}
		}
		return existingShow;
	}

	@Override
	public List<Show> getShows() {
		List<Show> shows = new ArrayList<>();
		List<?> showList = JSONUtil.readJSONFromFile(MTBSConstants.JSON_FILE_PATH, MTBSConstants.SHOW_JSON_FILE_NAME);
		for (Object show : showList) {
			shows.add(JSONUtil.mapObjectToSpecificModelObject(Show.class, show));
		}
		return shows;
	}

	@Override
	public int updateShow(Show existingShow) {
		int rowsAffected = 0;
		if (getShow(existingShow.getMovieScreenMap().getMovie().getName(),
				existingShow.getMovieScreenMap().getScreen().getName()) == null) {
			throw new AlreadyExistException("Show doesnt exist");
		}
		List<Show> shows = getShows();
		for (Show show : shows) {
			if (show.getMovieScreenMap().getMovie().getName()
					.equalsIgnoreCase(existingShow.getMovieScreenMap().getMovie().getName())
					&& show.getMovieScreenMap().getScreen().getName()
							.equalsIgnoreCase(existingShow.getMovieScreenMap().getScreen().getName())) {
				show.setCategories(existingShow.getCategories());
				show.setMovieScreenMap(existingShow.getMovieScreenMap());
				break;
			}
		}
		JSONUtil.writeJSONToFile(shows, MTBSConstants.JSON_FILE_PATH, MTBSConstants.SHOW_JSON_FILE_NAME);
		rowsAffected = 1;
		return rowsAffected;
	}

}
