package com.Dao;

import java.sql.*;

import com.model.Booking;

public class BookingDAO {
  

    public static void insertBooking(Booking booking) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Myconnection m=new Myconnection();
        try {
            connection =m.getConnection();
            
            // Check if the seat for the same movie at the same showtime already exists
            
            preparedStatement = connection.prepareStatement("SELECT * FROM bookings WHERE showtime_id = ? AND seat_number = ? AND movie_name=?");
            preparedStatement.setInt(1, booking.getShowtimeId());
            preparedStatement.setString(2, booking.getSeatNumber());
            preparedStatement.setString(3, booking.getMoviename());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Seat is already booked for this showtime. Please choose another seat.");
                return; // Exit the method without inserting the booking
            }
            
            // If the seat is not already booked, proceed with inserting the booking
            String insertQuery = "INSERT INTO bookings (user_name,movie_name, showtime_id, seat_number) VALUES (?,?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, booking.getUsername());
            preparedStatement.setString(2, booking.getMoviename());
            preparedStatement.setInt(3, booking.getShowtimeId());
            preparedStatement.setString(4, booking.getSeatNumber());
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
            	preparedStatement =connection.prepareStatement("update showtimes set  available_seats=(available_seats-1) where  showtime_id=?");
                preparedStatement.setInt(1, booking.getShowtimeId());
                preparedStatement.execute();
                System.out.println("Booking successful!");
                preparedStatement =connection.prepareStatement("select booking_id from bookings where user_name=?");
                preparedStatement.setString(1,booking.getUsername());
                ResultSet rs=preparedStatement.executeQuery();
                if(rs.next())
                {
                	System.out.println("Your booking ID is: "+ rs.getInt(1));
                }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in a finally block
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void cancelBooking(int bookingId,int showtimeid) {
            Connection connection;
            Myconnection m=new Myconnection();
			try {
				connection = m.getConnection();
				String query = "DELETE FROM bookings WHERE booking_id = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, bookingId);
	            int i=preparedStatement.executeUpdate();
	            if(i>0) {
	            	preparedStatement =connection.prepareStatement("update showtimes set  available_seats=(available_seats+1) where  showtime_id=?");
	                preparedStatement.setInt(1, showtimeid);
	                preparedStatement.execute();
	                System.out.println("Ticket Cancle successfully");
	            	
	            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            
        
    }
}

