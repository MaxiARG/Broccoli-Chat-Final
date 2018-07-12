package com.dataAccess;

import java.util.List;
import java.util.Random;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.modelo.ChuckNorris;

public class DAChuck {
	Session session;
	
	public DAChuck() {
		session = ConectorSingleton.getInstance().getSession();
	}
	
	public String obtenerFrase() {
		CriteriaBuilder cb1 = session.getCriteriaBuilder();
		CriteriaQuery<ChuckNorris> criteriaQuery = cb1.createQuery(ChuckNorris.class);
		Root<ChuckNorris> tabla = criteriaQuery.from(ChuckNorris.class);
		//criteriaQuery.select(tabla).where(cb1.equal(tabla.get("alias"), alias));
			
		List<ChuckNorris> lista = session.createQuery(criteriaQuery).getResultList();
		
		Random random=new Random(System.currentTimeMillis());
		return lista.get(random.nextInt(lista.size())).getFrase();
	}
}