package com.dataAccess;

import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.modelo.ChuckNorris;

public class DAChuck {
	Session session;
	
	public DAChuck() {
		session = ConectorSingleton.getInstance().getSession();
	}
	
	public String obtenerFrase() {
		Criteria c= session.createCriteria(ChuckNorris.class);
		List<ChuckNorris> lista= (List<ChuckNorris>) c.list(); 
		
		Random random=new Random(System.currentTimeMillis());
		return lista.get(random.nextInt(lista.size())).getFrase();
	}
}