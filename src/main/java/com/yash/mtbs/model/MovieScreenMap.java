package com.yash.mtbs.model;

public class MovieScreenMap {

	private int movieScreenMapId;

	private Movie movie;

	private Screen screen;

	public MovieScreenMap() {
		// TODO Auto-generated constructor stub
	}

	public MovieScreenMap(int movieScreenMapId, Movie movie, Screen screen) {
		super();
		this.movieScreenMapId = movieScreenMapId;
		this.movie = movie;
		this.screen = screen;
	}

	public int getMovieScreenMapId() {
		return movieScreenMapId;
	}

	public void setMovieScreenMapId(int movieScreenMapId) {
		this.movieScreenMapId = movieScreenMapId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

}
