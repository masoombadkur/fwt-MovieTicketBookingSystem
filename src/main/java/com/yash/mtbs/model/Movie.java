package com.yash.mtbs.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public class Movie {

	private int movieId;

	private String name;

	private List<String> actors;

	private String production;

	private String duration;

	public Movie() {
	}

	public Movie(int movieId, String name, List<String> actors, String production, String duration) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.actors = actors;
		this.production = production;
		this.duration = duration;
	}

	public Movie(int movieId, String name) {
		super();
		this.movieId = movieId;
		this.name = name;
	}

	public Movie(int movieId, String name, String duration) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.duration = duration;
	}
	
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}
