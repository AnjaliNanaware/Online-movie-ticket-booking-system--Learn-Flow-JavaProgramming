package com.model;

public class Booking {
    private int id;
    private String username;
    private String moviename;
    private int showtimeId;
    private String seatNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getShowtimeId() {
		return showtimeId;
	}
	public void setShowtimeId(int showtimeId) {
		this.showtimeId = showtimeId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	
    
    
    
}
