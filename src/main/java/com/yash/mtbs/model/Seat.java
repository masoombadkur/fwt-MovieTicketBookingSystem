package com.yash.mtbs.model;

public class Seat {

	private int seatId;

	private boolean isAvailable;

	private int rowNo;

	private int seatNo;
	
	public Seat() {
		// TODO Auto-generated constructor stub
	}

	public Seat(int seatId, boolean isAvailable, int rowNo, int seatNo) {
		super();
		this.seatId = seatId;
		this.isAvailable = isAvailable;
		this.rowNo = rowNo;
		this.seatNo = seatNo;
	}
	
	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
}
