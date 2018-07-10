package dataAccess;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.db.Usuario;

public class DAUsuario {
	Session session;
	
	public DAUsuario() {
		session = ConectorSingleton.getInstance().getSession();
	}
	
	public void almacenarUsuarioNuevo(Usuario u) {
		if(usuarioExistente(u.getNombre())==false) {
		session.getTransaction().begin();
		session.saveOrUpdate(u);
		session.getTransaction().commit();
		}
	}
	
	public boolean usuarioExistente(String nombre) {
		Criteria c= session.createCriteria(Usuario.class);
		List<Usuario> lista= (List<Usuario>) c.list(); 
		
		for(Usuario u: lista) {
			if(u.getNombre().equals(nombre)) return true;
		}
		return false;
	}
}