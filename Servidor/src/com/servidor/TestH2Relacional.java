package com.servidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestH2Relacional {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.h2.Driver");
	    try (Connection conn = DriverManager.getConnection("jdbc:h2:~/ChatDB", "sa", ""); 
	            Statement stat = conn.createStatement()) {
	        try (ResultSet rs = stat.executeQuery("select * from Usuario")) {
	            while (rs.next()) {
	                System.out.println(rs.getString("nombre"));
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
