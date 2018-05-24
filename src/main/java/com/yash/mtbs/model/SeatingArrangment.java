package com.yash.mtbs.model;

import java.util.List;

public class SeatingArrangment {
	private int seatingArrangmentId;

	private List<Category> categories;

	public SeatingArrangment() {
		// TODO Auto-generated constructor stub
	}

	public SeatingArrangment(int seatingArrangmentId, List<Category> categiories) {
		super();
		this.seatingArrangmentId = seatingArrangmentId;
		this.categories = categiories;
	}

	public int getSeatingArrangmentId() {
		return seatingArrangmentId;
	}

	public void setSeatingArrangmentId(int seatingArrangmentId) {
		this.seatingArrangmentId = seatingArrangmentId;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
