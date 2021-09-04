package com.example.drools.model;

public class FootballClubRequest {
	private String country;
	private String year;
	private String winner;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public FootballClubRequest(String country, String year) {
		super();
		this.country = country;
		this.year = year;
	}
}