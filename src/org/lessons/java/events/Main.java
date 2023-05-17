package org.lessons.java.events;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Inserisci il titolo");
		String title = sc.nextLine();
		
		System.out.println("Inserisci la data");
		LocalDate date = LocalDate.parse(sc.nextLine());
		
		System.out.println("Inserisci i posti");
		int totalPlaces = sc.nextInt();
		
		// Event
		Event event = null;
		try {
			event = new Event(title, date, totalPlaces);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(event);
		
		sc.close();
	}
}
