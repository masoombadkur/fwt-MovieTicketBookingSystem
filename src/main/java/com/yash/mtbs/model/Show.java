package com.yash.mtbs.model;

import java.util.Date;

public class Show {

	private int showId;

	private MovieScreenMap movieScreenMap;

	private String startTime;

	private String endTime;

	private String date;

	public Show() {
		// TODO Auto-generated constructor stub
	}

	public Show(int showId, MovieScreenMap movieScreenMap, String startTime, String endTime) {
		super();
		this.showId = showId;
		this.movieScreenMap = movieScreenMap;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public MovieScreenMap getMovieScreenMap() {
		return movieScreenMap;
	}

	public void setMovieScreenMap(MovieScreenMap movieScreenMap) {
		this.movieScreenMap = movieScreenMap;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
