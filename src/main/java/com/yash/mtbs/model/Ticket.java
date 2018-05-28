package com.yash.mtbs.model;

public class Ticket {
	
	private int ticketId;
	
	private Show show;
	
	private Customer customer;
	
	private Seat seat;
	
	private double price;
	
	private boolean isCancelled;
	
	private String categoryName;
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public Ticket(int ticketId, Show show, Customer customer, Seat seat, double price) {
		super();
		this.ticketId = ticketId;
		this.show = show;
		this.customer = customer;
		this.seat = seat;
		this.price = price;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isCancelled() {
		return isCancelled;
	}

	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
