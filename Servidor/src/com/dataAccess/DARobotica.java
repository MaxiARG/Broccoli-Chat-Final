package com.dataAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.modelo.ChuckNorris;
import com.modelo.Robotica;

public class DARobotica {
	Session session;
	
	public DARobotica() {
		session = ConectorSingleton.getInstance().getSession();
	}
	
	public ArrayList<String> obtenerTodasLasFrase() {
		Criteria c= session.createCriteria(Robotica.class);
		List<Robotica> lista= (List<Robotica>) c.list(); 
		ArrayList<String> frases= new ArrayList<String>();
		
		for(Robotica r: lista) {
			frases.add(r.getFrase());
		}
		return frases;
		
	}
	public String obtenerFraseNumero(int numeroDeFrase) {
		Criteria c= session.createCriteria(Robotica.class);
		List<Robotica> lista= (List<Robotica>) c.list(); 
		ArrayList<String> frases= new ArrayList<String>();
		if(numeroDeFrase>0 && numeroDeFrase<lista.size())
		return frases.get(numeroDeFrase);
		return "Numero de frase incorrecta";
	}
	
	public String obtenerFraseRandom() {
		Criteria c= session.createCriteria(Robotica.class);
		List<Robotica> lista= (List<Robotica>) c.list(); 
		
		Random random=new Random(System.currentTimeMillis());
		return lista.get(random.nextInt(lista.size())).getFrase();
	}
}