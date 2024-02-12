package com.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Showtime;

public class ShowtimeDAO {


    public static List<Showtime> getShowtimesForMovie(int movieId) {
        List<Showtime> showtimes = new ArrayList<>();
        Myconnection m=new Myconnection();
        PreparedStatement preparedStatement;
			try {
				Connection connection = m.getConnection();
	            String query = "SELECT * FROM showtimes WHERE movie_id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, movieId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                 Showtime showtime = new Showtime();
	                 showtime.setId(resultSet.getInt("showtime_id"));
	                 showtime.setMovieId(resultSet.getInt("movie_id"));
	                 showtime.setDate(resultSet.getDate("show_date"));
	                 showtime.setTime(resultSet.getTime("show_time"));
	                 showtime.setAvailableSeats(resultSet.getInt("available_seats"));
	                 showtimes.add(showtime);
	            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
               
               
            
      
        return showtimes;
    }
}
