package com.yash.mtbs.model;

import java.util.List;

public class SeatingArrangment {
	private int seatingArrangmentId;

	private List<Category> categiories;

	public int getSeatingArrangmentId() {
		return seatingArrangmentId;
	}

	public void setSeatingArrangmentId(int seatingArrangmentId) {
		this.seatingArrangmentId = seatingArrangmentId;
	}

	public List<Category> getCategiories() {
		return categiories;
	}

	public void setCategiories(List<Category> categiories) {
		this.categiories = categiories;
	}

}
