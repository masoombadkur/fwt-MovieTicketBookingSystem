package com.yash.mtbs.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.yash.mtbs.dao.ShowDao;
import com.yash.mtbs.exceptions.EmptyException;
import com.yash.mtbs.literals.MTBSConstants;
import com.yash.mtbs.model.Movie;
import com.yash.mtbs.model.MovieScreenMap;
import com.yash.mtbs.model.Show;
import com.yash.mtbs.service.ShowService;
import com.yash.mtbs.util.TimeUtil;

public class ShowServiceImpl implements ShowService {

	private ShowDao showDao;

	public ShowServiceImpl(ShowDao showDao) {
		this.showDao = showDao;
	}

	@Override
	public int addShow(Show show) {
		int rowCount = 0;
		if (show == null) {
			throw new NullPointerException("Show is null");
		}
		if (show.getShowId() == 0) {
			throw new EmptyException("Show is empty");
		}
		if (show.getMovieScreenMap() == null) {
			throw new NullPointerException("Movie and screen for show are null");
		}
		rowCount = showDao.insertShow(show);
		return rowCount;
	}

	public List<Show> createShowsForMovieScreenMap(MovieScreenMap movieScreenMap) {

		Movie movie = movieScreenMap.getMovie();
		String durationInStringFormat = movie.getDuration();
		int hrs = Integer.parseInt(durationInStringFormat.substring(0, durationInStringFormat.indexOf(":")));
		int mins = Integer.parseInt(durationInStringFormat.substring(durationInStringFormat.indexOf(":") + 1));

		int durationInMins = (hrs * 60) + mins;
		int noOfShows = (MTBSConstants.TOTAL_HRS_IN_DAY_TO_BE_ALLOTED * 60)
				/ (durationInMins + MTBSConstants.TIME_INTERVAL_BTW_SHOWS);
		List<Show> shows = getShows(movieScreenMap, durationInMins, noOfShows);

		return shows;
	}

	private List<Show> getShows(MovieScreenMap movieScreenMap, int durationInMins, int noOfShows) {
		List<Show> shows = new ArrayList<>();
		String startTime = "10:00";
		String endTime = null;
		Show show = null;
		while (noOfShows > 0) {
			show = new Show();
			show.setShowId(100);
			show.setMovieScreenMap(movieScreenMap);
			show.setDate(TimeUtil.getTodaysDate());
			show.setStartTime(startTime);
			// calculate end time of current show
			endTime = TimeUtil.calcuteEndTime(startTime, durationInMins);
			show.setEndTime(endTime);
			// calculate start time of next show
			startTime = TimeUtil.calcuteEndTime(endTime, MTBSConstants.TIME_INTERVAL_BTW_SHOWS);
			addShow(show);
			shows.add(show);
			
			noOfShows = noOfShows - 1;
		}
		return shows;
	}

}
