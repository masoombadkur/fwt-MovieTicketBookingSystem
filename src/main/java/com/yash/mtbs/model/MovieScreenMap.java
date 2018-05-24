package com.yash.mtbs.model;

public class MovieScreenMap {

	private int movieScreenMapId;

	private Movie movie;

	private Screen screen;

	private String category;

	private double price;

	public MovieScreenMap() {
		// TODO Auto-generated constructor stub
	}
	
	public MovieScreenMap(int movieScreenMapId, Movie movie) {
		super();
		this.movieScreenMapId = movieScreenMapId;
		this.movie = movie;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
