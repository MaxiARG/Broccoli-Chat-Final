package dataAccess;

import org.hibernate.Session;

import com.db.Usuario;

public class DAUsuario {
	Session session;
	
	public DAUsuario() {
		session = ConectorSingleton.getInstance().getSession();
	}
	
	public Usuario obtenerUsuario(String alias) {
		return null;
	}
	
	public Usuario obtenerUsuario(int usuarioID) {
		return null;
	}
	
	public void almacenarUsuarioNuevo(Usuario u) {
		session.getTransaction().begin();
		session.saveOrUpdate(u);
		session.getTransaction().commit();
	}
}