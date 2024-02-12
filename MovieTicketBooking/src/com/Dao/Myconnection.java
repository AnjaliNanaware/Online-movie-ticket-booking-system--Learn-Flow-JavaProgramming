package com.Dao;



import java.sql.*;

public class Myconnection {
	
		public  Connection getConnection() {
			
			Connection con=null;
			String driver="oracle.jdbc.OracleDriver";
			String DB_URL = "jdbc:mysql://localhost:3306/movie_db";
			String DB_USER = "root";
			String DB_PASSWORD = "Anjali@9876";
			
			try {
				con=DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return con;
		}
}
