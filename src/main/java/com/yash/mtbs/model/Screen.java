package com.yash.mtbs.model;

public class Screen {

	private int screenId;

	private String name;

	private SeatingArrangment seatingArrangment;
	
	public Screen() {
	}

	public Screen(int screenId, String name, SeatingArrangment seatingArrangment) {
		super();
		this.screenId = screenId;
		this.name = name;
		this.seatingArrangment = seatingArrangment;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SeatingArrangment getSeatingArrangment() {
		return seatingArrangment;
	}

	public void setSeatingArrangment(SeatingArrangment seatingArrangment) {
		this.seatingArrangment = seatingArrangment;
	}

}
