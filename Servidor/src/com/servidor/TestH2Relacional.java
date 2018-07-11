package com.servidor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestH2Relacional {

	public static void main(String[] args) throws ClassNotFoundException {
		/*Class.forName("org.h2.Driver");
	    try (Connection conn = DriverManager.getConnection("jdbc:h2:~/ChatDB", "sa", ""); 
	            Statement stat = conn.createStatement()) {
	        try (ResultSet rs = stat.executeQuery("select * from Usuario")) {
	            while (rs.next()) {
	                System.out.println(rs.getString("nombre"));
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }*/
		  Pattern p = Pattern.compile("(?<=^|(?<=[^a-zA-Z0-9-\\.]))@[A-Za-z0-9-]+(?=[^a-zA-Z0-9-_\\.])");
	        Matcher m = p.matcher("Hola que @hace  @haceee ");
	        boolean b= m.find();
	       // while(m.find()) {
	            //System.out.println(m.group());
	        //}

	}

}
