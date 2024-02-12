package com.main;

import java.util.List;
import java.util.Scanner;

import com.Dao.BookingDAO;
import com.Dao.MovieDAO;
import com.Dao.ShowtimeDAO;
import com.model.Booking;
import com.model.Movie;
import com.model.Showtime;

public class Main {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int choice =0;
	        System.out.println("Welcome to Movie Ticket Booking System!");
	        do {
	        // Display welcome message and available options

	        System.out.println("Choose an option:");
	        System.out.println("1. View movie details");
	        System.out.println("2. View showtimes for a movie");
	        System.out.println("3. Book tickets");
	        System.out.println("4. Cancel booking");
	        System.out.println("5. Exit");
	        
	        // Read user input
	        System.out.print("Enter your choice: ");
	        choice = scanner.nextInt();
	        
	        switch (choice) {
	            case 1:
	                viewMovieDetails(scanner);
	                break;
	            case 2:
	                viewShowtimes(scanner);
	                break;
	            case 3:
	                bookTickets(scanner);
	                break;
	            case 4:
	                cancelBooking(scanner);
	                break;
	            case 5:
	                System.out.println("Thank you for using Movie Ticket Booking System. Exiting...");
	                break;
	            default:
	                System.out.println("Invalid choice. Please enter a valid option.");
	        }
	        
	      
	    }while(choice !=5);
	 }
	    
	    private static void viewMovieDetails(Scanner scanner) {
	   
	        MovieDAO.getMovieDetails();
	        
	    }
	    
	    private static void viewShowtimes(Scanner scanner) {
	        // Implement logic to view showtimes for a movie
	        System.out.println("Enter movie ID to view showtimes:");
	        int movieId = scanner.nextInt();
	        List<Showtime> showtimes = ShowtimeDAO.getShowtimesForMovie(movieId);
	        if (!showtimes.isEmpty()) {
	            System.out.println("\nShowtimes for Movie:");
	            for (Showtime showtime : showtimes) {
	                System.out.println("ID: " + showtime.getId());
	                System.out.println("Date: " + showtime.getDate());
	                System.out.println("Time: " + showtime.getTime());
	                System.out.println("Available Seats: " + showtime.getAvailableSeats());
	                // Print other showtime details
	            }
	        } else {
	            System.out.println("No showtimes available for this movie!");
	        }
	    }
	    
	    private static void bookTickets(Scanner scanner) {
	    	
	    	System.out.println("Enter your name: ");
	    	String uname=scanner.next();
	    	System.out.println("Enter Movie name: ");
	    	String movie=scanner.next();
	    	System.out.println("Enter Showtime ID: ");
	    	int sid=scanner.nextInt();
	    	System.out.println("Enter seat no. (eg A1 , A20): ");
	    	String seatno=scanner.next();
	    	
	    	 Booking booking = new Booking();
	         booking.setUsername(uname); 
	         booking.setMoviename(movie);
	         booking.setShowtimeId(sid); // Example showtime ID
	         booking.setSeatNumber(seatno); // Example seat number

	         // Insert booking into the database
	         BookingDAO.insertBooking(booking);
	    }
	    
	    private static void cancelBooking(Scanner scanner) {
	    	System.out.println("Enter booking id: ");
	        int bookingId = scanner.nextInt();
	        System.out.println("Enter showtime id: ");
	        int showtimeId = scanner.nextInt();
	        BookingDAO.cancelBooking(bookingId,showtimeId);
	    }
	

}
