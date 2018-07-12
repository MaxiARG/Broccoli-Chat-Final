package com.servidor;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.dataAccess.ConectorSingleton;
import com.modelo.Usuario;

import clase.Asistente;

public class TestH2Relacional {

	public static void main(String[] args) throws ClassNotFoundException {
			//Asistente asistente= new Asistente("jenkins");
			//String devuelve= asistente.escuchar("buen día @jenkins");
			//String devuelve= asistente.escuchar("gracias @jenkins");.
			//String devuelve= asistente.escuchar("me decís la hora @jenkins?");
			
			//String devuelve= asistente.escuchar("@jenkins qué día será dentro de 22 días?");
			//String devuelve= asistente.escuchar("@jenkins cuánto es 1 + 2");
			//String devuelve= asistente.escuchar("@jenkins jugamos?");
			//String devuelve= asistente.escuchar("@jenkins cuántos kilos son 9000 gramos");
			//String devuelve= asistente.escuchar("@jenkins dime las 3 leyes de la robótica");
			//String devuelve= asistente.escuchar("@jenkins dime la 1ra ley de la robótica.");
			//String devuelve= asistente.escuchar("@jenkins puedes decir una Chuck Norris Facts?");
			//String devuelve= asistente.escuchar("@jenkins cual es mi estado de deudas?");
			//String devuelve= asistente.escuchar("@jenkins dime las 3 leyes de la robótica");
			//System.out.println(devuelve);
			//devuelve="Disculpa... no entiendo el pedido "+"asdasdasda";
			//System.out.println(devuelve.contains("Disculpa... no entiendo el pedido"));
			
				 Session session = ConectorSingleton.getInstance().getSession();
			
				CriteriaBuilder cb1 = session.getCriteriaBuilder();
				CriteriaQuery<Usuario> criteriaQuery = cb1.createQuery(Usuario.class);
				Root<Usuario> tabla = criteriaQuery.from(Usuario.class);
				//criteriaQuery.select(tabla).where(cb1.equal(tabla.get("alias"), alias));
					
				List<Usuario> lista = session.createQuery(criteriaQuery).getResultList();

				//Criteria c= session.createCriteria(Usuario.class);
				//List<Usuario> lista= (List<Usuario>) c.list(); 
				
				for(Usuario u: lista) {
					System.out.println(u.getNombre());
				}
	}

}
