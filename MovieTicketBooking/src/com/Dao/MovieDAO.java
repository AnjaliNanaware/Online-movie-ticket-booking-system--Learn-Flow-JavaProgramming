package com.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Movie;

public class MovieDAO {
	

    public static void getMovieDetails() {
        Movie movie = null;
        Connection connection;
        Myconnection m=new Myconnection();
		try {
			connection = m.getConnection();
			String query = "SELECT * FROM movies";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	               
	               ResultSet resultSet = preparedStatement.executeQuery();
	               System.out.println("Movie ID\tMovie Name\t\tGenre\t\tRatings");
	                    while(resultSet.next()) {
	                       System.out.println("\t"+resultSet.getInt(1)+"\t\t" +resultSet.getString(2)+"\t\t"+resultSet.getString(3)+"\t\t"+resultSet.getDouble(5));
	       
	                    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}

