package org.lessons.java.events;

import java.time.LocalDate;

public class Event {
	private String title;
	private LocalDate date;
	private int totalPlaces;
	private int bookedPlaces;

	public Event(String title, LocalDate date, int totalPlaces) {
		setTitle(title);
		setDate(date);
		setTotalPlaces(totalPlaces);
		this.bookedPlaces = 0;
	}
	
	//	getter and setter
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public int getTotalPlaces() {
		return totalPlaces;
	}
	private void setTotalPlaces(int totalPlaces) {
		this.totalPlaces = totalPlaces;
	}
	
	public int getBookedPlaces() {
		return bookedPlaces;
	}
	
	// Book/Cancel
	public void book(int bookedPlaces, LocalDate date) throws Exception {
		isSoldOut(getTotalPlaces(), bookedPlaces);
		isBefore(date);
		this.bookedPlaces += bookedPlaces;
	}
	
	public void cancel(int bookedPlaces, LocalDate date) throws Exception {
		isBefore(date);
		this.bookedPlaces -= bookedPlaces;
	}
	
	// Exceptions
	private void isBefore(LocalDate date) throws Exception {
		if (date.isBefore(LocalDate.now())) {
			throw new Exception("Non si possono inserire date passate");
		}
	}
	
	private void isSoldOut(int totalPlaces, int bookedPlaces) throws Exception {
		if (bookedPlaces > totalPlaces) {
			throw new Exception("I posti sono esauriti");
		}
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + "\n" +  
				"Evento: " + getTitle() + "\n" + 
				"Data: " + getDate() + "\n" + 
				"Posti totali: " + getTotalPlaces() + "\n" + 
				"Posti Prenotati: " + getBookedPlaces() + "\n" + 
				"]";
	}
}
