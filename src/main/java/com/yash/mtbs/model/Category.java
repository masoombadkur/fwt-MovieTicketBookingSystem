package com.yash.mtbs.model;

import java.util.List;

public class Category {

	private int categoryId;

	private String name;

	private List<Seat> seats;

	private int totalRows;

	private int noOfSeatsInFirstRow;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getNoOfSeatsInFirstRow() {
		return noOfSeatsInFirstRow;
	}

	public void setNoOfSeatsInFirstRow(int noOfSeatsInFirstRow) {
		this.noOfSeatsInFirstRow = noOfSeatsInFirstRow;
	}

}